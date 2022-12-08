package be.intecbrussel.leaguedle.registration;

import be.intecbrussel.leaguedle.registration.token.ConfirmationToken;
import be.intecbrussel.leaguedle.registration.token.ConfirmationTokenService;
import be.intecbrussel.leaguedle.user.User;
import be.intecbrussel.leaguedle.user.UserRole;
import be.intecbrussel.leaguedle.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest registrationRequest){
        boolean isValidEmail = emailValidator.test(registrationRequest.getUserEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        String token = userService.signUpUser(new User(
                registrationRequest.getUserName(),
                registrationRequest.getUserEmail(),
                registrationRequest.getUserPassword(),
                UserRole.USER

        ));
        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getUserEmail());
        return "confirmed";
    }

}

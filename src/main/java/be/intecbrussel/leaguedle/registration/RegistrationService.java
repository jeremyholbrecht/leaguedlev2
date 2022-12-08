package be.intecbrussel.leaguedle.registration;

import be.intecbrussel.leaguedle.user.User;
import be.intecbrussel.leaguedle.user.UserRole;
import be.intecbrussel.leaguedle.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest registrationRequest){
        boolean isValidEmail = emailValidator.test(registrationRequest.getUserEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return userService.signUpUser(new User(
                registrationRequest.getUserName(),
                registrationRequest.getUserEmail(),
                registrationRequest.getUserPassword(),
                UserRole.USER

        ));
    }
}

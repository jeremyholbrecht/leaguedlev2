package be.intecbrussel.leaguedle.user;

import be.intecbrussel.leaguedle.registration.token.ConfirmationToken;
import be.intecbrussel.leaguedle.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MESSAGE = "user with email %s not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository.findByUserEmail(userEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MESSAGE, userEmail)));
    }
    public String signUpUser(User user){
       boolean userExists =  userRepository.findByUserEmail(user.getUserEmail()).isPresent();
       if (userExists){
           throw new IllegalStateException("email already taken");
       }
       String encodedPassword = bCryptPasswordEncoder.encode(user.getUserPassword());
       user.setUserPassword(encodedPassword);
       userRepository.save(user);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user

        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        // TODO: SEND EMAIL
        return token;
    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }
}

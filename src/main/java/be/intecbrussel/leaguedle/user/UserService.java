package be.intecbrussel.leaguedle.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MESSAGE = "user with email %s not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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
       // TODO: SEND confirmation token
        return "it works";
    }
}

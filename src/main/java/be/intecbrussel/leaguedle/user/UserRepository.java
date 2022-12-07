package be.intecbrussel.leaguedle.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Transactional
public interface UserRepository {
    Optional<User> findByUserEmail(String userEmail);
}

package be.intecbrussel.leaguedle.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserEmail(String userEmail);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Users " +
            "SET enabled = TRUE WHERE user_email = ?1", nativeQuery = true)
    int enableUser(String email);
}

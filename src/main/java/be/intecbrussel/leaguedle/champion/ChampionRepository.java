package be.intecbrussel.leaguedle.champion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository  extends JpaRepository <Champion, Long> {
}

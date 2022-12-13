package be.intecbrussel.leaguedle.champion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChampionConfig {

    @Bean
    CommandLineRunner commandLineRunner(ChampionRepository championRepository){
        return args -> {
            Champion aatrox = new Champion(
                    "Aatrox",
                    ChampionGender.MALE,
                    ChampionPosition.TOP,
                    "Darkin",
                     "Manaless",
                    "Melee",
                    "Runeterra",
                    "lolol",
                    2013);

            Champion ahri = new Champion(
                    "Ahri",
                    ChampionGender.FEMALE,
                    ChampionPosition.TOP,
                    "Vastayan",
                    "Mana",
                    "Ranged",
                    "Iona",
                    "charmed are you",
                    2011
            );

            championRepository.saveAll(
                    List.of(aatrox, ahri)
            );
        };
    }
}

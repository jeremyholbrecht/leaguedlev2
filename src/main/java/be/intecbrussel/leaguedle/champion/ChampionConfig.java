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
                    ChampionName.Aatrox,
                    ChampionGender.Male,
                    ChampionPosition.Top,
                    "Darkin",
                    ChampionRescourceType.Maneless,
                    ChampionRangeType.Melee,
                    "Runeterra",
                    "lolol",
                    2013);

            Champion ahri = new Champion(
                    ChampionName.Ahri,
                    ChampionGender.Female,
                    ChampionPosition.Mid,
                    "Vastayan",
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Ranged,
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

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
                    ChampionSpecies.Darkin,
                    ChampionRescourceType.Maneless,
                    ChampionRangeType.Melee,
                    ChampionRegion.Shurima,
                    2013);

            Champion ahri = new Champion(
                    ChampionName.Ahri,
                    ChampionGender.Female,
                    ChampionPosition.Mid,
                    ChampionSpecies.Vastayan,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Ranged,
                    ChampionRegion.Ionia,
                    2011
            );

            Champion akali = new Champion(
                    ChampionName.Akali,
                    ChampionGender.Female,
                    ChampionPosition.Mid,
                    ChampionSpecies.Human,
                    ChampionRescourceType.Energy,
                    ChampionRangeType.Melee,
                    ChampionRegion.Ionia,
                    2010
            );

            Champion akshan = new Champion(
                    ChampionName.Akshan,
                    ChampionGender.Male,
                    ChampionPosition.Mid,
                    ChampionSpecies.Human,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Ranged,
                    ChampionRegion.Shurima,
                    2021
            );

            Champion alistar = new Champion(
                    ChampionName.Alistar,
                    ChampionGender.Male,
                    ChampionPosition.Support,
                    ChampionSpecies.Minotaur,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Melee,
                    ChampionRegion.Runeterra,
                    2021
            );



            championRepository.saveAll(
                    List.of(
                            aatrox,
                            ahri,
                            akali,
                            akshan,
                            alistar
                            )
            );
        };
    }
}

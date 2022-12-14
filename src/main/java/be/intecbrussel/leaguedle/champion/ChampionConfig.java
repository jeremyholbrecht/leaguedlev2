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

            Champion amumu = new Champion(
                    ChampionName.Amumu,
                    ChampionGender.Male,
                    ChampionPosition.Jungle,
                    ChampionSpecies.Yordle,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Melee,
                    ChampionRegion.Shurima,
                    2009
            );

            Champion anivia = new Champion(
                    ChampionName.Anivia,
                    ChampionGender.Female,
                    ChampionPosition.Mid,
                    ChampionSpecies.Spirit,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Ranged,
                    ChampionRegion.TheFreljord,
                    2009
            );

            Champion annie = new Champion(
                    ChampionName.Annie,
                    ChampionGender.Female,
                    ChampionPosition.Mid,
                    ChampionSpecies.Human,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Ranged,
                    ChampionRegion.Noxus,
                    2009
            );

            Champion aphelios = new Champion(
                    ChampionName.Aphelios,
                    ChampionGender.Male,
                    ChampionPosition.Bottom,
                    ChampionSpecies.Human,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Ranged,
                    ChampionRegion.Targon,
                    2019
            );

            Champion ashe = new Champion(
                    ChampionName.Ashe,
                    ChampionGender.Female,
                    ChampionPosition.Bottom,
                    ChampionSpecies.Human,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Ranged,
                    ChampionRegion.TheFreljord,
                    2009
            );

            Champion aurelionSol = new Champion(
                    ChampionName.AurelionSol,
                    ChampionGender.Male,
                    ChampionPosition.Mid,
                    ChampionSpecies.Dragon,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Ranged,
                    ChampionRegion.Targon,
                    2016
            );

            Champion azir = new Champion(
                    ChampionName.Azir,
                    ChampionGender.Male,
                    ChampionPosition.Mid,
                    ChampionSpecies.GodWarrior,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Ranged,
                    ChampionRegion.Shurima,
                    2014
            );

            Champion bard = new Champion(
                    ChampionName.Bard,
                    ChampionGender.Male,
                    ChampionPosition.Support,
                    ChampionSpecies.Celestial,
                    ChampionRescourceType.Mana,
                    ChampionRangeType.Ranged,
                    ChampionRegion.Runeterra,
                    2015
            );


            championRepository.saveAll(
                    List.of(
                            aatrox,
                            ahri,
                            akali,
                            akshan,
                            alistar,
                            amumu,
                            anivia,
                            annie,
                            aphelios,
                            ashe,
                            aurelionSol,
                            azir,
                            bard
                            )
            );
        };
    }
}

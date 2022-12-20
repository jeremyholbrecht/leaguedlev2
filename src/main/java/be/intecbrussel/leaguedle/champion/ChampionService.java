package be.intecbrussel.leaguedle.champion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChampionService {

    private ChampionRepository championRepository;

    @Autowired
    public ChampionService(ChampionRepository championRepository){
        this.championRepository = championRepository;
    }

    // all champions
    public List<Champion> getAllChampions(){
        return championRepository.findAll();
    }

    // name ascending
    public List<Champion> orderByNameAscending(){
        List<Champion> champions = championRepository.findAll();
        champions = champions.stream().sorted(Comparator.comparing(Champion::getChampionName)).collect(Collectors.toList());
        return champions;
    }

    // name descending
    public List<Champion> orderByNameDescending(){
        List<Champion> champions = championRepository.findAll();
        champions = champions.stream().sorted(Comparator.comparing(Champion::getChampionName).reversed()).collect(Collectors.toList());
        return champions;
    }

    // male
    public List<Champion> getMaleChampions(){
        List<Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionGender()
                .equals(ChampionGender.Male)).collect(Collectors.toList());
        return champions;
    }

    // female
    public List <Champion> getFemaleChampions(){
        List<Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionGender().
                equals(ChampionGender.Female)).collect(Collectors.toList());
        return champions;
    }


    // top
    public List <Champion> getTopChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionPosition().
                equals(ChampionPosition.Top)).collect(Collectors.toList());
        return champions;
    }

    // jungle
    public List <Champion> getJungleChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionPosition().
                equals(ChampionPosition.Jungle)).collect(Collectors.toList());
        return champions;
    }

    // mid
    public List <Champion> getMidChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionPosition().
                equals(ChampionPosition.Mid)).collect(Collectors.toList());
        return champions;
    }

    // bottom
    public List <Champion> getBottomChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionPosition().
                equals(ChampionPosition.Bottom)).collect(Collectors.toList());
        return champions;
    }

    //support
    public List <Champion> getSupportChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionPosition().
                equals(ChampionPosition.Support)).collect(Collectors.toList());
        return champions;
    }

    // human
    public List <Champion> getHumanChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Human)).collect(Collectors.toList());
        return champions;
    }

    // yordle
    public List <Champion> getYordleChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Yordle)).collect(Collectors.toList());
        return champions;
    }

    // vastayan
    public List <Champion> getVastayanChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Vastayan)).collect(Collectors.toList());
        return champions;
    }

    // undead
    public List <Champion> getUndeadChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Undead)).collect(Collectors.toList());
        return champions;
    }

    // spirit
    public List <Champion> getSpiritChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Undead)).collect(Collectors.toList());
        return champions;
    }

    // dragon
    public List <Champion> getDragonChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Dragon)).collect(Collectors.toList());
        return champions;
    }

    //  brackern
    public List <Champion> getbrackernChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Brackern)).collect(Collectors.toList());
        return champions;
    }

    // celestial
    public List <Champion> getCelestialChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Celestial)).collect(Collectors.toList());
        return champions;
    }

    // voidborn
    public List <Champion> getVoidbornChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Voidborn)).collect(Collectors.toList());
        return champions;
    }

    // ascended
    public List <Champion> getAscendedChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Ascended)).collect(Collectors.toList());
        return champions;
    }

    // darkin
    public List <Champion> getDarkinChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Darkin)).collect(Collectors.toList());
        return champions;
    }

    // minotaur
    public List <Champion> getMinotaurChampions(){
        List <Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionSpecies().
                equals(ChampionSpecies.Minotaur)).collect(Collectors.toList());
        return champions;
    }



}

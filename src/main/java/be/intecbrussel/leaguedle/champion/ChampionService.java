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

    // list of all champions
    public List<Champion> getAllChampions(){
        return championRepository.findAll();
    }

    // by name ascending
    public List<Champion> orderByNameAscending(){
        List<Champion> champions = championRepository.findAll();
        champions = champions.stream().sorted(Comparator.comparing(Champion::getChampionName)).collect(Collectors.toList());
        return champions;
    }

    // by name descending
    public List<Champion> orderByNameDescending(){
        List<Champion> champions = championRepository.findAll();
        champions = champions.stream().sorted(Comparator.comparing(Champion::getChampionName).reversed()).collect(Collectors.toList());
        return champions;
    }

    // Male
    public List<Champion> getMaleChampions(){
        List<Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionGender()
                .equals(ChampionGender.Male)).collect(Collectors.toList());
        return champions;
    }

    // Female
    public List <Champion> getFemaleChampions(){
        List<Champion> champions = championRepository.findAll();
        champions = champions.stream().filter(champion -> champion.getChampionGender().
                equals(ChampionGender.Female)).collect(Collectors.toList());
        return champions;
    }





}

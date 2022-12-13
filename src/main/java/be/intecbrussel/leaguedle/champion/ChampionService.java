package be.intecbrussel.leaguedle.champion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

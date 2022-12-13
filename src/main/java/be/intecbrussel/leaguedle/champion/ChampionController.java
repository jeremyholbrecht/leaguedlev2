package be.intecbrussel.leaguedle.champion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChampionController {

    private ChampionService championService;

    @Autowired
    public ChampionController(ChampionService championService){
        this.championService = championService;
    }

    // all champions
    @GetMapping("/champions")
    public String getAllChampions(Model model){
        model.addAttribute("champion", championService.getAllChampions());
        return "champions";
    }

}

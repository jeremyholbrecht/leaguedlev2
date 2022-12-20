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

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }


    // all champions
    @GetMapping("/champions")
    public String getAllChampions(Model model){
        model.addAttribute("champion", championService.getAllChampions());
        return "champions";
    }

    // name desc
    @GetMapping("/championsByNameDesc")
    public String championsByNameDescPage(Model model){
        model.addAttribute("champion", championService.orderByNameDescending());
        return "championsByNameDesc";
    }

    // male
    @GetMapping("/maleChampions")
    public String maleChampions(Model model){
        model.addAttribute("champion", championService.getMaleChampions());
        return "maleChampions";
    }

    // female
    @GetMapping("femaleChampions")
    public String femaleChampions(Model model){
        model.addAttribute("champion", championService.getFemaleChampions());
        return "femaleChampions";
    }



}

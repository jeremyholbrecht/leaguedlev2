package be.intecbrussel.leaguedle.quote;

import be.intecbrussel.leaguedle.champion.Champion;
import be.intecbrussel.leaguedle.champion.ChampionName;
import be.intecbrussel.leaguedle.guess.Guess;
import be.intecbrussel.leaguedle.guess.GuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class QuoteController {

    private QuoteService quoteService;
    private GuessService guessService;

    @Autowired
    public QuoteController(QuoteService quoteService, GuessService guessService){
        this.quoteService = quoteService;
        this.guessService = guessService;
    }

    @GetMapping("/quote")
    public String quotePage(Model model){
        Quote randomQuote = quoteService.randomQuote();
        ChampionName randomQuoteChampionName = randomQuote.getChampionName();
        List<Guess> guesses = guessService.allGuesses();
        ChampionName guessedChampionName =  guessService.getGuessById(1L).getGuessChampionName();
        model.addAttribute("guess", new Guess());
        model.addAttribute("quote", randomQuote);
        model.addAttribute("guesses", guesses);
        model.addAttribute("guessId", guessedChampionName);

        if (randomQuoteChampionName == guessedChampionName){
            System.out.println("you are correct");
        }
        else{
            System.out.println("you are not correct");
        }
        return "quote";
    }

    @PostMapping("/quote")
    public String addGuess(Guess guess){
        guessService.addGuess(guess);
        return "redirect:/quote";
    }
}

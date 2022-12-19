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

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
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
    public String quotePage(Model model, HttpSession httpSession){
        Quote randomQuote;
        if(httpSession.getAttribute("quote") == null){
            randomQuote = quoteService.randomQuote();
            httpSession.setAttribute("quote", randomQuote);
        } else{
            randomQuote = (Quote)httpSession.getAttribute("quote");
        }
        ChampionName randomQuoteChampionName = randomQuote.getChampionName();
        List<Guess> guesses = guessService.allGuesses();
        model.addAttribute("guess", new Guess());
        model.addAttribute("quote", randomQuote);
        model.addAttribute("guesses", guesses);
        if(httpSession.getAttribute("guessed")!= null){
            ChampionName guessedChampionName =  guesses.get(guesses.size()-1).getGuessedChampionName();
            System.out.println("quote " + randomQuoteChampionName);
            System.out.println("your guess" + guessedChampionName);
            if (randomQuoteChampionName == guessedChampionName){
                System.out.println("you are correct");
                httpSession.setAttribute("guessed", null);
                httpSession.setAttribute("quote", null);
            }
            else{
                System.out.println("you are not correct");
            }

        }
        return "quote";
    }

    @PostMapping("/quote")
    public String addGuess(Guess guess, HttpSession httpSession){
        guessService.addGuess(guess);
        httpSession.setAttribute("guessed", "active");

        return "redirect:/quote";
    }
}

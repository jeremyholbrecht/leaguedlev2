package be.intecbrussel.leaguedle.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuoteController {

    private QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }

    // random Quote
    @GetMapping("/quote")
    public String randomQuote(Model model){
        model.addAttribute("quote", quoteService.randomQuote());
        return "quote";
    }
}

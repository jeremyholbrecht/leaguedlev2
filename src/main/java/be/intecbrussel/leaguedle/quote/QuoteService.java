package be.intecbrussel.leaguedle.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }

    // random Quote
    public Quote randomQuote(){
        List<Quote> quotes = quoteRepository.findAll();
        Random random = new Random();
        int position = random.nextInt(quotes.size());
        return quotes.get(position);
    }
}

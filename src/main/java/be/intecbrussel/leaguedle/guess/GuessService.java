package be.intecbrussel.leaguedle.guess;

import be.intecbrussel.leaguedle.champion.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuessService {

    private GuessRepository guessRepository;

    @Autowired
    public GuessService(GuessRepository guessRepository){
        this.guessRepository = guessRepository;
    }

    // add guess
    public void addGuess(Guess guess){
        guessRepository.save(guess);
    }

    // show all guesses
    public List<Guess> allGuesses(){
        return guessRepository.findAll();
    }

    // guess by id
    public Guess getGuessById(Long guessId){
        return guessRepository.findById(guessId).orElse(null);
    }
}

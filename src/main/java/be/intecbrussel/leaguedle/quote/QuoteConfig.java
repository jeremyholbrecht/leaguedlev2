package be.intecbrussel.leaguedle.quote;

import be.intecbrussel.leaguedle.champion.ChampionName;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuoteConfig {

    @Bean
    CommandLineRunner commandLineRunner2(QuoteRepository quoteRepository){
        return args -> {
            Quote aatroxQuote1 = new Quote(
                "The only peace I seek is Death",
                    ChampionName.Aatrox
            );

            Quote ahriQuote1 = new Quote(
                    "No one will stand in my way.",
                    ChampionName.Ahri
            );

            quoteRepository.saveAll(List.of(aatroxQuote1, ahriQuote1));
        };
    }
}

package be.intecbrussel.leaguedle.guess;


import be.intecbrussel.leaguedle.champion.ChampionName;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class Guess {

    @Id
    @SequenceGenerator(
            name = "guess_sequence",
            sequenceName = "guess_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "guess_sequence"
    )
    private Long guessId;
    @Enumerated(EnumType.STRING)
    private ChampionName guessedChampionName;

    public Guess(ChampionName guessedChampionName) {
        this.guessedChampionName = getGuessedChampionName();
    }
}

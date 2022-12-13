package be.intecbrussel.leaguedle.quote;

import be.intecbrussel.leaguedle.champion.ChampionName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name ="quotes")
public class Quote {

    @Id
    @SequenceGenerator(
            name = "quote_sequence",
            sequenceName = "quote_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quote_sequence"
    )
    private Long quoteId;
    private String quote;
    @Enumerated(EnumType.STRING)
    private ChampionName championName;

    public Quote(String quote, ChampionName championName) {
        this.quote = quote;
        this.championName = championName;
    }

}

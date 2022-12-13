package be.intecbrussel.leaguedle.champion;

import lombok.*;
import javax.persistence.*;


@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name ="champions")
public class Champion {

    @Id
    @SequenceGenerator(
            name = "champion_sequence",
            sequenceName = "champion_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "champion_sequence"
    )
    private Long championId;
    private String championName;
    @Enumerated(EnumType.STRING)
    private ChampionGender championGender;
    @Enumerated(EnumType.STRING)
    private ChampionPosition championPosition;
    private String championSpecies;
    @Enumerated(EnumType.STRING)
    private ChampionRescourceType championResourceType;
    @Enumerated(EnumType.STRING)
    private ChampionRangeType championRangeType;
    private String championRegion;
    private String championQuote;
    private Integer championReleaseYear;

    public Champion(String championName, ChampionGender championGender, ChampionPosition championPosition, String championSpecies,
                    ChampionRescourceType championResourceType, ChampionRangeType championRangeType, String championRegion, String championQuote
            ,Integer championReleaseYear) {
        this.championName = championName;
        this.championGender = championGender;
        this.championPosition = championPosition;
        this.championSpecies = championSpecies;
        this.championResourceType = championResourceType;
        this.championRangeType = championRangeType;
        this.championRegion = championRegion;
        this.championQuote = championQuote;
        this.championReleaseYear = championReleaseYear;
    }

}

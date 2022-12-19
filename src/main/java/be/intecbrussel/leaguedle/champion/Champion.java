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
    @Enumerated(EnumType.STRING)
    private ChampionName championName;
    @Enumerated(EnumType.STRING)
    private ChampionGender championGender;
    @Enumerated(EnumType.STRING)
    private ChampionPosition championPosition;
    @Enumerated(EnumType.STRING)
    private ChampionSpecies championSpecies;
    @Enumerated(EnumType.STRING)
    private ChampionRescourceType championResourceType;
    @Enumerated(EnumType.STRING)
    private ChampionRangeType championRangeType;
    @Enumerated(EnumType.STRING)
    private ChampionRegion championRegion;
    private String championQuote;
    private Integer championReleaseYear;

    public Champion(ChampionName championName, ChampionGender championGender, ChampionPosition championPosition, ChampionSpecies championSpecies,
                    ChampionRescourceType championResourceType, ChampionRangeType championRangeType, ChampionRegion championRegion,Integer championReleaseYear) {
        this.championName = championName;
        this.championGender = championGender;
        this.championPosition = championPosition;
        this.championSpecies = championSpecies;
        this.championResourceType = championResourceType;
        this.championRangeType = championRangeType;
        this.championRegion = championRegion;
        this.championReleaseYear = championReleaseYear;
    }

}

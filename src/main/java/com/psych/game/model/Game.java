package com.psych.game.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="games")
public class Game extends Auditable{

    @Getter @Setter @NotNull
    private int numRounds=0;

    @Getter @Setter
    private int currRuound=0;

    @Getter @Setter @ManyToMany
    private Map<Player,Stats> playerStats;

    @Getter @Setter @ManyToMany
    private List<Player> players;

    @Getter @Setter @NotNull
    private GameMode gameMode;

    @Getter @Setter @NotNull
    private GameStatus gameStatus = GameStatus.JOINING;

    @Getter @Setter @ManyToOne @NotNull
    private Player leader;

    @Getter @Setter @OneToMany
    private List<Round> rounds;
}

package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Entity
@Table(name="rounds")
public class Round extends Auditable {
    @ManyToOne @Getter @Setter @NotNull
    private Game game;

    @Getter @Setter @ManyToOne
    private Question question;

    @Getter @Setter @NotNull
    private int roundNumber;

    @Getter @Setter @ManyToMany
    private Map<Player,PlayerAnswer> playerAnswer;
}

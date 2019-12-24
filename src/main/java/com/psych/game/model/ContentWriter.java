package com.psych.game.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="content_writer")
public class ContentWriter extends Employee {
    @Getter @Setter @ManyToMany
    List<Question> editedQuestions;
}

package com.psych.game.contoller;


import com.psych.game.model.Question;
import com.psych.game.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dev")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }
    @GetMapping("/questions/{id}")
    public Question getQuestion(@PathVariable(value="id") Long id) throws Exception{

        return questionRepository.findById(id).orElseThrow(Exception::new);

    }
}

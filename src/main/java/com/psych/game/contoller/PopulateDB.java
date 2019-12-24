package com.psych.game.contoller;


import com.psych.game.Constants;
import com.psych.game.Pair;
import com.psych.game.Utils;
import com.psych.game.model.GameMode;
import com.psych.game.model.Player;
import com.psych.game.model.Question;
import com.psych.game.repository.PlayerRepository;
import com.psych.game.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/dev")
public class PopulateDB {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/add-questions-from-file")
    public void addQuestionsFromFiles() throws IOException {

        questionRepository.deleteAll();

        for(Map.Entry<String,GameMode> entry: Constants.QA_FILES.entrySet()) {

            int questionCount = 0;

            String fileName = entry.getKey();

            GameMode gameMode = entry.getValue();

            for (Pair<String, String> question_answer : Utils.readQAFile(fileName)) {
                Question q = new Question();

                q.setQuestionText(question_answer.getFirst());
                q.setCorrectAnswer(question_answer.getSecond());
                q.setGameMode(gameMode);
                questionRepository.save(q);
                questionCount++;

                if (questionCount > Constants.MAX_QUESTIONS_TO_READ) {
                    break;
                }
            }
        }


}

    @GetMapping("/add-dummy-players")
    public void addDummyPlayers() throws Exception{
        playerRepository.deleteAll();

        Player alexa = new Player();
        alexa.setName("Xena Grills");

        Player siri = new Player();
        siri.setName("Xena Wills");

        playerRepository.save(alexa);
        playerRepository.save(siri);


    }
}

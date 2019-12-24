package com.psych.game;


import com.psych.game.model.GameMode;
import com.psych.game.model.Question;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Pair<String,String>> readQAFile(String fileName) throws FileNotFoundException{

        FileReader fr = new FileReader(fileName);

        BufferedReader br = new BufferedReader(fr);

        List<Pair<String,String>> question_answer = new ArrayList<>();

        String question,answer;

        try{
            do{
                question = br.readLine();
                answer = br.readLine();

                if (question==null || answer==null || question.length()>Constants.MAX_QUESTION_LENGTH || answer.length()>Constants.MAX_ANSWER_LENGTH) {
                    System.out.println("Skipping Question:"+question);
                    System.out.println("Skipping Answer:"+answer);

                    continue;
                }

                question_answer.add(new Pair<>(question,answer));

            }while(question!=null & answer!=null);
        } catch(IOException ignored){

        }

        return question_answer;

    }

}
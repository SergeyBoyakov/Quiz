package com.otus;

import com.otus.service.AnswerService;
import com.otus.service.QuizService;
import com.otus.service.UserService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("/spring-context.xml");

        UserService userService = context.getBean(UserService.class);
        userService.askFirstName();
        userService.askLastName();

        QuizService quizService = context.getBean(QuizService.class);
        quizService.askQuestion(0);
        quizService.askQuestion(1);
        quizService.askQuestion(2);
        quizService.askQuestion(3);
        quizService.askQuestion(4);

        AnswerService answerService = context.getBean(AnswerService.class);
        answerService.showResult();
    }
}

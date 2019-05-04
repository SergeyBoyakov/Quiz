package com.otus.service;


import com.otus.domain.QuizElement;
import com.otus.repository.CsvRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;

import static com.otus.utils.PrintUtils.print;

@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final CsvRepository csvRepository;
    private final Scanner scanner = new Scanner(System.in);
    private final AnswerService answerService;

    @Override
    public void askQuestion(int questionIndex) {
        List<QuizElement> allQuizElements = getAllQuizElements();

        print(allQuizElements.get(questionIndex).getQuestion());

        answerService.askAnswer(questionIndex);
    }

    @Override
    public List<QuizElement> getAllQuizElements() {
        return csvRepository.getAllElements();
    }
}

package com.otus.service;

import com.otus.domain.QuizElement;

import java.util.List;

public interface QuizService {

    void askQuestion(int questionIndex);

    List<QuizElement> getAllQuizElements();
}

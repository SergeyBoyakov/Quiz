package com.otus.domain;

import lombok.Value;

@Value
public class QuizElement {
    private String question;
    private String correctAnswer;
}

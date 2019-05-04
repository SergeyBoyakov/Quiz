package com.otus.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class QuizElement {
    private String question;
    private String correctAnswer;
}

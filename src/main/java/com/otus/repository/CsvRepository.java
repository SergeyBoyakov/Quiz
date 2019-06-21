package com.otus.repository;

import com.otus.domain.QuizElement;

import java.util.List;

public interface CsvRepository {

    List<QuizElement> getAllElements();
}

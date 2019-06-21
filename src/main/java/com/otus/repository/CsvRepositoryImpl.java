package com.otus.repository;

import com.opencsv.CSVReader;
import com.otus.domain.QuizElement;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

@RequiredArgsConstructor
public class CsvRepositoryImpl implements CsvRepository {

    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private final CSVReader reader;
    private List<QuizElement> quizElements;

    @Override
    public List<QuizElement> getAllElements() {
        return isEmpty(quizElements) ? quizElements = readAll() : quizElements;
    }

    private List<QuizElement> readAll() {
        try {
            List<String[]> questionsAnswers = reader.readAll();
            return convertToQuizElements(questionsAnswers);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    private List<QuizElement> convertToQuizElements(List<String[]> questionsAnswers) {
        return questionsAnswers.stream()
                .map(questionAnswer ->
                        new QuizElement(questionAnswer[QUESTION_INDEX], questionAnswer[ANSWER_INDEX]))
                .collect(Collectors.toList());
    }
}

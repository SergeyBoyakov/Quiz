package com.otus.service;

import com.otus.domain.QuizElement;
import com.otus.mock.QuizServiceTestConfig;
import com.otus.repository.CsvRepository;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = QuizServiceTestConfig.class)
@FieldDefaults(level = PRIVATE)
class QuizServiceImplTest {

    private static final String QUESTION = "question";
    private static final String ANSWER = "answer";

    @Autowired
    CsvRepository csvRepository;

    @Autowired
    QuizService quizService;

    @Test
    void getAllQuizElements() {
        // given
        when(csvRepository.getAllElements())
                .thenReturn(asList(new QuizElement(QUESTION, ANSWER)));

        // when
        List<QuizElement> allQuizElements = quizService.getAllQuizElements();

        // then
        assertAll(
                () -> assertEquals(Collections.singletonList(new QuizElement(QUESTION, ANSWER)), allQuizElements)
        );
    }
}
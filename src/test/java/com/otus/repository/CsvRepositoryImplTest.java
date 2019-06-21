package com.otus.repository;

import com.otus.domain.QuizElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/test-context.xml")
class CsvRepositoryImplTest {
    private static final String EXPECTED_QUESTION = "4. How much access modifiers available in Java? 1. 1 2. 2 3. 4 4. 5";

    @Autowired
    private CsvRepository csvRepository;

    @Test
    void should_retrieve_question() {
        // when
        List<QuizElement> allElements = csvRepository.getAllElements();

        // then
        assertEquals(EXPECTED_QUESTION, allElements.get(3).getQuestion());
    }

    @Test
    void should_retrieve_answer() {
        // when
        List<QuizElement> allElements = csvRepository.getAllElements();

        // then
        assertEquals("3", allElements.get(3).getCorrectAnswer());
    }
}
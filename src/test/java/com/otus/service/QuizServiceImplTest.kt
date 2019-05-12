package com.otus.service

import com.otus.domain.QuizElement
import com.otus.mock.QuizServiceTestConfig
import com.otus.repository.CsvRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import kotlin.test.assertEquals

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [QuizServiceTestConfig::class])
class QuizServiceImplTest {
    companion object {
        private const val QUESTION = "question"
        private const val ANSWER = "answer"
    }

    @Autowired
    private lateinit var csvRepository: CsvRepository

    @Autowired
    private lateinit var quizService: QuizService

    @Test
    fun getAllQuizElements() {
        // given
        `when`(csvRepository.getAllElements()).thenReturn(listOf(QuizElement(QUESTION, ANSWER)))

        // when
        val allQuizElements = quizService.getAllQuizElements()

        // then
        assertEquals(1, allQuizElements.size)
        assertEquals(listOf(QuizElement(QUESTION, ANSWER)), allQuizElements)
    }
}
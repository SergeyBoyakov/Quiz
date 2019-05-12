package com.otus.mock

import com.otus.repository.CsvRepository
import com.otus.service.AnswerService
import com.otus.service.AnswerServiceImpl
import com.otus.service.QuizServiceImpl
import org.mockito.Mockito.mock
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class QuizServiceTestConfig {

    @Bean
    open fun quizService() = QuizServiceImpl(csvRepository(), null)

    @Bean
    open fun csvRepository() = mock(CsvRepository::class.java)!!
}
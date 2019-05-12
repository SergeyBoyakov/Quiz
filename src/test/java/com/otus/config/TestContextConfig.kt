package com.otus.config

import com.opencsv.CSVReader
import com.otus.repository.CsvRepositoryImpl
import com.otus.service.AnswerServiceImpl
import com.otus.service.QuizServiceImpl
import com.otus.service.UserServiceImpl
import com.otus.utils.CollectionUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileReader

@Configuration
open class TestContextConfig {

    @Bean
    open fun userService() = UserServiceImpl()

    @Bean
    open fun answerService() = AnswerServiceImpl(userService(), csvRepository(), collectionUtils())

    @Bean
    open fun collectionUtils() = CollectionUtils()

    @Bean
    open fun quizService() = QuizServiceImpl(csvRepository(), answerService())

    @Bean
    open fun fileReader() = FileReader("src/main/resources/Test.csv")

    @Bean
    open fun csvReader() = CSVReader(fileReader())

    @Bean
    open fun csvRepository() = CsvRepositoryImpl(csvReader())
}
package com.otus.testconfig

import com.opencsv.CSVReader
import com.otus.repository.CsvRepository
import com.otus.service.AnswerService
import com.otus.service.QuizServiceImpl
import com.otus.service.UserServiceImpl
import com.otus.service.localization.LocalizationLabels
import com.otus.service.localization.LocalizationService
import com.otus.utils.CollectionUtils
import io.mockk.mockk
import org.mockito.Mockito.mock
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileReader

@Configuration
open class TestContextConfig {

    // TODO Why do we have two separate test configs?
    @Bean
    open fun userService(
        localizationService: LocalizationService,
        labels: LocalizationLabels
    ) = UserServiceImpl(localizationService, labels)

    @Bean
    open fun collectionUtils() = CollectionUtils()

    @Bean
    open fun quizService(
        csvRepository: CsvRepository,
        answerService: AnswerService,
        localizationService: LocalizationService,
        labels: LocalizationLabels
    ) = QuizServiceImpl(csvRepository, answerService, localizationService, labels)

    @Bean
    open fun fileReader() = FileReader("src/main/resources/Test.csv")

    @Bean
    open fun csvReader() = CSVReader(fileReader())

//    @Bean
//    open fun quizService(
//        answerService: AnswerService,
//        csvRepository: CsvRepository,
//        localizationService: LocalizationService,
//        labels: LocalizationLabels
//    ) =
//        QuizServiceImpl(csvRepository, answerService, localizationService, labels)

    @Bean
    open fun csvRepository() = mockk<CsvRepository>()

    @Bean
    open fun answerService() = mockk<AnswerService>()

    @Bean
    open fun localizationService() = mockk<LocalizationService>()

    @Bean
    open fun localizationLabels() = mockk<LocalizationLabels>()
}
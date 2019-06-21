package com.otus.service

import com.otus.BaseIntegrationTest
import com.otus.service.localization.LocalizationLabels
import com.otus.service.localization.LocalizationServiceImpl
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.*
import kotlin.test.assertEquals

open class QuizServiceImplIT : BaseIntegrationTest() {
    companion object {
        private const val QUESTION = "question"
        private const val ANSWER = "answer"
    }

    private lateinit var quizService: QuizService

    @Autowired
    private lateinit var answerService: AnswerService

    private lateinit var localizationService: LocalizationServiceImpl

    @Autowired
    private lateinit var scanner: ConsoleInputService

    @Autowired
    private lateinit var printService: PrintService

    @BeforeEach
    open fun setLocale() {
        Locale.setDefault(Locale.US)
    }

    @Test
    open fun `should return localized string by label`() {
        // given
        every { scanner.nextInt() } returns 1
        localizationService = LocalizationServiceImpl()
        quizService = QuizServiceImpl(answerService, localizationService, printService)

        // when
        val localizedQuestion = quizService.askQuestionWith(LocalizationLabels.FIRST_QUESTION)

        // then
        assertEquals(
            "1. What is not the concepts of OOP? 1. Polymorphism 2. Encapsulation 3. Inheritance 4. Low coupling,4",
            localizedQuestion
        )
    }
}

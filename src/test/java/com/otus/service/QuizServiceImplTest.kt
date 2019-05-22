package com.otus.service

import com.otus.testconfig.TestContextConfig
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [TestContextConfig::class])
class QuizServiceImplTest {
    companion object {
        private const val QUESTION = "question"
        private const val ANSWER = "answer"
    }


    @Autowired
    private lateinit var quizService: QuizService


}
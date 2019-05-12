package com.otus

import com.otus.service.AnswerService
import com.otus.service.QuizService
import com.otus.service.UserService
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan

@ComponentScan
class Application {
    fun main(args: Array<String>) {

        // TODO -------------------------------
        // TODO need to migrate tests to kotlin
        // TODO -------------------------------

        val context = AnnotationConfigApplicationContext()

        val userService = context.getBean(UserService::class.java)
        userService.askFirstName()
        userService.askLastName()

        val quizService = context.getBean(QuizService::class.java)
        quizService.askQuestion(0)
        quizService.askQuestion(1)
        quizService.askQuestion(2)
        quizService.askQuestion(3)
        quizService.askQuestion(4)

        val answerService = context.getBean(AnswerService::class.java)
        answerService.showResult()
    }
}

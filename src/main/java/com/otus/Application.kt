package com.otus

import com.otus.service.AnswerService
import com.otus.service.QuizService
import com.otus.service.UserService
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan

@ComponentScan
open class Application

fun main() {

    val context = AnnotationConfigApplicationContext(Application::class.java)

    val userService = context.getBean(UserService::class.java)
    userService.askFirstName()
    userService.askLastName()

    val quizService = context.getBean(QuizService::class.java)
    quizService.askAllQuestions()

    val answerService = context.getBean(AnswerService::class.java)
    answerService.showResult()
}

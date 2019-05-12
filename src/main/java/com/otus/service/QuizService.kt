package com.otus.service

import com.otus.domain.QuizElement

interface QuizService {

    fun askQuestion(questionIndex: Int)
    fun getAllQuizElements(): List<QuizElement>
}
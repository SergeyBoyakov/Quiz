package com.otus.service

import com.otus.domain.QuizElement

interface QuizService {

    fun askQuestionWith(questionLabel: String)
    fun askAllQuestions()
}
package com.otus.service

interface QuizService {

    fun askQuestionWith(questionLabel: String): String
    fun askAllQuestions()
}
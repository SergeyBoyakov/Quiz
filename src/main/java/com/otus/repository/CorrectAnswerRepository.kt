package com.otus.repository

interface CorrectAnswerRepository {
    fun getCorrectAnswerByLabel(label: String): String
    fun getQuestionLabelsToCorrectAnswers(): Map<String, String>
    fun getQuestionsAmount(): Int
}
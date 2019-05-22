package com.otus.service

interface AnswerService {
    fun showResult()
    fun askAnswer(questionLabel: String): Int
}
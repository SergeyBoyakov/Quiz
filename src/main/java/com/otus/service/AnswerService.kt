package com.otus.service

interface AnswerService {
    fun showResult()
    fun askAnswer(quizElementIndex: Int): Int
}
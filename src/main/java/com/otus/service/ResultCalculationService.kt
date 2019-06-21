package com.otus.service

interface ResultCalculationService {
    fun getUserCorrectAnswersAmount(questionLabelToUserAnswer: MutableMap<String, Int>): Int
}

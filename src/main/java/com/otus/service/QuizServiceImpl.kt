package com.otus.service

import com.otus.service.localization.LocalizationLabels
import com.otus.service.localization.LocalizationService
import org.springframework.stereotype.Service

@Service
class QuizServiceImpl(
    private val answerService: AnswerService,
    private val localizationService: LocalizationService,
    labels: LocalizationLabels
) : QuizService {
    private val allQuestionLabels = listOf(
        labels.FIRST_QUESTION,
        labels.SECOND_QUESTION,
        labels.THIRD_QUESTION,
        labels.FOURTH_QUESTION,
        labels.FIFTH_QUESTION
    )

    override fun askAllQuestions() {
        allQuestionLabels.forEach { askQuestionWith(it) }
    }

    override fun askQuestionWith(questionLabel: String) {
        println(localizationService.getLocalizedStringByLabel(questionLabel))

        answerService.askAnswer(questionLabel)
    }
}
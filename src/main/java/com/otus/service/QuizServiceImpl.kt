package com.otus.service

import com.otus.service.localization.LocalizationLabels
import com.otus.service.localization.LocalizationService
import org.springframework.stereotype.Service

@Service
class QuizServiceImpl(
    private val answerService: AnswerService,
    private val localizationService: LocalizationService,
    private val printService: PrintService
) : QuizService {
    private val allQuestionLabels = listOf(
        LocalizationLabels.FIRST_QUESTION,
        LocalizationLabels.SECOND_QUESTION,
        LocalizationLabels.THIRD_QUESTION,
        LocalizationLabels.FOURTH_QUESTION,
        LocalizationLabels.FIFTH_QUESTION
    )

    override fun askAllQuestions() = allQuestionLabels.forEach { askQuestionWith(it) }

    override fun askQuestionWith(questionLabel: String): String {
        val localizedString = localizationService.getLocalizedStringByLabel(questionLabel)
        printService.println(localizedString)

        answerService.askAnswer(questionLabel)

        return localizedString
    }
}
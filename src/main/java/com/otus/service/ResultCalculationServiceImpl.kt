package com.otus.service

import com.otus.repository.CorrectAnswerRepository
import com.otus.utils.CollectionUtils
import org.springframework.stereotype.Service

@Service
class ResultCalculationServiceImpl(
    private val correctAnswerRepository: CorrectAnswerRepository,
    private val utils: CollectionUtils
) : ResultCalculationService {

    override fun getUserCorrectAnswersAmount(questionLabelToUserAnswer: MutableMap<String, Int>): Int {
        val correctAnswers = correctAnswerRepository.getQuestionLabelsToCorrectAnswers().values.map { it.toInt() }
        return utils.equalElementsCountConsideringIndex(questionLabelToUserAnswer.values.toList(), correctAnswers.toList())
    }
}
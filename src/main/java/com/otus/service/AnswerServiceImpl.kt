package com.otus.service

import com.otus.domain.QuizElement
import com.otus.repository.CsvRepository
import com.otus.utils.CollectionUtils
import org.springframework.stereotype.Service
import java.util.*

@Service
class AnswerServiceImpl(
    private val userService: UserService,
    private val csvRepository: CsvRepository,
    private val utils: CollectionUtils
) : AnswerService {

    private val scanner = Scanner(System.`in`)
    private val questionLabelToUserAnswer = mutableMapOf<String, Int>()

    override fun showResult() {
        userService.showFullName()
        println("You result: ${getResult()} of ${questionCount()}")
    }

    override fun askAnswer(questionLabel: String): Int {
        val answer = scanner.nextInt()
        questionLabelToUserAnswer[questionLabel] = answer

        return answer
    }

    private fun questionCount(): Int {
        return getCorrectAnswers(csvRepository.getAllElements()).size
    }

    private fun getResult(): Long {
        val correctAnswers = getCorrectAnswers(csvRepository.getAllElements())

        return utils.equalElementsCountConsideringIndex(correctAnswers, questionLabelToUserAnswer.values.toList())
    }

    private fun getCorrectAnswers(allElements: List<QuizElement>): List<Int> {
        return allElements
            .map { it.correctAnswer }
            .map { it.toInt() }
            .toList()
    }
}
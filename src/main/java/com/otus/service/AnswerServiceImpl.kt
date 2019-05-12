package com.otus.service

import com.otus.domain.QuizElement
import com.otus.repository.CsvRepository
import com.otus.utils.CollectionUtils
import org.springframework.stereotype.Service
import java.util.*

@Service
class AnswerServiceImpl(private val userService: UserService,
                        private val csvRepository: CsvRepository,
                        private val utils: CollectionUtils) : AnswerService {

    private val scanner = Scanner(System.`in`)
    private val userAnswers = mutableListOf<Int>()

    override fun showResult() {
        userService.showFullName()
        print("You result: ${getResult()} of ${questionCount()}")
    }

    override fun askAnswer(quizElementIndex: Int): Int {
        val answer = scanner.nextInt()
        userAnswers.add(scanner.nextInt())

        return answer
    }

    private fun questionCount(): Int {
        return getCorrectAnswers(csvRepository.getAllElements()).size
    }

    private fun getResult(): Long {
        val correctAnswers = getCorrectAnswers(csvRepository.getAllElements())
        return utils.equalElementsCountConsideringIndex(correctAnswers, userAnswers)
    }

    private fun getCorrectAnswers(allElements: List<QuizElement>): List<Int> {
        return allElements
                .map { it.correctAnswer }
                .map { it.toInt() }
                .toList()
    }
}
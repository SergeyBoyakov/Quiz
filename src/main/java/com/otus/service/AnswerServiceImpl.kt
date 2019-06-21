package com.otus.service

import com.otus.repository.CorrectAnswerRepository
import org.springframework.stereotype.Service

@Service
open class AnswerServiceImpl(
    private val userService: UserService,
    private val scanner: ConsoleInputService,
    private val printService: PrintService,
    private val correctAnswerRepo: CorrectAnswerRepository,
    private val resultCalculationService: ResultCalculationService

) : AnswerService {

    private val questionLabelToUserAnswer = mutableMapOf<String, Int>()

    override fun showResult() {
        userService.showFullName()
        printService.println("Your result is ${userCorrectAnswersAmount()} of ${questionsAmount()}")
    }

    private fun userCorrectAnswersAmount() =
        resultCalculationService.getUserCorrectAnswersAmount(questionLabelToUserAnswer)

    private fun questionsAmount() = correctAnswerRepo.getQuestionsAmount()

    override fun askAnswer(questionLabel: String): Int {
        val answer = scanner.nextInt()
        questionLabelToUserAnswer[questionLabel] = answer

        return answer
    }
}
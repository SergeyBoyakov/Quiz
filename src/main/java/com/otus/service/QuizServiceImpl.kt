package com.otus.service

import com.otus.domain.QuizElement
import com.otus.repository.CsvRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class QuizServiceImpl(private val csvRepository: CsvRepository,
                      private val answerService: AnswerService?) : QuizService {
    private val scanner = Scanner(System.`in`)

    override fun askQuestion(questionIndex: Int) {
        print(getAllQuizElements()[questionIndex].question)

        answerService?.askAnswer(questionIndex)
    }

    override fun getAllQuizElements(): List<QuizElement> = csvRepository.getAllElements()
}
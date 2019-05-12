package com.otus.repository

import com.opencsv.CSVReader
import com.otus.domain.QuizElement
import com.otus.exception.InvalidDataException
import org.springframework.stereotype.Service

@Service
open class CsvRepositoryImpl(private val reader: CSVReader) : CsvRepository {

    private var quizElements: List<QuizElement> = emptyList()

    companion object {
        private const val QUESTION_INDEX: Int = 0
        private const val ANSWER_INDEX: Int = 1
    }

    override fun getAllElements(): List<QuizElement> {
        if (quizElements.isNullOrEmpty()) quizElements = readAll()

        return quizElements
    }

    private fun readAllFromFile(): List<Array<String>>? = reader.readAll() ?: emptyList()


    private fun validateData(questionsAnswers: List<Array<String>>) {
        val hasNotValidQuestionAnswer = questionsAnswers
                .any { it: Array<String> -> it.size != 2 }
                .or(questionsAnswers.isEmpty())

        if (hasNotValidQuestionAnswer) throw InvalidDataException("Data in file is not valid");
    }

    private fun readAll(): List<QuizElement> {
        return reader.readAll()
                .map { it: Array<String> -> QuizElement(it[QUESTION_INDEX], it[ANSWER_INDEX]) }
                .toList()
    }
}
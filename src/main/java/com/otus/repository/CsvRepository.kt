package com.otus.repository

import com.otus.domain.QuizElement
import org.springframework.stereotype.Repository

interface CsvRepository {

    fun getAllElements(): List<QuizElement>

}
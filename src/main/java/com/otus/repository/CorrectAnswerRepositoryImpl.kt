package com.otus.repository

import org.springframework.stereotype.Service
import java.io.FileInputStream
import java.io.InputStream
import java.util.*

@Service
class CorrectAnswerRepositoryImpl : CorrectAnswerRepository {
    private val properties = Properties()
    private lateinit var input: InputStream

    override fun getCorrectAnswerByLabel(label: String): String {
        input = FileInputStream("src/main/resources/CorrectAnswers.yml")
        input.use {
            properties.load(input)

            return properties.getProperty(label)
        }
    }

    override fun getQuestionLabelsToCorrectAnswers(): Map<String, String> {
        input = FileInputStream("src/main/resources/CorrectAnswers.yml")
        input.use {
            properties.load(input)

            return properties.entries
                .map { it.key as String to it.value as String }
                .toMap()
        }
    }

    override fun getQuestionsAmount(): Int {
        return getQuestionLabelsToCorrectAnswers().size
    }
}


package com.otus.repository

import com.otus.config.TestContextConfig
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import kotlin.test.assertEquals

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [TestContextConfig::class])
class CsvRepositoryImplTest (@Autowired val csvRepository: CsvRepository){
    companion object {
        private const val EXPECTED_QUESTION = "4. How much access modifiers available in Java? 1. 1 2. 2 3. 4 4. 5"
    }

    @Test
    fun should_retrieve_question() {
        // when
        val allElements = csvRepository.getAllElements()

        // then
        assertEquals(EXPECTED_QUESTION, allElements[3].question)
    }

    @Test
    fun should_retrieve_answer() {
        // when
        val allElements = csvRepository.getAllElements()

        // then
        assertEquals("3", allElements[3].correctAnswer)
    }
}
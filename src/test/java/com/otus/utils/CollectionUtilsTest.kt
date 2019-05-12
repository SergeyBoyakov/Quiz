package com.otus.utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.function.Executable
import kotlin.test.assertEquals


class CollectionUtilsTest {

    @Test
    fun should_return_count_equal_elements_considering_index() {
        val utils = CollectionUtils()

        assertAll(
                Executable {
                    assertEquals(1, utils.equalElementsCountConsideringIndex(listOf(1, 2, 3), listOf(3, 2, 1)))
                },
                Executable {
                    assertEquals(2, utils.equalElementsCountConsideringIndex(listOf(1, 2, 1), listOf(3, 2, 1)))
                },
                Executable {
                    assertEquals(0, utils.equalElementsCountConsideringIndex(emptyList(), emptyList()))
                },
                Executable {
                    assertEquals(0, utils.equalElementsCountConsideringIndex(listOf(1, 2, 3, 4), listOf(2, 1, 1, 1)))
                }
        )
    }
}
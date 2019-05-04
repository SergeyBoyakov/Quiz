package com.otus.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.otus.utils.CollectionUtils.equalElementsCountConsideringIndex;
import static com.otus.utils.CollectionUtils.nonNull;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {

    @Test
    @DisplayName("should return count equal elements considering index")
    void should_return_count_equal_elements_considering_index() {
        assertAll(
                () -> assertEquals(1, equalElementsCountConsideringIndex(asList(1, 2, 3), asList(3, 2, 1))),
                () -> assertEquals(2, equalElementsCountConsideringIndex(asList(1, 2, 1), asList(3, 2, 1))),
                () -> assertEquals(0, equalElementsCountConsideringIndex(emptyList(), emptyList())),
                () -> assertEquals(0, equalElementsCountConsideringIndex(asList(1, 2, 3, 4), asList(2, 1, 1, 1)))
        );
    }

    @Test
    @DisplayName("should return false if at least one of the parameters is null")
    void should_return_false_if_at_least_one_of_the_parameters_is_null() {
        assertAll(
                () -> assertTrue(nonNull(asList(1, 2, 3), asList("1", "2", "3"))),
                () -> assertFalse(nonNull(null, asList(1, 2, 3)))
        );
    }
}
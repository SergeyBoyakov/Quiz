package com.otus.utils

import org.springframework.stereotype.Component

@Component
class CollectionUtils {
    fun equalElementsCountConsideringIndex(left: List<Int>, right: List<Int>): Long {
        var count = 0L
        for (index in 0..left.lastIndex)
            if (left[index] == right[index]) count++

        return count
    }
}
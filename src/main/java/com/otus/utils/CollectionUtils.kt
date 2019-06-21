package com.otus.utils

import org.springframework.stereotype.Component

@Component
open class CollectionUtils {
    open fun equalElementsCountConsideringIndex(left: List<Int>, right: List<Int>): Int {
        var count = 0
        for (index in 0..left.lastIndex)
            if (left[index] == right[index]) count++

        return count
    }
}
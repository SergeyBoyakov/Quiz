package com.otus.utils

import spock.lang.Specification

class CollectionUtilsSpec extends Specification {

    def 'should return count equal elements considering index'() {
        given:
        def utils = new CollectionUtils()

        expect:
        utils.equalElementsCountConsideringIndex(left as List<Integer>, right as List<Integer>) == result

        where:
        left         | right        | result
        [1, 2, 3]    | [3, 2, 1]    | 1
        [1, 2, 1]    | [3, 2, 1]    | 2
        []           | []           | 0
        [1, 2, 3, 4] | [2, 1, 1, 1] | 0
    }
}

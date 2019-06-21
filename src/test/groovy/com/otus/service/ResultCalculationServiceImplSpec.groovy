package com.otus.service

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.otus.repository.CorrectAnswerRepository
import com.otus.utils.CollectionUtils
import spock.lang.Specification


class ResultCalculationServiceImplSpec extends Specification {

    @Subject
    ResultCalculationServiceImpl service

    @Collaborator
    CollectionUtils collectionUtils = new CollectionUtils()

    @Collaborator
    CorrectAnswerRepository correctAnswerRepository = Mock()

    def 'should return amount of user s correct answers'() {
        setup:
        correctAnswerRepository.questionLabelsToCorrectAnswers >> [
                "first.question" : "1",
                "second.question": "2",
                "third.question" : "3"]

        expect:
        correctAnswersAmount == service.getUserCorrectAnswersAmount(
                ["first.question" : firstUserAnswer,
                 "second.question": secondUserAnswer,
                 "third.question" : thirdUserAnswer] as Map<String, Integer>)

        where:
        firstUserAnswer | secondUserAnswer | thirdUserAnswer | correctAnswersAmount
        1               | 3                | 2               | 1
        1               | 2                | 3               | 3
        0               | 0                | 0               | 0
        2               | 2                | 3               | 2
    }
}

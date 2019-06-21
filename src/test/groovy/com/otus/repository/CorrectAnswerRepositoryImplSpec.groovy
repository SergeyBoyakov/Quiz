package com.otus.repository

import spock.lang.Specification
import com.otus.service.localization.LocalizationLabels

class CorrectAnswerRepositoryImplSpec extends Specification {

    def 'should return question amount'() {
        setup:
        def repo = new CorrectAnswerRepositoryImpl()

        when:
        def amount = repo.questionsAmount

        then:
        5 == amount
    }

    def 'should retrieve correct answer'() {
        setup:
        def repo = new CorrectAnswerRepositoryImpl()

        when:
        String correctAnswer = repo.getCorrectAnswerByLabel(LocalizationLabels.FIRST_QUESTION)

        then:
        "4" == correctAnswer
    }

    def 'should throw exception if retrieve by non existent label'() {
        setup:
        def repo = new CorrectAnswerRepositoryImpl()
        def NON_EXISTENT_LABEL = "NON_EXISTENT_LABEL"

        when:
        repo.getCorrectAnswerByLabel(NON_EXISTENT_LABEL)

        then:
        thrown IllegalStateException
    }
}


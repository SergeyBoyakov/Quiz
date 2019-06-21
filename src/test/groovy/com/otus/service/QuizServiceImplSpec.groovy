package com.otus.service

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.otus.service.localization.LocalizationService
import spock.lang.Specification

class QuizServiceImplSpec extends Specification {
    private static final String LABEL = "label"
    private static final String LOCALIZED_STRING = "localized string"

    @Collaborator
    AnswerService answerService = Mock()

    @Collaborator
    LocalizationService localizationService = Mock()

    @Collaborator
    PrintService printService = Mock()

    @Subject
    QuizServiceImpl quizService

    def 'should print localized string'() {
        setup: 'mock logic'
        localizationService.getLocalizedStringByLabel(LABEL) >> LOCALIZED_STRING

        when:
        quizService.askQuestionWith(LABEL)

        then: 'should print localized string'
        1 * printService.println(LOCALIZED_STRING)
    }

    def 'should ask answer'() {
        setup:
        localizationService.getLocalizedStringByLabel(LABEL) >> LOCALIZED_STRING

        when:
        quizService.askQuestionWith(LABEL)

        then:
        1 * answerService.askAnswer(LABEL)
    }

    def 'should return question'() {
        setup:
        localizationService.getLocalizedStringByLabel(LABEL) >> LOCALIZED_STRING

        when:
        def actualQuestion = quizService.askQuestionWith(LABEL)

        then:
        LOCALIZED_STRING == actualQuestion
    }
}

package com.otus.service

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.otus.repository.CorrectAnswerRepository
import spock.lang.Specification

class AnswerServiceImplSpec extends Specification {
    final String LABEL = "LABEL"

    @Subject
    AnswerServiceImpl service

    @Collaborator
    UserService userService = Mock()

    @Collaborator
    ConsoleInputService scanner = Mock()

    @Collaborator
    PrintService printService = Mock()

    @Collaborator
    CorrectAnswerRepository correctAnswerRepository = Mock()

    @Collaborator
    ResultCalculationService resultCalculationService = Mock()

    def 'should show full name'() {
        when:
        service.showResult()

        then:
        1 * userService.showFullName()
    }

    def 'should print result'() {
        when:
        service.showResult()

        then:
        1 * printService.println(_) >> null
    }

    def 'should ask to input answer'() {
        when:
        service.askAnswer(_ as String)

        then:
        1 * scanner.nextInt()
    }

    def 'should add user answer to questionLabelToUserAnswer name'() {
        setup:
        scanner.nextInt() >> 2
        service.questionLabelToUserAnswer.clear()

        when:
        service.askAnswer(LABEL)

        then:
        service.questionLabelToUserAnswer.size() == 1
        service.questionLabelToUserAnswer.get(LABEL) == 2
    }

    def 'should return user answer'() {
        setup:
        scanner.nextInt() >> 5

        when:
        def userAnswer = service.askAnswer(LABEL)

        then:
        userAnswer == 5
    }
}

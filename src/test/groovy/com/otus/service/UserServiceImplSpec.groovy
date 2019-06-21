package com.otus.service

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.otus.service.localization.LocalizationService
import spock.lang.Specification

class UserServiceImplSpec extends Specification {

    @Subject
    UserServiceImpl service

    @Collaborator
    LocalizationService localizationService = Mock()

    @Collaborator
    ConsoleInputService scanner = Mock()

    @Collaborator
    PrintService printService = Mock()

    def 'should demand first name'() {
        setup:
        localizationService.getLocalizedStringByLabel(_ as String) >> "Your first name:"
        scanner.next() >> "John"

        when:
        service.askFirstName()

        then:
        1 * printService.println("Your first name:")
    }

    def 'should demand input first name'() {
        when:
        service.askFirstName()

        then:
        1 * scanner.next()
    }

    def 'should demand last name'() {
        setup:
        localizationService.getLocalizedStringByLabel(_ as String) >> "Your last name:"

        when:
        service.askLastName()

        then:
        1 * printService.println("Your last name:")
    }

    def 'should demand input last name'() {
        when:
        service.askLastName()

        then:
        1 * scanner.next()
    }

    def 'should show full name'() {
        setup:
        service.firstName = "John"
        service.lastName = "Doe"

        when:
        service.showFullName()

        then:
        1 * printService.println("John Doe")
    }
}

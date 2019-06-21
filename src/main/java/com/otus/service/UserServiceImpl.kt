package com.otus.service

import com.otus.service.localization.LocalizationLabels.ASK_FIRST_NAME
import com.otus.service.localization.LocalizationLabels.ASK_LAST_NAME
import com.otus.service.localization.LocalizationService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val localizationService: LocalizationService,
    private val scanner: ConsoleInputService,
    private val printService: PrintService
) : UserService {

    private lateinit var firstName: String
    private lateinit var lastName: String

    override fun askFirstName() {
        val demandFirstName = localizationService.getLocalizedStringByLabel(ASK_FIRST_NAME)
        printService.println(demandFirstName)
        firstName = scanner.next() ?: ""
    }

    override fun askLastName() {
        val demandLastName = localizationService.getLocalizedStringByLabel(ASK_LAST_NAME)
        printService.println(demandLastName)
        lastName = scanner.next() ?: ""
    }

    override fun showFullName() {
        printService.println("$firstName $lastName")
    }
}
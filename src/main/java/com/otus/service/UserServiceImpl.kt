package com.otus.service

import com.otus.service.localization.LocalizationLabels
import com.otus.service.localization.LocalizationService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val localizationService: LocalizationService,
    private val localizationLabels: LocalizationLabels
) : UserService {

    private lateinit var firstName: String
    private lateinit var lastName: String
    private val scanner = Scanner(System.`in`)

    override fun askFirstName() {
        println(localizationService.getLocalizedStringByLabel(localizationLabels.ASK_FIRST_NAME))
        firstName = scanner.next()
    }

    override fun askLastName() {
        println(localizationService.getLocalizedStringByLabel(localizationLabels.ASK_LAST_NAME))
        lastName = scanner.next()
    }

    override fun showFullName() {
        println("$firstName $lastName")
    }
}
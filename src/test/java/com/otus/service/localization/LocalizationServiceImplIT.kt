package com.otus.service.localization

import com.otus.BaseIntegrationTest
import com.otus.service.localization.LocalizationLabels.ASK_FIRST_NAME
import com.otus.service.localization.LocalizationLabels.ASK_LAST_NAME
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

open class LocalizationServiceImplIT : BaseIntegrationTest() {

    @Test
    fun `should retrieve en_US question if locale en_US`() {
        // given
        Locale.setDefault(Locale.US)

        // when
        val localizedString = LocalizationServiceImpl().getLocalizedStringByLabel(ASK_FIRST_NAME)

        // then
        assertEquals("First name:", localizedString)
    }

    @Test
    fun `should retrieve ru_RU question if locale ru_RU`() {
        // given
        Locale.setDefault(Locale("ru", "RU"))

        // when
        val localizedString = LocalizationServiceImpl().getLocalizedStringByLabel(ASK_LAST_NAME)

        // then
        assertEquals("Введите свою фамилию", localizedString)
    }

    @Test
    fun `should retrieve default question if bundle with locale not exists`() {
        // given
        Locale.setDefault(Locale.KOREA)

        // when
        val localizedString = LocalizationServiceImpl().getLocalizedStringByLabel(ASK_FIRST_NAME)

        // then
        assertEquals("Erste name:", localizedString)
    }
}
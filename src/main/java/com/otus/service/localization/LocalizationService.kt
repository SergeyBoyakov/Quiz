package com.otus.service.localization

interface LocalizationService {
    fun getLocalizedStringByLabel(label: String): String
}

package com.otus.service.localization

import org.springframework.stereotype.Service
import java.util.*

@Service
open class LocalizationService {
    companion object {
        private const val LABELS = "Labels"
    }

    private val bundle = ResourceBundle.getBundle(LABELS)

    fun getLocalizedStringByLabel(label: String) = bundle.getString(label)!!
}
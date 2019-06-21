package com.otus.service.localization

import org.springframework.context.annotation.Scope
import org.springframework.context.support.BeanDefinitionDsl
import org.springframework.stereotype.Service
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

@Service
open class LocalizationServiceImpl : LocalizationService {
    private var bundle: ResourceBundle

    companion object {
        private const val LABELS = "Labels"
    }

    init {
        bundle = ResourceBundle.getBundle(LABELS, Locale.getDefault(), UTF8Control())
    }

    override fun getLocalizedStringByLabel(label: String) = bundle.getString(label)!!
}

class UTF8Control : ResourceBundle.Control() {
    override fun newBundle(
        baseName: String,
        locale: Locale,
        format: String,
        loader: ClassLoader,
        reload: Boolean
    ): ResourceBundle {
        val bundleName = toBundleName(baseName, locale)
        val resourceName = toResourceName(bundleName, "properties")
        lateinit var bundle: ResourceBundle
        val inputStream: InputStream
        if (reload) {
            val connection = loader.getResource(resourceName)?.openConnection()
            connection?.useCaches = false
            inputStream = connection?.getInputStream()!!
        } else {
            inputStream = loader.getResourceAsStream(resourceName)
        }

        if (inputStream !== null) {
            inputStream.use { stream ->
                bundle = PropertyResourceBundle(InputStreamReader(stream, "UTF-8"))
            }
        }

        return bundle
    }
}

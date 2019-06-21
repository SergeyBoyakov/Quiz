package com.otus.service

import org.springframework.stereotype.Service

@Service
open class PrintServiceImpl : PrintService {
    override fun print(message: Any) {
        kotlin.io.print(message)
    }

    override fun println(message: Any) {
        kotlin.io.println(message)
    }
}
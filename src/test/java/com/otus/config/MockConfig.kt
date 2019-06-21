package com.otus.config

import com.otus.service.ConsoleInputService
import com.otus.service.ConsoleInputServiceImpl
import io.mockk.mockk
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
open class MockConfig {

    @Bean
    @Primary
    open fun consoleInputService(): ConsoleInputService {
        return mockk<ConsoleInputServiceImpl>()
    }
}
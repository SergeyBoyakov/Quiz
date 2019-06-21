package com.otus.service

import org.springframework.stereotype.Service
import java.util.*

@Service
open class ConsoleInputServiceImpl(private val scanner: Scanner) : ConsoleInputService {

    override fun nextInt() = scanner.nextInt()
    override fun next() = scanner.next() ?: ""
}
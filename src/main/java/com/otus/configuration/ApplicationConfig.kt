package com.otus.configuration

import com.opencsv.CSVReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File
import java.io.FileReader
import java.util.*

@Configuration
open class ApplicationConfig {
    @Bean
    open fun csvReader(fileReader: FileReader): CSVReader {
        return CSVReader(fileReader)
    }

    @Bean
    open fun fileReader(): FileReader {
        return FileReader(File("src/main/resources/Test.csv"))
    }

    @Bean
    open fun scanner(): Scanner {
        return Scanner(System.`in`)
    }
}

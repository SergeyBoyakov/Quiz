package com.otus.configuration

import com.opencsv.CSVReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File
import java.io.FileReader

@Configuration
open class ApplicatinConfig {
    @Bean
    open fun csvReader(fileReader: FileReader): CSVReader {
        return CSVReader(fileReader)
    }

    @Bean
    open fun fileReader(): FileReader {
        return FileReader(File("src/main/resources/Test.csv"))
    }
}
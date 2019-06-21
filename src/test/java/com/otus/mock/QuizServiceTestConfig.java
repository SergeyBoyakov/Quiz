package com.otus.mock;

import com.otus.repository.CsvRepository;
import com.otus.service.QuizService;
import com.otus.service.QuizServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@Configuration
public class QuizServiceTestConfig {

    @Bean
    public QuizService quizService(){
        return new QuizServiceImpl(csvRepository(), null);
    }

    @Bean
    @Primary
    public CsvRepository csvRepository() {
        return mock(CsvRepository.class);
    }
}

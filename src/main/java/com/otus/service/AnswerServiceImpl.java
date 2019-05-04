package com.otus.service;

import com.otus.domain.QuizElement;
import com.otus.repository.CsvRepository;
import com.otus.utils.CollectionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.otus.utils.PrintUtils.print;

@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final UserService userService;
    private final CsvRepository csvRepository;

    private Scanner scanner = new Scanner(System.in);

    private static List<Integer> userAnswers = new ArrayList<>();

    @Override
    public void showResult() {
        userService.showFullName();
        print("You result: " + getResult() + " of " + questionCount());
    }

    @Override
    public Integer askAnswer(int quizElementIndex) {
        int answer = scanner.nextInt();
        userAnswers.add(answer);

        return answer;
    }

    private Integer questionCount(){
        return getCorrectAnswers(csvRepository.getAllElements()).size();
    }

    private Long getResult() {
        List<Integer> correctAnswers = getCorrectAnswers(csvRepository.getAllElements());

        return CollectionUtils.equalElementsCountConsideringIndex(correctAnswers, userAnswers);
    }


    private List<Integer> getCorrectAnswers(List<QuizElement> allElements) {
        return allElements.stream()
                .map(QuizElement::getCorrectAnswer)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}


package com.otus.service;

import lombok.Data;

import java.util.Scanner;

import static com.otus.utils.PrintUtils.print;

@Data
public class UserServiceImpl implements UserService {

    private String firstName;
    private String lastName;
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void askFirstName() {
        print("Your first name: ");
        firstName = scanner.next();
    }

    @Override
    public void askLastName() {
        print("Your last name: ");
        lastName = scanner.next();
    }

    @Override
    public void showFullName() {
        print(firstName + " " + lastName);
    }
}

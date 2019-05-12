package com.otus.service

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : UserService {

    private lateinit var firstName: String
    private lateinit var lastName: String
    private val scanner = Scanner(System.`in`)

    override fun askFirstName() {
        print("Your first name: ")
        firstName = scanner.next()
    }

    override fun askLastName() {
        print("Your last name: ")
        lastName = scanner.next()
    }

    override fun showFullName() {
        print("$firstName $lastName")
    }
}
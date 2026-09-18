# Tsooanap-artone

# Tsooanapartone

## Project Overview

This project is a Java-based registration and login system developed as part of a programming project.

The system allows a user to register by entering their personal details, username, password, and cellphone number. The information is validated before the registration is completed.

## Features

- Allows the user to enter their first name and surname.
- Validates the username.
- Checks that the username contains an underscore (`_`).
- Checks that the username is no more than 5 characters long.
- Validates password complexity.
- Requires the password to contain at least 8 characters.
- Requires a capital letter, number, and special character.
- Validates a South African cellphone number using a regular expression.
- Allows the user to log in using their registered username and password.
- Displays an error message when incorrect login details are entered.
- Displays a personalised welcome message after a successful login.
- Includes JUnit tests to test the functionality of the Login class.

## Technologies Used

- Java
- NetBeans IDE
- JUnit
- GitHub
- Regular Expressions (Regex)

## Testing

JUnit tests were created to test the main functionality of the Login class, including:

- Username validation
- Password complexity validation
- Cellphone number validation
- User registration
- Successful login
- Unsuccessful login
- Login status messages

All implemented JUnit tests pass successfully.

## Project Structure

- `Tsooanapartone.java` - Contains the main program and user interaction.
- `login.java` - Contains the registration, validation, and login methods.
- `LoginTest.java` - Contains the JUnit tests for the Login class.

## Author

Tsooana Mokowenya

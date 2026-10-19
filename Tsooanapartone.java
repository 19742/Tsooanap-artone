/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tsooanapartone;

import java.util.Scanner;

/**
 *
 * @author tmoko
 */
public class Tsooanapartone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create Scanner object to receive input from the user
        Scanner input = new Scanner(System.in);

        // Declare variables for the user's details
        String firstName;
        String surname;
        String username;
        String password;
        String cellPhoneNumber;

        // Declare variables used for login
        String enteredUsername;
        String enteredPassword;
        boolean loginSuccessful;

        // Declare Login objects
        login login;
        login testLogin;

        // Ask the user for their first name
do {
    System.out.print("Enter your first name: ");
    firstName = input.nextLine();

    // Check if the first name is empty
    if (firstName.trim().isEmpty()) {
        System.out.println("First name cannot be empty. Please try again.");
    }

} while (firstName.trim().isEmpty());

        // Ask the user for their surname
do {
    System.out.print("Enter your surname: ");
    surname = input.nextLine();

    // Check if the surname is empty
    if (surname.trim().isEmpty()) {
        System.out.println("Surname cannot be empty. Please try again.");
    }

} while (surname.trim().isEmpty());

        // Ask the user for a valid username
        while (true) {

            // Display the username requirements
            System.out.println("Username must contain an underscore (_) and be no more than 5 characters.");
            System.out.print("Enter your username: ");
            username = input.nextLine();

            // Create a temporary Login object to validate the username
            testLogin = new login(username, "", "");

            // Check whether the username meets the requirements
            if (testLogin.checkUserName()) {
                System.out.println("Username accepted.");
                break;
            } else {
                System.out.println("Username is invalid. Please try again.");
            }
        }

        // Ask the user for a valid password
        while (true) {

            // Display the password requirements
            System.out.println("Password must be at least 8 characters long, contain a capital letter, a number, and a special character.");
            System.out.print("Enter your password: ");
            password = input.nextLine();

            // Create a temporary Login object to validate the password
            testLogin = new login("", password, "");

            // Check whether the password meets the requirements
            if (testLogin.checkPasswordComplexity()) {
                System.out.println("Password accepted.");
                break;
            } else {
                System.out.println("Password is invalid. Please try again.");
            }
        }

        // Ask the user for a valid cellphone number
        while (true) {

            // Display the cellphone number requirements
            System.out.println("Cellphone number must be in international format, for example +27745620711.");
            System.out.print("Enter your cellphone number: ");
            cellPhoneNumber = input.nextLine();

            // Create a temporary Login object to validate the cellphone number
            testLogin = new login("", "", cellPhoneNumber);

            // Check whether the cellphone number meets the requirements
            if (testLogin.checkCellPhoneNumber()) {
                System.out.println("Cellphone number accepted.");
                break;
            } else {
                System.out.println("Cellphone number is invalid. Please try again.");
            }
        }

        // Create the Login object using all of the validated user details
login = new login(firstName, surname, username, password, cellPhoneNumber);
        // Register the user and display the registration result
        System.out.println(login.registerUser());

        // Display the login section
        System.out.println();
        System.out.println("================================");
        System.out.println("             LOGIN");
        System.out.println("================================");

        // Keep asking for login details until the user logs in successfully
        while (true) {

            // Ask the user to enter their registered username
            System.out.print("Enter your username to login: ");
            enteredUsername = input.nextLine();

            // Ask the user to enter their registered password
            System.out.print("Enter your password to login: ");
            enteredPassword = input.nextLine();

            // Check whether the entered details match the registered details
            loginSuccessful = login.loginUser(enteredUsername, enteredPassword);

            // Display the appropriate login message
            System.out.println(login.returnLoginStatus(loginSuccessful));

            // Stop the loop when the login is successful
            if (loginSuccessful) {
                break;
            }

            // Inform the user that they can try again
            System.out.println("Please enter your login details again.");
        }

        // Close the Scanner
        input.close();
    }
}
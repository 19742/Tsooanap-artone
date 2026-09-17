package tsooanapartone;

import java.util.regex.Pattern;

public class login {

    // Store the user's personal and login details
private String firstName;
private String surname;
private String username;
private String password;
private String cellPhoneNumber;
    /**
     *
     * @param username
     * @param password
     * @param cellPhoneNumber
     */
    public login(String username, String password, String cellPhoneNumber) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }
    
    // Constructor used to store all of the user's registration details
public login(String firstName, String surname, String username,
        String password, String cellPhoneNumber) {

    this.firstName = firstName;
    this.surname = surname;
    this.username = username;
    this.password = password;
    this.cellPhoneNumber = cellPhoneNumber;
}

    // Checks if the username has an underscore and is 5 characters or less
    public boolean checkUserName() {

        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    // Checks if the password meets the required complexity
    public boolean checkPasswordComplexity() {

        // Password must have at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Flags used to check the password requirements
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        // Check each character in the password
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            // Check for a capital letter
            if (Character.isUpperCase(ch)) {
                hasCapitalLetter = true;
            }

            // Check for a number
            if (Character.isDigit(ch)) {
                hasNumber = true;
            }

            // Check for a special character
            if (!Character.isLetterOrDigit(ch)) {
                hasSpecialCharacter = true;
            }
        }

        // All requirements must be met
        return hasCapitalLetter && hasNumber && hasSpecialCharacter;
    }

    // Checks if the cellphone number is in the correct international format
    public boolean checkCellPhoneNumber() {

        // Regular expression for a South African international cellphone number
        String phoneRegex = "^\\+27[0-9]{9}$";

        return Pattern.matches(phoneRegex, cellPhoneNumber);
    }

    // Registers the user if all details are valid
    public String registerUser() {

        if (!checkUserName()) {
            return "Username is incorrectly formatted.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is incorrectly formatted.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell phone number is incorrectly formatted.";
        }

        return "Registration successful.";
    }

    // Checks if the login details match the registered details
    public boolean loginUser(String enteredUsername, String enteredPassword) {

        return username.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

   // Returns a message showing whether the login was successful
public String returnLoginStatus(boolean loginSuccessful){ 

    if (loginSuccessful) {

        // If the user's name was provided, use a personalised message
        if (firstName != null && surname != null) {
            return "Welcome " + firstName + " " + surname
                    + ", it is great to see you again.";
        } else {
            // Used when no first name or surname was provided
            return "Welcome back! It is great to see you again.";
        }

    } else {
        // Message displayed when the login details are incorrect
        return "Username or password incorrect, please try again.";
    }
}
}




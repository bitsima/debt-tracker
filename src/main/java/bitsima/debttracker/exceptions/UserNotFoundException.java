package bitsima.debttracker.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User does not exist!");
    }
}

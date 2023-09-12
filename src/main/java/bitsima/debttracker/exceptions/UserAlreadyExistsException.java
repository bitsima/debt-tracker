package bitsima.debttracker.exceptions;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException() {
        super("This user already exists.");
    }
}

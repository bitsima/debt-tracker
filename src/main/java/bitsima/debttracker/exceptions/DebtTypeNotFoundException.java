package bitsima.debttracker.exceptions;

public class DebtTypeNotFoundException extends Exception {
    public DebtTypeNotFoundException() {
        super("Given debt-type does not exist on the database!");
    }
}

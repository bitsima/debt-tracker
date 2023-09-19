package bitsima.debttracker.dto;

import java.sql.Timestamp;
import java.util.Date;

import bitsima.debttracker.enums.Roles;

public class PersonCreateDTO {
    private long idNumber;
    private String firstName;
    private String lastName;

    private String pass;
    private String accountCreationDate;
    private String userRole;

    private long timestamp = new Timestamp(System.currentTimeMillis()).getTime();

    public PersonCreateDTO(long idNumber, String firstName, String lastName, String pass, Roles userRole) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pass = pass;
        this.accountCreationDate = new Date(timestamp).toString();
        this.userRole = userRole.getDisplayName();
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @return the accountCreationDate
     */
    public String getAccountCreationDate() {
        return accountCreationDate;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @return the id
     */
    public long getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the id to set
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

}

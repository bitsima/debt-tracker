package bitsima.debttracker.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import bitsima.debttracker.enums.Roles;

public class PersonCreateDTO {
    private UUID id;

    private String username;
    private String passwordHash;
    private String accountCreationDate;
    private String userRole;

    private long timestamp = new Timestamp(System.currentTimeMillis()).getTime();

    /**
     * @param username
     * @param passwordHash
     */
    public PersonCreateDTO(String username, String passwordHash, Roles userRole) {
        this.username = username;
        this.passwordHash = passwordHash;
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the passwordHash
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

}

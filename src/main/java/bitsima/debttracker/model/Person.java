package bitsima.debttracker.model;

import java.sql.Timestamp;
import java.util.UUID;

import bitsima.debttracker.enums.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected final UUID id = null;

    @Column(unique = true, nullable = false)
    protected String username = null;

    @Column(nullable = false)
    protected String passwordHash = null;

    @Column(nullable = false)
    protected long accountCreationTime = 0;

    @Column(nullable = false)
    protected Roles userRole = null;

    /**
     * @param userRole
     */
    public Person(Roles userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the userRole
     */
    public Roles getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(Roles userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the accountCreationTime
     */
    public long getAccountCreationTime() {
        return accountCreationTime;
    }

    /**
     * @param accountCreationTime the accountCreationTime to set
     */
    public void setAccountCreationTime(long accountCreationTime) {
        this.accountCreationTime = accountCreationTime;
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the passwordHash
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * @param passwordHash the passwordHash to set
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

}

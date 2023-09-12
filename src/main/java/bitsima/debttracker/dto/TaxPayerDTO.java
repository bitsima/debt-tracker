package bitsima.debttracker.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TaxPayerDTO {
    private String username;
    private String accountCreationDate;
    private String userRole = "TAXPAYER";
    private UUID id;

    private List<DebtDTO> debts = new ArrayList<>();

    public TaxPayerDTO(String username) {
        this.username = username;
    }

    public TaxPayerDTO() {
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
     * @return the accountCreationDate
     */
    public String getAccountCreationDate() {
        return accountCreationDate;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
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

    /**
     * @return the debts
     */
    public List<DebtDTO> getDebts() {
        return debts;
    }

    /**
     * @param debts the debts to set
     */
    public void setDebts(List<DebtDTO> debts) {
        this.debts = debts;
    }

    public void addDebt(DebtDTO debt) {
        this.debts.add(debt);
    }

}

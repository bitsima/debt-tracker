package bitsima.debttracker.dto;

import java.util.ArrayList;
import java.util.List;

public class TaxPayerDTO {
    private String firstName;
    private String lastName;

    private String accountCreationDate;
    private String userRole = "TAXPAYER";
    private long idNumber;

    private List<DebtDTO> debts = new ArrayList<>();

    public TaxPayerDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TaxPayerDTO() {
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public long getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the id to set
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
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

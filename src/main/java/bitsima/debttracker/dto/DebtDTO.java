package bitsima.debttracker.dto;

import java.util.Date;

import bitsima.debttracker.model.DebtType;

public class DebtDTO {
    private String debtType;
    private String interestRate;
    private String taxStartDate;
    private String taxDueDate;
    private boolean isActive;

    /**
     * @param debtType
     * @param taxStartTime
     * @param taxDueTime
     * @param isActive
     */
    public DebtDTO(DebtType debtType, long taxStartTime, long taxDueTime, boolean isActive) {
        this.debtType = debtType.getDisplayName();
        this.taxStartDate = new Date(taxStartTime).toString();
        this.taxDueDate = new Date(taxDueTime).toString();
        this.isActive = isActive;
    }

    /**
     * @return the debtType
     */
    public String getDebtType() {
        return this.debtType;
    }

    /**
     * @param debtType the debtType to set
     */
    public void setDebtType(String debtType) {
        this.debtType = debtType;
    }

    /**
     * @return the interestRate
     */
    public String getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the taxStartDate
     */
    public String getTaxStartDate() {
        return taxStartDate;
    }

    /**
     * @param taxStartDate the taxStartDate to set
     */
    public void setTaxStartDate(String taxStartDate) {
        this.taxStartDate = taxStartDate;
    }

    /**
     * @return the taxDueDate
     */
    public String getTaxDueDate() {
        return taxDueDate;
    }

    /**
     * @param taxDueDate the taxDueDate to set
     */
    public void setTaxDueDate(String taxDueDate) {
        this.taxDueDate = taxDueDate;
    }

    /**
     * @return the isActive
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}

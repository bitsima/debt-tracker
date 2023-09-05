package bitsima.debttracker.model;

import java.util.UUID;

import bitsima.debttracker.enums.DebtType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Debt {

    @Id
    @GeneratedValue
    private final UUID id = null;

    @Enumerated(EnumType.STRING)
    private DebtType debtType;

    @Column(nullable = false)
    private float interestRate;

    @Column(nullable = false)
    private long taxStartDate;

    @Column(nullable = false)
    private long taxDueDate;

    @Column(nullable = false)
    private boolean isActive;

    /**
     * @param debtType
     * @param interestRate
     * @param taxStartDate
     * @param taxDueDate
     * @param isActive
     */
    public Debt(DebtType debtType, float interestRate, long taxStartDate, long taxDueDate, boolean isActive) {
        this.debtType = debtType;
        this.interestRate = interestRate;
        this.taxStartDate = taxStartDate;
        this.taxDueDate = taxDueDate;
        this.isActive = isActive;
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the debtType
     */
    public DebtType getDebtType() {
        return debtType;
    }

    /**
     * @param debtType the debtType to set
     */
    public void setDebtType(DebtType debtType) {
        this.debtType = debtType;
    }

    /**
     * @return the interestRate
     */
    public float getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the taxStartDate
     */
    public long getTaxStartDate() {
        return taxStartDate;
    }

    /**
     * @param taxStartDate the taxStartDate to set
     */
    public void setTaxStartDate(long taxStartDate) {
        this.taxStartDate = taxStartDate;
    }

    /**
     * @return the taxDueDate
     */
    public long getTaxDueDate() {
        return taxDueDate;
    }

    /**
     * @param taxDueDate the taxDueDate to set
     */
    public void setTaxDueDate(long taxDueDate) {
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

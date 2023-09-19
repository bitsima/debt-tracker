package bitsima.debttracker.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Debt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID debtId = null;

    @ManyToOne
    @JoinColumn(name = "displayName")
    private DebtType debtType;

    @Column(nullable = false)
    private long taxStartTime;

    @Column(nullable = false)
    private long taxDueTime;

    @Column(nullable = false)
    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idNumber", nullable = false)
    private TaxPayer taxPayer;

    public Debt(DebtType debtType, long taxStartTime, long taxDueTime, boolean isActive, TaxPayer taxPayer) {
        this.debtType = debtType;
        this.taxStartTime = taxStartTime;
        this.taxDueTime = taxDueTime;
        this.isActive = isActive;
        this.taxPayer = taxPayer;
    }

    @JsonIgnore
    public TaxPayer getTaxPayer() {
        return taxPayer;
    }

    @JsonIgnore
    public void setTaxPayer(TaxPayer taxPayer) {
        this.taxPayer = taxPayer;
    }

    /**
     * @return the taxPayer's id
     */
    public long getTaxPayerId() {
        return taxPayer.getIdNumber();
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return debtId;
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
     * @return the taxStartTime
     */
    public long getTaxStartTime() {
        return taxStartTime;
    }

    /**
     * @param taxStartTime the taxStartTime to set
     */
    public void setTaxStartTime(long taxStartTime) {
        this.taxStartTime = taxStartTime;
    }

    /**
     * @return the taxDueTime
     */
    public long getTaxDueTime() {
        return taxDueTime;
    }

    /**
     * @param taxDueTime the taxDueTime to set
     */
    public void setTaxDueTime(long taxDueTime) {
        this.taxDueTime = taxDueTime;
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

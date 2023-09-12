package bitsima.debttracker.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import bitsima.debttracker.enums.Roles;

@Entity
public class TaxPayer extends Person {

    @OneToMany(mappedBy = "taxPayer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Debt> debts = new ArrayList<>();

    public TaxPayer() {
        super(Roles.TAXPAYER);
    }

    /**
     * @return the debts
     */
    public List<Debt> getDebts() {
        return debts;
    }

    /**
     * @param debts the debts to set
     */
    public void setDebts(List<Debt> debts) {
        this.debts = debts;
    }
}

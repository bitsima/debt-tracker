package bitsima.debttracker.dto;

import java.util.ArrayList;
import java.util.List;

public class DebtEditDTO {
    List<DebtDTO> debts = new ArrayList<>();

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

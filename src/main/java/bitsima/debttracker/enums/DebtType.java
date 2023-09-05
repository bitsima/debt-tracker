package bitsima.debttracker.enums;

public enum DebtType {
    CAPITAL_GAINS_TAX("Capital Gains Tax", "Tax on investment profit"),
    INCOME_TAX("Income Tax", "Tax on earnings"),
    PROPERTY_TAX("Property Tax", "Tax on real estate ownership"),
    PAYROLL_TAX("Payroll Tax", "Tax on employee wages");

    private final String displayName;
    private final String description;

    DebtType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }
}

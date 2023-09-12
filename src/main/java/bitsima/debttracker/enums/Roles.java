package bitsima.debttracker.enums;

public enum Roles {
    TAXPAYER("Taxpayer", "A regular user who is only authorized to have an overview of and pay off their own debts."),
    MUNICIPALITY_ADMIN("Municipality admin",
            "A municipality level admin who is authorized to handle almost everything about the municipality."),
    SYSTEM_ADMIN("System admin",
            "A system-level admin whose job is too oversee all of the system and add new municipalities.");

    private final String displayName;
    private final String description;

    Roles(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}

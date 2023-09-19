package bitsima.debttracker.model;

import bitsima.debttracker.enums.Roles;
import jakarta.persistence.Entity;
import lombok.Builder;

@Builder
@Entity
public class SystemAdmin extends Person {

    public SystemAdmin() {
        super(Roles.SYSTEM_ADMIN);
    }

}

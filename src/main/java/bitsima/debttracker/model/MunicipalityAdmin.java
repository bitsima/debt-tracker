package bitsima.debttracker.model;

import bitsima.debttracker.enums.Roles;
import jakarta.persistence.Entity;

@Entity
public class MunicipalityAdmin extends Person {

    public MunicipalityAdmin() {
        super(Roles.MUNICIPALITY_ADMIN);
    }
}

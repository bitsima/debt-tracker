package bitsima.debttracker.model;

import bitsima.debttracker.enums.Roles;
import jakarta.persistence.Entity;
import lombok.Builder;

@Builder
@Entity
public class MunicipalityAdmin extends Person {

    public MunicipalityAdmin() {
        super(Roles.MUNICIPALITY_ADMIN);
    }

}

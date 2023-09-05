package bitsima.debttracker.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Municipality {

    @Id
    @GeneratedValue
    private final UUID id = null;

    @Column(unique = true, nullable = false)
    private String name;

}

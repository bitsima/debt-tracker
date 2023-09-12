package bitsima.debttracker.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id = null;

    @Column(unique = true, nullable = false)
    private String name;

}

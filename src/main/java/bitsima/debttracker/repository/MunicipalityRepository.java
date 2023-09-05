package bitsima.debttracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import bitsima.debttracker.model.Municipality;

public interface MunicipalityRepository extends JpaRepository<Municipality, UUID> {

}

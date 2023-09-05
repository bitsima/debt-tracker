package bitsima.debttracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import bitsima.debttracker.model.MunicipalityAdmin;

public interface MunicipalityAdminRepository extends JpaRepository<MunicipalityAdmin, UUID> {

}

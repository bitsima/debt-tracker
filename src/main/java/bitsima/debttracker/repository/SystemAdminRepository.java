package bitsima.debttracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import bitsima.debttracker.model.SystemAdmin;

public interface SystemAdminRepository extends JpaRepository<SystemAdmin, UUID> {

}

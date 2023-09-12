package bitsima.debttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bitsima.debttracker.model.DebtType;

public interface DebtTypeRepository extends JpaRepository<DebtType, String> {

}

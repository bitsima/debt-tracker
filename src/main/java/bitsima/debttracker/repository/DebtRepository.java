package bitsima.debttracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import bitsima.debttracker.model.Debt;

public interface DebtRepository extends JpaRepository<Debt, UUID> {

}

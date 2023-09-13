package bitsima.debttracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import bitsima.debttracker.model.Debt;
import bitsima.debttracker.model.DebtType;

import java.util.List;

public interface DebtRepository extends JpaRepository<Debt, UUID> {
    List<Debt> findByDebtType(DebtType debtType);
}

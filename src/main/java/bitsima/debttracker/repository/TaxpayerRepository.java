package bitsima.debttracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import bitsima.debttracker.model.TaxPayer;

public interface TaxpayerRepository extends JpaRepository<TaxPayer, UUID> {

}

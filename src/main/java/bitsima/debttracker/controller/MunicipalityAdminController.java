package bitsima.debttracker.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitsima.debttracker.dto.DebtEditDTO;
import bitsima.debttracker.dto.TaxPayerDTO;
import bitsima.debttracker.service.DebtService;
import bitsima.debttracker.service.DebtTypeService;
import bitsima.debttracker.service.TaxpayerService;

@RestController
@RequestMapping("/api/v1/municipality")
public class MunicipalityAdminController {
    /*
     * /taxpayers GET ---------------------------
     * /taxpayers/{taxpayer_id} GET ------------------------------
     * /taxpayers/{taxpayer_id}/debts PUT or PATCH -> update debts of a
     * taxpayer-----------------
     * /taxpayers/{taxpayer_id}/debts GET -> view a taxpayer's debts' status
     * /debt-types GET -> list out existing debt types and their interest rates
     * /debt-types POST -> add a new debt type to the system
     * /debt-types DELETE -> delete a debt-type from the system (all debts of this
     * type will be deleted)
     */

    private final TaxpayerService taxPayerService;
    private final DebtTypeService debtTypeService;
    private final DebtService debtService;

    public MunicipalityAdminController(TaxpayerService taxpayerService, DebtTypeService debtTypeService,
            DebtService debtService) {
        this.taxPayerService = taxpayerService;
        this.debtTypeService = debtTypeService;
        this.debtService = debtService;
    }

    @GetMapping("/taxpayers")
    public ResponseEntity<List<TaxPayerDTO>> getAllTaxPayersForMunicipality() {
        List<TaxPayerDTO> taxPayers = taxPayerService.getAllTaxPayerDTOs();
        return ResponseEntity.ok(taxPayers);
    }

    @GetMapping("/taxpayers/{taxpayer_id}")
    public ResponseEntity<?> getTaxPayer(@PathVariable UUID id) {

        Optional<TaxPayerDTO> taxpayer = taxPayerService.getTaxPayerDTOById(id);

        if (taxpayer.isPresent()) {
            return ResponseEntity.ok(taxpayer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/taxpayer/{id}/debts")
    public ResponseEntity<DebtEditDTO> addNewDebtToTaxpayer(
            @PathVariable UUID id,
            @RequestBody DebtEditDTO updatedDebts) {
        Optional<TaxPayerDTO> taxPayer = taxPayerService.getTaxPayerDTOById(id);

        if (taxPayer.isPresent()) {
            taxPayer.get().setDebts(updatedDebts.getDebts());
            taxPayerService.updateTaxPayer(taxPayer.get());
            return ResponseEntity.ok(updatedDebts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

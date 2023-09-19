package bitsima.debttracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitsima.debttracker.dto.DebtDTO;
import bitsima.debttracker.dto.TaxPayerDTO;
import bitsima.debttracker.exceptions.DebtTypeNotFoundException;
import bitsima.debttracker.exceptions.UserNotFoundException;
import bitsima.debttracker.model.DebtType;
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
     * --------------------
     * /debt-types GET -> list out existing debt types and their interest rates
     * ---------------------
     * /debt-types POST -> add a new debt type to the system----------------------
     * /debt-types/{debt_type_name} GET -----------------------------------
     * /debt-types/{debt_type_name} DELETE -> delete a debt-type from the system
     * (all debts of this type will be
     * deleted) ---------------------------------------
     */

    private final TaxpayerService taxPayerService;
    private final DebtTypeService debtTypeService;

    public MunicipalityAdminController(TaxpayerService taxpayerService, DebtTypeService debtTypeService) {
        this.taxPayerService = taxpayerService;
        this.debtTypeService = debtTypeService;
    }

    @GetMapping("/taxpayers")
    public ResponseEntity<List<TaxPayerDTO>> getAllTaxPayersForMunicipality() {
        List<TaxPayerDTO> taxPayers = taxPayerService.getAllTaxPayerDTOs();
        return ResponseEntity.ok(taxPayers);
    }

    @GetMapping("/taxpayers/{taxpayer_id}")
    public ResponseEntity<?> getTaxPayer(@PathVariable long id) {
        try {
            TaxPayerDTO taxpayer = taxPayerService.getTaxPayerDTOById(id);
            return ResponseEntity.ok(taxpayer);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/taxpayer/{id}/debts")
    public ResponseEntity<List<DebtDTO>> addNewDebtToTaxpayer(
            @PathVariable long id,
            @RequestBody List<DebtDTO> updatedDebts) {
        try {
            TaxPayerDTO taxPayer = taxPayerService.getTaxPayerDTOById(id);
            taxPayer.setDebts(updatedDebts);
            taxPayerService.updateTaxPayer(taxPayer);
            return ResponseEntity.ok(updatedDebts);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/taxpayers/{taxpayer_id}/debts")
    public ResponseEntity<List<DebtDTO>> getAllTaxesForTaxpayer(@PathVariable long id) {
        try {
            TaxPayerDTO taxPayer = taxPayerService.getTaxPayerDTOById(id);
            List<DebtDTO> debts = taxPayer.getDebts();
            return ResponseEntity.ok(debts);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/debt-types")
    public ResponseEntity<List<DebtType>> getAllDebtTypes() {
        List<DebtType> debtTypes = debtTypeService.getAllDebtTypes();
        return ResponseEntity.ok(debtTypes);
    }

    @PostMapping("/debt-types")
    public ResponseEntity<String> addNewDebtType(@RequestBody DebtType newDebtType) {
        DebtType debtType = debtTypeService.addNewDebtToTaxpayer(newDebtType);
        return ResponseEntity
                .ok(String.format("New tax type: '%s' was added successfully.", debtType.getDisplayName()));
    }

    @GetMapping("/debt-types/{debt_type_name}")
    public ResponseEntity<?> getDebtTypeByName(@PathVariable String debt_type_name) {
        try {
            DebtType debtType = debtTypeService.getDebtTypeByName(debt_type_name);
            return ResponseEntity.ok(debtType);
        } catch (DebtTypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/debt-types/{debt_type_name}")
    public ResponseEntity<?> deleteDebtTypeAndSetDebtsToNull(@PathVariable String debt_type_name) {
        try {
            debtTypeService.deleteDebtTypeAndSetDebtsToNull(debt_type_name);
            return ResponseEntity.ok(String.format(
                    "Successfully deleted tax type: '%s' from the database. All taxes of that type was set to be of type 'null'.",
                    debt_type_name));
        } catch (DebtTypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
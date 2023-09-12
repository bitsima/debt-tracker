package bitsima.debttracker.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import bitsima.debttracker.dto.DebtDTO;
import bitsima.debttracker.dto.PersonCreateDTO;
import bitsima.debttracker.dto.TaxPayerDTO;
import bitsima.debttracker.exceptions.UserAlreadyExistsException;
import bitsima.debttracker.model.Debt;
import bitsima.debttracker.model.TaxPayer;
import bitsima.debttracker.repository.DebtRepository;
import bitsima.debttracker.repository.TaxpayerRepository;

@Service
public class TaxpayerService {
    private final TaxpayerRepository taxPayerRepository;
    private final DebtRepository debtRepository;
    private final ModelMapper modelMapper;

    public TaxpayerService(TaxpayerRepository taxPayerRepository, DebtRepository debtRepository,
            ModelMapper modelMapper) {
        this.taxPayerRepository = taxPayerRepository;
        this.modelMapper = modelMapper;
        this.debtRepository = debtRepository;
    }

    public List<TaxPayerDTO> getAllTaxPayerDTOs() {
        List<TaxPayer> taxPayers = taxPayerRepository.findAll();
        List<TaxPayerDTO> taxPayerDTOs = new ArrayList<>();

        for (TaxPayer taxPayer : taxPayers) {
            List<Debt> modelDebts = taxPayer.getDebts();
            TaxPayerDTO dto = modelMapper.map(taxPayer, TaxPayerDTO.class);

            for (Debt debt : modelDebts) {
                DebtDTO debtDTO = modelMapper.map(debt, DebtDTO.class);
                dto.addDebt(debtDTO);
            }
            taxPayerDTOs.add(dto);
        }

        return taxPayerDTOs;
    }

    public TaxPayer createTaxPayer(PersonCreateDTO person) throws UserAlreadyExistsException {
        if (!taxPayerRepository.findById(person.getId()).isPresent()) {
            TaxPayer taxPayer = new TaxPayer();
            modelMapper.map(person, taxPayer);
            taxPayer.setAccountCreationTime(System.currentTimeMillis());
            return taxPayerRepository.save(taxPayer);
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    public Optional<TaxPayer> getTaxPayerById(UUID id) {
        Optional<TaxPayer> taxPayer = taxPayerRepository.findById(id);
        return taxPayer;
    }

    public Optional<TaxPayerDTO> getTaxPayerDTOById(UUID id) {
        Optional<TaxPayer> taxPayer = taxPayerRepository.findById(id);

        if (taxPayer.isPresent()) {
            TaxPayerDTO taxPayerDTO = modelMapper.map(taxPayer, TaxPayerDTO.class);
            List<Debt> modelDebts = taxPayer.get().getDebts();
            List<DebtDTO> dtoDebts = new ArrayList<>();
            for (Debt debt : modelDebts) {
                DebtDTO debtDTO = modelMapper.map(debt, DebtDTO.class);
                dtoDebts.add(debtDTO);
            }
            taxPayerDTO.setDebts(dtoDebts);
            return Optional.of(taxPayerDTO);
        }
        return Optional.of(null);
    }

    public void updateTaxPayer(TaxPayerDTO taxPayerDTO) {
        TaxPayer taxPayer = modelMapper.map(taxPayerDTO, TaxPayer.class);
        List<DebtDTO> dtoDebts = taxPayerDTO.getDebts();
        List<Debt> modelDebts = new ArrayList<>();
        for (DebtDTO debtDTO : dtoDebts) {
            Debt debt = modelMapper.map(debtDTO, Debt.class);
            modelDebts.add(debt);
        }
        taxPayer.setDebts(modelDebts);
        taxPayerRepository.save(taxPayer);
    }
}

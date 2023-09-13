package bitsima.debttracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bitsima.debttracker.exceptions.DebtTypeNotFoundException;
import bitsima.debttracker.model.Debt;
import bitsima.debttracker.model.DebtType;
import bitsima.debttracker.repository.DebtRepository;
import bitsima.debttracker.repository.DebtTypeRepository;

@Service
public class DebtTypeService {
    private final DebtTypeRepository debtTypeRepository;
    private final DebtRepository debtRepository;

    /**
     * @param debtTypeRepository
     */
    public DebtTypeService(DebtTypeRepository debtTypeRepository, DebtRepository debtRepository) {
        this.debtTypeRepository = debtTypeRepository;
        this.debtRepository = debtRepository;
    }

    public List<DebtType> getAllDebtTypes() {
        List<DebtType> debtTypes = debtTypeRepository.findAll();
        return debtTypes;
    }

    public DebtType addNewDebtToTaxpayer(DebtType newDebtType) {
        DebtType debtType = debtTypeRepository.save(newDebtType);
        return debtType;
    }

    public DebtType getDebtTypeByName(String debtTypeName) throws DebtTypeNotFoundException {
        Optional<DebtType> debtType = debtTypeRepository.findById(debtTypeName);
        if (debtType.isPresent()) {
            return debtType.get();
        } else {
            throw new DebtTypeNotFoundException();
        }

    }

    public void deleteDebtTypeAndSetDebtsToNull(String debtTypeName) throws DebtTypeNotFoundException {
        Optional<DebtType> debtType = debtTypeRepository.findById(debtTypeName);
        if (debtType.isPresent()) {
            List<Debt> debtsWithDebtType = debtRepository.findByDebtType(debtType.get());
            for (Debt debt : debtsWithDebtType) {
                debt.setDebtType(null);
            }
            debtRepository.saveAll(debtsWithDebtType);
            debtTypeRepository.delete(debtType.get());
        } else {
            throw new DebtTypeNotFoundException();
        }
    }
}

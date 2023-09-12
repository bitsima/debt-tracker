package bitsima.debttracker.service;

import org.springframework.stereotype.Service;

import bitsima.debttracker.repository.DebtTypeRepository;

@Service
public class DebtTypeService {
    private final DebtTypeRepository debtTypeRepository;

    /**
     * @param debtTypeRepository
     */
    public DebtTypeService(DebtTypeRepository debtTypeRepository) {
        this.debtTypeRepository = debtTypeRepository;
    }

}

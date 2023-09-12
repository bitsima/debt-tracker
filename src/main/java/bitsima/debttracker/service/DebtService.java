package bitsima.debttracker.service;

import org.springframework.stereotype.Service;

import bitsima.debttracker.repository.DebtRepository;

@Service
public class DebtService {
    private final DebtRepository debtRepository;

    /**
     * @param debtRepository
     */
    public DebtService(DebtRepository debtRepository) {
        this.debtRepository = debtRepository;
    }

}

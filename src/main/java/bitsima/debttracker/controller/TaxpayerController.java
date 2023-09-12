package bitsima.debttracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitsima.debttracker.service.DebtService;
import bitsima.debttracker.service.TaxpayerService;

@RestController
@RequestMapping("/api/v1/taxpayer")
public class TaxpayerController {
    /*
     * /debts GET -> view their own debts
     * /debts PUT or PATCH -> pay off all of their own debts
     * /debts/{debt_id} PUT or PATCH -> pay of a single debt
     */
    private final DebtService debtService;
    private final TaxpayerService taxpayerService;

    public TaxpayerController(DebtService debtService, TaxpayerService taxpayerService) {
        this.debtService = debtService;
        this.taxpayerService = taxpayerService;
    }

}

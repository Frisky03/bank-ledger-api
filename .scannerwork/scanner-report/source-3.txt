package com.accenture.bank_ledger.controller;

import com.accenture.bank_ledger.dto.LedgerOpenAccountRequest;
import com.accenture.bank_ledger.dto.LedgerOpenAccountResponse;
import com.accenture.bank_ledger.entity.Account;
import com.accenture.bank_ledger.service.BankLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/ms-bank-ledger")
public class BankLedgerController {

    Logger log = Logger.getLogger(BankLedgerController.class.getName());

    private final BankLedgerService bankLedgerService;

    @Autowired
    public BankLedgerController
            (BankLedgerService bankLedgerService) {
        this.bankLedgerService = bankLedgerService;
    }

    @PostMapping("/createAccount")
    public LedgerOpenAccountResponse createAccount
            (@RequestBody LedgerOpenAccountRequest ledgerOpenAccountRequest) {
        if (ledgerOpenAccountRequest == null) {
            throw new IllegalArgumentException
                    ("LedgerOpenAccountRequest cannot be null.");
        }
        log.info("Received request to create account");
        Account account = bankLedgerService.
                createAccount(ledgerOpenAccountRequest);
        return new LedgerOpenAccountResponse(account.getAccountNumber());
    }

}

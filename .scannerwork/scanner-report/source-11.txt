package com.accenture.bank_ledger.service;

import com.accenture.bank_ledger.controller.BankLedgerController;
import com.accenture.bank_ledger.dto.LedgerOpenAccountRequest;
import com.accenture.bank_ledger.entity.Account;
import com.accenture.bank_ledger.repository.BankLedgerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Service
public class BankLedgerServiceImpl implements BankLedgerService {

    Logger log = Logger.getLogger(BankLedgerController.class.getName());

    private final BankLedgerRepository bankLedgerRepository;

    public BankLedgerServiceImpl(
            BankLedgerRepository bankLedgerRepository
    ) {
        this.bankLedgerRepository = bankLedgerRepository;
    }

    public Account createAccount
            (LedgerOpenAccountRequest ledgerOpenAccountRequest) {

        // Generate the Account object using the helper method
        Account account = generateAccount(ledgerOpenAccountRequest);
        // Save the Account object to the repository
        bankLedgerRepository.save(account);
        // Return the created Account object
        return account;
    }

    // Helper methods for the createAccount
    public Account generateAccount
            (LedgerOpenAccountRequest request) {
        String accountNumber = request.
                getTermDepositMaturityDetails().getAccountNumber();
        String productId = request.getProductId();
        BigDecimal interestRate = request.
                getTermDepositDetails().getInterestRate();
        BigDecimal depositAmount = request.
                getTermDepositDetails().getDepositAmount();
        int termMonths = request.
                getTermDepositDetails().getTermMonths();
        String effectiveDateStr = request.
                getTermDepositDetails().getEffectiveDate();
        LocalDate effectiveDate = convertToLocalDate(effectiveDateStr);
        LocalDate expiryDate = effectiveDate.plusMonths(termMonths);
        String accountName = request.
                getTermDepositMaturityDetails().getAccountName();

        // Creating and returning the Account object
        return new Account(
                accountNumber,
                productId,
                interestRate,
                depositAmount,
                termMonths,
                effectiveDate,
                expiryDate,
                accountName
        );
    }

    public LocalDate convertToLocalDate(String date) {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException(
                    "Date string cannot be null or empty."
            );
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}

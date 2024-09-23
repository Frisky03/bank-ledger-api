package com.accenture.bank_ledger.service;

import com.accenture.bank_ledger.dto.LedgerOpenAccountRequest;
import com.accenture.bank_ledger.dto.TermDepositDetails;
import com.accenture.bank_ledger.dto.TermDepositMaturityDetails;
import com.accenture.bank_ledger.entity.Account;
import com.accenture.bank_ledger.repository.BankLedgerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BankLedgerServiceImplTest {

    @Mock
    private BankLedgerRepository bankLedgerRepository;

    @InjectMocks
    private BankLedgerServiceImpl bankLedgerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validCreateAccount() {
        // Arrange
        LedgerOpenAccountRequest request = new LedgerOpenAccountRequest();
        TermDepositDetails termDepositDetails = new TermDepositDetails();
        termDepositDetails.setInterestRate(BigDecimal.valueOf(5.0));
        termDepositDetails.setDepositAmount(BigDecimal.valueOf(1000));
        termDepositDetails.setTermMonths(12);
        termDepositDetails.setEffectiveDate("21/02/2023"); // Setting date in DD/MM/YYYY format
        request.setTermDepositDetails(termDepositDetails);

        TermDepositMaturityDetails termDepositMaturityDetails = new TermDepositMaturityDetails();
        termDepositMaturityDetails.setAccountNumber("12345");
        termDepositMaturityDetails.setAccountName("Test Account");
        request.setTermDepositMaturityDetails(termDepositMaturityDetails);

        request.setProductId("P123");

        // Expected effective and expiry dates
        LocalDate effectiveDate = LocalDate.of(2023, 2, 21);
        LocalDate expiryDate = effectiveDate.plusMonths(12);

        Account expectedAccount = new Account("12345", "P123", BigDecimal.valueOf(5.0), BigDecimal.valueOf(1000), 12, effectiveDate, expiryDate, "Test Account");

        when(bankLedgerRepository.save(any(Account.class))).thenReturn(expectedAccount);

        // Act
        Account createdAccount = bankLedgerService.createAccount(request);

        // Assert
        assertEquals("12345", createdAccount.getAccountNumber());
        assertEquals("P123", createdAccount.getProductId());
        assertEquals(BigDecimal.valueOf(5.0), createdAccount.getInterestRate());
        assertEquals(BigDecimal.valueOf(1000), createdAccount.getDepositAmount());
        assertEquals(12, createdAccount.getTermMonths());
        assertEquals(effectiveDate, createdAccount.getEffectiveDate());
        assertEquals(expiryDate, createdAccount.getExpiryDate());
        assertEquals("Test Account", createdAccount.getAccountName());
    }
}

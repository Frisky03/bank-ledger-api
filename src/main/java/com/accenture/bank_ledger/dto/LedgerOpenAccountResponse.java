package com.accenture.bank_ledger.dto;

public class LedgerOpenAccountResponse {
    private String accountNumber;

    public LedgerOpenAccountResponse(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

package com.accenture.bank_ledger.dto;

public class TermDepositMaturityDetails {
    private String accountName;
    private String accountNumber;

    public TermDepositMaturityDetails
            (String accountName, String accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public TermDepositMaturityDetails() {
        /* default constructor */
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

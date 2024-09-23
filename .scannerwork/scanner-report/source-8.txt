package com.accenture.bank_ledger.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Account {

    @Id
    private String accountNumber;

    private String productId;
    private BigDecimal interestRate;
    private BigDecimal depositAmount;
    private int termMonths;
    private LocalDate effectiveDate;
    private LocalDate expiryDate;
    private String accountName;

    public Account() {
    }

    public Account(String accountNumber, String productId,
                   BigDecimal interestRate, BigDecimal depositAmount,
                   int termMonths, LocalDate effectiveDate,
                   LocalDate expiryDate, String accountName) {
        this.accountNumber = accountNumber;
        this.productId = productId;
        this.interestRate = interestRate;
        this.depositAmount = depositAmount;
        this.termMonths = termMonths;
        this.effectiveDate = effectiveDate;
        this.expiryDate = expiryDate;
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getTermMonths() {
        return termMonths;
    }

    public void setTermMonths(int termMonths) {
        this.termMonths = termMonths;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}

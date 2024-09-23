package com.accenture.bank_ledger.service;

import com.accenture.bank_ledger.dto.LedgerOpenAccountRequest;
import com.accenture.bank_ledger.entity.Account;

public interface BankLedgerService {
    Account createAccount(LedgerOpenAccountRequest ledgerOpenAccountRequest);

}

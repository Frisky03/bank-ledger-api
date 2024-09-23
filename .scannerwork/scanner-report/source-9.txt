package com.accenture.bank_ledger.repository;

import com.accenture.bank_ledger.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankLedgerRepository extends JpaRepository<Account, String> {
}

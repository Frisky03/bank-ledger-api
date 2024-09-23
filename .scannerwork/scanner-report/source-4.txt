package com.accenture.bank_ledger.dto;

public class LedgerOpenAccountRequest {
    private String productId;
    private TermDepositDetails termDepositDetails;
    private TermDepositMaturityDetails termDepositMaturityDetails;

    public LedgerOpenAccountRequest() {
        this.termDepositDetails = new TermDepositDetails();
        this.termDepositMaturityDetails = new TermDepositMaturityDetails();
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public TermDepositDetails getTermDepositDetails() {
        return termDepositDetails;
    }

    public void setTermDepositDetails(TermDepositDetails termDepositDetails) {
        this.termDepositDetails = termDepositDetails;
    }

    public TermDepositMaturityDetails getTermDepositMaturityDetails() {
        return termDepositMaturityDetails;
    }

    public void setTermDepositMaturityDetails
            (TermDepositMaturityDetails termDepositMaturityDetails) {
        this.termDepositMaturityDetails = termDepositMaturityDetails;
    }
}

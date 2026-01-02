package com.leetcode.designpatterns.corejava.structure.bridge.patterns;

public class UPATransactionModes implements TransactionModes {

    private HDFCBankTransaction bankTransaction;

    public UPATransactionModes(HDFCBankTransaction bankTransaction){
     this.bankTransaction=bankTransaction;
    }
    @Override
    public void transactionModes() {
        bankTransaction.processTransaction();
    }
}

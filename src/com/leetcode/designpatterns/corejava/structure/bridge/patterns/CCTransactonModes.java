package com.leetcode.designpatterns.corejava.structure.bridge.patterns;

public class CCTransactonModes implements  TransactionModes{

    private HDFCBankTransaction bankTransaction;

    public CCTransactonModes(HDFCBankTransaction bankTransaction){
        this.bankTransaction=bankTransaction;
    }

    @Override
    public void transactionModes() {
        bankTransaction.processTransaction();
    }
}

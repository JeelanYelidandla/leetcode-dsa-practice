package com.leetcode.designpatterns.corejava.structure.bridge.patterns;

public class CreditCardHdfcBankTransaction implements HDFCBankTransaction {

    @Override
    public void processTransaction() {
        System.out.println("CreditCardHdfcBankTransaction");
    }
}

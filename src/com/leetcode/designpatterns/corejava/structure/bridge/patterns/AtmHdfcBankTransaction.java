package com.leetcode.designpatterns.corejava.structure.bridge.patterns;

public class AtmHdfcBankTransaction implements HDFCBankTransaction {

    @Override
    public void processTransaction() {
        System.out.println("AtmHdfcBankTransaction");
    }
}

package com.leetcode.designpatterns.corejava.structure.bridge.patterns;

public class UpaHdfcBankTransaction implements HDFCBankTransaction {
    @Override
    public void processTransaction() {
        System.out.println("UpaTransaction");
    }
}

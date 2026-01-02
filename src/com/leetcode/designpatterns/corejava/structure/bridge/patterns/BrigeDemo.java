package com.leetcode.designpatterns.corejava.structure.bridge.patterns;

public class BrigeDemo {

    public static void main(String[] args) {
        HDFCBankTransaction upaHdfcBankTransaction = new UpaHdfcBankTransaction();
        TransactionModes upaTransactionModes= new UPATransactionModes(upaHdfcBankTransaction);
        upaTransactionModes.transactionModes();

        HDFCBankTransaction ccHdfcBankTransaction = new CreditCardHdfcBankTransaction();
        TransactionModes ccTransactionModes= new CCTransactonModes(ccHdfcBankTransaction);
        ccTransactionModes.transactionModes();

    }
}

package com.leetcode.designpatterns.corejava;

interface PaymentStrategy {
    void payment(int amount);
}
  class CreditCardPayment implements PaymentStrategy {
    @Override
    public void payment(int amount) {
        System.out.println("CreditCardPayment.payment() $"+ amount);
    }
}

 class PaypalPayment implements PaymentStrategy {
    @Override
    public void payment(int amount) {
        System.out.println("PayPlPayment.payment() $" + amount);
    }
}

class PaymentContext{
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(int amount) {
        paymentStrategy.payment( amount);
    }
}

class PaymentStrategyFactory{
        public static PaymentStrategy createPaymentStrategy(String paymentType) {
           return switch (paymentType.toLowerCase()){
               case "creditcard" -> new CreditCardPayment();
               case "paypal" -> new PaypalPayment();
              /* case "gpay" -> new PaypalPayment(); don't have impl to make it simple
               case "phonepay" -> new PaypalPayment();*/
               default -> throw new IllegalStateException("Unexpected value: " + paymentType.toLowerCase());
           };

        }
}

/**
 * Use Strategy when:
 * You're swapping out one behavior at runtime.
 * You want to choose the best algorithm or approach dynamically.
 * Strategy Pattern Summary
 * Purpose: Define a family of algorithms, encapsulate them, and make them interchangeable.
 * Pattern Type: Behavioral
 * When to Use:
 * You have many related classes that differ only in their behavior.
 * You want to avoid multiple if or switch statements for different behaviors.
 * You want to make a class easier to extend without modifying it.
 *
 *Strategy vs. Bridge — Quick Clarification
 * Concept	Strategy Pattern	Bridge Pattern
 * Goal	Swap behavior (algorithms) at runtime	Decouple abstraction from implementation
 * Focus	Behavior/algorithm substitution	Separation of interface (abstraction) and implementation
 * When to Use	You want to plug in different ways of doing a task	You have multiple dimensions that vary independently (e.g., shape and rendering)
 *
 */
class StrategyMain {
    public static void main(String[] args) {
        PaymentContext paymentContext;
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.createPaymentStrategy("paypal");
        paymentContext = new PaymentContext(paymentStrategy);
        paymentContext.makePayment(1);
    }
}
package com.leetcode.designpatterns.corejava;

 class InventoryService {
    public boolean checkStock(String itemId) {
        System.out.println("Checking stock for " + itemId);
        return true;
    }
}

 class PaymentService {
    public void processPayment(String paymentMode) {
        System.out.println("Processing payment via " + paymentMode);
    }
}

 class NotificationService {
    public void sendConfirmation(String userEmail) {
        System.out.println("Sending confirmation email to " + userEmail);
    }
}
 interface OrderFacade {
    void placeOrder(String itemId, String userEmail, String paymentMode);
}

 class OrderFacadeImpl implements OrderFacade {

    private final InventoryService inventoryService = new InventoryService();
    private final PaymentService paymentService = new PaymentService();
    private final NotificationService notificationService = new NotificationService();

    @Override
    public void placeOrder(String itemId, String userEmail, String paymentMode) {
        if (inventoryService.checkStock(itemId)) {
            paymentService.processPayment(paymentMode);
            notificationService.sendConfirmation(userEmail);
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Item out of stock.");
        }
    }
}


public class FacadeMain {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacadeImpl();
        orderFacade.placeOrder("item123", "user@example.com", "CreditCard");
    }
}

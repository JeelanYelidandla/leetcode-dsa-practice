package com.leetcode.designpatterns.corejava;

 interface MessageSender {
    void sendMessage(String message);
}

 class TextSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending TEXT SMS: " + message);
    }
}

 class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}

 abstract class Message {

    protected MessageSender sender;

    public Message(MessageSender sender) {
        this.sender = sender;
    }
    public abstract void send(String content);
}

 class TextMessage extends Message {

    public TextMessage(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String content) {
        sender.sendMessage("TextMessage: " + content);
    }
}

 class AlertMessage extends Message {
    public AlertMessage(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String content) {
        sender.sendMessage("ALERT: " + content);
    }
}


/**
 * Decouple abstraction (Message) from implementation (MessageSender)
 * Factory	Decouple creation of implementations like SmsSender, EmailSender
 *
 * Let’s say you’re building a Message Sender system, where:
 * Abstraction: Message type (e.g., TextMessage, EmailMessage)
 * Implementation: Delivery mechanism (e.g., SMS, Email, WhatsApp)
 * Each message type can be sent via any delivery mechanism → that's a classic Bridge scenario.
 *
 *
 *
 * Strategy vs. Bridge — Quick Clarification
 * Concept	Strategy Pattern	Bridge Pattern
 * Goal	Swap behavior (algorithms) at runtime	Decouple abstraction from implementation
 * Focus	Behavior/algorithm substitution	Separation of interface (abstraction) and implementation
 * When to Use	You want to plug in different ways of doing a task	You have multiple dimensions that vary independently (e.g., shape and rendering)
 */
public class BridgeMain {
    public static void main(String[] args) {
        MessageSender textSender = new TextSender();
        MessageSender emailSender = new EmailSender();

        Message message1 = new TextMessage(textSender);
        message1.send("Hello via SMS");

        Message message2 = new AlertMessage(emailSender);
        message2.send("Server down!");
    }
}

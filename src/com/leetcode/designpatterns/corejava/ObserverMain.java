package com.leetcode.designpatterns.corejava;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class EmailSubscriber implements Observer {
    String name;
   public EmailSubscriber(String name){
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println("name"+ " " +name + " " + "message"+ " "  + message);
    }
}
interface Subject {
    void attach(Observer attachObserver);
    void detach(Observer detachObserver);
    void notifyObservers(String notifyObservers);
}

class NewsPublisher implements Subject {

    private List<Observer> observers = new ArrayList<>();
    @Override
    public void attach(Observer attachObserver) {
        observers.add(attachObserver);
    }

    @Override
    public void detach(Observer detachObserver) {
        observers.remove(detachObserver);
    }

    @Override
    public void notifyObservers(String notifyObservers) {
        if (observers.size() > 0) {
            for (Observer observer : observers) {
                observer.update(notifyObservers);
            }
        }
    }
}
public class ObserverMain {
    public static void main(String[] args) {
        NewsPublisher newsPublisher = new NewsPublisher();
        Observer newsObserver = new EmailSubscriber("PROMOTIONAL");
        newsPublisher.attach(newsObserver);

        Observer emailObserver = new EmailSubscriber("JOB OFFER");
        newsPublisher.attach(emailObserver);

        newsPublisher.notifyObservers("PROMOTIONAL EMAIL JUST SENT");
    }
}

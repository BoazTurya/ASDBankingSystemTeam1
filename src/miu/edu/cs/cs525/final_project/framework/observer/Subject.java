package miu.edu.cs.cs525.final_project.framework.observer;

import miu.edu.cs.cs525.final_project.framework.model.Account;

import java.util.Collection;

public abstract class Subject {
    Collection<Observer> observers;
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    public void notifyAllObservers(Account account){
        observers.forEach(observer -> observer.update(account));
    }
}

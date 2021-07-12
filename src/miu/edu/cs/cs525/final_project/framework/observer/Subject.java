package miu.edu.cs.cs525.final_project.framework.observer;

import miu.edu.cs.cs525.final_project.framework.observer.Observer;
import miu.edu.cs.cs525.final_project.framework.service.AccountService;

public interface Subject {

    public abstract void addObserver(Observer observer);

    public abstract void removeObserver(Observer observer);

    public abstract void donotify(AccountService accountService);

}

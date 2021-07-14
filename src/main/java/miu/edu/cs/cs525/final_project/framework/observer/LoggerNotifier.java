package miu.edu.cs.cs525.final_project.framework.observer;

import miu.edu.cs.cs525.final_project.framework.model.Account;

public class LoggerNotifier implements Observer{
    private volatile static LoggerNotifier Instance;
    private LoggerNotifier(){}

    @Override
    public void update(Account account) {

    }

    public static LoggerNotifier getInstance(){
        if(Instance == null){
            synchronized (LoggerNotifier.class){
                if(Instance == null){
                    Instance = new LoggerNotifier();
                }
            }
        }
        return Instance;
    }
}

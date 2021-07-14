package miu.edu.cs.cs525.final_project.framework.observer;

import miu.edu.cs.cs525.final_project.framework.model.Account;

public class Logger implements Observer{
    private volatile static Logger Instance;
    private Logger(){}

    @Override
    public void update(Account account) {

    }

    public static Logger getInstance(){
        if(Instance == null){
            synchronized (Logger.class){
                if(Instance == null){
                    Instance = new Logger();
                }
            }
        }
        return Instance;
    }
}

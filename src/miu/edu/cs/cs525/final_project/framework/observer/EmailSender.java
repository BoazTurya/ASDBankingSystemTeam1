package miu.edu.cs.cs525.final_project.framework.observer;

import miu.edu.cs.cs525.final_project.framework.model.Account;

public class EmailSender implements Observer {
    private volatile static EmailSender Instance;
    private EmailSender(){}

    @Override
    public void update(Account account) {

    }

    public static EmailSender getInstance(){
        if(Instance == null){
            synchronized (Logger.class){
                if(Instance == null){
                    Instance = new EmailSender();
                }
            }
        }
        return Instance;
    }
}

package miu.edu.cs.cs525.final_project.framework.observer;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EmailSender implements Observer {
    private volatile static EmailSender Instance;
    private EmailSender(){}

    @Override
    public void update(Account account) {
        List<AccountEntry> accountEntries = account.getAccountEntries().stream().toList();
        double alertLimit = account.getAlertStrategy().alertAmount();
        int entry_length = accountEntries.size();
        double lastAmount = accountEntries.get(entry_length-1).getAmount();

        if (lastAmount > alertLimit) {
           String  email = account.getCustomer().getEmail();
            System.out.println("SENDING NOTIFICATION EMAIL FOR account : " + account.getAccountNumber());
//            this.notifyAllObservers(account);
        }
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

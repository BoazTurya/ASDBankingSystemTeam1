package miu.edu.cs.cs525.final_project.framework.observer;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;

import java.util.Collection;
import java.util.stream.Collectors;

public class EmailSender implements Observer {
    private volatile static EmailSender Instance;
    private EmailSender(){}

    @Override
    public void update(Account account) {
        Collection<AccountEntry> accountEntries = account.getAccountEntry();
        double alertLimit = account.getAlertStrategy().alertAmount();
        int entry_length = accountEntries.size();
        double lastAmount = accountEntries.stream().collect(Collectors.toList()).get(entry_length).getAmount();

        if (lastAmount > alertLimit) {
           String  email = account.getCustomer().getEmail();
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

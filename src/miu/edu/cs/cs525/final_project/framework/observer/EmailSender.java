package miu.edu.cs.cs525.final_project.framework.observer;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EmailSender implements Observer {
    private volatile static EmailSender Instance;

    protected EmailSender() {
    }

    @Override
    public void update(Account account) {
        Collection<AccountEntry> accountEntries = account.getAccountEntries();
        double alertLimit = account.getAlertStrategy().alertAmount();
        int entry_length = accountEntries.size();
        double lastAmount = accountEntries.stream().collect(Collectors.toList()).get(entry_length - 1).getAmount();
        String typeOfTransaction = accountEntries.stream().collect(Collectors.toList()).get(entry_length-1).getDescription();
        if (lastAmount > alertLimit) {
            sendEmail(account.getCustomer().getEmail(), account.getBalance(), typeOfTransaction);
        }
    }

    public void sendEmail(String reciepient, double balance, String typeOfTransaction) {

        try {
            System.out.println("Account Number Updated! " + reciepient);
            //TODO LOGIC FOR EMAIL
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            String myEmail = "newtestasd@gmail.com";
            String password = "testasd1234";

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myEmail, password);
                }
            });
            Message message = prepare(session, myEmail, reciepient, balance, typeOfTransaction);
            Transport.send(message);
        } catch (Exception e) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.INFO, null, e);

        }

    }

    Message prepare(Session session, String myEmail, String recipient, double balance, String typeOfTransaction) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("--- Updates on Your Account ---");
            message.setText("Your Account is updated for transactions, The transaction is " + typeOfTransaction + " and your current balance is " + balance);
            return message;
        } catch (Exception e) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.INFO, "Exception", e);
        }
        return null;
    }

    public static EmailSender getInstance() {
        if (Instance == null) {
            synchronized (EmailSender.class) {
                if (Instance == null) {
                    Instance = new EmailSender();
                }
            }
        }
        return Instance;
    }
}

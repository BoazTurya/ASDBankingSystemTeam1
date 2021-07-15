package miu.edu.cs.cs525.final_project.test.ccard.ui;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAOImpl;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAOImpl;
import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Report;
import miu.edu.cs.cs525.final_project.framework.service.CustomerService;
import miu.edu.cs.cs525.final_project.framework.service.CustomerServiceImpl;
import miu.edu.cs.cs525.final_project.test.bank.BankAccountFactory;
import miu.edu.cs.cs525.final_project.test.ccard.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A basic JFC based application.
 */
public class CardFrm extends JFrame {
    /****
     * init variables in the object
     ****/
    String clientName, street, city, zip, state, accountType, amountDeposit, expdate, ccnumber;
    boolean newaccount;
    CardFrm thisframe;
    JPanel JPanel1 = new JPanel();
    JButton JButton_NewCCAccount = new JButton();
    JButton JButton_GenBill = new JButton();
    JButton JButton_Deposit = new JButton();
    JButton JButton_Withdraw = new JButton();
    JButton JButton_Exit = new JButton();
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    private Object rowdata[];
    private CardAccountService accountService;

    public CardFrm() {
        thisframe = this;
        AccountDAO accountDao = new AccountDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        CustomerService customerService = new CustomerServiceImpl(customerDAO);
        AccountFactory accountFactory = new BankAccountFactory();
        Report report = new CardReport();
        accountFactory = new CardFactory();
        accountDao = new AccountDAOImpl();
        customerService = new CustomerServiceImpl(customerDAO);
        accountService = new CardAccountServiceImpl(accountDao,customerDAO,customerService,accountFactory,report);

        setTitle("Credit-card processing Application.");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(575, 310);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 575, 310);
		/*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
        rowdata = new Object[7];
        newaccount = false;


        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 444, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

        JButton_NewCCAccount.setText("Add Credit-card account");
        JPanel1.add(JButton_NewCCAccount);
        JButton_NewCCAccount.setBounds(24, 20, 192, 33);
        JButton_GenBill.setText("Generate Monthly bills");
        JButton_GenBill.setActionCommand("jbutton");
        JPanel1.add(JButton_GenBill);
        JButton_GenBill.setBounds(240, 20, 192, 33);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        JButton_Withdraw.setText("Charge");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setBounds(468, 164, 96, 33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 31);


        JButton_GenBill.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_NewCCAccount.addActionListener(lSymAction);
        JButton_GenBill.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);

    }

    /*****************************************************
     * The entry point for this application.
     * Sets the Look and Feel to the System Look and Feel.
     * Creates a new JFrame1 and makes it visible.
     *****************************************************/
    static public void main(String args[]) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (new CardFrm()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    void BankFrm_windowClosing(WindowEvent event) {
        // to do: code goes here.

        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(ActionEvent event) {
        System.exit(0);
    }

    void JButtonNewCCAC_actionPerformed(ActionEvent event) {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/

        JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe, accountService);
        ccac.setBounds(450, 20, 300, 380);
        ccac.show();
        if (newaccount) {
            // add row to table
//            rowdata[0] = clientName;
//            rowdata[1] = ccnumber;
//            rowdata[2] = expdate;
//            rowdata[3] = accountType;
//            rowdata[4] = "0";
//            model.addRow(rowdata);
            displayCustomers();
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }


    }

    void displayCustomers() {
        java.util.List<Account> accounts = ((CardAccountService) accountService).getAllAccounts();
        // add row to table
        model.setRowCount(0);
        for (Account account : accounts) {
            account = (CardAccount) account;
            rowdata[0] = account.getCustomer().getName();
            rowdata[1] = account.getAccountNumber();
            rowdata[2] = ((CardAccount) account).getExpirationDate();
//            rowdata[3] = account.getType();
            rowdata[4] = account.getBalance();
            model.addRow(rowdata);
        }
    }

    void JButtonGenerateBill_actionPerformed(ActionEvent event) {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) model.getValueAt(selection, 1);
            JDialog_GenerateReport billFrm = new JDialog_GenerateReport(thisframe, creditCardNumber, accountService);
            billFrm.setBounds(450, 20, 400, 350);
            billFrm.show();
        }
    }

    void JButtonDeposit_actionPerformed(ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) model.getValueAt(selection, 1);

            //Show the dialog for adding deposit amount for the current mane
            JDialog_Deposit dep = new JDialog_Deposit(thisframe, creditCardNumber, accountService);
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            // compute new amount
            double currentAmount = Double.parseDouble(amountDeposit);
            model.setValueAt(String.valueOf(currentAmount), selection, 4);
        }


    }

    void JButtonWithdraw_actionPerformed(ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) model.getValueAt(selection, 1);

            //Show the dialog for adding withdraw amount for the current mane
            JDialog_Withdraw wd = new JDialog_Withdraw(thisframe, creditCardNumber, accountService);
            wd.setBounds(430, 15, 275, 140);
            wd.show();

            // compute new amount
            double currentAmount = Double.parseDouble(amountDeposit);
            model.setValueAt(String.valueOf(currentAmount), selection, 4);
            if (currentAmount < 0) {
                JOptionPane.showMessageDialog(JButton_Withdraw, " " + creditCardNumber + " Your balance is negative: $" + String.valueOf(currentAmount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
            }
        }


    }

    class SymWindow extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            Object object = event.getSource();
            if (object == CardFrm.this)
                BankFrm_windowClosing(event);
        }
    }

    class SymAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_Exit)
                JButtonExit_actionPerformed(event);
            else if (object == JButton_NewCCAccount)
                JButtonNewCCAC_actionPerformed(event);
            else if (object == JButton_GenBill)
                JButtonGenerateBill_actionPerformed(event);
            else if (object == JButton_Deposit)
                JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw)
                JButtonWithdraw_actionPerformed(event);
        }
    }

}

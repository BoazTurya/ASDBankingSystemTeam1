package miu.edu.cs.cs525.final_project.test.bank.ui;

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
import miu.edu.cs.cs525.final_project.test.bank.BankAccountReport;
import miu.edu.cs.cs525.final_project.test.bank.BankAccountService;
import miu.edu.cs.cs525.final_project.test.bank.BankAccountServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * A basic JFC based application.
 */
public class BankFrm extends JFrame {
    /****
     * init variables in the object
     ****/
    String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit;
    boolean newaccount;
    BankFrm myframe;
    JPanel JPanel1 = new JPanel();
    JButton JButton_PerAC = new JButton();
    JButton JButton_CompAC = new JButton();
    JButton JButton_Deposit = new JButton();
    JButton JButton_Withdraw = new JButton();
    JButton JButton_Addinterest = new JButton();
    JButton JButton_Report = new JButton();
    JButton JButton_Exit = new JButton();

    private BankAccountService accountService;

    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    private Object rowdata[];

    public BankFrm() {
        //
        AccountDAO accountDao = new AccountDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        CustomerService customerService = new CustomerServiceImpl(customerDAO);
        AccountFactory accountFactory = new BankAccountFactory();
        Report report = new BankAccountReport();

        accountFactory = new BankAccountFactory();
        accountDao = new AccountDAOImpl();
        customerService = new CustomerServiceImpl(customerDAO);
        accountService = new BankAccountServiceImpl(accountDao,customerDAO,customerService,accountFactory,report);
        //
        myframe = this;
        setTitle("Bank Application.");
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
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        rowdata = new Object[8];
        newaccount = false;


        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 444, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

        JButton_PerAC.setText("Add personal account");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24, 20, 192, 33);
        JButton_CompAC.setText("Add company account");
        JButton_CompAC.setActionCommand("jbutton");
        JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240, 20, 192, 33);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        JButton_Addinterest.setBounds(448, 20, 106, 33);
        JButton_Addinterest.setText("Add interest");
        JPanel1.add(JButton_Addinterest);
        JButton_Withdraw.setBounds(468, 164, 96, 33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 31);
        // lineBorder1.setRoundedCorners(true);
        // lineBorder1.setLineColor(java.awt.Color.green);
        //$$ lineBorder1.move(24,312);

        JButton_PerAC.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_PerAC.addActionListener(lSymAction);
        JButton_CompAC.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
        JButton_Addinterest.addActionListener(lSymAction);
        JButton_Report.setText("Generate Report");
        JButton_Report.setActionCommand("jbutton");
        JPanel1.add(JButton_Report);
        JButton_Report.setBounds(600, 20, 220, 33);
        JButton_Report.addActionListener(lSymAction);

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
            (new BankFrm()).setVisible(true);
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

    void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
        // to do: code goes here.

        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
        System.exit(0);
    }

    void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/

        JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe, accountService);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount) {
            displayCustomers();
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }
    }

    void displayCustomers(){
        List<Account> accounts = ((BankAccountService) accountService).getAllAccounts();
        System.out.println(accounts);
        // add row to table
        model.setRowCount(0);
        for (Account account : accounts) {
            rowdata[0] = account.getAccountNumber();
            rowdata[1] = account.getCustomer().getName();
            rowdata[2] = account.getCustomer().getAddress().getCity();
            rowdata[3] = account.getCustomer().getCustomerType();
//            rowdata[4] = customerDto.getAccountType();
            rowdata[5] = account.getBalance();
            model.addRow(rowdata);
        }
    }

    void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/

        JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe, accountService);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount) {
            displayCustomers();
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }


    }

    void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding deposit amount for the current mane
            JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr, accountService);
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            // compute new amount
            double deposit = Double.parseDouble(amountDeposit);
            model.setValueAt(String.valueOf(deposit), selection, 5);
        }


    }

    void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
            JDialog_Withdraw wd = new JDialog_Withdraw(myframe, accnr,accountService);
            wd.setBounds(430, 15, 275, 140);
            wd.show();

            // compute new amount
            double currentAmount = Double.parseDouble(amountDeposit);
            model.setValueAt(String.valueOf(currentAmount), selection, 5);
            if (currentAmount < 0) {
                JOptionPane.showMessageDialog(JButton_Withdraw, " Account " + accnr + " : balance is negative: $" + String.valueOf(currentAmount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
            }
        }


    }


    void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
        accountService.calculateInterest();
        displayCustomers();
        JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
    }

    void JButtonGenerate_report(ActionEvent event) {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accountNumber = (String) model.getValueAt(selection, 0);
            JDialogReport dialogReport = new JDialogReport(myframe, accountNumber, accountService);
            dialogReport.setBounds(450, 20, 400, 350);
            dialogReport.show();
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter {
        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == BankFrm.this)
                BankFrm_windowClosing(event);
        }
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_Exit)
                JButtonExit_actionPerformed(event);
            else if (object == JButton_PerAC)
                JButtonPerAC_actionPerformed(event);
            else if (object == JButton_CompAC)
                JButtonCompAC_actionPerformed(event);
            else if (object == JButton_Deposit)
                JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw)
                JButtonWithdraw_actionPerformed(event);
            else if (object == JButton_Addinterest)
                JButtonAddinterest_actionPerformed(event);
            else if (object == JButton_Report) {
                JButtonGenerate_report(event);
            }
        }
    }
}

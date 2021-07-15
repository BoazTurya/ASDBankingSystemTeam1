package miu.edu.cs.cs525.final_project.test.bank.ui;


import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;
import miu.edu.cs.cs525.final_project.framework.model.Report;
import miu.edu.cs.cs525.final_project.framework.service.AccountService;
import miu.edu.cs.cs525.final_project.test.bank.BankAccountService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collection;

public class JDialogReport extends javax.swing.JDialog {
    private JPanel jPanel = new JPanel();
    private JLabel lblCustomerName = new JLabel();
    private JLabel lblTotalBalance = new JLabel();
    //{{DECLARE_CONTROLS
    private JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
    private JButton JButton_OK = new javax.swing.JButton();
    private JTable reportTable;
    private DefaultTableModel tableModel;
    private Object[] rowdata = new Object[20];

    public JDialogReport(Frame parent, String accountNumber, BankAccountService accountService) {
        super(parent);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 575, 310);
        Account account = accountService.getAccount(accountNumber);
        Report report = accountService.generateReport(accountNumber);
        getContentPane().add(BorderLayout.CENTER, jPanel);
        setSize(500, 367);
        setVisible(false);
        jPanel.add(JScrollPane1);
        jPanel.add(lblCustomerName);
        jPanel.add(lblTotalBalance);
        lblCustomerName.setBounds(15,10,100,30);
        lblTotalBalance.setBounds(15,60,100,30);
        tableModel = new DefaultTableModel();
        reportTable = new JTable(tableModel);

        tableModel.addColumn("Account No.");
        tableModel.addColumn("Action");
        tableModel.addColumn("Date");
        tableModel.addColumn("Amount");
//        double balance = report.getTransactions().stream().map(Transaction::getAmount).reduce(Double::sum).get();
        lblCustomerName.setText("Name - " + account.getCustomer().getName());
        lblTotalBalance.setText("Total Balance - " + account.getBalance());
        for (AccountEntry accountEntry : account.getAccountEntries()) {
            rowdata[0] = account.getAccountNumber();
            rowdata[1] = accountEntry.getDescription();
            rowdata[2] = accountEntry.getDate();
            rowdata[3] = accountEntry.getAmount();
            tableModel.addRow(rowdata);
        }
        getContentPane().add(JScrollPane1);
        jPanel.add(reportTable);
        JScrollPane1.setBounds(24, 24, 358, 240);
        JScrollPane1.getViewport().add(reportTable);
        reportTable.setBounds(10, 160, 355, 237);
        jPanel.add(JButton_OK);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        JButton_OK.setBounds(56, 376, 96, 24);

        // listen for the action
        SymAction action = new SymAction();
        JButton_OK.addActionListener(action);


    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK)
                JButtonOK_actionPerformed(event);
        }
    }
}

package miu.edu.cs.cs525.final_project.bank;

import javax.swing.*;

import miu.edu.cs.cs525.final_project.framework.ui.WithdrawDialog;

import java.awt.*;


public class JDialog_Withdraw extends WithdrawDialog
{
   
    private BankFrm parentframe;
    private String accnr;

	public JDialog_Withdraw(BankFrm parent, String aaccnr)
	{
		super(parent);
		parentframe=parent;
		accnr=aaccnr;
		
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.

		setTitle("Withdraw");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(277,134);
		setVisible(false);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(Color.black);
		JLabel1.setBounds(12,12,48,24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(Color.black);
		JLabel2.setBounds(12,36,48,24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,156,20);
		getContentPane().add(JTextField_AMT);
		JTextField_AMT.setBounds(84,36,156,20);
	
	    JTextField_NAME.setText(accnr);
	}

	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JTextField JTextField_AMT = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
}
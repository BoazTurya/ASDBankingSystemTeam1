package miu.edu.cs.cs525.final_project.ccard.ui;
/*
		A basic implementation of the JDialog class.
*/

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import miu.edu.cs.cs525.final_project.bank.ui.BankFrm;

public class JDialogGenBill extends JDialog{
    String billstring;
    CardFrm parent;
    
	public JDialogGenBill(CardFrm parent,String acctNumber){
		super(parent);
		this.parent = parent;
		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		setBounds(450, 20, 400, 350);
		show();

		JScrollPane JScrollPane1 = new JScrollPane();
		JTextField JTextField1 = new JTextField();
		JButton JButton_OK = new JButton();
	
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,358,240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0,0,355,237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);
	
		billstring = parent.getCreditAccountService().generateReport(acctNumber).getReport();
		JTextField1.setText(billstring);
	
		JButton_OK.addActionListener((ActionEvent evt)->dispose());
		//}}
	}

//	public JDialogGenBill()
//	{
//		this((CardFrm)null,null);
//	}

}

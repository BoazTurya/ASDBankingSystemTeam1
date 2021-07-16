package miu.edu.cs.cs525.final_project.bank.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import miu.edu.cs.cs525.final_project.framework.ui.Form;

public class AddBankInterestAction implements ActionListener {

	BankFrm parent;
	public AddBankInterestAction(BankFrm parent) {
		super();
		this.parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(parent, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
		
		/*
		 * 
		 * to do
		 */
		parent.getBankAccountService().calculateInterest();
		parent.populateModel();
	}
	
	

}

package miu.edu.cs.cs525.final_project.ccard.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import miu.edu.cs.cs525.final_project.framework.ui.Form;

public class AddCrediInterestAction implements ActionListener {

	CardFrm parent;
	public AddCrediInterestAction(CardFrm parent) {
		super();
		parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(parent, "Add interest to all Credit accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
		
		/*
		 * 
		 * to do
		 */
		parent.getCreditAccountService().calculateInterest();
	}
}

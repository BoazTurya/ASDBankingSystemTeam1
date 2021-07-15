package miu.edu.cs.cs525.final_project.framework.ui.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import miu.edu.cs.cs525.final_project.bank.ui.BankFrm;
import miu.edu.cs.cs525.final_project.bank.ui.BankWithdrawDialog;
import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;

public class JButtonWithdttttttrawAction extends WithdrawAction{
	Form parent;
	public JButtonWithdttttttrawAction(Form parent) {
		this.parent = parent;
	}
	public void actionPerformed(ActionEvent event){
		// get selected name
		int selection = parent.JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >=0){
			String accnr = (String)parent.getModel().getValueAt(selection, 0);
			//Show the dialog for adding withdraw amount for the current mane
			TransactionDialog wd = new BankWithdrawDialog((BankFrm) parent,accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

			// compute new amount
			long deposit = parent.getAmountDeposit();
			String samount = (String)parent.getModel().getValueAt(selection, 5);
			long currentamount = Long.parseLong(samount);
			long newamount=currentamount-deposit;
			parent.getModel().setValueAt(String.valueOf(newamount),selection, 5);
			if (newamount <0){
				JOptionPane.showMessageDialog(parent.getJButton_Withdraw(), " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
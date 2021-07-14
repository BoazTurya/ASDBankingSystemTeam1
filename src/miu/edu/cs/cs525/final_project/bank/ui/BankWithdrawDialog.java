package miu.edu.cs.cs525.final_project.bank.ui;

import java.awt.event.ActionEvent;

import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.actions.CancelDialogAction;
import miu.edu.cs.cs525.final_project.framework.ui.actions.OKButtonWithdrawAction;


public class BankWithdrawDialog extends TransactionDialog{
   
	public BankWithdrawDialog(BankFrm parent, String accnr){
		super(parent);
		setTitle("Bank Withdraw dialog");
		JLabel1.setText("Bank AccNr");
	    JTextField_NAME.setText(accnr);
	    JButton_OK.addActionListener(new OKButtonWithdrawAction(this));
	    JButton_Cancel.addActionListener(new CancelDialogAction(this));
	}
}
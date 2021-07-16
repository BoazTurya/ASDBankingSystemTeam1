package miu.edu.cs.cs525.final_project.bank.ui;

import miu.edu.cs.cs525.final_project.bank.ApplicationBank;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.actions.CancelDialogAction;


public class BankWithdrawDialog extends TransactionDialog{
   
	public BankWithdrawDialog(ApplicationBank parent, String accnr){
		super(parent);
		setTitle("Bank Withdraw dialog");
		JLabel1.setText("Bank AccNr");
	    JTextField_NAME.setText(accnr);
	    JButton_OK.addActionListener(new OKBankButtonWithdrawAction(parent, this));
	    JButton_Cancel.addActionListener(new CancelDialogAction(this));
	}
}
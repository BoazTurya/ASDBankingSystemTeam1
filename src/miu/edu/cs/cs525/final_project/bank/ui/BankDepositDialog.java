package miu.edu.cs.cs525.final_project.bank.ui;

import java.awt.event.ActionEvent;

import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.actions.CancelDialogAction;
import miu.edu.cs.cs525.final_project.framework.ui.actions.OKButtonDepositAction;

public class BankDepositDialog extends TransactionDialog{
  
	public BankDepositDialog(Form parent, String accnr){
		super(parent);
		setTitle("Bank Deposit dialog");
		
		
		JLabel1.setText("Bank AccNr");
	    JTextField_NAME.setText(accnr);
	    JButton_OK.addActionListener(new OKButtonDepositAction(parent, this));
	    JButton_Cancel.addActionListener(new CancelDialogAction(this));
	}
}
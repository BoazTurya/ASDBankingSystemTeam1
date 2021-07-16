package miu.edu.cs.cs525.final_project.ccard.ui;

import miu.edu.cs.cs525.final_project.ccard.ApplicationCreditCard;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.actions.CancelDialogAction;


public class CreditChargeDialog extends TransactionDialog{
	public CreditChargeDialog(ApplicationCreditCard parent, String anumber){
		super(parent);
		setTitle("Charge Credit Account");
		
		JLabel1.setText("CC Number");
		JLabel2.setText("ChargeAmount");
		
	    JTextField_NAME.setText(anumber);
	    JButton_OK.addActionListener(new OKButtonCreditWithdrawAction(parent,this));
	    JButton_Cancel.addActionListener(new CancelDialogAction(this));
	}
}
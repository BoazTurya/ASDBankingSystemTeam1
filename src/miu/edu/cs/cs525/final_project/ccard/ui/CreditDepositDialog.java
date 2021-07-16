package miu.edu.cs.cs525.final_project.ccard.ui;

import miu.edu.cs.cs525.final_project.ccard.ApplicationCreditCard;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.actions.CancelDialogAction;

public class CreditDepositDialog extends TransactionDialog{ 
	public CreditDepositDialog(ApplicationCreditCard form, String aNumber){
		super(form);
		setTitle("Deposit To Credit Account");
		JLabel1.setText("CC Number");
		JLabel2.setText("PaymentAmount");
		
	    JTextField_NAME.setText(aNumber);
	    JButton_OK.addActionListener(new OKButtonCreditDepositAction(form, this));
	    JButton_Cancel.addActionListener(new CancelDialogAction(this));
	    //dispose();
	}
}
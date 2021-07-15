package miu.edu.cs.cs525.final_project.ccard.ui;

import java.awt.event.ActionEvent;

import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.FrameTextField;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.actions.CancelDialogAction;
import miu.edu.cs.cs525.final_project.framework.ui.actions.OKButtonDepositAction;

public class CreditDepositDialog extends TransactionDialog{ 
	public CreditDepositDialog(Form form, String aname){
		super(form);
		setTitle("Deposit To Credit Account");
		JLabel1.setText("CC Number");
		JLabel2.setText("PaymentAmount");
		
	    JTextField_NAME.setText(aname);
	    JButton_OK.addActionListener(new OKButtonDepositAction(form, this));
	    JButton_Cancel.addActionListener(new CancelDialogAction(this));
	    //dispose();
	}
}
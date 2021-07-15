package miu.edu.cs.cs525.final_project.ccard.ui;

import java.awt.event.ActionEvent;

import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.actions.CancelDialogAction;
import miu.edu.cs.cs525.final_project.framework.ui.actions.OKButtonDepositAction;
import miu.edu.cs.cs525.final_project.framework.ui.actions.OKButtonWithdrawAction;


public class CreditChargeDialog extends TransactionDialog{
	public CreditChargeDialog(Form parent, String aname){
		super(parent);
		setTitle("Charge Credit Account");
		
		JLabel1.setText("CC Number");
		JLabel2.setText("ChargeAmount");
		
	    JTextField_NAME.setText(aname);
	    JButton_OK.addActionListener(new OKButtonWithdrawAction(parent,this));
	    JButton_Cancel.addActionListener(new CancelDialogAction(this));
	}
}
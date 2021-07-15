package miu.edu.cs.cs525.final_project.framework.ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.controller.UIControllerImpl;

public class OKButtonDepositAction implements ActionListener {
	TransactionDialog transactionDialog;
	Form parentFrame;
	public OKButtonDepositAction(Form parentFrame,TransactionDialog transactionDialog) {
		this.transactionDialog = transactionDialog;	
		this.parentFrame = parentFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accountNo = transactionDialog.getJTextField_NAME().getText();
		Long amount = Long.parseLong(transactionDialog.getJTextField_AMOUNT().getText());
				
		UIControllerImpl.getInstance().deposit(accountNo, amount);
		
	}

}

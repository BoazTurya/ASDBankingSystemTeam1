package miu.edu.cs.cs525.final_project.framework.ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miu.edu.cs.cs525.final_project.bank.ui.BankDepositDialog;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.controller.UIController;
import miu.edu.cs.cs525.final_project.framework.ui.controller.UIControllerImpl;

public class OKButtonDepositAction implements ActionListener {
	TransactionDialog transactionDialog;
	public OKButtonDepositAction(TransactionDialog transactionDialog) {
		this.transactionDialog = transactionDialog;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accountNo = transactionDialog.getJTextField_NAME().getText();
		Double amount = Double.parseDouble(transactionDialog.getJTextField_AMOUNT().getText());
		System.out.println("Amount " +amount);
		System.out.println("Account "+accountNo);
		
		UIControllerImpl.getInstance().deposit(accountNo, amount);
		
	}

}

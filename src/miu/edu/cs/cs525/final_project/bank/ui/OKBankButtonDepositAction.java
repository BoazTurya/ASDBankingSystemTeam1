package miu.edu.cs.cs525.final_project.bank.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miu.edu.cs.cs525.final_project.bank.ApplicationBank;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;

public class OKBankButtonDepositAction implements ActionListener {
	TransactionDialog transactionDialog;
	ApplicationBank parentFrame;
	public OKBankButtonDepositAction(ApplicationBank parentFrame,TransactionDialog transactionDialog) {
		this.transactionDialog = transactionDialog;	
		this.parentFrame = parentFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accountNo = transactionDialog.getJTextField_NAME().getText();
		Long amount = Long.parseLong(transactionDialog.getJTextField_AMOUNT().getText());
		System.out.println("ACCOUNT NUMBER " + accountNo);
		System.out.println("AMOUNT " + amount);
		parentFrame.setAmountDeposit(amount);
		parentFrame.getBankAccountService().deposit(accountNo, amount);
		transactionDialog.dispose();		
	}

}

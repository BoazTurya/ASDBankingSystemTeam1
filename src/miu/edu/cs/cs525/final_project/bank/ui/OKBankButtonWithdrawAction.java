package miu.edu.cs.cs525.final_project.bank.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miu.edu.cs.cs525.final_project.bank.ui.BankDepositDialog;
import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.controller.UIController;
import miu.edu.cs.cs525.final_project.framework.ui.controller.UIControllerImpl;

public class OKBankButtonWithdrawAction implements ActionListener {
	
	TransactionDialog depositDialog;
	BankFrm parentFrame;

	public OKBankButtonWithdrawAction(BankFrm parentFrame,TransactionDialog depositDialog) {
		this.depositDialog = depositDialog;
		this.parentFrame = parentFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accountNo= depositDialog.getJTextField_NAME().getText();
		Long amount = Long.parseLong(depositDialog.getJTextField_AMOUNT().getText());	
		parentFrame.getBankAccountService().withdraw(accountNo, amount);	
		depositDialog.dispose();
	}

}

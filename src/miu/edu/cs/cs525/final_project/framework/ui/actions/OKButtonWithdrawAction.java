package miu.edu.cs.cs525.final_project.framework.ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miu.edu.cs.cs525.final_project.bank.ui.BankDepositDialog;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.controller.UIController;
import miu.edu.cs.cs525.final_project.framework.ui.controller.UIControllerImpl;

public class OKButtonWithdrawAction implements ActionListener {
	
	TransactionDialog depositDialog;

	public OKButtonWithdrawAction(TransactionDialog depositDialog) {
		this.depositDialog = depositDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accountNo= depositDialog.getJTextField_NAME().getText();
		Double amount = Double.parseDouble(depositDialog.getJTextField_AMOUNT().getText());
		UIControllerImpl.getInstance().withdraw(accountNo, amount);		
	}

}

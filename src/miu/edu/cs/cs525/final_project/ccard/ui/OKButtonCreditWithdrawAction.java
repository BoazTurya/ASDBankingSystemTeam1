package miu.edu.cs.cs525.final_project.ccard.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;

public class OKButtonCreditWithdrawAction implements ActionListener {
	
	TransactionDialog depositDialog;
	CardFrm parentFrame;

	public OKButtonCreditWithdrawAction(CardFrm parentFrame,TransactionDialog depositDialog) {
		this.depositDialog = depositDialog;
		this.parentFrame = parentFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accountNo= depositDialog.getJTextField_NAME().getText();
		Long amount = Long.parseLong(depositDialog.getJTextField_AMOUNT().getText());	
		parentFrame.getCreditAccountService().charge(accountNo, amount);	
		depositDialog.dispose();
	}

}

package miu.edu.cs.cs525.final_project.ccard.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miu.edu.cs.cs525.final_project.ccard.ui.CardFrm;
import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.controller.UIControllerImpl;

public class OKButtonCreditDepositAction implements ActionListener {
	TransactionDialog transactionDialog;
	CardFrm parentFrame;
	public OKButtonCreditDepositAction(CardFrm parentFrame,TransactionDialog transactionDialog) {
		this.transactionDialog = transactionDialog;	
		this.parentFrame = parentFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accountNo = transactionDialog.getJTextField_NAME().getText();
		Long amount = Long.parseLong(transactionDialog.getJTextField_AMOUNT().getText());
				
		parentFrame.getCreditAccountService().makePayment(accountNo, amount);
		transactionDialog.dispose();		
	}

}

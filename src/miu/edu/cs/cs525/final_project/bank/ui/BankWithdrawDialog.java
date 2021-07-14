package miu.edu.cs.cs525.final_project.bank.ui;

import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;


public class BankWithdrawDialog extends TransactionDialog{
    private String accnr;

	public BankWithdrawDialog(BankFrm parent, String aaccnr){
		super(parent);
		accnr=aaccnr;
		setTitle("Bank Withdraw dialog");
		JLabel1.setText("Bank AccNr");
	    JTextField_NAME.setText(accnr);
	}


}
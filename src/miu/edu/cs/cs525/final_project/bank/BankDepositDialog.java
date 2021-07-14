package miu.edu.cs.cs525.final_project.bank;

import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;

public class BankDepositDialog extends TransactionDialog{
    private String accnr;
    
	public BankDepositDialog(Form parent, String aaccnr){
		super(parent);
		accnr=aaccnr;
		setTitle("Bank Deposit dialog");
		
		JLabel1.setText("Bank AccNr");
	    JTextField_NAME.setText(accnr);
	}
}
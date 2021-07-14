package miu.edu.cs.cs525.final_project.ccard.ui;

import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;


public class CreditChargeDialog extends TransactionDialog{
    private String name;

	public CreditChargeDialog(Form parent, String aname){
		super(parent);
		name=aname;

		setTitle("Charge Credit Account");
		
		JLabel1.setText("Name");
		JLabel2.setText("ChargeAmount");
		
	    JTextField_NAME.setText(name);
	}
}
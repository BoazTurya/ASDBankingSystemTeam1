package miu.edu.cs.cs525.final_project.ccard;

import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.FrameTextField;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;

public class CreditDepositDialog extends TransactionDialog{
    private String name;
    private FrameTextField JTextField_NAME = new FrameTextField();
    
	public CreditDepositDialog(Form form, String aname){
		super(form);
		name=aname;
		setTitle("Deposit To Credit Account");
	    JTextField_NAME.setText(name);
	}
}
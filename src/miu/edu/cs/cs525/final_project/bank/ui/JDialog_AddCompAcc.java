package miu.edu.cs.cs525.final_project.bank.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.ui.AddAccountDialog;
import miu.edu.cs.cs525.final_project.framework.ui.FrameLabel;
import miu.edu.cs.cs525.final_project.framework.ui.FrameRadioButton;
import miu.edu.cs.cs525.final_project.framework.ui.FrameTextField;
import miu.edu.cs.cs525.final_project.framework.ui.controller.UIControllerImpl;


public class JDialog_AddCompAcc extends AddAccountDialog{
    private BankFrm parentframe;

    FrameRadioButton JRadioButton_Chk = new FrameRadioButton("Checking");
    FrameRadioButton JRadioButton_Sav = new FrameRadioButton("Saving");
	FrameLabel JLabel7 = new FrameLabel("Acc Nr");
	FrameLabel JLabel8 = new FrameLabel("Num Of employees");
	FrameTextField JTextField_ACNR = new FrameTextField();
	FrameTextField JTextField_NoOfEmp = new FrameTextField();
	
	public JDialog_AddCompAcc(BankFrm parent)
	{
		super(parent);
		parentframe=parent;
		setTitle("Add compamy account");
	
		getContentPane().add(JRadioButton_Chk);JRadioButton_Chk.setBounds(36,12,84,24);
		getContentPane().add(JRadioButton_Sav);JRadioButton_Sav.setBounds(180,12,84,24);
	
		getContentPane().add(JLabel7);JLabel7.setBounds(12,72,48,24);
		getContentPane().add(JLabel8);JLabel8.setBounds(12,240,100,24);
		getContentPane().add(JTextField_ACNR);JTextField_ACNR.setBounds(120,72,156,20);
		getContentPane().add(JTextField_NoOfEmp);JTextField_NoOfEmp.setBounds(120,240,156,20);
		
		JButton_OK.addActionListener(new FormOKAddBankAccountAction());
	}
	class FormOKAddBankAccountAction implements ActionListener {
		public void actionPerformed(ActionEvent event){
			Account acct = parentframe.getAccountController().loadAccount(JTextField_ACNR.getText());
			if(acct == null) {
				parentframe.setNewaccount(true);
				parentframe.setAccountnr(JTextField_ACNR.getText());
				parentframe.setClientName(JTextField_NAME.getText());
				parentframe.setStreet(JTextField_STR.getText());
				parentframe.setCity(JTextField_CT.getText());
				parentframe.setZip(JTextField_ZIP.getText());
				parentframe.setState(JTextField_ST.getText());
				parentframe.setAmountDeposit(0L);
				parentframe.setAccountType(JRadioButton_Chk.isSelected()?"Ch":"S");
				dispose();
			}else {
				J
			}
		}
	}
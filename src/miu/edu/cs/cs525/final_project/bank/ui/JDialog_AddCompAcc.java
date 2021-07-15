package miu.edu.cs.cs525.final_project.bank.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.ui.AddAccountDialog;
import miu.edu.cs.cs525.final_project.framework.ui.FrameLabel;
import miu.edu.cs.cs525.final_project.framework.ui.FrameRadioButton;
import miu.edu.cs.cs525.final_project.framework.ui.FrameTextField;
import miu.edu.cs.cs525.final_project.framework.ui.controller.UIControllerImpl;


public class JDialog_AddCompAcc extends AddAccountDialog{
	private BankFrm parentFrame;

	FrameRadioButton JRadioButton_Chk = new FrameRadioButton("Checking");
	FrameRadioButton JRadioButton_Sav = new FrameRadioButton("Saving");
	FrameLabel JLabel7 = new FrameLabel("Acc Nr");
	FrameLabel JLabel8 = new FrameLabel("Num Of employees");
	FrameTextField JTextField_ACNR = new FrameTextField();
	FrameTextField JTextField_NoOfEmp = new FrameTextField();

	public JDialog_AddCompAcc(BankFrm parent)
	{
		super(parent);
		parentFrame=parent;
		setTitle("Add compamy account");
		setBounds(450, 20, 300, 330);
		show();

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

			//parentFrame.setNewaccount(true);
			parentFrame.setAccountnr(JTextField_ACNR.getText());
			parentFrame.setClientName(JTextField_NAME.getText());
			parentFrame.setStreet(JTextField_STR.getText());
			parentFrame.setCity(JTextField_CT.getText());
			parentFrame.setZip(JTextField_ZIP.getText());
			parentFrame.setStateName(JTextField_ST.getText());
			parentFrame.setAmountDeposit(0L);
			parentFrame.setNumOfEmployees(Integer.parseInt(JTextField_NoOfEmp.getText()));
			parentFrame.setAccountType(JRadioButton_Chk.isSelected()?"checking":"saving");
			Account acct = parentFrame.getBankAccountService().getAccount(JTextField_ACNR.getText());
			if(acct!=null) {
				JOptionPane.showMessageDialog(parentFrame, "company ac Already Present","already ",JOptionPane.WARNING_MESSAGE);
				parentFrame.setAmountDeposit((long) acct.getBalance());
			}else {
				parentFrame.getBankAccountService().createOrganizationAccount(
						parentFrame.getAccountnr(),
						parentFrame.getClientName(),
						parentFrame.getEmail(),
						parentFrame.getStreet(),
						parentFrame.getCity(),
						parentFrame.getStateName(),
						parentFrame.getZip(),
						parentFrame.getNumOfEmployees(),
						parentFrame.getAccountType());
				
			}
			dispose();
		}
	}
}

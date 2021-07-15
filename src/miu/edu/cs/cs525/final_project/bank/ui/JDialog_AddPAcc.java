package miu.edu.cs.cs525.final_project.bank.ui;
/*
		A basic implementation of the JDialog class.
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.ui.AddAccountDialog;
import miu.edu.cs.cs525.final_project.framework.ui.FrameLabel;
import miu.edu.cs.cs525.final_project.framework.ui.FrameRadioButton;

public class JDialog_AddPAcc extends AddAccountDialog
{
    private BankFrm parentFrame;
	//{{DECLARE_CONTROLS
	JRadioButton JRadioButton_Chk = new FrameRadioButton("Checking");
	JRadioButton JRadioButton_Sav = new FrameRadioButton("Saving");

	JLabel JLabel7 = new FrameLabel("Acc Nr");
	JLabel JLabel8 = new FrameLabel("Birthdate");
	JTextField JTextField_BD = new JTextField();
	JTextField JTextField_ACNR = new JTextField();
	
	public JDialog_AddPAcc(BankFrm parent)
	{
		super(parent);
		parentFrame=parent;
		setTitle("Add personal account");		
		getContentPane().add(JRadioButton_Chk);JRadioButton_Chk.setBounds(36,12,84,24);
		getContentPane().add(JRadioButton_Sav);JRadioButton_Sav.setBounds(180,12,84,24);	
		getContentPane().add(JLabel7);JLabel7.setBounds(12,72,48,24);
		getContentPane().add(JLabel8);JLabel8.setBounds(12,240,48,24);
		getContentPane().add(JTextField_ACNR);JTextField_ACNR.setBounds(120, 72, 156, 20);
		getContentPane().add(JTextField_BD);JTextField_BD.setBounds(120, 240, 156, 20);
		getContentPane().add(JButton_OK);
		getContentPane().add(JButton_Cancel);
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
		JButton_OK.addActionListener(new JButtonOK_ActionPerformed());
	}

	class SymMouse extends java.awt.event.MouseAdapter{
		public void mouseClicked(java.awt.event.MouseEvent event){
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event){
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event){
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);
	}

	class JButtonOK_ActionPerformed implements ActionListener {
		public void actionPerformed(ActionEvent event){
	       parentFrame.setAccountnr(JTextField_ACNR.getText());
	       parentFrame.setClientName(JTextField_NAME.getText());
	       parentFrame.setEmail(JTextField_Email.getText());
	       parentFrame.setStreet(JTextField_STR.getText());
	       parentFrame.setCity(JTextField_CT.getText());
	       parentFrame.setStateName(JTextField_ST.getText());
	       parentFrame.setZip(JTextField_ZIP.getText());
	       parentFrame.setAmountDeposit(0L);
	       parentFrame.setBirthdate(LocalDate.parse(JTextField_BD.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	       parentFrame.setAccountType(JRadioButton_Chk.isSelected()?"checking":"saving");
	     
	       Account acct = parentFrame.getBankAccountService().getAccount(JTextField_ACNR.getText());
			if(acct!=null) {
				JOptionPane.showMessageDialog(parentFrame, "ppp Account Already Present","Account Already Present",JOptionPane.WARNING_MESSAGE);
				parentFrame.setAmountDeposit((long) acct.getBalance());
			}else {
				System.out.println("INSINDE CREATE pacc.");
				parentFrame.getBankAccountService().createPersonalAccount(parentFrame.getAccountnr(),
																		parentFrame.getClientName(),
																		parentFrame.getEmail(),																	
																		parentFrame.getStreet(),
																		parentFrame.getCity(),
																		parentFrame.getStateName(),
																		parentFrame.getZip(),
																		parentFrame.getBirthdate(),
																		parentFrame.getAccountType()																		
																		);
				System.out.println(parentFrame.bankAccountService.getAllAccounts());
			}
			dispose();
		}	 
	}
}
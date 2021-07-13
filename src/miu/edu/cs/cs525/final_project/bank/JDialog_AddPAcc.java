package miu.edu.cs.cs525.final_project.bank;
/*
		A basic implementation of the JDialog class.
*/

import javax.swing.*;

import miu.edu.cs.cs525.final_project.framework.ui.AddAccountDialog;

import java.awt.*;

public class JDialog_AddPAcc extends AddAccountDialog
{
    private BankFrm parentFrame;

	//{{DECLARE_CONTROLS
	JRadioButton JRadioButton_Chk = new JRadioButton();
	JRadioButton JRadioButton_Sav = new JRadioButton();
//	JLabel JLabel1 = new JLabel();
//	JLabel JLabel2 = new JLabel();
//	JLabel JLabel3 = new JLabel();
//	JLabel JLabel4 = new JLabel();
//	JLabel JLabel5 = new JLabel();
	JLabel JLabel6 = new JLabel();
	JLabel JLabel7 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JTextField JTextField_CT = new JTextField();
	JTextField JTextField_ST = new JTextField();
	JTextField JTextField_STR = new JTextField();
	JTextField JTextField_ZIP = new JTextField();
	JTextField JTextField_BD = new JTextField();
	JTextField JTextField_EM = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
	JTextField JTextField_ACNR = new JTextField();
	JLabel JLabel8 = new JLabel();
	//}}

	public JDialog_AddPAcc(BankFrm parent)
	{
		super(parent);
		parentFrame=parent;
		
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		setTitle("Add personal account");
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,0,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,24,84,24);
		
		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(Color.black);
		JLabel6.setBounds(12,204,96,24);
		
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84,204,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84,228,156,20);
		
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(84,60,156,20);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(Color.black);
		JLabel8.setBounds(12,60,48,24);

		//}}
	
		//{{REGISTER_LISTENERS
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
	
	}

	class SymMouse extends java.awt.event.MouseAdapter
	{
		public void mouseClicked(java.awt.event.MouseEvent event)
		{
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event)
	{
		//When Checking radio is clicked make this radio on 
		//and make Saving account radio off
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event)
	{
		//When Saving radio is clicked make this radio on 
		//and make Checking account radio off
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);
	 
	}

	
	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
       parentFrame.accountnr=JTextField_ACNR.getText();
       parentFrame.setClientName(JTextField_NAME.getText());
       parentFrame.setStreet(JTextField_STR.getText());
       parentFrame.setCity(JTextField_CT.getText());
       parentFrame.setZip(JTextField_ZIP.getText());
       parentFrame.setState(JTextField_ST.getText());
       if (JRadioButton_Chk.isSelected())
           parentFrame.setAccountType("Ch");
           else
           parentFrame.setAccountType("S");
	   parentFrame.newaccount=true;
       dispose();
	}

	void JButtonCancel_actionPerformed(java.awt.event.ActionEvent event)
	{
    //make this frame invisible if Cancel button is clicked
        dispose();
	}
}
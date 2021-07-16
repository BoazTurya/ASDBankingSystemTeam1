package miu.edu.cs.cs525.final_project.ccard.ui;
/*
		A basic implementation of the JDialog class.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.ui.AddAccountDialog;
import miu.edu.cs.cs525.final_project.framework.ui.FrameLabel;
import miu.edu.cs.cs525.final_project.framework.ui.FrameTextField;

public class JDialog_AddCCAccount extends AddAccountDialog
{
	//{{DECLARE_CONTROLS
	JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton("Gold");
	JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton("Silver");
	JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton("Bronze");

	JLabel JLabel7 = new FrameLabel("CC number");
	JLabel JLabel8 = new FrameLabel("Exp. Date");
	JTextField JTextField_CCNR = new FrameTextField();
	JTextField JTextField_ExpDate = new FrameTextField();

	private CardFrm parentFrame;

	//}}
	public JDialog_AddCCAccount(CardFrm parent)
	{
		super(parent);
		parentFrame = parent;
		setTitle("Add credit card account");

		JRadioButton_Gold.setActionCommand("Checkings");
		JRadioButton_Silver.setActionCommand("Savings");
		JRadioButton_Bronze.setActionCommand("Savings");

		getContentPane().add(JRadioButton_Gold); JRadioButton_Gold.setBounds(15,12,60,24);
		getContentPane().add(JRadioButton_Silver);JRadioButton_Silver.setBounds(90,12,60,24);
		getContentPane().add(JRadioButton_Bronze);JRadioButton_Bronze.setBounds(165,12,60,24);

		getContentPane().add(JLabel7);JLabel7.setBounds(12,72,48,24);
		getContentPane().add(JLabel8);JLabel8.setBounds(12,240,48,24);
		getContentPane().add(JTextField_CCNR);   JTextField_CCNR.setBounds(120,72,156,20);
		getContentPane().add(JTextField_ExpDate);JTextField_ExpDate.setBounds(120,240,156,20);


		//{{REGISTER_LISTENERS
		JRadioButton_Gold.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event){
				JRadioButton_Gold.setSelected(true);
				JRadioButton_Silver.setSelected(false);
				JRadioButton_Bronze.setSelected(false);
			}});
		JRadioButton_Silver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event){
				JRadioButton_Gold.setSelected(false);
				JRadioButton_Silver.setSelected(true);
				JRadioButton_Bronze.setSelected(false);
			}});		
		JRadioButton_Bronze.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event){
				JRadioButton_Gold.setSelected(false);
				JRadioButton_Silver.setSelected(false);
				JRadioButton_Bronze.setSelected(true);
			}});
		JButton_OK.addActionListener(new JButtonOKActionPerformed());
	}
	class JButtonOKActionPerformed implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			parentFrame.setCcnumber(JTextField_CCNR.getText());
			parentFrame.setClientName(JTextField_NAME.getText());
			parentFrame.setEmail(JTextField_Email.getText());
			parentFrame.setStreet(JTextField_STR.getText());
			parentFrame.setCity(JTextField_CT.getText());
			parentFrame.setZip(JTextField_ZIP.getText());
			parentFrame.setBirthdate(LocalDate.parse(JTextField_ExpDate .getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			parentFrame.setStateName(JTextField_ST.getText());
			parentFrame.setExpdate(LocalDate.parse(JTextField_ExpDate.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			if (JRadioButton_Gold.isSelected()) {
				parentFrame.setAccountType("gold");}else{parentFrame.setAccountType(JRadioButton_Silver.isSelected()?"silver":"bronze");}
			Account acct = parentFrame.getCreditAccountService().getAccount(JTextField_CCNR.getText());
			if(acct != null) {
				JOptionPane.showMessageDialog(parentFrame, "this credit account Already Present","this credit account Already Present",JOptionPane.WARNING_MESSAGE);
				parentFrame.setAmountDeposit((long) acct.getBalance());
			}else {
					parentFrame.getCreditAccountService().createPersonalAccount(
							parentFrame.getCcnumber(), 
							parentFrame.getClientName(),
							parentFrame.getEmail(),
							parentFrame.getStreet(),
							parentFrame.getCity(),
							parentFrame.getStateName(),
							parentFrame.getZip(),
							parentFrame.getBirthdate(),
							parentFrame.getAccountType(),
							parentFrame.getExpdate());
					dispose();
				}
			}

		}
	}
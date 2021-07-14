package miu.edu.cs.cs525.final_project.framework.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WithdrawDialog extends JDialog
{

	private Form parentframe;

	protected JLabel JLabel1 = new JLabel();
	protected JLabel JLabel2 = new JLabel();
	protected JTextField JTextField_NAME = new JTextField();
	protected JTextField JTextField_AMT = new JTextField();
	protected JButton JButton_OK = new JButton();
	protected JButton JButton_Cancel = new JButton();

	public WithdrawDialog(Form parent)
	{
		super(parent);
		parentframe=parent;

		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.

		setTitle("Withdraw");
		setBounds(430, 15, 275, 140);
		show();

		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(Color.black);
		JLabel1.setBounds(12,12,48,24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(Color.black);
		JLabel2.setBounds(12,36,48,24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,156,20);
		getContentPane().add(JTextField_AMT);
		JTextField_AMT.setBounds(84,36,156,20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,84,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);

		JButton_OK.addActionListener((ActionEvent event)
				->{parentframe.setAmountDeposit(JTextField_AMT.getText());dispose();});
		JButton_Cancel.addActionListener((ActionEvent event)->dispose());

	}


}
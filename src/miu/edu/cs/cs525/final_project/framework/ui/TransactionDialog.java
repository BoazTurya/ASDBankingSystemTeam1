package miu.edu.cs.cs525.final_project.framework.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class TransactionDialog extends JDialog {
	protected Form parentFrame;
	protected JLabel JLabel1 = new FrameLabel("Name");
	protected JLabel JLabel2 = new FrameLabel("Amount");
	
	protected JTextField JTextField_NAME = new FrameTextField();
	protected JTextField JTextField_AMOUNT = new FrameTextField();
	protected JButton JButton_OK = new FrameButton("OK");
	protected JButton JButton_Cancel = new FrameButton("Cancel");

	public TransactionDialog(Form parent) {
		// TODO Auto-generated constructor stub
		super(parent);
		parentFrame = parent;

		setModal(true);
		getContentPane().setLayout(null);
		setSize(400,200);
		setVisible(true);
		setBounds(430, 15, 275, 140);
		show();
		JTextField_NAME.setEditable(false);

		getContentPane().add(JLabel1);JLabel1.setBounds(12,12,48,24);
		getContentPane().add(JLabel2);JLabel2.setBounds(12,48,48,24);
		getContentPane().add(JTextField_NAME);JTextField_NAME.setBounds(84,12,144,24);
		getContentPane().add(JTextField_AMOUNT);JTextField_AMOUNT.setBounds(84,36,156,20);

		getContentPane().add(JButton_OK);JButton_OK.setBounds(36,84,84,24);
		getContentPane().add(JButton_Cancel);JButton_Cancel.setBounds(156,84,84,24);

		//{{REGISTER_LISTENERS
		JButton_OK.addActionListener((ActionEvent event)
				->{parentFrame.setAmountDeposit(JTextField_AMOUNT.getText());dispose();});
		JButton_Cancel.addActionListener((ActionEvent event)->dispose());
	}
}
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
	public Form getParentFrame() {
		return parentFrame;
	}

	public JLabel getJLabel1() {
		return JLabel1;
	}

	public JLabel getJLabel2() {
		return JLabel2;
	}

	public JTextField getJTextField_NAME() {
		return JTextField_NAME;
	}

	public JTextField getJTextField_AMOUNT() {
		return JTextField_AMOUNT;
	}

	public JButton getJButton_OK() {
		return JButton_OK;
	}

	public JButton getJButton_Cancel() {
		return JButton_Cancel;
	}

	protected JTextField JTextField_AMOUNT = new FrameTextField();
	protected JButton JButton_OK = new FrameButton("OK");
	protected JButton JButton_Cancel = new FrameButton("Cancel");

	public TransactionDialog(Form parent) {
		// TODO Auto-generated constructor stub
		super(parent);
		parentFrame = parent;

		setModal(true);
		getContentPane().setLayout(null);
		setSize(500,400);
		setVisible(false);
	
		JTextField_NAME.setEditable(false);

		getContentPane().add(JLabel1);JLabel1.setBounds(12,12,70,24);
		getContentPane().add(JLabel2);JLabel2.setBounds(12,48,70,24);
		getContentPane().add(JTextField_NAME);JTextField_NAME.setBounds(100,12,175,24);
		getContentPane().add(JTextField_AMOUNT);JTextField_AMOUNT.setBounds(100,48,175,24);

		getContentPane().add(JButton_OK);JButton_OK.setBounds(36,84,84,24);
		getContentPane().add(JButton_Cancel);JButton_Cancel.setBounds(156,84,84,24);
	}

	public void setParentFrame(Form parentFrame) {
		this.parentFrame = parentFrame;
	}

	public void setJLabel1(JLabel jLabel1) {
		JLabel1 = jLabel1;
	}

	public void setJLabel2(JLabel jLabel2) {
		JLabel2 = jLabel2;
	}

	public void setJTextField_NAME(JTextField jTextField_NAME) {
		JTextField_NAME = jTextField_NAME;
	}

	public void setJTextField_AMOUNT(JTextField jTextField_AMOUNT) {
		JTextField_AMOUNT = jTextField_AMOUNT;
	}

	public void setJButton_OK(JButton jButton_OK) {
		JButton_OK = jButton_OK;
	}

	public void setJButton_Cancel(JButton jButton_Cancel) {
		JButton_Cancel = jButton_Cancel;
	}
}
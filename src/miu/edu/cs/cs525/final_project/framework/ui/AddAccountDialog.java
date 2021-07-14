
package miu.edu.cs.cs525.final_project.framework.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class AddAccountDialog extends javax.swing.JDialog {

	protected FrameLabel JLabel1 = new FrameLabel("Name");
	protected FrameLabel JLabel2 = new FrameLabel("Email");
	protected FrameLabel JLabel3 = new FrameLabel("Street");
	protected FrameLabel JLabel4 = new FrameLabel("City");
	protected FrameLabel JLabel5 = new FrameLabel("State");
	protected FrameLabel JLabel6 = new FrameLabel("Zip");
	protected FrameTextField JTextField_NAME = new FrameTextField();
	protected FrameTextField JTextField_Email = new FrameTextField();
	protected FrameTextField JTextField_STR = new FrameTextField();
	protected FrameTextField JTextField_CT = new FrameTextField();
	protected FrameTextField JTextField_ST = new FrameTextField();
	protected FrameTextField JTextField_ZIP = new FrameTextField();
	
	protected FrameButton JButton_OK = new FrameButton("OK");
	protected FrameButton JButton_Cancel = new FrameButton("CANCEL");

	public AddAccountDialog(Form parent) {
		super(parent);
		// TODO Auto-generated constructor stub
		setBounds(450, 20, 300, 350);
		show();
		setModal(true);
		getContentPane().setLayout(null);
		setSize(350, 350);
		setVisible(false);
		getContentPane().add(JLabel1);JLabel1.setBounds(12,96,48,24);
		getContentPane().add(JLabel2);JLabel2.setBounds(12,120,48,24);
		getContentPane().add(JLabel3);JLabel3.setBounds(12,144,48,24);
		getContentPane().add(JLabel4);JLabel4.setBounds(12,168,48,24);
		getContentPane().add(JLabel5);JLabel5.setBounds(12,192,48,24);
		getContentPane().add(JLabel6);JLabel6.setBounds(12,216,48,24);
		  
		getContentPane().add(JTextField_NAME);JTextField_NAME.setBounds(120, 96, 156, 20);
		getContentPane().add(JTextField_Email);JTextField_Email.setBounds(120,144, 156, 20);
		getContentPane().add(JTextField_STR);JTextField_STR.setBounds(120, 120, 156, 20);
		getContentPane().add(JTextField_CT);JTextField_CT.setBounds(120,168, 156, 20);
		getContentPane().add(JTextField_ST);JTextField_ST.setBounds(120, 192, 156, 20);
		getContentPane().add(JTextField_ZIP);JTextField_ZIP.setBounds(120,216, 156, 20);
		
		getContentPane().add(JButton_OK);JButton_OK.setBounds(24,265,84,24);
		getContentPane().add(JButton_Cancel);JButton_Cancel.setBounds(180,265,84,24);
		JButton_Cancel.addActionListener((ActionEvent evt) -> dispose()); 
	}
}

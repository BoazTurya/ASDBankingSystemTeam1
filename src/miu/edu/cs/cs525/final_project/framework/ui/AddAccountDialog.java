
package miu.edu.cs.cs525.final_project.framework.ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddAccountDialog extends javax.swing.JDialog {
	
	protected FrameLabel JLabel1 = new FrameLabel("Name");
	protected FrameLabel JLabel2 = new FrameLabel("Street");
	protected FrameLabel JLabel3 = new FrameLabel("City");
	protected FrameLabel JLabel4 = new FrameLabel("State");
	protected FrameLabel JLabel5 = new FrameLabel("Zip");
	protected FrameLabel JLabel6 = new FrameLabel("Email");
	protected FrameTextField JTextField_NAME = new FrameTextField();
	protected FrameTextField JTextField_CT = new FrameTextField();
	protected FrameTextField JTextField_ST = new FrameTextField();
	protected FrameTextField JTextField_STR = new FrameTextField();
	protected FrameTextField JTextField_ZIP = new FrameTextField();
	protected FrameTextField JTextField_Email = new FrameTextField();
	protected FrameButton JButton_OK = new FrameButton("OK");
	protected FrameButton JButton_Cancel = new FrameButton("CANCEL");
	

	
	public AddAccountDialog(Form parent) {
		super(parent);
		// TODO Auto-generated constructor stub
		setBounds(450, 20, 300, 330);
		show();
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283,303);
		setVisible(false);
		
		getContentPane().add(JLabel1);	
		getContentPane().add(JLabel2);
		getContentPane().add(JLabel3);
		getContentPane().add(JLabel4);
		getContentPane().add(JLabel5);
		getContentPane().add(JLabel6);
		getContentPane().add(JTextField_NAME);
		getContentPane().add(JTextField_CT);
		getContentPane().add(JTextField_ST);
		getContentPane().add(JTextField_STR);
		getContentPane().add(JTextField_ZIP);
		getContentPane().add(JTextField_Email);
		getContentPane().add(JButton_OK);
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,264,84,24);
		
	}
	
	
}



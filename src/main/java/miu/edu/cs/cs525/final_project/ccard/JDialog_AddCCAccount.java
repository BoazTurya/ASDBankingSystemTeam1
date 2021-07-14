package miu.edu.cs.cs525.final_project.ccard;
/*
		A basic implementation of the JDialog class.
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import miu.edu.cs.cs525.final_project.framework.ui.AddAccountDialog;
import miu.edu.cs.cs525.final_project.framework.ui.FrameLabel;
import miu.edu.cs.cs525.final_project.framework.ui.FrameTextField;

public class JDialog_AddCCAccount extends AddAccountDialog
{
    //{{DECLARE_CONTROLS
	JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
	JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
	JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();
	JLabel JLabel7 = new FrameLabel("CC number");
	JLabel JLabel8 = new FrameLabel("Exp. Date");
	JTextField JTextField_CCNR = new FrameTextField();
	JTextField JTextField_ExpDate = new FrameTextField();
	
	private CardFrm parentframe;
	
	//}}
	public JDialog_AddCCAccount(CardFrm parent)
	{
		super(parent);
		parentframe = parent;
		setTitle("Add credit card account");
		JRadioButton_Gold.setText("Gold");
		JRadioButton_Gold.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Gold);
		JRadioButton_Gold.setBounds(36,12,84,24);
		JRadioButton_Silver.setText("Silver");
		JRadioButton_Silver.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Silver);
		JRadioButton_Silver.setBounds(36,36,84,24);
		
		getContentPane().add(JLabel7);
		getContentPane().add(JLabel8);;
		getContentPane().add(JTextField_CCNR);
		
		JTextField_CCNR.setBounds(84,252,156,20);
		getContentPane().add(JTextField_ExpDate);
		JTextField_ExpDate.setBounds(84,276,156,20);
		
		JRadioButton_Bronze.setText("Bronze");
		JRadioButton_Bronze.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Bronze);
		JRadioButton_Bronze.setBounds(36,60,84,24);
		
	
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
		//}}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
       parentframe.setClientName(JTextField_NAME.getText());
       parentframe.setStreet(JTextField_STR.getText());
       parentframe.setCity(JTextField_CT.getText());
       parentframe.setZip(JTextField_ZIP.getText());
       parentframe.setState(JTextField_ST.getText());
       parentframe.ccnumber=JTextField_CCNR.getText();
       parentframe.expdate=JTextField_ExpDate.getText();
       if (JRadioButton_Gold.isSelected())
           parentframe.setAccountType("Gold");
           else{
            if (JRadioButton_Silver.isSelected())
                parentframe.setAccountType("Silver");
                else
                parentframe.setAccountType("Bronze");
           }
           
	   parentframe.setNewaccount(true);
       dispose();
	}
	class JButtonCancel_Action implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			dispose();
		}
	}

//	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
//	{
//    //make this frame invisible if Cancel button is clicked
//        dispose();
//	}
}
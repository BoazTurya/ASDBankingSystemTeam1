package miu.edu.cs.cs525.final_project.bank.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.FrameButton;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.actions.AddInterestAction;
import miu.edu.cs.cs525.final_project.framework.ui.actions.WithdrawAction;

/**
 * A basic JFC based application.
 */
public class BankFrm extends Form
{
	String accountnr, clientType;
	
	FrameButton JButton_PerAC = new FrameButton("Add personal account");
	FrameButton JButton_CompAC = new FrameButton("Add company account");
	FrameButton JButton_Addinterest= new FrameButton("Add interest");

	public BankFrm()
	{
		super();
		super.setThisFrame(this);
		setTitle("Bank Application.");

		super.getModel().addColumn("AccountNr");
		super.getModel().addColumn("Name");
		super.getModel().addColumn("City");
		super.getModel().addColumn("P/C");
		super.getModel().addColumn("Ch/S");
		super.getModel().addColumn("Amount");
		super.rowdata = new Object[8];

		newaccount=false;

		JPanel1.add(JButton_PerAC);
		JPanel1.add(JButton_CompAC);
		JPanel1.add(JButton_Addinterest);
		
		JButton_PerAC.setActionCommand("jbutton");
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setActionCommand("jbutton");
		JButton_CompAC.setBounds(240,20,192,33);
		JButton_Addinterest.setBounds(448,20,106,33);
		getJButton_Withdraw().setBounds(468,164,96,33);
		
		JButton_Deposit.addActionListener(new FormDepositButtonAction());
		JButton_Withdraw.addActionListener(new FormWithdrawButtonAction());
		JButton_PerAC.addActionListener(new JButtonPerAC_Action());
		JButton_CompAC.addActionListener(new JButtonCompAC_Action());
		JButton_Addinterest.addActionListener(new AddInterestAction(JButton_Addinterest));

	}
	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} 
			catch (Exception e) { 
			}

			//Create a new instance of our application's frame, and make it visible.
			(new BankFrm()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	class JButtonPerAC_Action implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			JDialog_AddPAcc pac = new JDialog_AddPAcc((BankFrm) thisFrame);
			pac.setBounds(450, 20, 300, 330);
			pac.show();

			if (newaccount){
				// add row to table
				rowdata[columnIndex++] = accountnr;
				rowdata[columnIndex++] = getClientName();
				rowdata[columnIndex++] = getCity();
				rowdata[columnIndex++] = "P";
				rowdata[columnIndex++] = getAccountType();
				rowdata[columnIndex] = "0";
				getModel().addRow(rowdata);
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
				newaccount=false;
			}        
		}
	}

	class JButtonCompAC_Action implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JDialog_AddCompAcc pac = new JDialog_AddCompAcc((BankFrm) thisFrame);
			pac.setBounds(450, 20, 300, 330);
			pac.show();
			if (newaccount){
				// add row to table
				rowdata[columnIndex++] = accountnr;
				rowdata[columnIndex++] = getClientName();
				rowdata[columnIndex++] = getCity();
				rowdata[columnIndex++] = "C";
				rowdata[columnIndex++] = getAccountType();
				rowdata[columnIndex] = "0";
				getModel().addRow(rowdata);
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
				newaccount=false;
			}
		}
	}

	public String getAccountnr() {
		return accountnr;
	}
	public void setAccountnr(String accountnr) {
		this.accountnr = accountnr;
	}
	@Override
	public TransactionDialog createDepositDialog(Form parent) {
		return new BankDepositDialog(parent, accountnr);
	}
	@Override
	public TransactionDialog createWithdrawDialog(Form parent) {
		return new BankWithdrawDialog((BankFrm)thisFrame, accountnr);
	}
}


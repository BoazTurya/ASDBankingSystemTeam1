package miu.edu.cs.cs525.final_project.ccard.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.FrameButton;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.actions.WithdrawAction;

/**
 * A basic JFC based application.
 */
public class CardFrm extends Form
{
	String expdate; 
	String ccnumber; 
	JButton JButton_NewCCAccount = new FrameButton("Add Credit-card account");
	JButton JButton_GenBill = new FrameButton("Generate Monthly bills");

	public CardFrm()
	{
		setThisFrame(this);
		setTitle("Credit-card processing Application.");

		super.getModel().addColumn("CC number");
		super.getModel().addColumn("Name");
		super.getModel().addColumn("Exp date");
		super.getModel().addColumn("Type");
		super.getModel().addColumn("Balance");

		JButton_GenBill.setBounds(240,20,192,33);
		JButton_NewCCAccount.setBounds(24,20,192,33);
		JButton_GenBill.setActionCommand("jbutton");
		JButton_GenBill.setActionCommand("jbutton");
		super.JPanel1.add(JButton_NewCCAccount);
		super.JPanel1.add(JButton_GenBill);

		//SymWindow aSymWindow = new SymWindow();
		//this.addWindowListener(aSymWindow);
		JButton_NewCCAccount.addActionListener(new JButtonNewCC_Action());
		JButton_GenBill.addActionListener((ActionEvent event)->{JDialogGenBill billFrm = new JDialogGenBill();});
		JButton_Deposit.addActionListener(new FormDepositButtonAction());
		JButton_Withdraw.addActionListener(new FormWithdrawButtonAction());

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
			(new CardFrm()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	public String getCcnumber() {
		return ccnumber;
	}
	public void setCcnumber(String ccnumber) {
		this.ccnumber = ccnumber;
	}
	class JButtonNewCC_Action implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JDialog_AddCCAccount ccac = new JDialog_AddCCAccount((CardFrm) getThisFrame());
			ccac.setBounds(450, 20, 300, 380);
			ccac.show();

			if (isNewaccount()){
				// add row to table
				rowdata[columnIndex++] = getClientName();
				rowdata[columnIndex++] = ccnumber;
				rowdata[columnIndex++] = expdate;
				rowdata[columnIndex++] = getAccountType();
				rowdata[columnIndex] = "0";
				getModel().addRow(rowdata);
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
				setNewaccount(false);
			}
		}
	}
	@Override
	public TransactionDialog createDepositDialog(Form parent) {
		// TODO Auto-generated method stub
		return new CreditDepositDialog(thisFrame, ccnumber);
	}
	@Override
	public TransactionDialog createWithdrawDialog(Form parent) {
		// TODO Auto-generated method stub
		return new CreditChargeDialog(thisFrame, ccnumber);
	}

}



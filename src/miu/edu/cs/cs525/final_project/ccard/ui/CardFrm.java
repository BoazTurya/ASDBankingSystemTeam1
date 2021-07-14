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

		super.model.addColumn("Name");
		super.model.addColumn("CC number");
		super.model.addColumn("Exp date");
		super.model.addColumn("Type");
		super.model.addColumn("Balance");

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
		JButton_Deposit.addActionListener(new JButtonDepositAction());
		JButton_Withdraw.addActionListener(new JButtonWithdrawAction());

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
				rowdata[0] = getClientName();
				rowdata[1] = ccnumber;
				rowdata[2] = expdate;
				rowdata[3] = getAccountType();
				rowdata[4] = "0";
				model.addRow(rowdata);
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
				setNewaccount(false);
			}
		}
	}

	class JButtonWithdrawAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String name = (String)model.getValueAt(selection, 0);

				//Show the dialog for adding withdraw amount for the current mane
				CreditChargeDialog wd = new CreditChargeDialog(getThisFrame(),name);

				// compute new amount
				long deposit = Long.parseLong(getAmountDeposit());
				String samount = (String)model.getValueAt(selection, 4);
				long currentamount = Long.parseLong(samount);
				long newamount=currentamount-deposit;
				model.setValueAt(String.valueOf(newamount),selection, 4);
				if (newamount <0){
					JOptionPane.showMessageDialog(JButton_Withdraw, " "+name+" Your balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	class JButtonDepositAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)model.getValueAt(selection, 0);

				//Show the dialog for adding deposit amount for the current mane
				CreditDepositDialog dep = new CreditDepositDialog(thisFrame,"enter amount to deposit");
	
				// compute new amount
				long deposit = Long.parseLong(getAmountDeposit());
				String samount = (String)model.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount=currentamount+deposit;
				model.setValueAt(String.valueOf(newamount),selection, 5);
			}
		}
	}

}



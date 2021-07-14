package miu.edu.cs.cs525.final_project.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.FrameButton;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.framework.ui.actions.WithdrawAction;

/**
 * A basic JFC based application.
 */
public class BankFrm extends Form
{
	String accountnr, clientType;
	
	boolean newaccount;

	FrameButton JButton_PerAC = new FrameButton("Add personal account");
	FrameButton JButton_CompAC = new FrameButton("Add company account");
	FrameButton JButton_Addinterest= new FrameButton("Add interest");

	public BankFrm()
	{
		super();
		super.setThisFrame(this);
		setTitle("Bank Application.");

		super.model.addColumn("AccountNr");
		super.model.addColumn("Name");
		super.model.addColumn("City");
		super.model.addColumn("P/C");
		super.model.addColumn("Ch/S");
		super.model.addColumn("Amount");
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
		JButton_Withdraw.setBounds(468,164,96,33);
		
		JButton_Deposit.addActionListener(new JButtonDepositAction());
		JButton_Withdraw.addActionListener(new JButtonWithdrawAction());
		JButton_PerAC.addActionListener(new JButtonPerAC_Action());
		JButton_CompAC.addActionListener(new JButtonCompAC_Action());
		JButton_Addinterest.addActionListener(new AddInterestAction());

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
			/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
			 */

			JDialog_AddPAcc pac = new JDialog_AddPAcc((BankFrm) thisFrame);
			pac.setBounds(450, 20, 300, 330);
			pac.show();

			if (newaccount){
				// add row to table
				rowdata[0] = accountnr;
				rowdata[1] = getClientName();
				rowdata[2] = getCity();
				rowdata[3] = "P";
				rowdata[4] = getAccountType();
				rowdata[5] = "0";
				model.addRow(rowdata);
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
				rowdata[0] = accountnr;
				rowdata[1] = getClientName();
				rowdata[2] = getCity();
				rowdata[3] = "C";
				rowdata[4] = getAccountType();
				rowdata[5] = "0";
				model.addRow(rowdata);
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
				newaccount=false;
			}
		}
	}

	class JButtonDepositAction implements ActionListener{
			public void actionPerformed(ActionEvent event) {
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)model.getValueAt(selection, 0);

				//Show the dialog for adding deposit amount for the current mane
				TransactionDialog dep = new BankDepositDialog(thisFrame,"deposit to your bank");

				// compute new amount
				long deposit = Long.parseLong(getAmountDeposit());
				String samount = (String)model.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount=currentamount+deposit;
				model.setValueAt(String.valueOf(newamount),selection, 5);
			}
		}
	}

	class JButtonWithdrawAction extends WithdrawAction{
		public void actionPerformed(ActionEvent event){
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)model.getValueAt(selection, 0);
				//Show the dialog for adding withdraw amount for the current mane
				BankWithdrawDialog wd = new BankWithdrawDialog((BankFrm)thisFrame,accnr);

				// compute new amount
				long deposit = Long.parseLong(getAmountDeposit());
				String samount = (String)model.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount=currentamount-deposit;
				model.setValueAt(String.valueOf(newamount),selection, 5);
				if (newamount <0){
					JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	class AddInterestAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
			
			/*
			 * 
			 * to do
			 */
		}

	}
	public String getAccountnr() {
		return accountnr;
	}


	public void setAccountnr(String accountnr) {
		this.accountnr = accountnr;
	}
}


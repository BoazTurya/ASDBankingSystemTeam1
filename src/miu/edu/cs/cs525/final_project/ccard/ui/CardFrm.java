package miu.edu.cs.cs525.final_project.ccard.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.FrameButton;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.test.ccard.CreditAccountService;

/**
 * A basic JFC based application.
 */
public class CardFrm extends Form
{
	LocalDate expdate; 
	String ccnumber; 
	JButton JButton_NewCCAccount = new FrameButton("Add Credit-card account");
	JButton JButton_GenBill = new FrameButton("Generate Monthly bills");
	CreditAccountService creditAccountService;

	public CreditAccountService getCreditAccountService() {
		return creditAccountService;
	}
	public CardFrm()
	{
		setThisFrame(this);
		setTitle("Credit-card processing Application.");

		super.getModel().addColumn("CC number");
		super.getModel().addColumn("Name");
		super.getModel().addColumn("Exp date");
		super.getModel().addColumn("Type");
		super.getModel().addColumn("Balance");

		creditAccountService = new CreditAccountService();

		JButton_GenBill.setBounds(240,20,192,33);
		JButton_NewCCAccount.setBounds(24,20,192,33);
		JButton_GenBill.setActionCommand("jbutton");
		super.JPanel1.add(JButton_NewCCAccount);
		super.JPanel1.add(JButton_GenBill);

		//SymWindow aSymWindow = new SymWindow();
		//this.addWindowListener(aSymWindow);
		JButton_NewCCAccount.addActionListener(new JButtonNewCC_Action());
		JButton_GenBill.addActionListener((ActionEvent event)->{JDialogGenBill billFrm = new JDialogGenBill(this, ccnumber);});
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
	public LocalDate getExpdate() {
		return expdate;
	}
	public void setExpdate(LocalDate expdate) {
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

			columnIndex = 0;
			rowdata[columnIndex++] = ccnumber;
			rowdata[columnIndex++] = getClientName();
			rowdata[columnIndex++] = expdate;
			rowdata[columnIndex++] = getAccountType();
			rowdata[columnIndex] = "0";
			getModel().addRow(rowdata);
			maxrows++;
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			//setNewaccount(false);
		}
	}
	@Override
	public TransactionDialog createDepositDialog(Form parent) {
		return new CreditDepositDialog(this, ccnumber);
	}
	@Override
	public TransactionDialog createWithdrawDialog(Form parent) {
		return new CreditChargeDialog(this, ccnumber);
	}
	public class FormWithdrawButtonAction implements ActionListener{

		public void actionPerformed(ActionEvent event){
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)getModel().getValueAt(selection, 0);

				TransactionDialog wd = createWithdrawDialog(thisFrame);
				//new BankWithdrawDialog((BankFrm) parent,accnr);
				wd.setBounds(430, 15, 275, 140);
				wd.show();
				Account acct = getCreditAccountService().getAccount(accnr);
		
				double newamount = acct.getBalance();
				getModel().setValueAt(String.valueOf(newamount),selection, columnIndex);
				if (newamount <0){
					JOptionPane.showMessageDialog(getJButton_Withdraw(), " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	public void populateTable() {
		Collection<Account> accounts = getCreditAccountService().getAllAccounts();
		
		rowdata = new Object[8];
		
		DefaultTableModel model = getModel();
		int rowCount =model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
		    model.removeRow(i);
		}
		for(Account a :accounts) {
			
			columnIndex = 0;
			rowdata[columnIndex++] = a.getAccountNumber();
			rowdata[columnIndex++] = a.getCustomer().getName();
			rowdata[columnIndex++] = "";
			rowdata[columnIndex++] = "";
			rowdata[columnIndex] = a.getBalance();
			getModel().addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}
	}
	public class FormDepositButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)getModel().getValueAt(selection, 0);
				Account acct = getCreditAccountService().getAccount(accnr);
				Double currentamount = acct.getBalance();

				//Show the dialog for adding deposit amount for the current mane
				TransactionDialog dep = new CreditDepositDialog((CardFrm)thisFrame, accnr);//;; createDepositDialog(thisFrame);
				dep.setBounds(430, 15, 275, 140);
				dep.show();
//				Double deposit = (double)getAmountDeposit();
//				Double newamount=currentamount + deposit;
				double newamount=  acct.getBalance();
				getModel().setValueAt(String.valueOf(newamount),selection, columnIndex);
				//populateTable();
				//getModel().setValueAt(String.valueOf(newamount),selection, columnIndex);
			}
		}
	}
}
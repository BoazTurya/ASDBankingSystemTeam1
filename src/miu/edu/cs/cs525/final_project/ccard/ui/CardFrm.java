package miu.edu.cs.cs525.final_project.ccard.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAOImpl;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAOImpl;
import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Report;
import miu.edu.cs.cs525.final_project.framework.service.CustomerServiceImpl;
import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.FrameButton;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;
import miu.edu.cs.cs525.final_project.test.ccard.CardFactory;
import miu.edu.cs.cs525.final_project.test.ccard.CreditAccountService;
import miu.edu.cs.cs525.final_project.test.ccard.CreditReport;

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
				TransactionDialog dep = createDepositDialog(thisFrame);
				dep.setBounds(430, 15, 275, 140);
				dep.show();
				Double deposit = (double)getAmountDeposit();
				Double newamount=currentamount + deposit;
				getModel().setValueAt(String.valueOf(newamount),selection, columnIndex);
			}
		}
	}
}
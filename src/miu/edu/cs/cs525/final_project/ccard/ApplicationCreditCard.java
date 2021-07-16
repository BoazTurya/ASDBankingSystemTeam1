package miu.edu.cs.cs525.final_project.ccard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import miu.edu.cs.cs525.final_project.ccard.backend.CreditAccount;
import miu.edu.cs.cs525.final_project.ccard.backend.CreditAccountService;
import miu.edu.cs.cs525.final_project.ccard.backend.InterestStrategyGOLD;
import miu.edu.cs.cs525.final_project.ccard.backend.InterestStrategySILVER;
import miu.edu.cs.cs525.final_project.ccard.ui.CreditChargeDialog;
import miu.edu.cs.cs525.final_project.ccard.ui.CreditDepositDialog;
import miu.edu.cs.cs525.final_project.ccard.ui.JDialogGenBill;
import miu.edu.cs.cs525.final_project.ccard.ui.JDialog_AddCCAccount;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.FrameButton;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;

/**
 * A basic JFC based application.
 */
public class ApplicationCreditCard extends Form
{
	LocalDate expdate; 
	String ccnumber; 
	JButton JButton_NewCCAccount = new FrameButton("Add Credit-card account");
	JButton JButton_GenBill = new FrameButton("Generate Monthly bills");
	CreditAccountService creditAccountService;

	public ApplicationCreditCard() {
		buildGUI();
		
	}
	static public void main(String args[]){
		try {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} 
			catch (Exception e) { 
			}
			//Create a new instance of our application's frame, and make it visible.
			(new ApplicationCreditCard()).setVisible(true);
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
	public CreditAccountService getCreditAccountService() {
		return creditAccountService;
	}
	class JButtonNewCC_Action implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JDialog_AddCCAccount ccac = new JDialog_AddCCAccount((ApplicationCreditCard) getThisFrame());
			ccac.setBounds(450, 20, 300, 380);ccac.show();
			populateModel();
		}
	}
	public class FormWithdrawButtonAction implements ActionListener{

		public void actionPerformed(ActionEvent event){
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String ccnr = (String)getModel().getValueAt(selection, 0);

				TransactionDialog wd = new CreditChargeDialog((ApplicationCreditCard)getThisFrame(), ccnr);
				wd.setBounds(430, 15, 275, 140);wd.show();
						
				populateModel();
			}
		}
	}
	
	public class FormDepositButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)getModel().getValueAt(selection, 0);
				TransactionDialog dep = new CreditDepositDialog((ApplicationCreditCard)thisFrame, accnr);
				dep.setBounds(430, 15, 275, 140); dep.show();
				populateModel();
			}
		}
	}
	public void populateModel() {
		Collection<Account> accounts = getCreditAccountService().getAllAccounts();
		
		rowdata = new Object[8];
		
		DefaultTableModel model = getModel();
		int rowCount =model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
		    model.removeRow(i);
		}
		for(Account a :accounts) {
			CreditAccount b = (CreditAccount)a;
			columnIndex = 0;
			String ctype = b.getInterestStrategy().getClass().equals(InterestStrategyGOLD.class)?"GOLD":
				b.getInterestStrategy().getClass().equals(InterestStrategySILVER.class)?"SILVER":"BRONZE";
			
			rowdata[columnIndex++] = b.getAccountNumber();
			rowdata[columnIndex++] = b.getCustomer().getName();
			rowdata[columnIndex++] = b.getExpirationDate();
			rowdata[columnIndex++] = ctype;
			rowdata[columnIndex] = b.getBalance();
			getModel().addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}
	}
	public class GenerateBillAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)getModel().getValueAt(selection, 0);
				JDialogGenBill billFrm = new JDialogGenBill((ApplicationCreditCard)thisFrame, accnr);
				billFrm.show();
				populateModel();
			}
		}
	}
	@Override
	protected void buildModel() { 
		setThisFrame(this);
		setTitle("Credit-card processing Application.");

		getModel().addColumn("CC number");
		getModel().addColumn("Name");
		getModel().addColumn("Exp date");
		getModel().addColumn("Type");
		getModel().addColumn("Balance");
	}
	
	@Override
	protected void hook() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void buildButtons() {
		JButton_GenBill.setBounds(240,20,192,33);
		JButton_NewCCAccount.setBounds(24,20,192,33);
		JButton_GenBill.setActionCommand("jbutton");
		JButton_NewCCAccount.addActionListener(new JButtonNewCC_Action());
		JButton_GenBill.addActionListener(new GenerateBillAction());
		JButton_Deposit.addActionListener(new FormDepositButtonAction());
		JButton_Withdraw.addActionListener(new FormWithdrawButtonAction());
		JPanel1.add(JButton_NewCCAccount);
		JPanel1.add(JButton_GenBill);
	}

	@Override
	protected void initializeAccountService() { 
		creditAccountService = new CreditAccountService();
	}
}
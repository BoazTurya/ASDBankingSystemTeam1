package miu.edu.cs.cs525.final_project.bank.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
import miu.edu.cs.cs525.final_project.test.bank.BankAccountFactory;
import miu.edu.cs.cs525.final_project.test.bank.BankAccountReport;
import miu.edu.cs.cs525.final_project.test.bank.BankAccountService;

/**
 * A basic JFC based application.
 */
public class BankFrm extends Form
{
	String accountnr, clientType;
	BankAccountService bankAccountService;

	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}
	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}
	FrameButton JButton_PerAC = new FrameButton("Add personal account");
	FrameButton JButton_CompAC = new FrameButton("Add company account");
	FrameButton JButton_Addinterest= new FrameButton("Add interest");

	public BankFrm(){
		super();
		super.setThisFrame(this);
		AccountDAO accountDAO = new AccountDAOImpl();
		CustomerDAO customerDAO = new CustomerDAOImpl();
		CustomerServiceImpl customerService = new CustomerServiceImpl(customerDAO);
		AccountFactory accountFactory = new BankAccountFactory();
		Report report = new BankAccountReport();
		bankAccountService = new BankAccountService(accountDAO,customerDAO,customerService,accountFactory,report);
		setTitle("Bank Application.");
		super.getModel().addColumn("AccountNr");
		super.getModel().addColumn("Name");
		super.getModel().addColumn("City");
		super.getModel().addColumn("P/C");
		super.getModel().addColumn("Ch/S");
		super.getModel().addColumn("Amount");
		super.rowdata = new Object[8];
		//newaccount=false;
		JPanel1.add(JButton_PerAC);
		JPanel1.add(JButton_CompAC);
		JPanel1.add(JButton_Addinterest);

		JButton_PerAC.setActionCommand("jbutton");
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setActionCommand("jbutton");
		JButton_CompAC.setBounds(240,20,192,33);
		JButton_Addinterest.setBounds(448,20,106,33);
		JButton_Withdraw.setBounds(468,164,96,33);

		JButton_Deposit.addActionListener(new FormDepositButtonAction());
		JButton_Withdraw.addActionListener(new FormWithdrawButtonAction());
		JButton_PerAC.addActionListener(new JButtonPerAC_Action());
		JButton_CompAC.addActionListener(new JButtonCompAC_Action());
		JButton_Addinterest.addActionListener(new AddBankInterestAction(this));
	}
	static public void main(String args[]){
		try {
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
	public void populateTable() {
		Collection<Account> accounts = getBankAccountService().getAllAccounts();
		//DefaultTableModel newmodel= new DefaultTableModel();
		//getModel()
//		getModel().addColumn("AccountNr");
//		getModel().addColumn("Name");
//		getModel().addColumn("City");
//		getModel().addColumn("P/C");
//		getModel().addColumn("Ch/S");
//		getModel().addColumn("Amount");
	//	for(int i=0;i<maxrows;i++) {getModel().removeRow(i);}
		rowdata = new Object[8];
		
		DefaultTableModel model = getModel();
		int rowCount =model.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    model.removeRow(i);
		}
		for(Account a :accounts) {
			
			columnIndex = 0;
			rowdata[columnIndex++] = a.getAccountNumber();
			rowdata[columnIndex++] = a.getCustomer().getName();
			rowdata[columnIndex++] = a.getCustomer().getAddress().getCity();
			rowdata[columnIndex++] = "cccc";
			rowdata[columnIndex++] = "cccc";
			rowdata[columnIndex] = a.getBalance();
			getModel().addRow(rowdata);maxrows++;
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}
		//JTable1.add(newmodel);
	}
	public class FormDepositButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)getModel().getValueAt(selection, 0);
				BankDepositDialog dep = new BankDepositDialog((BankFrm) thisFrame, accnr);
				dep.setBounds(430, 15, 275, 140);
				dep.show();
				
				Account acct = getBankAccountService().getAccount(accnr);
				double newamount=  acct.getBalance();
				populateTable();
				//getModel().setValueAt(String.valueOf(newamount),selection, 5);
			}
		}
	}
	class JButtonPerAC_Action implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			JDialog_AddPAcc pac = new JDialog_AddPAcc((BankFrm) thisFrame);
			pac.setBounds(450, 20, 300, 330);
			pac.show();			
			columnIndex = 0;
			rowdata[columnIndex++] = accountnr;
			rowdata[columnIndex++] = getClientName();
			rowdata[columnIndex++] = getCity();
			rowdata[columnIndex++] = "P";
			rowdata[columnIndex++] = getAccountType();
			rowdata[columnIndex] = "0";
			maxrows++;
			Account acct =	 getBankAccountService().getAccount(accountnr);
			if(acct!=null) {
				JOptionPane.showMessageDialog(thisFrame, "Account Already Exists","Account Already Exists",JOptionPane.WARNING_MESSAGE);
				rowdata[columnIndex] = acct.getBalance();	
			}
			getModel().addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}   
	}
	public class FormWithdrawButtonAction implements ActionListener{

		public void actionPerformed(ActionEvent event){
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)getModel().getValueAt(selection, 0);
				
				TransactionDialog wd = new BankWithdrawDialog((BankFrm)thisFrame, accnr);  
				wd.setBounds(430, 15, 275, 140);
				wd.show();
				Account acct = getBankAccountService().getAccount(accnr);
				// compute new amount

				double newamount=  acct.getBalance();
				getModel().setValueAt(String.valueOf(newamount),selection, columnIndex);
				if (newamount <0){
					JOptionPane.showMessageDialog(getJButton_Withdraw(), " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	class JButtonCompAC_Action implements ActionListener{
		public void actionPerformed(ActionEvent event){	
			JDialog_AddCompAcc cac = new JDialog_AddCompAcc((BankFrm)thisFrame);
			cac.setBounds(450, 20, 300, 330);
			cac.show();
			columnIndex = 0;
			rowdata[columnIndex++] = accountnr;
			rowdata[columnIndex++] = getClientName();
			rowdata[columnIndex++] = getCity();
			rowdata[columnIndex++] = "C";
			rowdata[columnIndex++] = getAccountType();
			rowdata[columnIndex] = "0";
			getModel().addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);			
		}
	}
	public String getAccountnr() {
		return accountnr;
	}
	public void setAccountnr(String accountnr) {
		this.accountnr = accountnr;
	}
	public TransactionDialog createDepositDialog(Form parent) {
		return new BankDepositDialog(this, accountnr);
	}
	@Override
	public TransactionDialog createWithdrawDialog(Form parent) {
		return new BankWithdrawDialog(this, accountnr);
	}
}
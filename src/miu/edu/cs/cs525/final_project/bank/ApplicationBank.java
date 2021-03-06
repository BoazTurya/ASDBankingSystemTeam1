package miu.edu.cs.cs525.final_project.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import miu.edu.cs.cs525.final_project.bank.backend.BankAccount;
import miu.edu.cs.cs525.final_project.bank.backend.BankAccountService;
import miu.edu.cs.cs525.final_project.bank.backend.InterestStrategySaving;
import miu.edu.cs.cs525.final_project.bank.ui.AddBankInterestAction;
import miu.edu.cs.cs525.final_project.bank.ui.BankDepositDialog;
import miu.edu.cs.cs525.final_project.bank.ui.BankWithdrawDialog;
import miu.edu.cs.cs525.final_project.bank.ui.JDialog_AddCompAcc;
import miu.edu.cs.cs525.final_project.bank.ui.JDialog_AddPAcc;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Person;
import miu.edu.cs.cs525.final_project.framework.ui.Form;
import miu.edu.cs.cs525.final_project.framework.ui.FrameButton;
import miu.edu.cs.cs525.final_project.framework.ui.TransactionDialog;

/**
 * A basic JFC based application.
 */
public class ApplicationBank extends Form{
	String accountnr, clientType;
	public BankAccountService bankAccountService;
	FrameButton JButton_PerAC = new FrameButton("Add personal account");
	FrameButton JButton_CompAC = new FrameButton("Add company account");
	FrameButton JButton_Addinterest= new FrameButton("Add interest");
	public ApplicationBank() {
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
			(new ApplicationBank()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	public void populateModel() {
		Collection<Account> accounts = getBankAccountService().getAllAccounts();

		rowdata = new Object[8];
		
		DefaultTableModel model = getModel();
		int rowCount =model.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    model.removeRow(i);
		}
		for(Account x :accounts) {
			BankAccount a = (BankAccount)x;
			String itype = a.getInterestStrategy().getClass().equals(InterestStrategySaving.class)?"saver":"checker";
			String ctype = a.getCustomer().getClass().equals(Person.class)?"personal":"company";
			columnIndex = 0;
			rowdata[columnIndex++] = a.getAccountNumber();
			rowdata[columnIndex++] = a.getCustomer().getName();
			rowdata[columnIndex++] = a.getCustomer().getAddress().getCity();
			rowdata[columnIndex++] = itype;
			rowdata[columnIndex++] = ctype;
			rowdata[columnIndex] = a.getBalance();
			getModel().addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}
		
	}

	class JButtonPerAC_Action implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			JDialog_AddPAcc pac = new JDialog_AddPAcc((ApplicationBank) thisFrame);
			pac.setBounds(450, 20, 300, 330);pac.show();			
			populateModel();
		}   
	}
	class JButtonCompAC_Action implements ActionListener{
		public void actionPerformed(ActionEvent event){	
			JDialog_AddCompAcc cac = new JDialog_AddCompAcc((ApplicationBank)thisFrame);
			cac.setBounds(450, 20, 300, 330);cac.show();
			populateModel();			
		}
	}
	public class FormDepositButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)getModel().getValueAt(selection, 0);
				BankDepositDialog dep = new BankDepositDialog((ApplicationBank) thisFrame, accnr);
				dep.setBounds(430, 15, 275, 140);dep.show();
							
				populateModel();
			}
		}
	}
	public class FormWithdrawButtonAction implements ActionListener{

		public void actionPerformed(ActionEvent event){
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String accnr = (String)getModel().getValueAt(selection, 0);
				
				TransactionDialog wd = new BankWithdrawDialog((ApplicationBank)thisFrame, accnr);  
				wd.setBounds(430, 15, 275, 140); wd.show();
		
				double newamount=  getBankAccountService().getAccount(accnr).getBalance();
				getModel().setValueAt(String.valueOf(newamount),selection, columnIndex);
				if (newamount <0){
					JOptionPane.showMessageDialog(getJButton_Withdraw(), " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
				}
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
	protected void initializeAccountService() {
		bankAccountService = new BankAccountService();
	}
	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}
	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}
	@Override
	protected void buildModel() {
		setThisFrame(this);
		setTitle("Bank Application.");
		getModel().addColumn("AccountNr");
		getModel().addColumn("Name");
		getModel().addColumn("City");
		getModel().addColumn("P/C");
		getModel().addColumn("Ch/S");
		getModel().addColumn("Amount");
	}
	@Override
	protected void hook() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void buildButtons() {
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
	
}
package miu.edu.cs.cs525.final_project.framework.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class Form extends JFrame{
	//private UIController accountController;
	protected String  clientName;
	protected String email;
	protected Integer numOfEmployees;
	public Integer getNumOfEmployees() {
		return numOfEmployees;
	}
	LocalDate birthdate;
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public void setNumOfEmployees(Integer numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	protected String street;
	protected String city;
	protected String zip;
	protected String stateName;
	protected long amountDeposit;
	protected String accountType;
	//protected boolean newaccount;
	private DefaultTableModel model;
	public JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected Form thisFrame;
	protected Object rowdata[];
	protected int maxrows =0;
	protected int columnIndex;

	protected JPanel JPanel1 = new JPanel();
	protected FrameButton JButton_Deposit = new FrameButton("Deposit");
	protected FrameButton JButton_Withdraw = new FrameButton("Withdraw");
	protected FrameButton JButton_Exit = new FrameButton("Exit");

	public Form()
	{
		setTitle("******generic bank application****");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		/* */
		JScrollPane1 = new JScrollPane();
		setModel(new DefaultTableModel());
		JTable1 = new JTable(getModel());
		rowdata = new Object[8];
		columnIndex = 0;
		//setNewaccount(false);

		//accountController = UIControllerImpl.getInstance();

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12,92,444,160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

		JPanel1.add(JButton_Deposit);
		JPanel1.add(getJButton_Withdraw());
		JPanel1.add(JButton_Exit);
		JButton_Deposit.setBounds(468,104,96,33);
		getJButton_Withdraw().setBounds(468,164,96,33);
		JButton_Exit.setBounds(468,248,96,31);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		JButton_Exit.addActionListener((ActionEvent event)->System.exit(0));

	}





	public abstract TransactionDialog createDepositDialog(Form parent);
	public abstract TransactionDialog createWithdrawDialog(Form parent);

	public class SymWindow extends java.awt.event.WindowAdapter{
		public void windowClosing(WindowEvent event)
		{

			Form_windowClosing(event);
		}
	}

	void Form_windowClosing(WindowEvent event){
		// to do: code goes here.

		try {
			this.setVisible(false);    // hide the Frame
			this.dispose();            // free the system resources
			System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	//	public boolean isNewaccount() {
	//		return newaccount;
	//	}
	//
	//
	//	public void setNewaccount(boolean newaccount) {
	//		this.newaccount = newaccount;
	//	}
	public Form getThisFrame() {
		return thisFrame;
	}


	public void setThisFrame(Form thisFrame) {
		this.thisFrame = thisFrame;
	}


	public Long getAmountDeposit() {
		return amountDeposit;
	}


	public void setAmountDeposit(Long Double) {
		this.amountDeposit = Double;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setStateName(String state) {
		this.stateName = state;
	}
	public String getStateName() {
		return stateName;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public FrameButton getJButton_Withdraw() {
		return JButton_Withdraw;
	}

	public void setJButton_Withdraw(FrameButton jButton_Withdraw) {
		JButton_Withdraw = jButton_Withdraw;
	}
	//	public UIController getAccountController() {
	//		return accountController;
	//	}
	//	public void setAccountController(UIController accountController) {
	//		this.accountController = accountController;
	//	}



}


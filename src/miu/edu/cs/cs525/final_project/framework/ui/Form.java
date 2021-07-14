package miu.edu.cs.cs525.final_project.framework.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Form extends JFrame{

	protected String  clientName;
	protected String street;
	protected String city;
	protected String zip;
	protected String state;
	protected String amountDeposit;
	protected String accountType;
	protected boolean newaccount;
	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected Form thisFrame;
	protected Object rowdata[];

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
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		rowdata = new Object[8];
		setNewaccount(false);


		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12,92,444,160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
		    
		JPanel1.add(JButton_Deposit);
		JPanel1.add(JButton_Withdraw);
		JPanel1.add(JButton_Exit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setBounds(468,248,96,31);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		JButton_Exit.addActionListener((ActionEvent event)->System.exit(0));
		
	}

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
	
	public boolean isNewaccount() {
		return newaccount;
	}


	public void setNewaccount(boolean newaccount) {
		this.newaccount = newaccount;
	}
	public Form getThisFrame() {
		return thisFrame;
	}


	public void setThisFrame(Form thisFrame) {
		this.thisFrame = thisFrame;
	}


	public String getAmountDeposit() {
		return amountDeposit;
	}


	public void setAmountDeposit(String amountDeposit) {
		this.amountDeposit = amountDeposit;
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

	public void setState(String state) {
		this.state = state;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



}


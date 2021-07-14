package miu.edu.cs.cs525.final_project.framework.ui.controller;

public class UIControllerImpl implements UIController {
	private static UIControllerImpl instance;

	private UIControllerImpl() {
		// TODO Auto-generated constructor stub
	}
	public static UIControllerImpl getInstance(){
		if(instance ==null) {
			synchronized (instance) {
				if(instance==null) {
					instance = new UIControllerImpl();
				}
			}
		}
		return instance;
	}
	@Override
	public void deposit(String number, double amount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double withdraw(String number, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void createAccount(String name, String street, String city, String state, String zip) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addInterest() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	

}

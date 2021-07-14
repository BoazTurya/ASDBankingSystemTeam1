package miu.edu.cs.cs525.final_project.framework.ui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AddInterestAction implements ActionListener {

	Component Parent;
	public AddInterestAction(Component parent) {
		super();
		Parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(Parent, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
		
		/*
		 * 
		 * to do
		 */
	}

}

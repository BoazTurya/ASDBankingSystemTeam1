package miu.edu.cs.cs525.final_project.framework.ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class CancelDialogAction implements ActionListener{
	JDialog parentComponent;
	public CancelDialogAction(JDialog comp) {
		// TODO Auto-generated constructor stub
		parentComponent = comp;	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		parentComponent.dispose();
		
	}
	

}

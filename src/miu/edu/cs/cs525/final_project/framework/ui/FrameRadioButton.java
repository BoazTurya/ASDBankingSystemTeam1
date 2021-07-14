package miu.edu.cs.cs525.final_project.framework.ui;

import javax.swing.JRadioButton;

public class FrameRadioButton extends JRadioButton{

	public FrameRadioButton(String string) {
		super(string);
		setActionCommand(string);
	}

}

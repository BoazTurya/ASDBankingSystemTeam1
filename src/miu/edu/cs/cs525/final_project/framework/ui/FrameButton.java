package miu.edu.cs.cs525.final_project.framework.ui;

import javax.swing.JButton;

public class FrameButton extends JButton{
	public FrameButton(String string) {
		super(string);
		setActionCommand(string);
	}
}
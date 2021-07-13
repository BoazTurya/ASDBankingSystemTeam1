package miu.edu.cs.cs525.final_project.framework.ui;

import javax.swing.JButton;

class FrameButton extends JButton{
	public FrameButton(String string) {
		super(string);
		setBounds(48,264,84,24);
		setActionCommand(string);
	}
}
package miu.edu.cs.cs525.final_project.framework.ui;

import java.awt.Color;

import javax.swing.JLabel;

public class FrameLabel extends JLabel{
	public FrameLabel(String name) {
		super(name);
		setForeground(Color.black);
		setBounds(12,84,48,24);
	}
}
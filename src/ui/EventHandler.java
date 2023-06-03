package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("SinglePlay")) {
			SingleNormalUI window = new SingleNormalUI();
			window.frame.setVisible(true);
		} else if (arg0.getActionCommand().equals("MultiPlay"))
			System.out.println("MultiPlay");
		else if (arg0.getActionCommand().equals("Easy"))
		{
			SingleEasyUI window = new SingleEasyUI();
			window.frame.setVisible(true);
		}
		else if (arg0.getActionCommand().equals("Normal"))
		{
			SingleNormalUI window = new SingleNormalUI();
			window.frame.setVisible(true);
		}
		else if (arg0.getActionCommand().equals("Hard"))
		{
			SingleHardUI window = new SingleHardUI();
			window.frame.setVisible(true);
		}
		else if (arg0.getActionCommand().equals("Easyreset"))
		{
			SingleEasyUI window = new SingleEasyUI();
			window.frame.setVisible(true);
		}
		else if (arg0.getActionCommand().equals("Normalreset"))
		{
			SingleNormalUI window = new SingleNormalUI();
			window.frame.setVisible(true);
		}
		else if (arg0.getActionCommand().equals("Hardreset"))
		{
			SingleHardUI window = new SingleHardUI();
			window.frame.setVisible(true);
		}
	}
}
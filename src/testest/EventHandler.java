package testest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {// 액션이벤트가 발생됬을떄 수행하는 동작
		if (arg0.getActionCommand().equals("SinglePlay")) {
			SingleNormalUI window = new SingleNormalUI();
			window.frame.setVisible(true);
		} else if (arg0.getActionCommand().equals("MultiPlay"))
			System.out.println("아직아니야");
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
	}
}
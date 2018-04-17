package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;



public class KeyDispatch implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e)  {
		if (e.getSource() == MeesChat.refreshButton) {
			MeesChat.writer.print("");
		} else if (e.getSource() == MeesChat.sendButton) {
			
			String msg = MeesChat.login+": "+MeesChat.t.getText();
			MeesChat.writer.println(msg);
			MeesChat.writer.flush();
			
			MeesChat.t.setText(" ");
			MeesChat.t.requestFocus();
			
			
		}
		
		

	}

/*	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			String msg = MeesChat.login + ": " + MeesChat.t.getText();
			MeesChat.writer.println(msg);
			MeesChat.writer.flush();

			MeesChat.t.setText(" ");
			MeesChat.t.requestFocus();
		}
	}
*/
}

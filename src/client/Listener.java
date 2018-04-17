package client;

public class Listener implements Runnable {

	@Override
	public void run() {
		String msg;
		try {
			while((msg=MeesChat.reader.readLine())!=null) {
				MeesChat.ta.append(msg+"\n");
			}
		}catch(Exception ex) {}

	}

}

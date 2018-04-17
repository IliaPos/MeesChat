package server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import client.MeesChat;




public class MeesServer {
	
	private static ArrayList<PrintWriter> streams;
	
	

	public static void main(String[] args) {
		go();

	}
	

	private static void go() {
		streams = new ArrayList<PrintWriter>();
		

		try {
			ServerSocket ss = new ServerSocket(5000);
			while (true) {
				Socket sock = ss.accept();
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				System.out.println("Got user!");
				
				
			
				
				
				streams.add(writer);
				
				Thread t = new Thread(new Listener(sock));
				t.start();
			}
		} catch (Exception ex) {
		}

	}
	public static void tellEveryOne(String msg) {
		int x = msg.indexOf(":");
		String login = msg.substring(0, x);
		
		
		
		java.util.Iterator<PrintWriter> it = streams.iterator();
		while(it.hasNext()) {
			try {
				PrintWriter writer = it.next();
				writer.println(msg);
				writer.flush();
			}catch(Exception e) {}
		}
		
	}

}

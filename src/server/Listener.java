package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import client.MeesChat;

public class Listener implements Runnable {

	BufferedReader reader;

	Listener(Socket sock) {
		InputStreamReader is;
		try {
			is = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(is);
		} catch (Exception e) {
		}

	}

	@Override
	public void run() {
		String msg;
		
		
		
		try {
			while ((msg = reader.readLine()) != null) {
				System.out.println(msg);
				MeesServer.tellEveryOne(msg);
			}
		} catch (Exception ex) {
		}

	}

}

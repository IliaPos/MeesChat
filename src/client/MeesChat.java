package client;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MeesChat {
	
	
	public static JTextArea ta;
	public static JTextField t;
	public static BufferedReader reader;//get message from server
	public static PrintWriter writer; //send message to server
	public static String login;
	public static JButton sendButton;
	public static JButton refreshButton;
	
	public static void main(String[] args) {
		checkName();
		go();

	}
	
	private static void checkName() {
		login = JOptionPane.showInputDialog(null, "Введите логин");
		if(login == null ){
			
			System.exit(0);
			
		} else if (login != null && ("".equals(login))){
			
			System.err.println("error");
			JOptionPane optionPane = new JOptionPane("Unfortunately, your login cannot be emty", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Failure");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			System.exit(0);
			
		}
		    
		
		
	}
	
	private static void go() {


		JFrame f = new JFrame("MeesChat 1.0.0");
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		JPanel p = new JPanel();
		ta = new JTextArea(15, 30);
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane(ta);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		t = new JTextField(20);
		sendButton = new JButton("Отправить");
		refreshButton = new JButton("Обновить");
	
		
		refreshButton.addActionListener(new KeyDispatch() {

		
		});
		sendButton.addActionListener(new KeyDispatch() {


			
		
			
		});
		
		
		p.add(sp);
		p.add(t);
		p.add(sendButton);
		setNet();
		
		Thread thread = new Thread(new Listener());	
		thread.start();

		f.getContentPane().add(BorderLayout.CENTER, p);
		f.getContentPane().add(BorderLayout.NORTH, refreshButton);
		f.setSize(400, 340);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	

	@SuppressWarnings("resource")
	private static void setNet() {
		try {
			Socket sock = new Socket("127.0.0.1", 5000);
			InputStreamReader is = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(is);
			writer = new PrintWriter(sock.getOutputStream());
		} catch (Exception ex) {
		}

	}




}

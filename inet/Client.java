import java.net.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;


public class Client extends JFrame implements KeyListener {

	private final String ADRESS = "127.0.0.1";
	private final int CONNECTION_PORT = 8080;

	private Socket clientSocket;
	private PrintWriter out;
	private static String player = null;

	public static void main (String[] args) throws IOException {
		
		Client client = new Client();
		
		player = args[0];

	}
	
	public Client() throws IOException {
		
		clientSocket = new Socket(ADRESS, CONNECTION_PORT);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		
		this.addKeyListener(this);
		setVisible(true);
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// Empty
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// Empty
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_Q)
			System.exit(0);
		
		if (event.getKeyCode() == KeyEvent.VK_UP) {
    		out.println(player);
    		out.println("u");
	    }
	    if (event.getKeyCode() == KeyEvent.VK_DOWN) {
	        out.println(player);
	        out.println("d");
	    }
	    if (event.getKeyCode() == KeyEvent.VK_LEFT) {
	        out.println(player);
	        out.println("l");
	    }
	    if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
	        out.println(player);
	        out.println("r");
	    }
		
	}
}
import java.io.*; 
import java.net.*; 

public class Server { 
	
	private final static int CONNECTION_PORT = 8080;

	private static ServerSocket serverSocket;
	private static BufferedReader in;
	
	
	 public static void main(String[] args) throws IOException { 
		 
	     serverSocket = new ServerSocket(CONNECTION_PORT);
	     
	     Spel spel = new Spel();
	       
	     while (true){ 
	         Socket clientSocket = null; 
	         clientSocket = serverSocket.accept(); 
	               
	         in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	               
	          Thread t = new ClientHandler(clientSocket, in, spel); 
	          t.start(); 
	
	     } 
	 } 
} 

class ClientHandler extends Thread { 
	 final BufferedReader in; 
	 final Socket s; 
	 final Spel spel;
	   
	 public ClientHandler(Socket s, BufferedReader in, Spel spel){ 
	     this.s = s; 
	     this.in = in; 
	     this.spel = spel;
	 } 
	
	 @Override
	 public void run() { 
		 
		 try {
			 
			 String player;
			 String direction;
			 while((player = in.readLine()) != null){
				 if ((direction = in.readLine()) != null)
					 spel.movePlayer(player, direction);
			 } 
			 
		 } catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	 } 
} 



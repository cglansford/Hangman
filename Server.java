package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
			//Sets up the "factory"
			ServerSocket server = new ServerSocket(4443);
			//listens for client connection request, and creates the socket on this side when
			Socket blueSocket = server.accept();
			
		
			BufferedReader in = new BufferedReader (new InputStreamReader(blueSocket.getInputStream()));
			PrintWriter out = new PrintWriter(blueSocket.getOutputStream(), true);
			
			//String to store word the user has to guess
			String word;
			int count = 0;
			

			
	public Server() throws IOException {
		
		//welcome();
		//playingGame();

		out.println("Welcome to Hangman");
		out.println("Enter a word");
		word = in.readLine();
		out.println(word);
		
		
		out.println("Guess any letter in the word");
		String inputLine;
	    while ((inputLine = in.readLine()) != null) {
	        
	       for(int i = 0; i<word.length(); i++) {
	    	   if (word.charAt(i) == inputLine.charAt(0)) {
	    		   out.println("The letter is in posisition " + (i+1) );
	    		   break;
	    	   }
	    	   if((i+1)==word.length()) {
	    		   out.println("That letter is not in the word");
	    		   break;
	    	   }
	    	   	
	       }
	       	
	       	count++;
	       	if (count == 5) {
	            out.println("5 guess limit reached, guess the word");
	            if(word.equals(in.readLine()))
	            	out.println("Congratulations you got the word right");
	            else
	            	out.println("Thats incorrect, you lose");
	            break;
	         }
	        
	        out.println("Guess any letter in the word");
	    }
		
	 
		out.close();
		in.close();
		blueSocket.close();
		server.close();
	}
	

	
	public static void main(String[] args) throws IOException {
		new Server();
	}
}

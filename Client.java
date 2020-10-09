package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	Scanner scan = new Scanner(System.in);
	int count = 0;
	Socket redSocket = new Socket("localhost", 4443);
	BufferedReader in = new BufferedReader (new InputStreamReader(redSocket.getInputStream()));
	PrintWriter out = new PrintWriter(redSocket.getOutputStream(), true);
	
	public Client() throws UnknownHostException, IOException {
		System.out.println("Client started");
		
		System.out.println("Client Connected to server");
		
		
		
		//welcome message
		String textFromServer = in.readLine();
		System.out.println("From Server " + textFromServer);
		
		//enter the word
	    textFromServer = in.readLine();
		System.out.println("From Server " + textFromServer);
		out.println(scan.nextLine());
		
		//replay the word entered 
		textFromServer = in.readLine();
		System.out.println("From Server " + textFromServer);
		
		//guess the letter
		textFromServer = in.readLine();
		System.out.println("From Server " + textFromServer);
		out.println(scan.nextLine());
		
		while(count<5) {
			textFromServer = in.readLine();
			System.out.println("From Server: " + textFromServer);	
			textFromServer = in.readLine();
			System.out.println("From Server: " + textFromServer);
			out.println(scan.nextLine());
			count++;
		}

		textFromServer = in.readLine();
		System.out.println("From Server: " + textFromServer);
		out.println(scan.nextLine());
		textFromServer = in.readLine();
		System.out.println("From Server: " + textFromServer);	

		out.close();
		in.close();
		redSocket.close();
		
		
	}
	
	public static void main(String[] args) throws IOException {
		new Client();
	}
}

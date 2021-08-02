//package TCL;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	
	public static void main(String[] args) {
	   try {
           ServerSocket serversocket =  new ServerSocket(5000);
           System.out.println("Server is booted up and waiting for client to connect");

           Socket clientsocket = serversocket.accept();
           System.out.println("A new client is connected to the server");
           Session client = new Session(clientsocket);
           client.start();

       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }

	}
}
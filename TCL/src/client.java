//package TCL;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		
		InetAddress ip;
	 
     try {
         ip = InetAddress.getByName("localhost");
         Socket clientsocket = new Socket(ip,5000);

         Scanner scanner = new Scanner(System.in);
         DataInputStream input = new DataInputStream(clientsocket.getInputStream());
         DataOutputStream output = new DataOutputStream(clientsocket.getOutputStream());

         String conn = input.readUTF();
         System.out.println("Server is " + conn);

         while(true)
         {
             String ask = input.readUTF();
             System.out.println("Server: " + ask);

             String request = scanner.nextLine();
             output.writeUTF(request);

             if(request.equals("close"))
             {
                 clientsocket.close();
                 System.out.println("The connection is closed");
                 break;
             }
             else if (request.equals("list"))
             {
            	 String ask2 = input.readUTF();
				 System.out.println("Server:" + ask2);
				 
				 String request2 = scanner.nextLine();
                 output.writeUTF(request2);
				 
                 
                 String ask3 = input.readUTF();
				 System.out.println("Server: " + ask3);
                 
                 String request3 = scanner.nextLine();
                 output.writeUTF(request3);
                 
                 String ask4 = input.readUTF();
				 System.out.println("Server: " + ask4);
				 
				 String request4 = scanner.nextLine();
				 output.writeUTF(request4);
				 
                 String reply = input.readUTF();
                 System.out.println("Server: "+ reply);
                 

             }

         }
         
     } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }

 }

}

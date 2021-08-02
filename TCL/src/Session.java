//package TCL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Session extends Thread{
    Socket clientSocket;

	    public Session(Socket clientSocket){
	        this.clientSocket = clientSocket;
	    }

	    public void run(){

	        while(true)
	        {
	            try {
	                Scanner scanner = new Scanner(System.in);
	                DataInputStream input = new DataInputStream(clientSocket.getInputStream());
	                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
	                output.writeUTF("connected");
	                while(true)
	                {
	                    output.writeUTF("Please enter the list of numbers to be aranged or 'close' to close the connection");

	                    String request = input.readUTF();
	                    System.out.println("Client : "+ request);

	                    if(request.equals("close"))
	                    {
	                        this.clientSocket.close();
	                        System.out.println("The connection is closed");
	                        break;
	                    }
	                    else if (request.equals("list"))
	                    {
	                    	output.writeUTF("Enter number of elements you want in the array: ");
	                    	
	                    	int count = Integer.parseInt(input.readUTF()); //request2
							System.out.println("Client : \n"+ count);
							
	                        
	                        output.writeUTF("Enter array elements:");
	                        
	                        String request3 = input.readUTF(); //request3
							System.out.println("Client : \n"+ request3);
							
							String[] num2 = request3.split(" ",count);
							int[] num = new int[count];
							
	                        for(int j = 0;j<count;j++)
	                        {
	                            num[j] = Integer.parseInt(num2[j]);
	                        }
	                        
	                        Arrays.sort(num);
	                        output.writeUTF("Please choose:\n 1. Ascending order \n 2. Descending order");
	                        
	                        String request4 = input.readUTF();
	                        System.out.println("Client : \n"+ request4);
	                        
	                        
	                        if(request4.equals("1"))
	                        {
	                            
	                        	 output.writeUTF(Arrays.toString(num));
	                            
	                        }
	                        else if (request4.equals("2"))
	                        {
	                        	int[] temp = new int [count];
	                        	
	                            for(int j = count-1 , itemp = 0; j > -1; j-- , itemp++)
	                            {
	                                temp[itemp] = num[j];
	                            }
	                            output.writeUTF(Arrays.toString(temp));
	                        }
	                    }
	                }
	            } catch (IOException ex) {
	                Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
	            }

	        }
	    }

}

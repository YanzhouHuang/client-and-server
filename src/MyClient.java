import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintStream;  
import java.net.Socket;  
import java.net.SocketTimeoutException;  
  
public class MyClient {  
    public static void main(String[] args) throws IOException {  
        //The client requests a TCP connection with the machine at port 5210  
        Socket client = new Socket("127.0.0.1", 5210);  
        client.setSoTimeout(10000);  
        //Get keyboard input   
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
        //Socket output stream, used to send data to the server   
        PrintStream out = new PrintStream(client.getOutputStream());  
        //Get the input stream from the socket to receive the data sent from the server    
        BufferedReader buf =  new BufferedReader(new InputStreamReader(client.getInputStream()));  
        boolean flag = true;  
        while(flag){  
            System.out.print("Enter some text£º");  
            String str = input.readLine();  
            //Sent Data to Server side    
            out.println(str);  
            if("exit".equals(str)){  
                flag = false;  
                System.out.println("Exiting client program!"); 
                // exit the program
            }else{  
                try{  
                    
                	//From the server to receive data has a time limit (the system itself can also set their own), more than this time, it will throw the exception
                    String echo = buf.readLine();  
                    System.out.println(echo);  
                }catch(SocketTimeoutException e){  
                    System.out.println("Time out, No response");  
                }  
            }  
        }  
        input.close();  
        if(client != null){  
            
        	//If the constructor to establish a connection, then close the socket, if you do not establish a connection, naturally do not close  
            client.close(); 
            //Only close the socket, its associated input and output streams will be closed  
        }  
    }  
}  
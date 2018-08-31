import java.net.ServerSocket;  
import java.net.Socket;  
  
public class MyServer {  
    public static void main(String[] args) throws Exception{  
    	//The server listens on the 5210 port to the TCP connection requested by the client
        ServerSocket server = new ServerSocket(5210);  
        Socket client = null;  
        boolean f = true;  
        while(f){  
            //Wait for the client to connect if there is no connection
            client = server.accept();  
            System.out.println("Connect to client successfully £¡");  
            //Open a thread for each client connection
            new Thread(new ServerThread(client)).start();  
        }  
        server.close();  
    }  
}  
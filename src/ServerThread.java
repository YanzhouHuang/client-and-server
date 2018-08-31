
import java.io.BufferedReader;  
import java.io.InputStreamReader;  
import java.io.PrintStream;  
import java.net.Socket;  
  

public class ServerThread implements Runnable {  
  
    private Socket client = null;  
    public ServerThread(Socket client){  
        this.client = client;  
    }  
      
    @Override  
    public void run() {  
        try{  
        	//Get the output stream of the socket to send data to the client 
            PrintStream out = new PrintStream(client.getOutputStream());  
            //Get the input stream from the socket to receive the data sent from the client
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));  
            boolean flag =true;  
            while(flag){  
            	// receive the data sent from the client 
                String string =  buf.readLine();  
                if(string == null || "".equals(string)){  
                    flag = false;  
                }else{  
                    if("exit".equals(string)){  
                        flag = false;  
                    }else{ 
                        out.println("Received from server:" + string);  
                    }  
                }  
            }  
            out.close();  
            client.close();  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
  
}  

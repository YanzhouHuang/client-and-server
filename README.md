# client-and-server
Simple Client Server project

Create two programs, for example, Client.java and Server.java, if the group chose Java as their programming language. The client and server
programs should communicate using TCP to ensure reliable, in-order communication. The server process should remain running at all times in a centralized location. The client
process should be run in a remote location, and may be replicated on multiple machines. Client/Server communication is simple: The client process prompts the user for input from
the keyboard. Once the user gives this data and presses enter, the client process communicates this data to the server process. The server responds by capitalizing all alphabetic data
and returns this data to the client. Once the data is received by the client, it is displayed to the user. The server responds to non-alphabetic data by sending it back to the client
unchanged. The user terminates the client by typing ”exit”.


Example (assuming the server is running):
gallojm@archer:˜$java client
Welcome to my simple Java network client!
Enter some text: This is a test.
Received from server: THIS IS A TEST.
Enter some text: 1 2 3 4
Received from server: 1 2 3 4
Enter some text: My favorite number is 7.
Received from server: MY FAVORITE NUMBER IS 7.
Enter some text: exit
Exiting client program!
gallojm@archer:˜$

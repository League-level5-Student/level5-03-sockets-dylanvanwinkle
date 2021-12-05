package _02_Chat_Application;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class ChatApp {
	public static int port = 10001;

	public static void main(String[] args) {
		// 1. Create a String for the ip address of the server.
		// If you don't know how to find a computer's ip address, ask about ifconfig on
		// linux/mac and ipconfig on windows.
		String ip = "localhost";
		boolean loop = true;
		// 2. Create an integer for the server's port number
		// 3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
		while(loop) {
		try {

			// 4. Create an object of the Socket class. When initializing the object, pass
			// in the ip address and the port number
			Socket socket = new Socket(ip, port);
			// 5. Create a DataOutputStream object. When initializing it, use the Socket
			// object you created in step 4 to call the getOutputStream() method.
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			// 6. Use the DataOutputStream object to send a message to the server using the
			// writeUTF(String message) method
			
			
			String s =JOptionPane.showInputDialog("Type Message Below.");
			if (s.equalsIgnoreCase("!Exit")) {
				dis.close();
				dos.close();			
			loop = false;
			}else {
				dos.writeUTF(s);	
			}
			// 7. Create a DataInputStream object. When initializing it, use the Server
			// object you created in step 4 to call the getInputStream() method.
		
			// 8. Use the DataInputStream object to print a message from the server using
			// the readUTF() method.
			JOptionPane.showMessageDialog(null, dis.readUTF());
			// 9. Close the client's server object
			dos.close();
			dis.close();
		} catch (IOException e) {
			// TODO: handle exception
			loop = false;
			
		}
		}
	}
}


package socket;

import java.io.*;
import java.net.*;



public class Cliente {
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	public  Cliente(String address, int port) throws IOException {
		try {
			socket = new Socket(address, port);
			System.out.println("Conectado...!");
			input = new DataInputStream(System.in);
			out = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException u) {
			System.out.println(u);
		}
		String line = "";
		while(!line.equals("S")) {
			try {
				line = input.readLine();
				out.writeUTF(line);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		try {
			input.close();
			out.close();
			socket.close();
		} catch (Exception e) {
			
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		Cliente cliente = new Cliente("192.168.1.39",3030);
		
		
	}
	
	
}

package socket;
import  java.io.*;
import java.net.*;



public class Server {
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	
	public Server(int port) throws IOException{
		server = new ServerSocket(port);
		System.out.println("Server Iniciado");
		socket = server.accept();
		System.out.println("CLiente aceptado");
		in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		String line = "";
		while(!line.equals("S")) {
			try {
				line = in.readUTF();
				System.out.println(line);
			} catch (IOException i) {
				System.out.println(i);
			}
		}
		
		
		System.out.println("Cerrando la conexión");
		socket.close();
		in.close();
	}
	
	public static void main(String[] args) throws IOException{
		Server server = new Server(3030);
	}
	
	
	
}

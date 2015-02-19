
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerKnock {
	public static void main(String[] args) {

		
		
		int port = 1123;
		
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			while(true){
				Socket clientSocket = serverSocket.accept();
				new WorkOnThread(clientSocket).start();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

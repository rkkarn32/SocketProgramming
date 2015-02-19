import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WorkOnThread extends Thread {

	Socket clientSocket;

	public WorkOnThread(Socket socket) {
		this.clientSocket = socket;
	}

	@Override
	public void run() {
		try (
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));)

		{

			while(true){
				
				String input = in.readLine();
				if(input != null)
				System.out.println("Input Messge: "+input);
				out.println("Input Was: " + input);
				if(input !=null && input.equals("bye"))
					break;
			}
				

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {
	public static void main(String[] args) {

		String server = "127.0.0.1";
		int port = 1123;

		String message = "This is my message";
		Scanner sc = new Scanner(System.in);

		try (Socket socket = new Socket(server, port);
				PrintWriter out = new PrintWriter(socket.getOutputStream(),
						true);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));) {
			while (true) {
				String val = sc.next();
				out.println(val);
				System.out.println("Reply from server: " + in.readLine());
				
				if(val.equals("bye"))
					break;
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

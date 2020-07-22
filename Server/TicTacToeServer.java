package Server;


import java.net.ServerSocket;

/**
 * To build a server for the game 
 * @author Aaron Lee
 *
 */
public class TicTacToeServer{
	
	/**
	 * main function to run the server
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Server is running");
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				System.out.println("Server Stopped.");
			}
		}));
		
		try (var listener = new ServerSocket(58901)) {
			Server myServer = new Server(listener);
			myServer.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
}
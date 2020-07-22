package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class Server {
	
	private ServerSocket serverSocket;	
	
	/**
	 * a constructor the construct the server for the game
	 * @param serverSocket
	 */
	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	/**
	 * to let the client to enter the game
	 */
	public void start() {
		var pool = Executors.newFixedThreadPool(200);
		while (true) {
			try {
				Game game = new Game(null, null);
				pool.execute(new Player(serverSocket.accept(), 'X', game));
				pool.execute(new Player(serverSocket.accept(), 'O', game));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
}

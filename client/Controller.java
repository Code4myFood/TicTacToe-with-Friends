package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Controller{
	private Socket socket;
	private View view;
	private PrintWriter out;
	
	/**
	 * a constructor to construct the GUI for the game
	 * @param view
	 */
	public Controller(View view) {
		this.view = view;
	}
	
	/**
	 * to let the player control the game and initializing the function of the button
	 * in order to send the command to the server
	 */
	public void start() {
		try {
			this.socket = new Socket("127.0.0.1", 58901);
			this.out = new PrintWriter(socket.getOutputStream(), true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		view.getBox1().addActionListener(e->{
			out.println("Move1");
			out.flush();
		});
		view.getBox2().addActionListener(e->{
			out.println("Move2");
		});
		view.getBox3().addActionListener(e->{
			out.println("Move3");
		});
		view.getBox4().addActionListener(e->{
			out.println("Move4");
		});
		view.getBox5().addActionListener(e->{
			out.println("Move5");
		});
		view.getBox6().addActionListener(e->{
			out.println("Move6");
		});
		view.getBox7().addActionListener(e->{
			out.println("Move7");
		});
		view.getBox8().addActionListener(e->{
			out.println("Move8");
		});
		view.getBox9().addActionListener(e->{
			out.println("Move9");
		});
		view.getExit().addActionListener(e->{
			out.println("Exit the Game");
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		});
		// Creates a new Thread for reading server messages
		Thread handler = new ClientHandler(socket, view);
		handler.start();
	}

	
	
	
	
}

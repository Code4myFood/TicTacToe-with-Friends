package client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class ClientHandler extends Thread {
	
	private Socket socket;
	private Scanner in;
	private PrintWriter out;
	private View view;
	private String opponentmark, mark;
	
	public ClientHandler(Socket socket, View view) {
		this.socket = socket;
		this.view = view;
	}
	
	/**
	 * run the game 
	 */
	public void run(){
		try {
			readFromServer();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * read and run the command received from the server
	 * @throws Exception
	 */
	private void readFromServer() throws Exception{
		
		try {
			this.in = new Scanner(socket.getInputStream());
			var playerMark = in.nextLine();
			mark = playerMark;
			if (mark.equals("X")) {
				opponentmark = "O";
			}else {
				opponentmark = "X";
			}
			while(in.hasNextLine()) {
				String command = in.nextLine();
				System.out.println(command);
				if(command.equalsIgnoreCase("Not your turn")) {
					JOptionPane.showMessageDialog(view.getFrame(), "Not your turn");
					view.getUpperLabel().setText("Not your turn");
				}else if(command.equalsIgnoreCase("Wait for opponent to move first")) {
					view.getUpperLabel().setText("Wait for opponent to move first");
				}else if(command.equalsIgnoreCase("Waiting opponent to join the game")) {
					view.getUpperLabel().setText("Waiting opponent to join the game");
				}else if(command.equalsIgnoreCase("Please move first")) {
					view.getUpperLabel().setText("Please move first");
				}else if(command.equalsIgnoreCase("opponent move1")) {
					view.getUpperLabel().setText("The opponent moved");
					view.setBox1(opponentmark);
				}else if(command.equalsIgnoreCase("opponent move2")) {
					view.getUpperLabel().setText("The opponent moved");
					view.setBox2(opponentmark);
				}else if(command.equalsIgnoreCase("opponent move3")) {
					
					view.getUpperLabel().setText("The opponent moved");
					view.setBox3(opponentmark);
				}else if(command.equalsIgnoreCase("opponent move4")) {
					
					view.getUpperLabel().setText("The opponent moved");
					view.setBox4(opponentmark);
				}else if(command.equalsIgnoreCase("opponent move5")) {
					
					view.getUpperLabel().setText("The opponent moved");
					view.setBox5(opponentmark);
				}else if(command.equalsIgnoreCase("opponent move6")) {
					
					view.getUpperLabel().setText("The opponent moved");
					view.setBox6(opponentmark);
				}else if(command.equalsIgnoreCase("opponent move7")) {
					
					view.getUpperLabel().setText("The opponent moved");
					view.setBox7(opponentmark);
				}else if(command.equalsIgnoreCase("opponent move8")) {
					
					view.getUpperLabel().setText("The opponent moved");
					view.setBox8(opponentmark);
				}else if(command.equalsIgnoreCase("opponent move9")) {
					
					view.getUpperLabel().setText("The " + command);
					view.setBox9(opponentmark);
				}else if(command.equalsIgnoreCase("move1")){
					view.getUpperLabel().setText("Move");
					view.setBox1(mark);
				}else if(command.equalsIgnoreCase("move2")){
					view.getUpperLabel().setText("Valid Move");
					view.setBox2(mark);
				}else if(command.equalsIgnoreCase("move3")){
					view.getUpperLabel().setText("Move");
					view.setBox3(mark);
				}else if(command.equalsIgnoreCase("move4")){
					view.getUpperLabel().setText("Move");
					view.setBox4(mark);
				}else if(command.equalsIgnoreCase("move5")){
					view.getUpperLabel().setText("Move");
					view.setBox5(mark);
				}else if(command.equalsIgnoreCase("move6")){
					view.getUpperLabel().setText("Move");
					view.setBox6(mark);
				}else if(command.equalsIgnoreCase("move7")){
					view.getUpperLabel().setText("Move");
					view.setBox7(mark);
				}else if(command.equalsIgnoreCase("move8")){
					view.getUpperLabel().setText("Move");
					view.setBox8(mark);
				}else if(command.equalsIgnoreCase("move9")){
					view.getUpperLabel().setText("Move");
					view.setBox9(mark);
				}else if(command.equalsIgnoreCase("win")) {
					JOptionPane.showMessageDialog(view.getFrame(), "You win the game");
					view.getUpperLabel().setText("You win the game");
					break;
				}else if(command.equalsIgnoreCase("lose")) {
					JOptionPane.showMessageDialog(view.getFrame(), "You lose the game");
					break;
				}else if(command.equalsIgnoreCase("draw")) {
					JOptionPane.showMessageDialog(view.getFrame(), "Draw");
					view.getUpperLabel().setText("Draw");
					break;
				}else if (command.equalsIgnoreCase("opponent quit game")) {
					JOptionPane.showMessageDialog(view.getFrame(), "opponent quit game");
					view.getUpperLabel().setText("opponent quit the game");
					break;
				}else if(command.equalsIgnoreCase("You don't have an opponent yet")) {
					JOptionPane.showMessageDialog(view.getFrame(), "You don't have an opponent yet");
					view.getUpperLabel().setText("You don't have an opponent yet");
				}else if(command.equalsIgnoreCase("Already have chess")) {
					JOptionPane.showMessageDialog(view.getFrame(), "Already have chess");
					view.getUpperLabel().setText("Already have chess");
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			socket.close();
		}
	}
}

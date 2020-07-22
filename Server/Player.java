package Server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Player implements Runnable {
		private char mark;
		private Socket socket;
		private Scanner input;
		private PrintWriter output;
		private Player currentPlayer;
		private Player opponent;
		private Game game;
		
		/**
		 * a constructor to build up the information for the player
		 * @param socket
		 * @param mark the first player will assign as cross the later enter one will assign as circle
		 * @param game which game the player will enter
		 */
		public Player(Socket socket, char mark, Game game) {
			this.socket = socket;
			this.mark = mark;
			this.game = game;
		}
		
		/**
		 * to receive the command from the player then follow the command
		 * after each command made by the clients will return the command to the clients for following up
		 */
		@Override
		public void run() {
			System.out.println("Connected: " + socket);
			try {
				input = new Scanner(socket.getInputStream());
				output = new PrintWriter(socket.getOutputStream(), true);
				output.println(mark);
				System.out.println(mark);
				// add this client to the broadcast list
				if(mark == 'X') {
					currentPlayer = this;
					game.setCurrentPlayer(this);
					output.println("Waiting opponent to join the game");
					output.flush();
				}else {
					currentPlayer = this;
					currentPlayer.setOpponent(game.getCurrentPlayer());
					currentPlayer.getOpponent().setOpponent(this);
					game.setOpponent(this);
					output.println("Wait for opponent to move first");
					opponent.output.println("Please move first");
					output.flush();
				}
				while (input.hasNextLine()) {
					var command = input.nextLine();

					System.out.println("Server Received: " + command);
					if (command.startsWith("Exit")) {
						break;
					}else if(command.startsWith("Move")) {
						try {
							String order = game.move(Integer.parseInt(command.substring(4)), this);
							//return the message about the choice to move to the client
							output.println(order);
							//return the message to the opponent that the move choice to move
							opponent.output.println("Opponent " + order);
							//return the message that the game is done to the client
							if(game.hasWinner()) {
								output.println("win");
								getOpponent().output.println("lose");
								break;
							}else if(game.draw()) {
								output.println("Draw");
								getOpponent().output.println("draw");
								break;
							}
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				// client disconnected
				if (opponent != null) {
					opponent.output.println("opponent quit game");
				}
				try {
					socket.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		/**
		 * to set the opponent of the player
		 * @param currentPlayer2
		 */
		private void setOpponent(Player currentPlayer2) {
			this.opponent = currentPlayer2;
		}
		
		/**
		 * to return the player opponent
		 * @return
		 */
		public Player getOpponent() {
			return opponent;
		}


		
	}
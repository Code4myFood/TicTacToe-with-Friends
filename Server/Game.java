package Server;

public class Game {
	
	private Player currentPlayer, opponent;
	private Player[] board = new Player[9];
	
	/**
	 * A constructor to build up the Game
	 * @param currentPlayer will assign to null
	 * @param opponent will assign to null
	 */
	public Game(Player currentPlayer, Player opponent) {
		this.currentPlayer = currentPlayer;
		this.opponent = opponent;
	}
	/**
	 * list out all the possible way that can win and 
	 * check out all the chess in the board to see there is a winner of not
	 * @return true if there is any winner
	 */
	public boolean hasWinner() {
		return (board[0] != null && board[0] == board[1] && board[0] == board[2])
	            || (board[3] != null && board[3] == board[4] && board[3] == board[5])
	            || (board[6] != null && board[6] == board[7] && board[6] == board[8])
	            || (board[0] != null && board[0] == board[3] && board[0] == board[6])
	            || (board[1] != null && board[1] == board[4] && board[1] == board[7])
	            || (board[2] != null && board[2] == board[5] && board[2] == board[8])
	            || (board[0] != null && board[0] == board[4] && board[0] == board[8])
	            || (board[2] != null && board[2] == board[4] && board[2] == board[6]
	        );
	}
	/**
	 * this function is followed after the hasWinner function
	 * if the board is filled up with chess and still no winner
	 * @return true
	 */
	public boolean draw() {
		for(int i = 0; i < 9; i++) {
			if(board[i] == null)
				return false;
		}
		return true;
	}
	/**
	 * check up the player can move the chess or not first then return permission to the client
	 * after the move then will turn to next player to move
	 * @param parseInt the location of chess that the player input
	 * @param player identity which player input the chess
	 * @return command to the client
	 */
	public synchronized String move(int parseInt, Player player) {
		// TODO Auto-generated method stub
		int loc = parseInt - 1;
		if (player != currentPlayer) {
			return "Not your turn";
            //throw new IllegalStateException("Not your turn");
        } else if (player.getOpponent() == null) {
        		return "You don't have an opponent yet";
            //throw new IllegalStateException("You don't have an opponent yet");
        } else if (board[loc] != null) {
        	return"Already have chess";
            //throw new IllegalStateException("Cell already occupied");
        }else {
        	board[loc] = currentPlayer;
        	currentPlayer = currentPlayer.getOpponent();
        	return "Move" + Integer.toString(parseInt);
        }
	}
	/**
	 * to return to the player who is his opponent
	 * @return Player
	 */
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	/**
	 * to let the first client assign himself as the player 
	 * @param currentPlayer
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	/**
	 * to let the second client to assign himself as the opponent
	 * @return
	 */
	public Player getOppoenent() {
		return opponent;
	}
	/**
	 * to the first player to know his opponent
	 * @param opponent
	 */
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
}



// This is the model of the system that holds all the data.
// It will make use of Knight class and Board class as part of their data.
public class Model {
	
	private Board[][] board;
	private int counter; // shows the movement the knight has made
	private Knight knight;
	
	public Model() {
		knight = new Knight();
		board = new Board[5][5];
		counter = 0;
	}
	
	// Setting up a 5x5 board of the chess game.
	public void boardSetUp() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = new Board(true);
			}
		}
	}
	
	//Use to keep track of the knight's movement towards victory
	public int getMovement() {
		counter++;
		return counter;
	}
	
	public Knight getKnight() {
		return knight;
	}
	
	public Board[][] getBoard() {
		return board;
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();

	}
}


import java.util.Random;

public class Game {
	//array of squares
	private Square[][] square = new Square[3][3];
	//randomizer for bomb setting
	private Random random;

	public Game() {

		random = new Random();
	}

	public void setUp() {
		//get bomb qoordinates
		int bombPx = random.nextInt(3);
		int bombPy = random.nextInt(3);
		
		// setup array to squares
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				square[i][j] = new Square(false, 1);
			}
		}

		// find and set up bomb square
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				if (i == bombPx && j == bombPy) {
					square[i][j].setBomb();
					setNumbers(i, j);
					break;
				}
			}
		}
		

	}
	
	//find and set sqaures who have 0 as their number
	public void setNumbers(int k, int l) {
		if(k==0){
			for (int j = 0; j < square[2].length; j++) {
				square[2][j].setSur(0);
			}
		}
		else if(k==2) {
			for (int j = 0; j < square[0].length; j++) {
				square[0][j].setSur(0);
			}
		}
		
		if(l==0) {
			for (int j = 0; j < square.length; j++) {
				square[j][2].setSur(0);
			}
		}
		else if(l==2) {
			for (int j = 2; j < square.length; j++) {
				square[j][0].setSur(0);
			}
		}

	}
	
	//get the number of the square with coordinates i and j
	public String getText(int i, int j) {
		return square[i][j].getSurr();
	}

	//check if square at [i][j] is the bomb
	public boolean gameOver(int i, int j) {
		if (square[i][j].isBomb())
			return true;
		else
			return false;
	}

	//start gui
	public static void main(String[] args) {
		Gui newGui = new Gui();

	}

}

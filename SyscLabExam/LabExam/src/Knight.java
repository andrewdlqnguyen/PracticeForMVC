// This Class will hold the behavior of the knight's movement on the board
// Should move in an L shape. 2 space forward 1 space sideways.
public class Knight {

	private int movement1;
	private int movement2;
	
	public Knight() {
		this.movement1 = 1; // The forward movement
		this.movement2 = 2; // the perpendicular movement
	}
	
	public int getFirstMovement() {
		return movement1;
	}
	
	public int getSecondMovement() {
		return movement2;
	}
}

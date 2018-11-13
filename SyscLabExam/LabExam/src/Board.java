
public class Board {

	private boolean validTile;
	
	public Board(boolean validTile) {
		this.validTile = false;
	}
	
	// Check if the tile has been used already
	public boolean getValidTile() {
		return validTile;
	}
	
	// Set tile when the tile is chosen
	public void setValidTile(boolean setValid) {
		this.validTile = setValid;
	}
}

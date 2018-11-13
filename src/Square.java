


public class Square {

	//is bomb boolean and number for adjacent squares
	private boolean isBomb;
	private int surounding;
	
	
	public Square(boolean isBomb, int surrounding) {
		//set bomb square (Not used)
		if(isBomb==true) {
			this.surounding = -1;
			this.isBomb = isBomb;
		}
		
		//set surrounding squares 
		else {
			this.isBomb = false;
			this.surounding=surrounding;
		}
	}
	
	public void setSur(int newThing) {
		this.surounding=newThing;
	}
	
	//set square to have a bomb
	public void setBomb(){
		this.isBomb = true;
		this.surounding=-1;
	}
	
	
	//return if the square has the bumb
	public boolean isBomb() {
		if(isBomb) return true;
		else return false;
	}
	
	//return the number of the square as a string
	public String getSurr() {
		return ""+this.surounding;
	}
	
}

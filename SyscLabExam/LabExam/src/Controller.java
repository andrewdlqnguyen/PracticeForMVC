import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

// This is the controller of the system and deals with all the action listeners
public class Controller implements ActionListener {
	private View view;
	private Model model;
	private int moves;
	
	public Controller() {
		view = new View();
		model = new Model();
		view.addActionListenerController(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.getNewGame()) {
			model.boardSetUp();
			//Game starts and the board is active
			for (int i = 0; i < view.getSquares().length; i++) {
				for (int j = 0; j < view.getSquares().length; j++) {
					view.getSquares()[i][j].setEnabled(true);
					view.getSquares()[i][j].setText("");
				}
			}
			moves = 0;
		}
		
		// When the tiles are pressed
		for (int i = 0; i < view.getSquares().length; i++) {
			for (int j = 0; j < view.getSquares().length; j++) {
				if (e.getSource() == view.getSquares()[i][j]) {
					view.getSquares()[i][j].setEnabled(false);
					view.getSquares()[i][j].setText(String.valueOf(model.getMovement()));
					
					try {
						for (int m = 0; m < view.getSquares().length; m++) {
							for (int n = 0; n < view.getSquares().length; n++) {
								view.getSquares()[m][n].setEnabled(false);
							}
						}
						
						// Attempt for Knight algorithm but not working ):
						// Should be in model to deal with the data checking.
						switch (1) {
						case 1:
							if (view.getSquares()[i + model.getKnight().getFirstMovement()][j + model.getKnight().getSecondMovement()] != null) {
								view.getSquares()[i + model.getKnight().getFirstMovement()][j + model.getKnight().getSecondMovement()].setEnabled(true);
							}
						case 2:	
							if (view.getSquares()[i + model.getKnight().getFirstMovement()][j - model.getKnight().getSecondMovement()] != null) {
								view.getSquares()[i + model.getKnight().getFirstMovement()][j - model.getKnight().getSecondMovement()].setEnabled(true);
							}
						case 3:
							if (view.getSquares()[i - model.getKnight().getFirstMovement()][j + model.getKnight().getSecondMovement()] != null) {
								view.getSquares()[i - model.getKnight().getFirstMovement()][j + model.getKnight().getSecondMovement()].setEnabled(true);
							}
						case 4:
							if (view.getSquares()[i - model.getKnight().getFirstMovement()][j - model.getKnight().getSecondMovement()] != null) {
								view.getSquares()[i - model.getKnight().getFirstMovement()][j - model.getKnight().getSecondMovement()].setEnabled(true);
							}
						case 5:
							if (view.getSquares()[i + model.getKnight().getSecondMovement()][j + model.getKnight().getFirstMovement()] != null) {
								view.getSquares()[i + model.getKnight().getSecondMovement()][j + model.getKnight().getFirstMovement()].setEnabled(true);
							} 
						case 6:	
							if (view.getSquares()[i + model.getKnight().getSecondMovement()][j - model.getKnight().getFirstMovement()] != null) {
								view.getSquares()[i + model.getKnight().getSecondMovement()][j - model.getKnight().getFirstMovement()].setEnabled(true);
							}
						case 7:
							if (view.getSquares()[i - model.getKnight().getSecondMovement()][j + model.getKnight().getFirstMovement()] != null) {
								view.getSquares()[i - model.getKnight().getSecondMovement()][j + model.getKnight().getFirstMovement()].setEnabled(true);
							}
						case 8:
							if (view.getSquares()[i - model.getKnight().getSecondMovement()][j - model.getKnight().getFirstMovement()] != null) {
								view.getSquares()[i - model.getKnight().getSecondMovement()][j - model.getKnight().getFirstMovement()].setEnabled(true);
							}
						
						}
						
//						for (int k = 0; k < view.getSquares()[i].length; k++) {
//							for (int l = 0; l < view.getSquares()[j].length; l++) {
//								
//							}
//						}
					} catch (IllegalArgumentException e1) {
						
					} catch(ArrayIndexOutOfBoundsException e2) {
						
					}
					
					moves++;
					// If moves are reached to 25, you win the game
					if(moves==25) {
						JOptionPane.showMessageDialog(view.getContentPane(), "You Win! \nThanks for Playing!");
						System.exit(0);
					}
				}
			}
		}
	}

}

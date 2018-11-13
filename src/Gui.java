import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//viewer class
public class Gui extends JFrame {
	
	JMenu menu1;
	JMenuBar menuBar;
	JMenuItem StartGame;
	JOptionPane optionPane;
	Container contentPane;
	GridLayout layout;
	JButton[][] squares = new JButton[3][3];
	Game game;
	int moves = 0;

	public Gui() {
		super("Mine Sweeper");
		game = new Game();

		//set up frame
		setLocationRelativeTo(null);
		setSize(400, 300);
		layout = new GridLayout(3, 3);

		//set up content pane
		contentPane = getContentPane();
		contentPane.setLayout(layout);

		// Creating Menu Bar
		menuBar = new JMenuBar();

		menu1 = new JMenu("Options");
		menuBar.add(menu1);

		// add start game to options
		StartGame = new JMenuItem("New Game");
		menu1.add(StartGame);

		//create the handler and add hanlder to start game option
		theHandler handler = new theHandler();

		StartGame.addActionListener(handler);
		StartGame.setEnabled(true);
		
		//set up buttons
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				squares[i][j] = new JButton();
				squares[i][j].addActionListener(handler);
				contentPane.add(squares[i][j]);
				squares[i][j].setEnabled(false);
			}
		}
		
		setJMenuBar(menuBar);

		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	
	//Controller Class
	private class theHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			//start game option
			if (e.getSource() == StartGame) {
				game.setUp();
				for (int i = 0; i < squares.length; i++) {
					for (int j = 0; j < squares[i].length; j++) {
						squares[i][j].setEnabled(true);//set all squares enabled to be clikced
						squares[i][j].setText("");//clear all text from squares
					}
				}
				moves=0;//re set number of moves
			}

			for (int i = 0; i < squares.length; i++) {
				for (int j = 0; j < squares[i].length; j++) {
					
					if (e.getSource() == squares[i][j]) {
						squares[i][j].setEnabled(false);//set clikced square disabled
						squares[i][j].setText(game.getText(i, j));// show number
						if (game.gameOver(i, j)) {
							JOptionPane.showMessageDialog(null, "Game Over");//game over pop up
						
							for (int k = 0; k < squares.length; k++) {
								for (int l = 0; l < squares[k].length; l++) {
									squares[k][l].setEnabled(false);//game over disable all squares
								}
							}
						}//gameOver
						moves++;
						if(moves==8) {
							JOptionPane.showMessageDialog(null, "You Win");//winner pop up
							for (int k = 0; k < squares.length; k++) {
								for (int l = 0; l < squares[k].length; l++) {
									squares[k][l].setEnabled(false);//disable remaining squares
								}
							}
						}
						

					}//getsource if
				}
			} // end of for loops
			
			
			
		}
	}
}

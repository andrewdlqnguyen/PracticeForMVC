import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

// This is the view class of the system.
public class View extends JFrame{
	
	JMenu menu1;
	JMenuBar menuBar;
	JMenuItem newGame;
	JOptionPane optionPane;
	Container contentPane;
	GridLayout layout;
	JButton[][] squares;


	public View() {
		super("Knight's Tour");
		
		squares = new JButton[5][5];
		
		//Setting up the frame and game board
		setLocationRelativeTo(null);
		setSize(500,500);
		layout = new GridLayout(5,5);
		
		//Setting up content pane
		contentPane = getContentPane();
		contentPane.setLayout(layout);
		
		// Creating Menu Bar
		menuBar = new JMenuBar();

		menu1 = new JMenu("Game Options");
		menuBar.add(menu1);

		// New Game to Start the Game
		newGame = new JMenuItem("New Game");
		menu1.add(newGame);
		
		//Set up Board
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				squares[i][j] = new JButton();
				contentPane.add(squares[i][j]);
				squares[i][j].setEnabled(false);
			}
		}
				
		// Display the interface
		setJMenuBar(menuBar);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	// Create action handler for each sub menu option
	public void addActionListenerController(Controller handler) {
		newGame.addActionListener(handler);
		
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {		
				squares[i][j].addActionListener(handler);	
			}
		}
		
	}
	
	public JMenuItem getNewGame() {
		return newGame;
	}
	
	public JButton[][] getSquares() {
		return squares;
	}
}

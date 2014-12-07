package ia54.project.taquin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Puzzle extends JFrame {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private static int SIZE = SharedValues.getSize();; // Number of tiles per side
	private static int CELL_SIZE = 480 / SIZE; // Cell width/height
	private static int CANVAS_SIZE = CELL_SIZE * SIZE;
	private static int FONT_SIZE = 160 / SIZE;
 
	// Game board
	private int[][] cells;
	private JTextField[][] tfCells;

 
	/** Constructor to setup the game and the GUI */
	public Puzzle() {
		Container cp = getContentPane();
//		cp.setLayout(new GridLayout(SIZE, SIZE));
		
//      SIZE = SharedValues.getSize();
//      CELL_SIZE = 240 / SIZE; // Cell width/height
//      CANVAS_SIZE = CELL_SIZE * SIZE;
//      FONT_SIZE = 80 / SIZE;
		
		// New JPanel for the actual puzzle
		JPanel puzzlePanel = new JPanel(new GridLayout(SIZE, SIZE));
		
		cells = new int[SIZE][SIZE];
		tfCells = new JTextField[SIZE][SIZE]; // allocate JTextField array
 
		// Create 9x9 JTextFields and place on the GridLayout
		for (int col = 0; col < SIZE; ++col) {
			for (int row = 0; row < SIZE; ++row) {  
				tfCells[row][col] = new JTextField(); // allocate element of array
				puzzlePanel.add(tfCells[row][col]);  // ContentPane adds JTextField
//				cp.add(tfCells[row][col]);  // ContentPane adds JTextField
				// In the agent part of the project the tile values are stored from 0 to 14,
				// here we want from 1 to 15
				int number = SharedValues.getMatrix(row, col) + 1;
				drawTile(number, row, col);
			}
		}
		
		
		
		// New JPanel for the buttons
		JPanel buttonPanel = new JPanel(new GridLayout(3,3));
		
		// Create JButton for "New Game"
		JButton btnNewGame = new JButton("New Game");
		buttonPanel.add(btnNewGame);
		btnNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Link to the new game event
				// Get the value in txtFldSize, set SharedValues.size and launch a new game
				System.out.println("You have clicked on 'New Game'");
			}
		});
		
		// Create JTextField for "Puzzle Size"
		JLabel lblSize = new JLabel(" Size: ");
		buttonPanel.add(lblSize);
		JTextField txtFldSize = new JTextField(Integer.toString(SharedValues.getSize()));
		buttonPanel.add(txtFldSize);
//		btnStop.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Link to the start event
//				System.out.println("You have clicked on 'Stop'");
//			}
//		});
		
		// Create JButton for "Start"
		JButton btnStart = new JButton("Start");
		buttonPanel.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Link to the start event
				System.out.println("You have clicked on 'Start'");
			}
		});
		
		// Create JTextField for "Number of moves"
		// TODO Add something to update this field
		JLabel lblMoves = new JLabel(" Number of moves: ");
		buttonPanel.add(lblMoves);
		JTextField txtFldMoves = new JTextField("0");
		txtFldMoves.setEditable(false);
		buttonPanel.add(txtFldMoves);
		
		// Create JButton for "Stop"
		JButton btnStop = new JButton("Stop");
		buttonPanel.add(btnStop);
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Link to the stop event
				System.out.println("You have clicked on 'Stop'");
			}
		});
		
		// Add both JPanels to the Content Pane
		cp.add(puzzlePanel, BorderLayout.CENTER);
		cp.add(buttonPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setTitle("Taquin");
		setVisible(true);
	}

   
	
	public void refresh(){
		for (int row = 0; row < SIZE; ++row) {
			for (int col = 0; col < SIZE; ++col) {
				// In the agent part of the project the tile values are stored from 0 to 14,
				// here we want from 1 to 15
				int number = SharedValues.getMatrix(row, col) + 1;
				drawTile(number, row, col);
			}
		}
	}

   
	
	private void drawTile(int number, int row, int col){
		// Try if blank tile
		if ( number == 0 ){		// The blank tile number in the SharedValues Matrix is -1 but since we previously added 1 it is now 0
			tfCells[row][col].setText("");  // empty
			tfCells[row][col].setBackground(Color.WHITE);
			tfCells[row][col].setFocusable(false);
		}
		else {
			// Try if tiles is in correct place		
			if( SharedValues.getMatrix(row, col) == (row + SIZE*col)){
				tfCells[row][col].setBackground(Color.BLUE);
			}
			else{
				tfCells[row][col].setBackground(Color.CYAN);
			}
			cells[row][col] = number;
			tfCells[row][col].setText(number + "");
			tfCells[row][col].setFocusable(false);
			tfCells[row][col].setHorizontalAlignment(JTextField.CENTER);
			tfCells[row][col].setFont(new Font("Monospaced", Font.BOLD, FONT_SIZE));
		}
	}
   
   
	public static int getSIZE() {
	   return SIZE;
	}
	
	
	public static void setSIZE(int size) {
		SIZE = size;
	}
	
	
	public static int getCELL_SIZE() {
		return CELL_SIZE;
	}
	
	
	public static void setCELL_SIZE(int cELL_SIZE) {
		CELL_SIZE = cELL_SIZE;
	}
	
	
	
	public static int getCANVAS_SIZE() {
		return CANVAS_SIZE;
	}


	public static void setCANVAS_SIZE(int cANVAS_SIZE) {
		CANVAS_SIZE = cANVAS_SIZE;
	}


	public static int getFONT_SIZE() {
		return FONT_SIZE;
	}


	public static void setFONT_SIZE(int fONT_SIZE) {
		FONT_SIZE = fONT_SIZE;
	}


	public int[][] getCells() {
		return cells;
	}
	
	
	public void setCells(int[][] cells) {
		this.cells = cells;
	}
	
	
	public JTextField[][] getTfCells() {
		return tfCells;
	}
	
	
	public void setTfCells(JTextField[][] tfCells) {
		this.tfCells = tfCells;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
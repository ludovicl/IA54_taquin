package ia54.project.taquin;

import java.awt.*;
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
		cp.setLayout(new GridLayout(SIZE, SIZE));
 
//      SIZE = SharedValues.getSize();
//      CELL_SIZE = 240 / SIZE; // Cell width/height
//      CANVAS_SIZE = CELL_SIZE * SIZE;
//      FONT_SIZE = 80 / SIZE;
      
		cells = new int[SIZE][SIZE];
		tfCells = new JTextField[SIZE][SIZE]; // allocate JTextField array
 
		// Create 9x9 JTextFields and place on the GridLayout
		for (int col = 0; col < SIZE; ++col) {
			for (int row = 0; row < SIZE; ++row) {  
				tfCells[row][col] = new JTextField(); // allocate element of array
				cp.add(tfCells[row][col]);  // ContentPane adds JTextField
				// In the agent part of the project the tile values are stored from 0 to 14,
				// here we want from 1 to 15
				int number = SharedValues.getMatrix(row, col) + 1;
				drawTile(number, row, col);
			}
		}
		cp.setPreferredSize(new Dimension(CANVAS_SIZE, CANVAS_SIZE));
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
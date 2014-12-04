package ia54.project.taquin;

import java.awt.*;
import javax.swing.*;
 
public class Puzzle extends JFrame {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// Name-constants for the various dimensions
   private static int ROWS = 4; // ROWS by COLS cells, default value
   private static int COLS = 4;
   // TODO Scale the cell size to the number of tiles
   private static int CELL_SIZE = 60; // Cell width/height
   private static int CANVAS_WIDTH = CELL_SIZE * COLS;
   private static int CANVAS_HEIGHT = CELL_SIZE * ROWS;
 
   // Game board
   private int[][] cells;
   private JTextField[][] tfCells;

 
   /** Constructor to setup the game and the GUI */
   public Puzzle() {
      Container cp = getContentPane();
      cp.setLayout(new GridLayout(ROWS, COLS));
 
      ROWS = COLS = SharedValues.getSize();
      
      cells = new int[ROWS][COLS];
      tfCells = new JTextField[ROWS][COLS]; // allocate JTextField array
 
      // Create 9x9 JTextFields and place on the GridLayout
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            tfCells[row][col] = new JTextField(); // allocate element of array
            cp.add(tfCells[row][col]);  // ContentPane adds JTextField
            
            int number = SharedValues.getMatrix(row, col);
            drawTile(number, row, col);
         }
      }
      
      cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setTitle("Taquin");
      setVisible(true);
   }

   
   public void refresh(){
      for (int row = 0; row < ROWS; ++row) {
          for (int col = 0; col < COLS; ++col) {
              int number = SharedValues.getMatrix(row, col);
              drawTile(number, row, col);
          }
      }
   }

   
   private void drawTile(int number, int row, int col){
       // Try if blank tile
       if ( number == -1 ){
           tfCells[row][col].setText("");  // empty
           tfCells[row][col].setBackground(Color.WHITE);
           tfCells[row][col].setFocusable(false);
       }
       else {
       	// Try if tiles is in correct place		
			if( SharedValues.getMatrix(row, col) == (row + 4*col)){
				tfCells[row][col].setBackground(Color.DARK_GRAY);
			}
			else{
				tfCells[row][col].setBackground(Color.GRAY);
			}
           cells[row][col] = number;
           tfCells[row][col].setText(number + "");
           tfCells[row][col].setFocusable(false);
           tfCells[row][col].setHorizontalAlignment(JTextField.CENTER);
           // TODO Scale the font size to the number of tiles
           tfCells[row][col].setFont(new Font("Monospaced", Font.BOLD, 20));
       }
   }
   
   
   public static int getROWS() {
		return ROWS;
   }
	
	
	public static void setROWS(int rOWS) {
		ROWS = rOWS;
	}
	
	
	public static int getCOLS() {
		return COLS;
	}
	
	
	public static void setCOLS(int cOLS) {
		COLS = cOLS;
	}
	
	
	public static int getCELL_SIZE() {
		return CELL_SIZE;
	}
	
	
	public static void setCELL_SIZE(int cELL_SIZE) {
		CELL_SIZE = cELL_SIZE;
	}
	
	
	public static int getCANVAS_WIDTH() {
		return CANVAS_WIDTH;
	}
	
	
	public static void setCANVAS_WIDTH(int cANVAS_WIDTH) {
		CANVAS_WIDTH = cANVAS_WIDTH;
	}
	
	
	public static int getCANVAS_HEIGHT() {
		return CANVAS_HEIGHT;
	}
	
	
	public static void setCANVAS_HEIGHT(int cANVAS_HEIGHT) {
		CANVAS_HEIGHT = cANVAS_HEIGHT;
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
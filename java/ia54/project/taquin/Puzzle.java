package ia54.project.taquin;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Puzzle {

	private PuzzleFrame puzzleFrame;
	private int size;
	
	
	
	public Puzzle(PuzzleFrame puzzleFrame, int puzzleSize, int puzzleWidth, int puzzleHeight) {
		super();
		this.puzzleFrame = puzzleFrame;
		this.size = puzzleSize;
		
		int tileWidth = puzzleWidth / size;
		int tileHeight = puzzleHeight / size;
		
		PuzzleSupport puzzleSupport = new PuzzleSupport(this);
		Graphics graphics = puzzleSupport.getGraphics();
		
		// Draw initial puzzle
		for (int y = 0 ; y < size ; y++){ 
			for (int x = 0 ; x < size ; x++){
				// Try is blank tile
				if ( SharedValues.getMatrix(x, y) == 0 ){
					graphics.setColor(Color.white);
					graphics.fillRect( x*tileWidth, y*tileHeight, x + tileWidth, y + tileHeight );
				}
				else{
					graphics.setColor(Color.gray);
					graphics.fill3DRect( x, y, size, size, true); // Graphical representation of a tile
					graphics.setColor( Color.white);
					graphics.setFont( new Font( "Arial", Font.BOLD, size / 2));
		            FontMetrics fm = graphics.getFontMetrics();
		            String st = ( new Integer( SharedValues.getMatrix(x, y) )).toString();
		            graphics.drawString( st, x*tileWidth + ( size - fm.stringWidth(st)) / 2, y*tileHeight + ( size + fm.getAscent()) /2 - 4  );
				}
			}
			
		}
		
	}
	
	
	public PuzzleFrame getPuzzleFrame() {
		return puzzleFrame;
	}
	public void setPuzzleFrame(PuzzleFrame puzzleFrame) {
		this.puzzleFrame = puzzleFrame;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}

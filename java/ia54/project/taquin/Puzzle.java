package ia54.project.taquin;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Puzzle {

	private PuzzleFrame puzzleFrame;
	private int size;
	private PuzzleSupport puzzleSupport;
	private int tileWidth;
	private int tileHeight;	
	
	
	public Puzzle(PuzzleFrame puzzleFrame, int puzzleSize, int puzzleWidth, int puzzleHeight) {
		super();
		this.puzzleFrame = puzzleFrame;
		this.size = puzzleSize;
		
		this.tileWidth = puzzleWidth / size;
		this.tileHeight = puzzleHeight / size;
		
		puzzleSupport = new PuzzleSupport(this);
		Graphics graphics = puzzleSupport.getGraphics();
		
		// Draw initial puzzle
		for (int y = 0 ; y < size ; y++){ 
			for (int x = 0 ; x < size ; x++){
				// Try is blank tile
				if ( SharedValues.getMatrix(x, y) == -1 ){
					graphics.setColor(Color.WHITE);
					graphics.fillRect( x*tileWidth, y*tileHeight, x + tileWidth, y + tileHeight );
				}
				else{
					graphics.setColor(Color.GRAY);
					graphics.fill3DRect( x, y, size, size, true); // Graphical representation of a tile
					graphics.setColor( Color.WHITE);
					graphics.setFont( new Font( "Arial", Font.BOLD, size / 2));
		            FontMetrics fm = graphics.getFontMetrics();
		            String st = ( new Integer( SharedValues.getMatrix(x, y) )).toString();
		            graphics.drawString( st, x*tileWidth + ( size - fm.stringWidth(st)) / 2, y*tileHeight + ( size + fm.getAscent()) /2 - 4  );
				}
			}
			
		}		
	}
	
	public void refresh( Graphics graphics){
		for (int y = 0 ; y < size ; y++){ 
			for (int x = 0 ; x < size ; x++){
				// Try is blank tile
				if ( SharedValues.getMatrix(x, y) == -1 ){
					graphics.setColor(Color.WHITE);
					graphics.fillRect( x*tileWidth, y*tileHeight, x + tileWidth, y + tileHeight );
				}
				else{
					// Try if tiles is in correct place		
					if( SharedValues.getMatrix(x, y) == (x + 4*y)){
						graphics.setColor(Color.DARK_GRAY);
					}
					else{
						graphics.setColor(Color.GRAY);
					}
					graphics.fill3DRect( x, y, size, size, true); // Graphical representation of a tile
					graphics.setColor( Color.WHITE);
					graphics.setFont( new Font( "Arial", Font.BOLD, size / 2));
		            FontMetrics fm = graphics.getFontMetrics();
		            // In the SharedValues matrix, the values are 0 to 14 and we want to show 1 to 15, thus the +1
		            String st = ( new Integer( SharedValues.getMatrix(x, y) + 1)).toString();
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
	public PuzzleSupport getPuzzleSupport() {
		return puzzleSupport;
	}
	public void setPuzzleSupport(PuzzleSupport puzzleSupport) {
		this.puzzleSupport = puzzleSupport;
	}
	
	
	
}

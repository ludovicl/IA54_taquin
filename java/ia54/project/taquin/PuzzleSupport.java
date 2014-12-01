package ia54.project.taquin;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;


public class PuzzleSupport extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	private Puzzle parentPuzzle;
	private int size;
	private int cote;
	
	public PuzzleSupport(Puzzle puzzle){
		super();
		parentPuzzle=puzzle;
		size=puzzle.getSize();
		
        this.setBackground( Color.darkGray);
//        int hMax = Toolkit.getDefaultToolkit().getScreenSize().height;
//        int insets = parent.pzFrame.getInsets().top + parent.pzFrame.getInsets().bottom + 66;
//        cote = parent.getSize();
//        int T = EcoNPuzzle.tile_size;
//        int aux = hMax  - insets;
//        size = ( cote * T + insets <= hMax) ? cote * T : ( aux - ( aux % cote));
        this.setSize(size, size);
	}
	
	@Override
	public void paint(Graphics graphics){
		parentPuzzle.refresh(graphics);
	}
	
}

package ia54.project.taquin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PuzzleFrame extends Frame {

	private static final long serialVersionUID = 4795963828492414386L;
	private int DEFAULT_SIZE;
	Panel centralPanel;
	
	private int PUZZLE_WIDTH = 600;
	private int PUZZLE_HEIGHT = 500;
	
	
   public PuzzleFrame(String title, int tileNumber) {
	   super(title);
	   DEFAULT_SIZE = tileNumber;
	   
    		//{{INIT_CONTROLS
		setLayout(new BorderLayout(1,2));
		setVisible(false);
		setSize(609,576);
		
		Panel puzzlePanel = new Panel();
		puzzlePanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		puzzlePanel.setBounds(0,0,PUZZLE_WIDTH,PUZZLE_HEIGHT);
		puzzlePanel.setBackground(new Color(16777215));
		add("Center", puzzlePanel);
		
		setTitle(title);
		setResizable(false);
		
		// TODO Create the actual puzzle
		Puzzle puzzle = new Puzzle(this, DEFAULT_SIZE, PUZZLE_WIDTH, PUZZLE_HEIGHT);
	    puzzlePanel.add( puzzle.getPuzzleSupport() );
        
		pack(); //donne a la fenetre une taille adaptee aux composants qui s'y trouvent
        setVisible(true);
        toFront();
        
        //Listeners
        SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
   }
   
	class SymWindow extends WindowAdapter
	{
		public void windowClosing(WindowEvent event)
		{
			Object object = event.getSource();
			if (object == PuzzleFrame.this)
				PuzzleFrame_WindowClosing(event);
		}
	}
	
	void PuzzleFrame_WindowClosing(java.awt.event.WindowEvent event)
	{
            dispose();
            System.exit(0);
	}
}

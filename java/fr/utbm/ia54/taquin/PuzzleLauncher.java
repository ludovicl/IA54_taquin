package fr.utbm.ia54.taquin;

public class PuzzleLauncher {

    // This static method is called by the PuzzleCreator agent to create the GUI
	public static void launchInterface(){
		
      // Run the GUI construction on the event-dispatching thread for thread safety
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Puzzle(); // Let the constructor do the job
         }
      });
		
	}
}

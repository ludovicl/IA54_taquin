package ia54.project.taquin;

public class PuzzleLauncher {

	public static void launchInterface(String title, int tileNumber){
//		new PuzzleFrame(title, tileNumber);
		
		
      // Run the GUI construction on the event-dispatching thread for thread safety
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Puzzle(); // Let the constructor do the job
         }
      });
		
	}
}

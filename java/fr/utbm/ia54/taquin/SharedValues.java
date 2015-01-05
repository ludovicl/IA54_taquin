package fr.utbm.ia54.taquin;

// This class is used for communicating between the GUI and the SARL code
// In here is stored the state of the puzzle
public class SharedValues {


	// Number of tiles a side of the puzzle will have, default 4 
	// This is the main variable with which all other size variables are defined
	private static int size = 4;
	private static int[][] puzzleMatrix = new int[size][size];  // In this matrix is stored the state of the puzzle
	private static boolean newGame = false; // This boolean creates a new puzzle, it is modified by a JButton on the GUI and is monitored by an event of the SARL code
	private static boolean start = false;// This boolean starts the resolution of the puzzle, it works just like newGame
    private static boolean stop = false;// This boolean stops the resolution of the puzzle, it works just like newGame
    
	public static int getSize()
	{
		return size;
	}

	public static void setSize(int size)
	{
		SharedValues.size = size;
	}

	public static void setMatrix(int x, int y, int v)
	{
		puzzleMatrix[x][y] = v;
	} 	
	
	public static int getMatrix(int x, int y)
	{
		return puzzleMatrix[x][y];
	}

	public static boolean isNewGame() {
		return newGame;
	}

	public static void setNewGame(boolean newGame) {
		SharedValues.newGame = newGame;
	}

	public static boolean isStart() {
		return start;
	}

	public static void setStart(boolean start) {
		SharedValues.start = start;
	}

	public static boolean isStop() {
		return stop;
	}

	public static void setStop(boolean stop) {
		SharedValues.stop = stop;
	}

	public static int[][] getPuzzleMatrix() {
		return puzzleMatrix;
	}

	public static void setPuzzleMatrix(int[][] puzzleMatrix) {
		SharedValues.puzzleMatrix = puzzleMatrix;
	}
	
	
	
}
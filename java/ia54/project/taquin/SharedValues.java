package ia54.project.taquin;

public class SharedValues {


	// Number of tiles a side of the puzzle will have, default 4 
	// This is the supreme variable with which all other size variables are defined
	private static int size = 4;		
	private static int[][] puzzleMatrix = new int[size][size];
	private static boolean newGame = false;
	private static boolean start = false;
	private static boolean stop = false;
	
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
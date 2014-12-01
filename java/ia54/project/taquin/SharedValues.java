package ia54.project.taquin;

public class SharedValues {

	 //TODO Should later be int[size][size]

	private static int size = 4;
	private static int[][] puzzleMatrix = new int[4][4];
	
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
}
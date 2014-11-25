package ia54.project.taquin;

public class SharedValues {

	public static int[][] puzzleMatrix = new int[4][4]; 

	public static void setMatrix(int x, int y, int v)
	{
		puzzleMatrix[x][y] = v;
	} 	
	
	public static int getMatrix(int x, int y)
	{
		return puzzleMatrix[x][y];
	}
	   
}
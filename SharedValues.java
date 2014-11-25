package ia54.project.taquin;

public class SharedValues {

	public int[][] puzzleMatrix = new int[4][4]; //$NON-NLS-1$
	public int toto =2; //$NON-NLS-1$

	public void setMatrix(int x, int y, int v)//$NON-NLS-1$
	{
		puzzleMatrix[x][y] = v;
	} 	
	  
}
package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazePrintWSolving {

	private static final int TRIED = 2;
	private static final int PATH = 3;
	private int numberRows, numberColumns;
	private int[][] grid;
	
	public MazePrintWSolving(String filename) throws FileNotFoundException{
		
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		numberRows = scan.nextInt();
		numberColumns = scan.nextInt();
		
		grid = new int[numberRows][numberColumns];
		for(int i = 0; i < numberRows; i++)
			for(int j = 0; j < numberColumns; j++)
				grid[i][j] = scan.nextInt();
		
	}
	
	public void tryPosition(int row, int col) {
		grid[row][col] = TRIED;
	}
	
	public int getRows() {
		return grid.length;
	}
	
	public int getColumns() {
		return grid[0].length;
	}
	
	public void markPath(int row, int col) {
		grid[row][col] = PATH;		
	}
	
	public boolean validPosition(int row, int col) {
		
		boolean result = false;
		
		if(row >= 0 && row < grid.length && col >= 0 && col < grid[row].length)
			if(grid[row][col] == 1) {
				result = true;
			}
		
		return result;
		
	}
	
	public String toString() {
		
		String result = "\n";
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++)
				result += grid[row][col] + "";
			result += "\n";
		}
		
		return result;
		
	}
	
}

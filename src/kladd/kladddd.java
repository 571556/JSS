package kladd;

public class kladddd {

	public static void main(String[] args) {
		
		int[] s = new int[5];
		System.out.println(s.length);
		for(int i = 0; i < s.length; i++) {
			s[i] = i;
			System.out.println(s[i]);
		}
			
	}
	
	if ((row < 0 || row >= grid.length - 1) && (column < 0 || column >= grid[row].length)) {
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				grid[i][j] = openPosition;
		
		placedQueens = 0;
		
		if((startRow >= 0 && startRow < grid.length) && (startColumn >= 0 && startColumn < grid[startRow].length)) {
			startColumn++;
		}
		else if((startRow >= 0 && startRow < grid.length - 1) && (startColumn < 0 || startColumn >= grid[startRow].length - 1)) {
			startRow++;
			startColumn = 0;
		}
		
		solveProblem(startRow,startColumn);
			
	}
		

}

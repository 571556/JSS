package ch8;

public class QueensV2 {
	private final static int openPosition = 0;
	private final static int invalidPosition = 1;
	private final static int placedQueen = 2;
	private final static int Queens = 8;
	private int startRow;
	private int startColumn;
	private int placedQueens;
	private int testedPositions;
	private int[][] grid;

	public QueensV2() {
		placedQueens = 0;
		startRow = 0;
		startColumn = 0;
		grid = new int[8][8];
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				grid[i][j] = openPosition;
	}

	public boolean solveProblem(int row, int column) {
		boolean result = false;
		
		if (placedQueens == Queens) {
			result = true;
			return result;
		}
		
		if ((startRow < 0 || startRow >= grid.length - 1) && (startColumn < 0 || startColumn >= grid[startRow].length - 1))
			return result;
		
		if(((row < 0 || row >= grid.length - 1) && (column < 0 || column >= grid[row].length - 1)) && testedPositions < (grid.length * grid[startRow].length)) {
			solveProblem(0,0);
		}else if(((row < 0 || row >= grid.length - 1) && (column < 0 || column >= grid[row].length - 1)) && testedPositions >= (grid.length * grid[startRow].length)) {
			tryNextInitialValue();
			solveProblem(startRow,startColumn);
		}
		

		if (testValidPosition(row, column)) {
			placeQueen(row, column);
			placedQueens++;
		}
	
		if((row >= 0 && row < grid.length - 1) && (column < 0 || column >= grid[row].length - 1)) {
			result = solveProblem(row + 1,0);
		}else
			result = solveProblem(row, column + 1);		
		
		return result;
		
		

	}
	
	private void tryNextInitialValue() {
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				grid[i][j] = openPosition;
		
		placedQueens = 0;
		testedPositions = 0;
		
		if((startRow >= 0 && startRow < grid.length - 1) && (startColumn < 0 || startColumn >= grid[startRow].length - 1)) {
			startRow++;
			startColumn = 0;
		}else
			startColumn++;
			
		
	}

	public void placeQueen(int row, int column) {
		grid[row][column] = placedQueen;
		markInvalidRow(row, column);
		markInvalidColumn(row, column);
		markInvalidDiagonals(row, column);
	}

	private void markInvalid(int row, int column) {
		grid[row][column] = invalidPosition;
	}

	private void markInvalidRow(int row, int column) {
		for (int i = 0; i < grid[row].length; i++) {
			if (i == column)
				i++;

			if (!(i >= grid[row].length))
				markInvalid(row, i);
		}
	}

	private void markInvalidColumn(int row, int column) {
		for (int i = 0; i < grid.length; i++) {
			if (i == row)
				i++;

			if (!(i >= grid.length))
				markInvalid(i, column);
		}
	}

	private void markInvalidDiagonals(int row, int column) {
		northEast(row - 1, column + 1);
		northWest(row - 1, column - 1);
		southEast(row + 1, column + 1);
		southWest(row + 1, column - 1);
	}

	private void northEast(int row, int column) {
		if ((row >= 0 && row < grid.length) && (column >= 0 && column < grid[row].length)) {
			markInvalid(row, column);
			northEast(row - 1, column + 1);
		}
	}

	private void southEast(int row, int column) {
		if ((row >= 0 && row < grid.length) && (column >= 0 && column < grid[row].length)) {
			markInvalid(row, column);
			southEast(row + 1, column + 1);
		}
	}

	private void northWest(int row, int column) {

		if ((row >= 0 && row < grid.length) && (column >= 0 && column < grid[row].length)) {
			markInvalid(row, column);
			northWest(row - 1, column - 1);
		}
	}

	private void southWest(int row, int column) {
		if ((row >= 0 && row < grid.length) && (column >= 0 && column < grid[row].length)) {
			markInvalid(row, column);
			southWest(row + 1, column - 1);
		}
	}

	public boolean testValidPosition(int row, int column) {
		boolean result = false;
		testedPositions++;
		if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length)
			if (grid[row][column] == openPosition)
				result = true;

		return result;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < grid.length; i++) {
			s += "\n";
			for (int j = 0; j < grid[i].length; j++)
				s += grid[i][j] + " ";
		}
		return s;
	}
}

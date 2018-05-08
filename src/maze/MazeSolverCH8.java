package maze;

public class MazeSolverCH8 {

	private Maze maze;
	
	public MazeSolverCH8(Maze maze) {
		this.maze = maze;
	}
	
	/*
	 * Attempts to recursively traverse the maze. Inserts special characters
	 * indicating locations that have been TRIED and that eventually become 
	 * part of the solution PATH.
	 * 
	 * @param row row index of current location
	 * @param column column index of current location
	 * @return true if the maze has been solved
	 */
	
	public boolean traverse(int row, int column) {
		
		boolean done = false;
		
		if(maze.validPosition(row, column)) {
			maze.tryPosition(row, column); //mark this cell as tried
			if(row == maze.getRows() - 1 && column == maze.getColumns() - 1)
				done = true;
			else {
				done = traverse(row + 1, column); //down
				if(!done)
					done = traverse(row,column + 1); //right
				if(!done)
					done = traverse(row - 1, column); //up
				if(!done) 
					done = traverse(row,column - 1); //left
			}
			if(done) //this location is part of the final path
				maze.markPath(row, column);
		}
		
		return done;
		
	}
	
}

package maze;

import java.util.*;
import java.io.*;

public class MazeTesterCH8 {

	public static void main(String[] args) throws FileNotFoundException{
		
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the file containing the maze: ");
		String filename = scan.nextLine();
		
		Maze labyrinth = new Maze(filename);
		
		System.out.println(labyrinth.toString());
		
		MazeSolverCH8 solver = new MazeSolverCH8(labyrinth);
		if(solver.traverse(0, 0))
			System.out.println("The maze was successfully traversed!");
		else
			System.out.println("There is no possible path.");
		System.out.println(labyrinth.toString());
	
		}
	
}

package ch8;

public class NonAttackingQueens {

	public static void main(String[] args) {
		
		QueensV2 q = new QueensV2();
		boolean problem = q.solveProblem(0,0);
		System.out.println(problem + "\n" + q.toString());

	}
	

}

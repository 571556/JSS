package jsjf;
import jsjf.exception.*;

public class AdderStack {

	private ArrayStack[] adder;
	private static final int OPERAND_1 = 0;
	private static final int OPERAND_2 = 1;
	private static final int RESULT = 2;
	
	public AdderStack(){
		
		adder = new ArrayStack[3];
		adder[OPERAND_1] = new ArrayStack<Integer>();
		adder[OPERAND_2] = new ArrayStack<Integer>();
		adder[RESULT] = new ArrayStack<Integer>();
		
	}
	
	
	public void pushOperand1(int operand) {
		adder[OPERAND_1].push(operand);
	}
	
	public void pushOperand2(int operand) {
		adder[OPERAND_2].push(operand);
	}
	
	private int popOperand1() {
		return (int)(adder[OPERAND_1].pop());
	}
	
	private int popOperand2() {
		return (int)(adder[OPERAND_2].pop());
	}
	
	public int result() {
		int result = 0;
		int o1;
		int o2;
		
		while ((adder[OPERAND_1].size() > 0 || adder[OPERAND_2].size() > 0) || adder[RESULT].size() > 1)
			
			if (adder[OPERAND_1].size() > 0 && adder[OPERAND_2].size() > 0) {
				o1 = popOperand1();
				o2 = popOperand2();
				adder[RESULT].push(o1 + o2);
			}
			
			else if(adder[OPERAND_1].size() > 0 && adder[OPERAND_2].size() == 0) {
				o1 = popOperand1();
				o2 = o1 + (int)(adder[RESULT].pop());
				adder[RESULT].push(o2);
				
			}
			else if(adder[OPERAND_1].size() == 0 && adder[OPERAND_2].size() > 0) {
				o2 = popOperand2();
				o1 = o2 + (int)adder[RESULT].pop();
				adder[RESULT].push(o1);
			}
			else if((adder[OPERAND_1].size() == 0 && adder[OPERAND_2].size() == 0) && adder[RESULT].size() > 1) {
				o1 = (int)(adder[RESULT].pop());
				o2 = (int)(adder[RESULT].pop());
				adder[RESULT].push(o1 + o2);
			}
			
		result = (int)(adder[RESULT].pop());
	
		
		return result;
	}
	
}

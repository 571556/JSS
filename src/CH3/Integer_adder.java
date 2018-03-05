package CH3;
import jsjf.*;

public class Integer_adder {

	public static void main(String[] args) {

		AdderStack calculate = new AdderStack();
		calculate.pushOperand1(1);
		calculate.pushOperand2(1);
		calculate.pushOperand2(2);
		calculate.pushOperand1(3);
		calculate.pushOperand1(2);
		calculate.pushOperand2(5);
		
		System.out.println(calculate.result());
		
	}

}

package jsjf;

import jsjf.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTEST {

	private LinkedOrderedList<Integer> test;
	private LinkedOrderedList<Integer> fasit;
	private int tall1;
	private int tall2;
	private int tall3;
	private int tall4;
	
	@BeforeEach
	private void setup() {
		test = new LinkedOrderedList<Integer>();
		fasit = new LinkedOrderedList<Integer>();
		tall1 = 1;
		tall2 = 2;
		tall3 = 3;
		tall4 = 4;
	}
	
	@AfterEach
	private void tearDown() {
		test = null;
		fasit = null;
		tall1 = 0;
		tall2 = 0;
		tall3 = 0;
		tall4 = 0;
	}
	
	@Test
	public void addtestWremovefirst() {
		test.add(tall1);
		test.add(tall2);
		test.add(tall3);
		test.add(tall4);
		
		assertTrue(test.removeFirst().equals(tall1));
		assertTrue(test.removeFirst().equals(tall2));
		assertTrue(test.removeFirst().equals(tall3));
		assertTrue(test.removeFirst().equals(tall4));
		
	}
	
	@Test
	public void removeLastTest() {
		test.add(tall1);
		test.add(tall2);
		test.add(tall3);
		test.add(tall4);
		
		assertTrue(test.removeLast().equals(tall4));
		assertTrue(test.removeLast().equals(tall3));
		assertTrue(test.removeLast().equals(tall2));
		assertTrue(test.removeLast().equals(tall1));
		
	}
	
	
}

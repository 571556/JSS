package jsjf;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LinkedStackGUI extends JFrame implements ActionListener{
	
	private JButton push,pop,peek;
	private JTextField enterValues;
	private JTextArea stackArea;
	private LinkedStack<String> stack;
	
	public LinkedStackGUI() {
	
	}
	
	public void execute() {
		
		LinkedStackGUI window = new LinkedStackGUI();
		window.setTitle("LinkedStack");
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.createGUI();
		window.pack();
		window.setVisible(true);
		window.setResizable(false);
		
	}
	
	private void createGUI() {
		
		setLayout(new BorderLayout());
		JPanel buttons = new JPanel(new BorderLayout());
		add(buttons,BorderLayout.NORTH);
		
		stack = new LinkedStack<>();
		
		push = new JButton("Push");
		push.addActionListener(this);
		buttons.add(push,BorderLayout.WEST);
		
		pop = new JButton("Pop");
		pop.addActionListener(this);
		buttons.add(pop,BorderLayout.CENTER);
		
		peek = new JButton("Peek");
		peek.addActionListener(this);
		buttons.add(peek,BorderLayout.EAST);
		
		JLabel instructions = new JLabel("Write something to be pushed:");
		buttons.add(instructions,BorderLayout.NORTH);
		
		enterValues = new JTextField();
		buttons.add(enterValues,BorderLayout.NORTH);
		
		stackArea = new JTextArea(40,40);
		JScrollPane scroll = new JScrollPane(stackArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(stackArea,BorderLayout.CENTER);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == push) {
			stack.push(enterValues.getText());
			stackArea.setText(stack.toString());
		}
		
		else if (e.getSource() == pop) {
			stack.pop();
			stackArea.setText(stack.toString());
		}
		
		else if (e.getSource() == peek) {
			stackArea.setText(stack.peek());
		}
		
	}

}

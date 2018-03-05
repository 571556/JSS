package CH3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jsjf.*;

public class StackGUI extends JFrame implements ActionListener{

	JButton push, pop;
	JTextField writeString;
	JTextArea contents;
	ArrayStack<String> stack;
	
	public static void main(String[] args) {

		StackGUI window = new StackGUI();
		window.setTitle("STACK");
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.createGUI();
		window.pack();
		window.setVisible(true);
		window.setResizable(false);
		
	}
	
	public void createGUI() {
		
		stack = new ArrayStack<String>();
		
		setLayout(new BorderLayout());
		JPanel m1 = new JPanel(new BorderLayout());
		
		add(m1,BorderLayout.CENTER);
		
		JLabel instructions = new JLabel("Write the String you want to push.");
		add(instructions, BorderLayout.NORTH);
		
		JLabel bSpace = new JLabel("  ");
		m1.add(bSpace, BorderLayout.SOUTH);
		
		writeString = new JTextField(15);
		m1.add(writeString, BorderLayout.NORTH);
		
		push = new JButton("PUSH");
		push.addActionListener(this);
		m1.add(push,BorderLayout.WEST);
		
		pop = new JButton("POP");
		pop.addActionListener(this);
		m1.add(pop, BorderLayout.EAST);
		
		contents = new JTextArea(30,30);
		contents.setEditable(false);
		add(contents, BorderLayout.EAST);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == push) {
			stack.push(writeString.getText());
			String s = stack.toString();
			contents.setText(s);
		}
		else if(e.getSource() == pop) {
			stack.pop();
			String s = stack.toString();
			contents.setText(s);
		}
		
		
	}

}

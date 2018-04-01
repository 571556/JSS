package CH6;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.*;
import javax.swing.*;

import jsjf.*;

public class TextOrderedList implements ActionListener{

	OrderedListADT<String> list;
	JFrame window;
	JPanel panel1;
	JTextField text1;
	JTextArea textArea;
	JButton knapp1, knapp2, knapp3;
	
	public static void main (String[] args) {
		TextOrderedList app = new TextOrderedList();
		app.run();
		
	}
	
	private void run() {
		list = new LinkedOrderedList<String>();
		window = new JFrame();
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		createGUI();
		window.pack();
		window.setVisible(true);
	}
	
	private void createGUI() {
		text1 = new JTextField(20);
		panel1 = new JPanel(new BorderLayout());
		textArea = new JTextArea(50,50);
		
		knapp1 = new JButton("Add");
		knapp1.addActionListener(this);
		
		knapp2 = new JButton("Remove");
		knapp2.addActionListener(this);
		
		knapp3 = new JButton("Reset");
		knapp3.addActionListener(this);
		
		panel1.add(text1,BorderLayout.SOUTH);
		panel1.add(knapp1, BorderLayout.WEST);
		panel1.add(knapp2, BorderLayout.CENTER);
		panel1.add(knapp3, BorderLayout.EAST);
		
		window.add(panel1,BorderLayout.NORTH);
		window.add(textArea, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == knapp1) {
			list.add(text1.getText());
			text1.setText("");
			textArea.setText(list.toString());
		}else if(e.getSource() == knapp2) {
			text1.setText(list.removeFirst());
			textArea.setText(list.toString());
		}else if(e.getSource() == knapp3) {
			text1.setText("");
			list = new LinkedOrderedList<String>();
			textArea.setText("");
		}
		
		
	}
	
	
}

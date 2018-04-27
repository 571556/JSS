package CH6;

import javax.swing.*;
import static javax.swing.JOptionPane.*;
import static javax.swing.JFrame.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jsjf.*;
import jsjf.exception.*;

public class TextUnorderedList implements ActionListener{

	private JFrame window;
	private JPanel panel1, addToFrontP, addToRearP, addAfterP, removeP, buttons1, buttons2;
	private JButton addToFront, addToRear, addAfter, remove;
	private JTextField textAdd, textRemove;
	private JTextArea area;
	private JLabel label1, label2;
	private UnorderedListADT<String> list;
	
	public static void main(String[] args) {
		
		TextUnorderedList app = new TextUnorderedList();
		app.run();


	}
	
	private void run() {
		
		list = new ArrayUnorderedList<String>();
		window = new JFrame();
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		createGUI();
		window.pack();
		window.setVisible(true);
		
	}
	
	public void createGUI() {
		panel1 = new JPanel(new BorderLayout());
		
		addToFrontP = new JPanel();
		addToFront = new JButton("Add to front");
		addToFront.addActionListener(this);
		addToFrontP.add(addToFront);
		
		addToRearP = new JPanel();
		addToRear = new JButton("Add to rear");
		addToRear.addActionListener(this);
		addToRearP.add(addToRear);
		
		addAfterP = new JPanel();
		addAfter = new JButton("Add after");
		addAfter.addActionListener(this);
		addAfterP.add(addAfter);
		
		removeP = new JPanel();
		remove = new JButton("Remove");
		remove.addActionListener(this);
		removeP.add(remove);
		
		textAdd = new JTextField(10);
		textRemove = new JTextField(10);
		area = new JTextArea(50,50);
		
		label1 = new JLabel("Write what to add:");
		buttons1 = new JPanel(new BorderLayout());
		buttons1.add(addToFrontP, BorderLayout.WEST);
		buttons1.add(addAfterP, BorderLayout.EAST);
		buttons1.add(textAdd, BorderLayout.SOUTH);
		buttons1.add(label1);
		
		label2 = new JLabel("Write what to remove or \nadd after");
		buttons2 = new JPanel(new BorderLayout());
		buttons2.add(addToRearP, BorderLayout.WEST);
		buttons2.add(removeP, BorderLayout.EAST);
		buttons2.add(textRemove, BorderLayout.SOUTH);
		buttons2.add(label2);
		
		panel1.add(buttons1, BorderLayout.WEST);
		panel1.add(buttons2, BorderLayout.EAST);
		
		panel1.add(area,BorderLayout.SOUTH);
		window.add(panel1);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		
		if(a.getSource() == addToFront) {
			list.addToFront(textAdd.getText());
			textAdd.setText("");
			area.setText(list.toString());
		}else if(a.getSource() == addToRear) {
			list.addToRear(textAdd.getText());
			textAdd.setText("");
			area.setText(list.toString());
		}else if(a.getSource() == addAfter) {
			try {
				list.addAfter(textAdd.getText(), textRemove.getText());
			}catch(ElementNotFoundException e) {
				showMessageDialog(null,"Target element not found");
			}
			
			area.setText(list.toString());
			
		}else if(a.getSource() == remove) {
			try {
			list.remove(textRemove.getText());
			}catch(ElementNotFoundException e) {
				showMessageDialog(null,"Target element not found");
			}
			
			area.setText(list.toString());
			
		}
		
		
	}

}

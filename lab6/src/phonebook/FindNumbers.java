package phonebook;
import javax.swing.*;

import java.awt.event.*;
import java.util.List;

public class FindNumbers extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public FindNumbers(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find number(s)");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 String name = JOptionPane.showInputDialog("Enter name");
		 
		 if(name == null) {
			 return;
		 }
		 
		 List<String> nbrs = phoneBook.findNumber(name);
		 
		 StringBuilder output = new StringBuilder();
		 
		 for(String nbr : nbrs) {
			 output.append(nbr + "\n");
		 }
		 
		 if(output.length() == 0) {
			 gui.setMessageArea("NO HITS AT ALL!! At name: " + name);
		 } else {
		 	 gui.setMessageArea(output.toString());
		 }
	 }
}

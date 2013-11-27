package phonebook;
import javax.swing.*;

import java.awt.event.*;
import java.util.Set;

public class ShowAll extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public ShowAll(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Show all");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 Set<String> names = phoneBook.names();
		 
		 StringBuilder sb = new StringBuilder();
		 
		 for(String name : names) {
			 sb.append(name + "\n");
		 }
		 
		 gui.setMessageArea(sb.toString());
	 }
}

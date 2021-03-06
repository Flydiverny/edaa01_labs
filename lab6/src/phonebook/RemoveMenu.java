package phonebook;
import javax.swing.*;
import java.awt.event.*;

public class RemoveMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public RemoveMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Remove");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 String name = JOptionPane.showInputDialog("Enter name");
		 
		 if(name == null) {
			 return;
		 }
		 
		 if(phoneBook.remove(name)) {
			 gui.setMessageArea("HEN(not a hen) WAS DELETED");
		 } else {
			 gui.setMessageArea("Can't delete nonexistent aliens.");
		 }
		 
	 }
}

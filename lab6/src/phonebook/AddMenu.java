package phonebook;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AddMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public AddMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Add");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 String name = JOptionPane.showInputDialog("Enter name");
		 
		 if(name == null) {
			 return;
		 }
		 
		 String nbr = JOptionPane.showInputDialog("Enter number");
		 
		 if(nbr == null) {
			 return;
		 }
		 
		 phoneBook.put(name, nbr);
	 }
}

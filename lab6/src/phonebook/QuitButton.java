package phonebook;
import javax.swing.*;

import java.awt.event.*;
import java.io.File;


public class QuitButton extends JButton implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public QuitButton(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Quit");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(gui, "Do you want to save?", "Save", JOptionPane.YES_NO_OPTION);

		if(result != JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
		//Create a file chooser
		JFileChooser fc = new JFileChooser();
		int returnValue = fc.showSaveDialog(gui);

		if(returnValue == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			phoneBook.writeToFile(file.getAbsolutePath());
			System.exit(0);
		}
	}
}

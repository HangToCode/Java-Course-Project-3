//Name: Li Hang Biao
//Lab: 11A

import java.awt.*;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class WordGui extends JFrame {
	// Set up textboxs
	public static JFrame textBoxs = new JFrame();
	public static TextArea box1 = new TextArea();
	public static TextArea box2 = new TextArea();
	public static TextArea box3 = new TextArea();
	public static TextArea box4 = new TextArea();
	public static TextArea box5 = new TextArea();
	public static TextArea box6 = new TextArea();

	public WordGui(String name) {
		textBoxs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textBoxs.setTitle(name);
		textBoxs.setSize(500, 400);
		textBoxs.setLocation(550, 170);
		textBoxs.setLayout(new GridLayout(2, 3));

		setGui();
		textBoxs.setVisible(true); // Allow user to see the GUI

	}

	public WordGui() {
		// TODO Auto-generated constructor stub
	}

	public void setGui() {
		// Set up Menu
		JMenuItem item;
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");

		FileHandler fh = new FileHandler();
		item = new JMenuItem("Open");
		// add action from handler
		item.addActionListener(fh);
		fileMenu.add(item);

		fileMenu.addSeparator(); // add a horizontal separator line

		item = new JMenuItem("Quit");
		item.addActionListener(fh);
		fileMenu.add(item);

		item = new JMenuItem("Find");
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		// put menuBar inside the Gui
		textBoxs.setJMenuBar(menuBar);

		// storage for the gui
		Container content = textBoxs.getContentPane();

		// Put textbox in the Gui
		content.add(box1);
		content.add(box2);
		content.add(box3);
		content.add(box4);
		content.add(box5);
		content.add(box6);

		// Disable user from editing textbox by typing in the textbox
		box1.setEditable(false);
		box2.setEditable(false);
		box3.setEditable(false);
		box4.setEditable(false);
		box5.setEditable(false);
		box4.setEditable(false);
	}

	// Clear all text from the gui
	public static void clearText() {
		box1.setText(null);
		box2.setText(null);
		box3.setText(null);
		box4.setText(null);
		box5.setText(null);
		box6.setText(null);
	}

	public static void taskWordGui(TreeMap<Word, Word> map) {
		// Clear text from textArea first so files won't overlap
		clearText();

		// Checking and assigning each place a word goes from the TreeMap
		Set set = map.entrySet();
		Iterator i = set.iterator();
		Map.Entry<Word, Word> me;

		//take out all word from treemap one by one until it done
		while (i.hasNext()) {
			me = (Map.Entry) i.next();

			Word key = me.getValue();
			//convert word to string
			String value = key + "";
			try {
                //check if word is doesn't have number
				if (wordCheck(value)) {

					// Set up AEIOU rule for the Gii
					// single word extract from the array
					char letter = value.charAt(0);
					if (letter == 'a' || letter == 'A')
						box1.append(value + "\n");
					else if (letter == 'e' || letter == 'E')
						box2.append(value + "\n");
					else if (letter == 'i' || letter == 'I')
						box3.append(value + "\n");
					else if (letter == 'o' || letter == 'O')
						box4.append(value + "\n");
					else if (letter == 'u' || letter == 'U')
						box5.append(value + "\n");
					else
						box6.append(value + "\n"); // The rest of the words
					textBoxs.setVisible(true);

				}//of not then throw a exception
				else if (!wordCheck(value)) {
					throw new IllegalWordException(value);
				}

			} // Try
			catch (IllegalWordException d) {
				// JOptionPane.showMessageDialog(null, "Not a valid Word" + d + "\n");
				System.out.println("Not A Valid word: " + d + '\n');
			} // Catch

		}//while

	}// taskWordGui

	// Regular Expression to check if a word is fully letter
	public static boolean wordCheck(String s) {
		return s.matches("[a-zA-Z]+");
	}
}

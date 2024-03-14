//Name: Li Hang Biao
//Lab: 11A

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import java.io.File;
import java.util.TreeMap;

public class FileHandler implements ActionListener {
	public static String filename;
	public static int arrLength = 0; // This is used to store the length of the array
	public static File f;

	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open")) {
			JOptionPane.showMessageDialog(null, "You clicked on Open");
			listFiles();

		} else if (menuName.equals("Quit")) {
			JOptionPane.showMessageDialog(null, "You clicked on Quit");
			System.exit(0);
		}
	} // actionPerformed

	public static void listFiles() {

		try {
			JFileChooser fd = new JFileChooser();
			// Only take file
			fd.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fd.showOpenDialog(null);
			File f = fd.getSelectedFile();
			System.out.println("You choose: " + f);
			// convert file into string
			String fileS = f + "";
			if (!f.getName().endsWith(".txt")) { // Check weather the file name end with .txt, if not throw exception
				throw new IllegalWordException(fileS);
			}
			if (f.getName().endsWith(".txt")) { // Check weather the file name end with .txt, if yes, contines to the
												// next step
				filename = f + "";
				taskManage();
			}
			// if file not end with .txt then throw exception
		} catch (IllegalWordException e) {
			System.out.println("Not a valid text (.txt) file: " + e + "\n" + "Please try again" + "\n");
			JOptionPane.showMessageDialog(null,
					"Not a valid text (.txt) file: " + e + "\n" + "Please try again" + "\n");
		}
	}

	// use tokenizer to take out word from the file
	public static void taskManage() {

		treeMapSort theInput = new treeMapSort(); // calls out the treeMapSort
		theInput.mapClear(); // Clear the map everytime a new file is called
		TextFileInput input = new TextFileInput(filename);
		String line = input.readLine(); // Take the first line from the input
		while (line != null) { // If the next line isn't a null, continues
			StringTokenizer tok = new StringTokenizer(line, " ");
			while (tok.hasMoreTokens()) {

				String holder = tok.nextToken(); // temporary hold the next token
				Word t = new Word(holder);

				theInput.add(t);
				arrLength++;
			}
			line = input.readLine();
		} // end of while loop
		input.close(); // end reading from file
		TreeMap<Word, Word> treeMap = theInput.getWordMap();
		WordGui.taskWordGui(treeMap); // This pass the array to WordGui where it will print out the sorted
	}

}
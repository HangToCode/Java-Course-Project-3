//Name: Li Hang Biao
//Lab: 11A

import java.util.Comparator;
import java.util.TreeMap;


public class treeMapSort {

	public TreeMap<Word, Word> wordMap = new TreeMap<Word, Word>(new compares());

	public void add(Word w) { // Take in new word from FileHandler and add to the TreeMap
		wordMap.put(w, w);
	}
  
	public TreeMap<Word, Word> getWordMap() {
		return wordMap;
	}

	public class compares implements Comparator<Word> {
		public int compare(Word a, Word b) {
			return a.compareTo(b);
		}
	}

	// Clear the TreeMap everytime a new file is called, used for project 3
	public void mapClear() {
		wordMap.clear();
	}
}

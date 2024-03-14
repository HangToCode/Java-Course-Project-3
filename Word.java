//Name: Li Hang Biao
//Lab: 11A

public class Word {
	// instance variable
	protected String word;

	public Word(String w) { // passing word to here
		this.word = w;
	}
	
	@Override
	public String toString() {
		return word; // return back the word
	}
	//@Override

	public int compareTo(Word w) { // compare new word from the previous word
		return this.word.compareTo(w.word);
	}
	

	public String getWord() {
		return word; // return back the word
	}

}
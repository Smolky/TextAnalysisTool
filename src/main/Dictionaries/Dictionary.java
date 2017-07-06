package main.Dictionaries;

import java.util.ArrayList;

import main.Readers.FileReader;

/**
 * Dictionary
 * 
 * A Dictionary represents a set of words within a 
 * specific context
 * 
 * Words can be simple or complex whether has spaces
 * such as "as long as" 
 * 
 * Dictionaries can be loaded word by word, from 
 * a file, etc. 
 * 
 * 
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class Dictionary {

	/** String[] words */
	protected ArrayList<String> words = new ArrayList<String>();
	
	
	/**
	 * Dictionary
	 * 
	 * @param file
	 */
	public Dictionary () {
	}	
	
	
	/**
	 * Dictionary
	 * 
	 * Allows to create a dictionary from a file
	 * 
	 * @param file
	 */
	public Dictionary (String file) {
		this.loadFromFile(file);
	}
	
	
	/**
	 * add
	 *  	
	 * @param word
	 */
	public Dictionary add (String word) {
		this.words.add (word);
		return this;
	}
	
	
	/**
	 * clear
	 *  	
	 * @param word
	 */
	public Dictionary clear () {
		this.words.clear();
		return this;
	}
	
	
	
	/**
	 * loadFromFile
	 * 
	 * @param file
	 */
	public void loadFromFile (String file) {
		
		// Create a file reader
		FileReader filereader = new FileReader ();
		
		
		// REtrieve info
		try {
			this.words = (ArrayList<String>) filereader.getLines(file);
			
		// Something happened
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * getWords
	 * 
	 * @return String
	 */
	public ArrayList<String> getWords () {
		return this.words;
	}
	
}

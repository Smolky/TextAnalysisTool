package main.Sictionaries;

import main.Readers.FileReader;

/**
 * Dictionary
 * 
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class Dictionary {

	protected String[] words;
	
	
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
			this.words = filereader.getLines(file);
			
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
	public String[] getWords () {
		return this.words;
	}
	
}

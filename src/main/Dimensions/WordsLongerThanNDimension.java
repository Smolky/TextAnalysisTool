package main.Dimensions;

import main.helpers.ExtractWordsFromString;

/**
 * WordsLongerThanNDimension
 * 
 * Detects the number of words with more/or equal than N
 * characters 
 * 
 * @author José Antonio García Díaz
 */
public class WordsLongerThanNDimension extends BaseDimension {
	
	/** int length */
	public int length;
	
	
	/**
	 * setLength
	 * 
	 * @param length
	 * 
	 * @return
	 */
	public void setLength (int length) {
		this.length = length;
	}
	
	
	/**
	 * getLength
	 * @return int
	 */
	public int getLength () {
		return this.length;
	}
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Get the number of words
		double result = 0;
		for (String word : ExtractWordsFromString.getWords (this.getInput ())) {
			if (word.length() >= this.length) {
				result++;
			}
		};
		
		return result;
		
	}
	
}

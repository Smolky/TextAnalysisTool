package es.um.dis.umutextstats.dimensions;


import es.um.dis.umutextstats.helpers.ExtractWordsFromString;


/**
 * WordsEqualToNDimension
 * 
 * Detects the number of words with equal length than N
 * characters 
 * 
 * @author José Antonio García Díaz
 */
public class WordsEqualToNDimension extends BaseDimension {

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
			if (word.length() == this.getLength ()) {
				result++;
			}
		};
		
		return result;
		
	}
	
}

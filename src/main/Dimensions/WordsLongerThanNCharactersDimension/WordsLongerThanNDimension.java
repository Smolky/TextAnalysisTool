package main.Dimensions.WordsLongerThanNCharactersDimension;

import main.Dimensions.BaseDimension;

/**
 * WordsLongerThanNDimension
 * 
 * @author José Antonio García Díaz
 */
public class WordsLongerThanNDimension extends BaseDimension {
	
	public int length = 1;
	
	
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
	 * process
	 */
	public double process () {
		if (this.getInput ().isEmpty()) {
			return 0;
		}
		
		
		// Get the number of words
		double result = 0;
		for (String word : this.getInput ().split ("\\s+")) {
			if (word.length() > this.length) {
				result++;
			}
		};
		
		return result;
		
	}
	
}

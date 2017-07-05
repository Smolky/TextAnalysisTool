package main.Dimensions.CharacterCountDimension;

import main.Dimensions.BaseDimension;
import main.helpers.ExtractWordsFromString;

/**
 * WordCountDimension
 * 
 * This dimensions counts the number of words has the
 * text
 * 
 * @author Jos� Antonio Garc�a D�az
 * 
 * @package TextAnalysis
 */
public class WordCountDimension extends BaseDimension {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "WC";
	}
	

	/**
	 * process
	 */
	public double process () {
		if (this.getInput ().isEmpty()) {
			return 0;
		}
		    
		return ExtractWordsFromString.getWords(this.getInput ()).length;
	}
	
	
}

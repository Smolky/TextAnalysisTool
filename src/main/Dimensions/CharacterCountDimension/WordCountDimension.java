package main.Dimensions.CharacterCountDimension;

import main.Dimensions.BaseDimension;
import main.helpers.ExtractWordsFromString;

/**
 * WordCountDimension
 * 
 * This dimensions counts the number of words has the
 * text
 * 
 * @author José Antonio García Díaz
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
	public double subprocess () {
		return ExtractWordsFromString.getWords(this.getInput ()).length;
	}
	
	
}

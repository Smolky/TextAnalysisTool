package main.Dimensions.InformalSpeechDimenion;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * DeathDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class SwearWordsDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "swear";
	}	
	
}

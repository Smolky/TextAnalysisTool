package main.Dimensions.AffectDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * SadnessDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class SadnessDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "sad";
	}	
	
}

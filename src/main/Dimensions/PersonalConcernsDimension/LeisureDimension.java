package main.Dimensions.PersonalConcernsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * LeisureDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class LeisureDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "leisure";
	}	
	
}

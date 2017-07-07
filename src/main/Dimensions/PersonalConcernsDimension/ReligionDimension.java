package main.Dimensions.PersonalConcernsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * ReligionDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class ReligionDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "religion";
	}	
	
}

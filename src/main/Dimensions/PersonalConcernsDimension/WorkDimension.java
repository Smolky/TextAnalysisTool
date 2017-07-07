package main.Dimensions.PersonalConcernsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * WorkDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class WorkDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "work";
	}	
	
}

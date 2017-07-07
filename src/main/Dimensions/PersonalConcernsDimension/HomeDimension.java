package main.Dimensions.PersonalConcernsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * HomeDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class HomeDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "home";
	}	
	
}

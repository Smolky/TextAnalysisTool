package main.Dimensions.PersonalConcernsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * DeathDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class DeathDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "death";
	}	
	
}

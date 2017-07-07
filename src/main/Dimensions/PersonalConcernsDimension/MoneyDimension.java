package main.Dimensions.PersonalConcernsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * MoneyDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class MoneyDimension extends MatchingWordsFromDictionary {

	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "money";
	}	
	
}

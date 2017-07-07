package main.Dimensions.CorePrinciplesDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * AffiliationDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class AffiliationDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "ingesting";
	}	
	
}

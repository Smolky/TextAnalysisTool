package main.Dimensions.FunctionWordsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * ConjunctionsDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class ConjunctionsDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "conj";
	}	
	
}

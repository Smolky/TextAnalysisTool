package main.Dimensions.FunctionWordsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * PrepositionsDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class PrepositionsDimension extends MatchingWordsFromDictionary {
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "preposition";
	}	
	
}

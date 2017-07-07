package main.Dimensions.FunctionWordsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * AuxiliaryVerbsDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class AuxiliaryVerbsDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "auxverb";
	}	
	
}

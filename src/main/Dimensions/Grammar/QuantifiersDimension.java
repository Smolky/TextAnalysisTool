package main.Dimensions.Grammar;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * QuantifiersDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class QuantifiersDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "quant";
	}	
	
}

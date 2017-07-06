package main.Dimensions.Grammar;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * ComparativesDimension
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class ComparativesDimension extends MatchingWordsFromDictionary {

	/**
	 * ArticlesDimension
	 * 
	 * @param dictionary
	 */
	public ComparativesDimension(Dictionary dictionary) {
		super(dictionary);
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "compare";
	}	
	
}

package main.Dimensions.FunctionWordsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * NegationDimension
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class NegationDimension extends MatchingWordsFromDictionary {

	/**
	 * ArticlesDimension
	 * 
	 * @param dictionary
	 */
	public NegationDimension(Dictionary dictionary) {
		super(dictionary);
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "negate";
	}	
	
}

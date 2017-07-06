package main.Dimensions.FunctionWordsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * PrepositionsDimension
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class PrepositionsDimension extends MatchingWordsFromDictionary {

	/**
	 * ArticlesDimension
	 * 
	 * @param dictionary
	 */
	public PrepositionsDimension(Dictionary dictionary) {
		super(dictionary);
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "preposition";
	}	
	
}

package main.Dimensions.FunctionWordsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * AuxiliaryVerbsDimension
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class AuxiliaryVerbsDimension extends MatchingWordsFromDictionary {

	/**
	 * ArticlesDimension
	 * 
	 * @param dictionary
	 */
	public AuxiliaryVerbsDimension(Dictionary dictionary) {
		super(dictionary);
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "auxverb";
	}	
	
}

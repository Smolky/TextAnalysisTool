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

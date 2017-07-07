package main.Dimensions.Grammar;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * ArticlesDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class AdjectivesDimension extends MatchingWordsFromDictionary {

	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "adjectives";
	}	
	
}

package main.Dimensions.AffectDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * PositiveEmotionDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class PositiveEmotionDimension extends MatchingWordsFromDictionary {

	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "posemo";
	}	
	
}

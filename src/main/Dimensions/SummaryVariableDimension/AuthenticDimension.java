package main.Dimensions.SummaryVariableDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * AuthenticDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class AuthenticDimension extends MatchingWordsFromDictionary {

	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Authentic";
	}		

}

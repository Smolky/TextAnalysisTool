package main.Dimensions.SummaryVariableDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * EmotionalToneDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class EmotionalToneDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Tone";
	}		

}

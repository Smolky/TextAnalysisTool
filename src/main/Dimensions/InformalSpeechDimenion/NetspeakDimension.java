package main.Dimensions.InformalSpeechDimenion;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * NetspeakDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class NetspeakDimension extends MatchingWordsFromDictionary {
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "netspeak";
	}	
	
}

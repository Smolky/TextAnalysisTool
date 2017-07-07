package main.Dimensions.BiologicalDimenssionProcesses;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * HealthIllnessDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class HealthIllnessDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "health";
	}	
	
}

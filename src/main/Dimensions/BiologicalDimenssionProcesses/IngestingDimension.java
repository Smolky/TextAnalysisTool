package main.Dimensions.BiologicalDimenssionProcesses;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * IngestingDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class IngestingDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "ingesting";
	}	
	
}

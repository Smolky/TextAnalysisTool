package main.Dimensions.TimeOrientationDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * AchievementDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class PastFocusDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "focuspast";
	}	
	
}

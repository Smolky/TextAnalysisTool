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
public class FutureFocusDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "focusfuture";
	}	
	
}

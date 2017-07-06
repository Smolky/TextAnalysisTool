package main.Dimensions.LanguageMetricsDimension;


/**
 * WordsLongerThan15Dimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class WordsLongerThan15Dimension extends WordsLongerThanNDimension {

	/**
	 * constructor
	 */
	public WordsLongerThan15Dimension () {
		this.setLength(15);
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "fifteenltr";
	}
	
}

package main.Dimensions.LanguageMetricsDimension;

/**
 * WordsLongerThan8Dimension
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class WordsLongerThan8Dimension extends WordsLongerThanNDimension {

	/**
	 * constructor
	 */
	public WordsLongerThan8Dimension () {
		this.setLength(8);
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Eightltr";
	}		
	
}

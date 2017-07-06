package main.Dimensions.LanguageMetricsDimension;


/**
 * WordsLongerThan7Dimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class WordsLongerThan7Dimension extends WordsLongerThanNDimension {

	/**
	 * constructor
	 */
	public WordsLongerThan7Dimension () {
		this.setLength(7);
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Sevenltr";
	}		
	
}

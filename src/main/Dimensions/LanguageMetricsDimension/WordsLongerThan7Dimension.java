package main.Dimensions.LanguageMetricsDimension;


/**
 * WordsLongerThan7Dimension
 *
 * @author Jos� Antonio Garc�a D�az
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

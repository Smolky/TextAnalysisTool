package main.Dimensions.LanguageMetricsDimension;

/**
 * WordsLongerThan8Dimension
 * 
 * @author Jos� Antonio Garc�a D�az
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

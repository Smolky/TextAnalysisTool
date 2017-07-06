package main.Dimensions.LanguageMetricsDimension;


/**
 * WordsLongerThan15Dimension
 *
 * @author Jos� Antonio Garc�a D�az
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

package main.Dimensions.WordsLongerThanNCharactersDimension;

/**
 * WordsLongerThan6Dimension
 * 
 * @author Jos� Antonio Garc�a D�az
 * 
 * @package TextAnalysis
 */
public class WordsLongerThan6Dimension extends WordsLongerThanNDimension {

	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Sixltr";
	}	
	
	
	/**
	 * constructor
	 */
	public WordsLongerThan6Dimension () {
		this.setLength(6);
	}
	
}

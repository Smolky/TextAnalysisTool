package main.Dimensions;

/**
 * Dimension
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class WordCountDimension extends BaseDimension {

	/**
	 * process
	 */
	public double process () {
		if (this.getInput ().isEmpty()) {
			return 0;
		}
		    
		return this.getInput ().trim ().split ("\\s+").length;
	}
	
	
}

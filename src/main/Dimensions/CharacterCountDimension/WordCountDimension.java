package main.Dimensions.CharacterCountDimension;

import main.Dimensions.BaseDimension;

/**
 * Dimension
 * 
 * @author Jos� Antonio Garc�a D�az
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

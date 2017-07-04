package main.Dimensions.PronounsDimension;

import main.Dimensions.CompositeDimension;
import main.Dimensions.DimensionInterface;

/**
 * * PronounsFirstPersonDimension
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class PronounsFirstPersonDimension extends CompositeDimension {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Self";
	}
	
	/**
	 * PronounsFirstPersonDimension
	 * 
	 * @param singular
	 * @param plural
	 */
	public PronounsFirstPersonDimension (DimensionInterface singular, DimensionInterface plural) {
		this.dimensions.add(singular);
		this.dimensions.add(plural);
	}
	
}

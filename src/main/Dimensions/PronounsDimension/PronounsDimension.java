package main.Dimensions.PronounsDimension;

import main.Dimensions.CompositeDimension;
import main.Dimensions.DimensionInterface;

/**
 * * PronounsDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class PronounsDimension extends CompositeDimension {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Pronoum";
	}
	
	
	/**
	 * PronounsDimension
	 * 
	 * @param first
	 * @param second
	 * @param plural
	 */
	public PronounsDimension (DimensionInterface first, DimensionInterface second, DimensionInterface third) {
		this.dimensions.add(first);
		this.dimensions.add(second);
		this.dimensions.add(third);
	}
	
}

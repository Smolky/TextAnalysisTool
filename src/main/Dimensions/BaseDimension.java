package main.Dimensions;

import main.Asset;

/**
 * BaseDimension 
 * 
 * A standard implementation of the DimensionInterface
 * 
 * @author José Antonio García Díaz
 * @package TextAnalysis
 */
public abstract class BaseDimension implements DimensionInterface {

	/** String asset */
	protected String asset;
	
	
	/**
	 * getDimensionKey
	 * 
	 * @return String
	 */
	public String getDimensionKey () {
		return this.getClass().getSimpleName ();
	}
	
	
	/**
	 * setInput
	 * 
	 * Allows to establish the input for the dimension
	 * 
	 * @param input
	 */	
	public BaseDimension setInput (Asset asset) {
		this.asset = asset.toString ();
		return this;
	}
	
	
	/**
	 * setInput
	 * 
	 * Allows to establish the input for the dimension
	 * 
	 * @param input
	 */	
	public BaseDimension setInput (String asset) {
		this.asset = asset;
		return this;
	}
	
	
	
	/**
	 * getInput
	 * 
	 * @return Double
	 */
	public String getInput () {
		return this.asset;
	}

}

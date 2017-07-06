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
	
	
	/** String key */
	protected String key;
	
	
	/** Double result */
	protected double result = -1;
	
	
	/**
	 * BaseDimension
	 * 
	 * A default implementation for the key
	 */
	public BaseDimension () {
		this.key = this.getClass().getSimpleName ();
	}
	
	
	/**
	 * reset
	 * 
	 * @return DimensionInterface
	 */
	public DimensionInterface reset () {
		this.result = -1;
		return this;
	}	
	
	
	/**
	 * getDimensionKey
	 * 
	 * @return String
	 */
	public String getDimensionKey () {
		return this.key;
	}
	
	
	/**
	 * setDimensionKey
	 * 
	 * @return String
	 */
	public DimensionInterface setDimensionKey (String key) {
		this.key = key;
		return this;
	}
	
	
	
	/**
	 * setInput
	 * 
	 * Allows to establish the input for the dimension
	 * 
	 * @param input
	 */	
	public BaseDimension setInput (Asset asset) {
		this.reset ();
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
		this.reset ();
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
	
	
	/**
	 * process
	 */
	public double process () {
		
		// Retrieve from cache
		if (this.result != -1) {
			return this.result;
		}
		
		
		// Base implementation. Check if results are empty
		if (this.getInput ().isEmpty()) {
			this.result = 0;
			return this.result;
		}
		
		
		// Delegate
		this.result = this.subprocess ();
		return this.result;
		
	}	

}

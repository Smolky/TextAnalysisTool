package es.um.dis.umutextstats.dimensions;

import es.um.dis.umutextstats.Asset;

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
	
	
	/** String description */
	protected String description = "";
	
	
	/** int input_length */
	protected int length = -1;
	
	
	/**
	 * BaseDimension
	 * 
	 * A default implementation for the key
	 */
	public BaseDimension () {
		this.key = this.getClass().getSimpleName ();
	}
	
	
	/**
	 * getInputLength
	 * 
	 * Allows to cache the input length
	 */	
	public int getInputLength () {
		if (this.length == -1) {
			this.length = this.getInput ().length();			
		}
		return this.length;
		
	}
	
	
	/**
	 * reset
	 * 
	 * @return DimensionInterface
	 */
	public DimensionInterface reset () {
		this.length = -1;
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
	 * getDescription
	 * 
	 * @return String
	 */
	public String getDescription () {
		return this.description;
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
	 * setDescription
	 * 
	 * @return String
	 */
	public DimensionInterface setDescription (String description) {
		this.description = description;
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

package main.Dimensions;

import main.Asset;

/**
 * DimensionInterface
 * 
 * This interface defines the behaviour about the 
 * requirements about the dimensions
 * 
 * @author Jos� Antonio Garc�a D�az
 * @package TextAnalysis
 */
public interface DimensionInterface {
	
	/**
	 * getDimensionKey
	 * 
	 * Returns a dimension key for identification
	 * 
	 * @return String
	 */
	public String getDimensionKey ();
	
	
	/**
	 * setDimensionKey
	 * 
	 * Allows to set a custom key
	 * 
	 * @param key
	 */
	public DimensionInterface setDimensionKey (String key);	
	
	
	/**
	 * setInput
	 * 
	 * Allows to establish the input for the dimension
	 * 
	 * @param Asset
	 */
	public DimensionInterface setInput (Asset input);
	
	
	/**
	 * setInput
	 * 
	 * Allows to establish the input for the dimension
	 * 
	 * @param Asset
	 */
	public DimensionInterface setInput (String input);	
	
	
	
	/**
	 * getInput
	 * 
	 * Returns the input
	 * 
	 * @return
	 */
	public String getInput ();
	
	
	/**
	 * process
	 * 
	 * Process the calculations
	 * 
	 * @return
	 */
	abstract public double process () ;
	
	
	/**
	 * subprocess
	 * 
	 * Process the calculations
	 * 
	 * @return
	 */
	public double subprocess () ;
	

}

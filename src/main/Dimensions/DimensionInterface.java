package main.Dimensions;

import main.Asset;

/**
 * DimensionInterface
 * 
 * This interface defines the behaviour about the 
 * requirements about the dimensions
 * 
 * @author José Antonio García Díaz
 * @package TextAnalysis
 */
public interface DimensionInterface {
	
	/**
	 * getDimensionKey
	 * 
	 * Returns a dimension key for identification
	 * 
	 * @param Asset
	 */
	public String getDimensionKey ();
	
	
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
	public double process () ;

}

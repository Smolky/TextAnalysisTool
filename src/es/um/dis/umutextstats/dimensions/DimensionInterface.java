package es.um.dis.umutextstats.dimensions;

import es.um.dis.umutextstats.Asset;

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
	 * @return String
	 */
	public String getDimensionKey ();
	
	
	/**
	 * getDimensionKey
	 * 
	 * Returns a dimension key for identification
	 * 
	 * @return String
	 */
	public String getDescription ();	
	
	
	/**
	 * setDimensionKey
	 * 
	 * Allows to set a custom key
	 * 
	 * @param key
	 */
	public DimensionInterface setDimensionKey (String key);	
	
	
	/**
	 * setDescription
	 * 
	 * @param description
	 * @return
	 */
	public DimensionInterface setDescription (String description) ;
	
	
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

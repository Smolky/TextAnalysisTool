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
public interface DimensionInterface<T> {
	
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
	public T setDimensionKey (String key);	
	
	
	/**
	 * setInput
	 * 
	 * Allows to establish the input for the dimension
	 * 
	 * @param Asset
	 */
	public T setInput (Asset input);
	
	
	/**
	 * setInput
	 * 
	 * Allows to establish the input for the dimension
	 * 
	 * @param Asset
	 */
	public T setInput (String input);	
	
	
	
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

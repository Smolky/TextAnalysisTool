package es.um.dis.umutextstats.dimensions;


/**
 * LengthDimension
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class LengthDimension extends BaseDimension {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "length";
	}
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		return this.getInput ().length(); 
	}
}

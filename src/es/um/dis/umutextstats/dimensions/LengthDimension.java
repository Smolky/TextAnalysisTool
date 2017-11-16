package es.um.dis.umutextstats.dimensions;


/**
 * LengthDimension
 * 
 * This dimension returns the length of the input
 * 
 * @author Jos� Antonio Garc�a D�az
 * 
 * @package TextAnalysis
 */
public class LengthDimension extends BaseDimension {
	
	/**
	 * subprocess
	 * 
	 * @override
	 */
	public double subprocess () {
		return this.getInputLength ();
	}
}

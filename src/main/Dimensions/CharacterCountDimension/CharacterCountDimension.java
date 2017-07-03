package main.Dimensions.CharacterCountDimension;

import main.Dimensions.BaseDimension;

/**
 * CharacterCountDimension
 * 
 * This dimension counts the appareance of a set 
 * of characers
 * 
 * @author Jos� Antonio Garc�a D�az
 * @package TextAnalysis
 */
abstract public class CharacterCountDimension extends BaseDimension {
	
	public String character;
	
	
	/**
	 * setChar
	 * 
	 * @param length
	 * 
	 * @return
	 */
	public void setChar (String character) {
		this.character = character;
	}
	
	/**
	 * getChar
	 * @return int
	 */
	public String getChar () {
		return this.character;
	}
	
	
	/**
	 * process
	 */
	public double process () {
		if (this.getInput ().isEmpty()) {
			return 0;
		}
		    
		
		return this.getInput ().length () - this.getInput ().replace (this.getChar (), "").length();
		
	}	

}

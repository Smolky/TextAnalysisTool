package main.Dimensions;

/**
 * CharacterCountDimension
 * 
 * This dimension counts the appareance of a set 
 * of characers
 * 
 * @author José Antonio García Díaz
 * @package TextAnalysis
 */
public class CharacterCountDimension extends BaseDimension {
	
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
	 * subprocess
	 */
	public double subprocess () {
		return this.getInput ().length () - this.getInput ().replace (this.getChar (), "").length();
	}	

}

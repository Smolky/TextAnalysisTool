package es.um.dis.umutextstats.dimensions;

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
	public CharacterCountDimension setChar (String character) {
		this.character = character;
		return this;
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

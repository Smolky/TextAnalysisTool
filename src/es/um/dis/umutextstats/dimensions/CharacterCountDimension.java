package es.um.dis.umutextstats.dimensions;

import org.apache.commons.lang3.StringUtils;

/**
 * CharacterCountDimension
 * 
 * This dimension counts the matches of a set 
 * of characters
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class CharacterCountDimension extends BaseDimension {
	
	/** String character the list of characters to match */
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
	 * 
	 * Returns the set of chars
	 * 
	 * @return String
	 */
	public String getChar () {
		return this.character;
	}
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Init vars
		double result = 0;
		String characters = this.getChar ();
		String input = this.getInput ();
		
		
		// Get all chars 
		for (int i = 0; i < characters.length(); i++){
			result += StringUtils.countMatches(input, "" + characters.charAt(i));
		}
		
		return result;
	}	

}

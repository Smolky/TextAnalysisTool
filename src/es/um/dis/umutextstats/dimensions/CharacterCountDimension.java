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
		
		// Init vars
		double result = 0;
		
		
		// Get all chars 
		for (int i = 0; i < this.getChar ().length(); i++){
			
			// Get char and string
			char c = this.getChar ().charAt(i);
			String input = this.getInput ();
			
			
			// Calculate the occurrences of each character
		    result = result + this.getInput ().length () - input.replace(Character.toString(c), "").length ();
		}
		
		return result;
	}	

}

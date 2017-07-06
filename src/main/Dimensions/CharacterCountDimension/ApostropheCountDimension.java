package main.Dimensions.CharacterCountDimension;


/**
 * ApostropheCountDimension
 *
 * @todo Improve for more types of quotes.
 * @todo Allow a set of characters
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class ApostropheCountDimension extends CharacterCountDimension {

	/**
	 * ApostropheCountDimension
	 */
	public ApostropheCountDimension () {
		this.setChar("'");
	}
	
}

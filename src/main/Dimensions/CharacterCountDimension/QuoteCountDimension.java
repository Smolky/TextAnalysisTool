package main.Dimensions.CharacterCountDimension;


/**
 * QuoteCountDimension
 *
 * @todo Improve for more types of quotes.
 * @todo Allow a set of characters
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class QuoteCountDimension extends CharacterCountDimension {

	public QuoteCountDimension () {
		this.setChar("\"");
	}
	
}

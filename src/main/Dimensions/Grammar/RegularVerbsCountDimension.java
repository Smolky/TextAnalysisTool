package main.Dimensions.Grammar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import main.Dimensions.BaseDimension;



/**
 * RegularVerbsCountDimension
 *
 * This dimension counts the number of regular verbs
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class RegularVerbsCountDimension extends BaseDimension {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Regular";
	}	
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Create Tagger
		MaxentTagger tagger = new MaxentTagger("assets/taggers/english-left3words-distsim.tagger");
		String tagged = tagger.tagString(this.getInput ());
		Pattern VerbPat=Pattern.compile("[A-Za-z]+/VB.");
		Matcher matcher = VerbPat.matcher (tagged);
		
		double count = 0;
		while (matcher.find()) {
		    count++;		
		}
		
		
		return count;
		
	}
}

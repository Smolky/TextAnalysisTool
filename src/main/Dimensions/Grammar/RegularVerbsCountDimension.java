package main.Dimensions.Grammar;

import org.apache.commons.lang3.StringUtils;

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
	
	// Tagger
	MaxentTagger tagger;
	
	
	/**
	 * setTagger
	 * @param tagger
	 */
	public void setTagger (MaxentTagger tagger) {
		this.tagger = tagger;
	}

	
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
		
		// No tagger to check!
		if (this.tagger == null) {
			return 0;
		}
		
		
		// Get tagged process
		return StringUtils.countMatches (this.tagger.tagString (this.getInput ()), "_VBP");
		
	}
}

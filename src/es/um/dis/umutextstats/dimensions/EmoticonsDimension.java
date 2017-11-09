package es.um.dis.umutextstats.dimensions;


/**
 * MatchingWordsFromDictionary
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class EmoticonsDimension extends PatternDimension {
	
	public EmoticonsDimension () {
		this.setPattern("(\\Q:)\\E|\\Q:D\\E|\\Q:(\\E|\\Q:wink:\\E)");
	}
	
}

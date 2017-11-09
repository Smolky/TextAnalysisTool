package es.um.dis.umutextstats.dimensions;


/**
 * MatchingWordsFromDictionary
 * 
 * @author Jos� Antonio Garc�a D�az
 * 
 * @package TextAnalysis
 */
public class EmoticonsDimension extends PatternDimension {
	
	public EmoticonsDimension () {
		this.setPattern("(\\Q:)\\E|\\Q:D\\E|\\Q:(\\E|\\Q:wink:\\E)");
	}
	
}

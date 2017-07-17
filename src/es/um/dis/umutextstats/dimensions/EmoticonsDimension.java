package es.um.dis.umutextstats.dimensions;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.um.dis.umutextstats.dictionaries.Dictionary;


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

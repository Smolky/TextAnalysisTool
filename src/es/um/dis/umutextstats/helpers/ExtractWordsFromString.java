package es.um.dis.umutextstats.helpers;

/**
 * ExtractWordsFromString
 * 
 * @author Jos� Antonio Garc�a D�az
 * 
 * @package TextAnalysis
 */
public final class ExtractWordsFromString {
	
	public static String[] getWords (String input) {
		return input.trim ().split ("\\s+");
	}
	

}

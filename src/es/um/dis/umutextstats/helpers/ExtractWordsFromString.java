package es.um.dis.umutextstats.helpers;

/**
 * ExtractWordsFromString
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public final class ExtractWordsFromString {
	
	public static String[] getWords (String input) {
		return input.trim ().split ("\\s+");
	}
	

}

package es.um.dis.umutextstats.helpers;

/**
 * ExtractSentencesFromString
 * 
 * @author Jos� Antonio Garc�a D�az
 * @package TextAnalysis
 */
public final class ExtractSentencesFromString {

	public static String[] getSentences (String input) {
		return input.split("[!?.:]+");
	}
	
}

package es.um.dis.textstats.helpers;

/**
 * ExtractSentencesFromString
 * 
 * @author José Antonio García Díaz
 * @package TextAnalysis
 */
public final class ExtractSentencesFromString {

	public static String[] getSentences (String input) {
		return input.split("[!?.:]+");
	}
	
}

package main;


import main.Dimensions.DimensionInterface;
import main.Dimensions.DimensionsContainer;
import main.Dimensions.MatchingWordsFromDictionary;
import main.Dimensions.PercentageWordsCapturedFromDictionary;
import main.Dimensions.UniqueWordsDimension;
import main.Dimensions.WordsPerSentenceDimension;
import main.Dimensions.CharacterCountDimension.CommaCountDimension;
import main.Dimensions.CharacterCountDimension.WordCountDimension;
import main.Dimensions.PronounsDimension.PronounsFirstPersonDimension;
import main.Dimensions.PronounsDimension.PronounsFirstPersonPluralDimension;
import main.Dimensions.PronounsDimension.PronounsFirstPersonSingularDimension;
import main.Dimensions.PronounsDimension.PronounsSecondPersonDimension;
import main.Dimensions.SentencesEndingWithCharacterDimension.SentencesEndingWithQuestionMarkDimension;
import main.Dimensions.WordsLongerThanNCharactersDimension.WordsLongerThan15Dimension;
import main.Readers.FileReader;
import main.Sictionaries.Dictionary;



/**
 * main
 * 
 * @author José Antonio García Díaz
 * 
 * @package TestAnalysis
 */
public class main {

	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Start!
		System.out.println ("Testing file reader");
		
		
		// Start file reader
		FileReader filereader = new FileReader ();
		
		
		// Create the iterator
		DimensionsContainer dimensions = new DimensionsContainer ();
		
		
		Dictionary fulldictionary = new Dictionary ();
		Dictionary firstpersonsingularpronounsdictionary = new Dictionary ();
		Dictionary firstpersonpluralpronounsdictionary = new Dictionary ();
		Dictionary secondpersonpronounsdictionary = new Dictionary ();

		
		
		// Create dictionaries
		try {
			fulldictionary.loadFromFile ("assets/dictionaries/english.txt");
			firstpersonsingularpronounsdictionary.loadFromFile ("assets/dictionaries/firstpersonsingularpronoums.txt");
			firstpersonpluralpronounsdictionary.loadFromFile ("assets/dictionaries/firstpersonpluralpronoums.txt");			
			secondpersonpronounsdictionary.loadFromFile("assets/dictionaries/secondpersonpronoums.txt");
			
			
		} catch (Exception e) {
			System.out.println ("error reading dictionaries");
			System.out.println (e);
			return;
		}
		
		
		// Create the dimensions
		dimensions
			.add (new WordCountDimension ())
			.add (new WordsPerSentenceDimension ())
			.add (new WordsLongerThan15Dimension ())
			.add (new CommaCountDimension ())
			.add (new SentencesEndingWithQuestionMarkDimension ())
			.add (new UniqueWordsDimension ())
			.add (new PercentageWordsCapturedFromDictionary ())
			.add (new MatchingWordsFromDictionary (fulldictionary))
			
			.add (new PronounsFirstPersonSingularDimension (firstpersonsingularpronounsdictionary))
			.add (new PronounsFirstPersonPluralDimension (firstpersonpluralpronounsdictionary))
			
			.add (new PronounsFirstPersonDimension (
				new PronounsFirstPersonSingularDimension (firstpersonsingularpronounsdictionary),
				new PronounsFirstPersonPluralDimension (firstpersonpluralpronounsdictionary)
			))
			
			.add (new PronounsSecondPersonDimension (secondpersonpronounsdictionary))
			
			
		;
		
		
		// Start!
		try {
			// Get the file
			String input = filereader.read ("assets/samples/sample-file-2.txt");
			
			// Read the asset
			Asset asset = new Asset ();
			asset.setAsset (input);
			
			
			// Set input
			for (DimensionInterface dimension : dimensions) {
				dimension.setInput(asset);
			}
			
			for (DimensionInterface dimension : dimensions) {
				System.out.println(dimension.getDimensionKey () + " " + dimension.process());	
			}
			

			
		} catch (Exception e) {
			System.out.println ("error");
			System.out.println (e);
		}
	}
}

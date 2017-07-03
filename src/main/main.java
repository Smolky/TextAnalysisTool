package main;

import main.Dimensions.*;
import main.Dimensions.WordsLongerThanNCharactersDimension.WordsLongerThan15Dimension;
import main.Readers.FileReader;


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
		
		
		// Create the dimensions
		dimensions
			.add (new WordCountDimension ())
			.add (new MatchingWordsFromDictionary ())
			.add (new WordsPerSentenceDimension ())
			.add (new WordsLongerThan15Dimension ())
			.add (new CommaCountDimension ())
			.add (new SentencesEndingWithQuestionMarkDimension ())
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

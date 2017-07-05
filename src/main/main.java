package main;


import main.Dictionaries.Dictionary;
// Imports
import main.Dimensions.CompositeDimension;
import main.Dimensions.DimensionInterface;
import main.Dimensions.DimensionsContainer;
import main.Dimensions.MatchingWordsFromDictionary;
import main.Dimensions.NegationDimension;
import main.Dimensions.PercentageWordsCapturedFromDictionary;
import main.Dimensions.UniqueWordsDimension;
import main.Dimensions.WordsPerSentenceDimension;
import main.Dimensions.CharacterCountDimension.CommaCountDimension;
import main.Dimensions.CharacterCountDimension.WordCountDimension;
import main.Dimensions.PronounsDimension.PronounsDimension;
import main.Dimensions.PronounsDimension.PronounsFirstPersonDimension;
import main.Dimensions.PronounsDimension.PronounsFirstPersonPluralDimension;
import main.Dimensions.PronounsDimension.PronounsFirstPersonSingularDimension;
import main.Dimensions.PronounsDimension.PronounsSecondPersonDimension;
import main.Dimensions.PronounsDimension.PronounsThirdPersonDimension;
import main.Dimensions.SentencesEndingWithCharacterDimension.SentencesEndingWithQuestionMarkDimension;
import main.Dimensions.WordsLongerThanNCharactersDimension.WordsLongerThan15Dimension;
import main.Readers.FileReader;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;



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
		Dictionary thirdpersonpronounsdictionary = new Dictionary ();
		Dictionary negationsdictionary = new Dictionary ();

		
		
		// Create dictionaries
		try {
			fulldictionary.loadFromFile ("assets/dictionaries/english.txt");
			firstpersonsingularpronounsdictionary.loadFromFile ("assets/dictionaries/firstpersonsingularpronoums.txt");
			firstpersonpluralpronounsdictionary.loadFromFile ("assets/dictionaries/firstpersonpluralpronoums.txt");			
			secondpersonpronounsdictionary.loadFromFile("assets/dictionaries/secondpersonpronoums.txt");
			thirdpersonpronounsdictionary.loadFromFile("assets/dictionaries/thirdpersonpronoums.txt");
			negationsdictionary.loadFromFile("assets/dictionaries/negations.txt");
			
			
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
			
			
			// PRonoums
			.add (new PronounsDimension (
				new PronounsFirstPersonDimension (
					new PronounsFirstPersonSingularDimension (firstpersonsingularpronounsdictionary),
					new PronounsFirstPersonPluralDimension (firstpersonpluralpronounsdictionary)
				),
				new PronounsSecondPersonDimension (secondpersonpronounsdictionary),
				new PronounsThirdPersonDimension (secondpersonpronounsdictionary)
			))
			
			
			// Assets and negations
			.add (new NegationDimension (negationsdictionary))
			
			
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
				printStats (0, dimension);
			}
			

			
		} catch (Exception e) {
			System.out.println ("error");
			System.out.println (e);
		}
	}
	
	
	
	/**
	 * printStats
	 * 
	 * This function helps to print the herarchy of the dimensions
	 * with proper indentation level
	 * 
	 * @param level
	 * @param dimension
	 */
	public static void printStats (int level, DimensionInterface dimension) {
		
		// Create indentation
		String indent = new String (new char[level * 4]).replace('\0', ' ');
		
		
		// Print!
		System.out.println(indent + dimension.getDimensionKey () + " " + dimension.process());
		
		if (dimension instanceof CompositeDimension) {
			for (DimensionInterface subdimension : (CompositeDimension) dimension) {
				printStats (level + 1, subdimension);
			}
		}
	}
	
}

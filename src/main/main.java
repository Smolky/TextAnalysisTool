package main;


import main.Dictionaries.Dictionary;
// Imports
import main.Dimensions.CompositeDimension;
import main.Dimensions.DimensionInterface;
import main.Dimensions.DimensionsContainer;
import main.Dimensions.MatchingWordsFromDictionary;
import main.Dimensions.PercentageWordsCapturedFromDictionary;
import main.Dimensions.UniqueWordsDimension;
import main.Dimensions.CharacterCountDimension.CommaCountDimension;
import main.Dimensions.CharacterCountDimension.WordCountDimension;
import main.Dimensions.FunctionWordsDimension.AdverbsDimension;
import main.Dimensions.FunctionWordsDimension.ArticlesDimension;
import main.Dimensions.FunctionWordsDimension.AuxiliaryVerbsDimension;
import main.Dimensions.FunctionWordsDimension.ConjunctionsDimension;
import main.Dimensions.FunctionWordsDimension.NegationDimension;
import main.Dimensions.FunctionWordsDimension.PrepositionsDimension;
import main.Dimensions.FunctionWordsDimension.PronounsDimension;
import main.Dimensions.FunctionWordsDimension.PronounsFirstPersonDimension;
import main.Dimensions.FunctionWordsDimension.PronounsFirstPersonPluralDimension;
import main.Dimensions.FunctionWordsDimension.PronounsFirstPersonSingularDimension;
import main.Dimensions.FunctionWordsDimension.PronounsSecondPersonDimension;
import main.Dimensions.FunctionWordsDimension.PronounsThirdPersonDimension;
import main.Dimensions.Grammar.AdjectivesDimension;
import main.Dimensions.Grammar.ComparativesDimension;
import main.Dimensions.Grammar.InterrogativesDimension;
import main.Dimensions.Grammar.NumbersDimension;
import main.Dimensions.Grammar.RegularVerbsCountDimension;
import main.Dimensions.LanguageMetricsDimension.WordsLongerThan6Dimension;
import main.Dimensions.LanguageMetricsDimension.WordsPerSentenceDimension;
import main.Dimensions.SentencesEndingWithCharacterDimension.SentencesEndingWithQuestionMarkDimension;
import main.Dimensions.SummaryVariableDimension.AnalyticalThinkingDimension;
import main.Dimensions.SummaryVariableDimension.AuthenticDimension;
import main.Dimensions.SummaryVariableDimension.CloutDimension;
import main.Dimensions.SummaryVariableDimension.EmotionalToneDimension;
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
		
		// Dictory folder
		String dictionary_folder =  "assets/dictionaries/";
		
		
		// Start file reader
		FileReader filereader = new FileReader ();
		
		
		// Create the iterator
		DimensionsContainer dimensions = new DimensionsContainer ();
		
		
		// Create dictionaries
		try {
			
			// Create the dimensions
			dimensions
				.add (new WordCountDimension ())
				
				.add (new AnalyticalThinkingDimension (new Dictionary ()))
				.add (new CloutDimension (new Dictionary ()))
				.add (new AuthenticDimension (new Dictionary ()))
				.add (new EmotionalToneDimension (new Dictionary ()))
				
				.add (new WordsPerSentenceDimension ())
				.add (new WordsLongerThan6Dimension ())
				.add (new MatchingWordsFromDictionary (new Dictionary (dictionary_folder + "english.txt")))
				
				.add (
					new CompositeDimension ()
						
						.setDimensionKey("functionwords")

						// Pronombs
						.add (new PronounsDimension (
							new PronounsFirstPersonDimension (
								new PronounsFirstPersonSingularDimension (new Dictionary (dictionary_folder + "firstpersonsingularpronoums.txt")),
								new PronounsFirstPersonPluralDimension (new Dictionary (dictionary_folder + "firstpersonpluralpronoums.txt"))
							),
							new PronounsSecondPersonDimension (new Dictionary (dictionary_folder + "secondpersonpronoums.txt")),
							new PronounsThirdPersonDimension (new Dictionary (dictionary_folder + "thirdpersonpronoums.txt"))
						))
						
						.add (new ArticlesDimension (new Dictionary (dictionary_folder + "articles.txt")))
						.add (new PrepositionsDimension (new Dictionary (dictionary_folder + "prepositions.txt")))
						.add (new AuxiliaryVerbsDimension (new Dictionary (dictionary_folder + "auxiliaryverbs.txt")))
						.add (new AdverbsDimension (new Dictionary (dictionary_folder + "adverbs.txt")))
						.add (new ConjunctionsDimension (new Dictionary (dictionary_folder + "conjunctions.txt")))
						.add (new NegationDimension (new Dictionary (dictionary_folder + "negations.txt")))
				)
				
				.add (new RegularVerbsCountDimension ())
				.add (new AdjectivesDimension (new Dictionary (dictionary_folder + "adjectives.txt")))
				.add (new ComparativesDimension (new Dictionary (dictionary_folder + "comparatives.txt")))
				.add (new InterrogativesDimension (new Dictionary (dictionary_folder + "interrogatives.txt")))
				
				.add (new NumbersDimension ())
				
				
				.add (new CommaCountDimension ())
				.add (new SentencesEndingWithQuestionMarkDimension ())
				.add (new UniqueWordsDimension ())
				.add (new PercentageWordsCapturedFromDictionary ())
				.add (new MatchingWordsFromDictionary (new Dictionary (dictionary_folder + "english.txt")))
				
				
				
				
				// Emotion
				.add (new EmotionalToneDimension (new Dictionary (dictionary_folder + "mood.txt")))
				
				
				// Custom Composite dimension
				.add (
					new CompositeDimension ()
						.setDimensionKey("sample-composite")
						.add(new AdverbsDimension (new Dictionary (dictionary_folder + "adverbs.txt")))
					
				)
			;
			
		// Exception handling
		} catch (Exception e) {
			System.out.println ("error configuring dimensions");
			System.out.println (e);
			return;
		}
		
		
		// Start!
		try {

			// Read the assets
			String input = filereader.read ("assets/samples/sample-file-2.txt");
			
			
			// Read the asset
			Asset asset = new Asset ();
			asset.setAsset (input);
			
			
			// Set input
			for (DimensionInterface dimension : dimensions) {
				dimension.setInput (asset);
			}
			
			
			// Process
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

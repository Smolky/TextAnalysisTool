package es.um.dis.umutextstats;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import es.um.dis.umutextstats.configuration.ConfigurationLoader;
import es.um.dis.umutextstats.dimensions.CompositeDimension;
import es.um.dis.umutextstats.dimensions.DimensionInterface;


/**
 * main
 * 
 * @author José Antonio García Díaz
 * 
 * @package TestAnalysis
 */
public class main {

	/** String format will output with 16 characters*/
	
	public static String format = "%16s";
	
	
	/**
	 * main
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Configure Logger
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);
		
		
		// Prepare the application to use command line arguments
		// create Options object
		Options options = new Options();
		CommandLine cmd;
		
		
		Option configOption = Option.builder("c")
				.hasArg(true)
	            .required(false)
	            .desc("The path to the config file.")
	            .longOpt("source")
	            .build()
		;				
		
		Option sourceOption = Option.builder("s")
			.hasArg(true)
            .required(false)
            .desc("The path to the source files.")
            .longOpt("source")
            .build()
	    ;		
		
		
		// Add options
		options.addOption (sourceOption);
		options.addOption (configOption);
		
		
		// Convert the parameters to options
		CommandLineParser parser = new DefaultParser();
		try {
			cmd = parser.parse (options, args);
		} catch (ParseException e) {
			e.printStackTrace(System.out);
			return;
		}
		
		
		// Read parameters
		String source = "assets/samples";
		if (cmd.hasOption("s")) {
			source = cmd.getOptionValue ("s");
		}
		
		
		// Read parameters
		String config = "assets/configuration/spanish.xml";
		if (cmd.hasOption("c")) {
			config = cmd.getOptionValue ("c");
		}
		

		// Create the dimension container
		DimensionsContainer dimensions = new DimensionsContainer ();

		
		try {

			// Load the configuration
			ConfigurationLoader loader = new ConfigurationLoader (config);
			
			
			// Load the dimensions that we are going to use
			// based on our configuration
			dimensions = loader.LoadDimensions ();
			
			
			// Attach the unmatched dimensions with the dictionaries
			// based on the default key
			loader.loadDictionaries (dimensions);
			
			
			// Attach the taggers
			// Create tagger
			if (loader.getTagger() != null) {
				loader.loadTaggers (new MaxentTagger (loader.getTagger()), dimensions);
			}
			
			
		} catch (Exception e) {
			System.out.println ("error loading configuration");
			e.printStackTrace(System.out);
			return;
		}
			
		
		// Reference the folder
		File folder = new File (source);
		
		
		// Print keys
		for (DimensionInterface dimension : dimensions) {
			printKeys (0, dimension);
		}
		System.out.println ("");
		
		
		// Process the files
		for (File file : folder.listFiles()) {
			
			// Exclude dirs
			if ( ! file.isFile()) {
				continue;
			}
			
			
			// Get input
			String input = new String (Files.readAllBytes(Paths.get(file.getPath ())));
			
			
			// Get asset
			Asset asset = new Asset ();
			asset.setAsset (input);
			
			
			// Set input
			for (DimensionInterface dimension : dimensions) {
				dimension.setInput (asset);
			}

			
			for (DimensionInterface dimension : dimensions) {
				printCSVStats (dimension);
			}
			
			System.out.println ("");			
			
		}
	}
	
	
	/**
	 * printKeys
	 * 
	 * This function helps to print the hierarchy of the dimensions
	 * with proper indentation level
	 * 
	 * @param level
	 * @param dimension
	 */
	public static void printKeys (int level, DimensionInterface dimension) {
		
		// Print!
		System.out.format(format, dimension.getDimensionKey());
		
		
		if (dimension instanceof CompositeDimension) {
			for (DimensionInterface subdimension : (CompositeDimension) dimension) {
				printKeys (level + 1, subdimension);
			}
		}
	}	
	
	/**
	 * printStats
	 * 
	 * This function helps to print the hierarchy of the dimensions
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
	
	
	/**
	 * printCSVStats
	 * 
	 * This function helps to print the hierarchy of the dimensions
	 * with proper indentation level
	 * 
	 * @param level
	 * @param dimension
	 */
	public static void printCSVStats (DimensionInterface dimension) {
		
		// Print!
		System.out.format(format, dimension.process());
		
		
		if (dimension instanceof CompositeDimension) {
			for (DimensionInterface subdimension : (CompositeDimension) dimension) {
				printCSVStats (subdimension);
			}
		}
	}
	
}

package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import main.Configuration.ConfigurationLoader;
import main.Dimensions.CompositeDimension;
import main.Dimensions.DimensionInterface;


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
		
		
		// Add options
		options.addOption ("s", true, "Source");
		
		
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


		// Create the dimension container
		DimensionsContainer dimensions = new DimensionsContainer ();

		
		try {

			// Load the configuration
			ConfigurationLoader loader = new ConfigurationLoader ("sample-config.xml");
			
			
			// Load the dimensions that we are going to use
			// based on our configuration
			dimensions = loader.LoadDimensions ();
			
			
			// Attach the unmatched dimensions with the dictionaries
			// based on the default key
			loader.loadDictionaries (dimensions);
			
			
			// Attach the taggers
			// Create tagger
			MaxentTagger tagger = new MaxentTagger (loader.getTagger());
			
			
			// Tagger
			loader.loadTaggers (tagger, dimensions);
			
			
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
		
		String chars = new String (new char[level * 1]).replace('\0', '*');
		
		
		// Print!
		System.out.format("%16s", dimension.getDimensionKey() + " " + chars);
		
		
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
		System.out.format("%16s", dimension.process());
		
		
		if (dimension instanceof CompositeDimension) {
			for (DimensionInterface subdimension : (CompositeDimension) dimension) {
				printCSVStats (subdimension);
			}
		}
	}
	
}

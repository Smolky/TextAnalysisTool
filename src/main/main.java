package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import main.Configuration.ConfigurationLoader;
import main.Dimensions.CompositeDimension;
import main.Dimensions.DimensionInterface;
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
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Configure Logger
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);
		
		
		// Read parameters
		// create Options object
		Options options = new Options();
		CommandLine cmd;
		options.addOption("s", true, "Source");
		
		
		CommandLineParser parser = new DefaultParser();
		try {
			cmd = parser.parse (options, args);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		
		
		// Init pars
		String source = "sample-file-2.txt";
		if (cmd.hasOption("s")) {
			source = cmd.getOptionValue ("c");
		}


		// Create the dimension container
		DimensionsContainer dimensions = new DimensionsContainer ();

		
		try {

			// Create the loader
			ConfigurationLoader loader = new ConfigurationLoader ("sample-config.xml");
			
			
			// Fetch dimensions
			dimensions = loader.LoadDimensions ();
			
			
			// Load dictionaries
			loader.loadDictionaries (dimensions);
			
			
		} catch (Exception e) {
			System.out.println ("error loading configuration");
			e.printStackTrace(System.out);
			return;
		}
			
			
		// Start file reader
		FileReader filereader = new FileReader ();
		
		
		File folder = new File ("assets/samples");
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
		    
				String input = new String(Files.readAllBytes(Paths.get(listOfFiles[i].getPath())));
				Asset asset = new Asset ();
				asset.setAsset (input);
				
				// Set input
				for (DimensionInterface dimension : dimensions) {
					dimension.setInput (asset);
				}
				
				// Process
				if (i == 0) {
					for (DimensionInterface dimension : dimensions) {
						System.out.print (dimension.getDimensionKey() + " ");
					}
					System.out.println ("");
				}
				
				for (DimensionInterface dimension : dimensions) {
					printCSVStats (0, dimension);
				}
				
				System.out.println ("");
				
				
			}
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
	
	
	/**
	 * printCSVStats
	 * 
	 * This function helps to print the herarchy of the dimensions
	 * with proper indentation level
	 * 
	 * @param level
	 * @param dimension
	 */
	public static void printCSVStats (int level, DimensionInterface dimension) {
		
		// Print!
		System.out.print (dimension.process() + " ");
		
		if (dimension instanceof CompositeDimension) {
			for (DimensionInterface subdimension : (CompositeDimension) dimension) {
				printCSVStats (level + 1, subdimension);
			}
		}
	}
	
}

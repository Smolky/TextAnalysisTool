package main;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import main.Dictionaries.Dictionary;
import main.Dimensions.CompositeDimension;
import main.Dimensions.DimensionInterface;
import main.Dimensions.MatchingWordsFromDictionary;
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
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		// Init vars
		FileReader filereader;
	    
	    
		// Load configuration
		Configurations configs = new Configurations();
	    XMLConfiguration config;	    
		
		
		// Create the dimension container
		DimensionsContainer dimensions = new DimensionsContainer ();

		
		try {
			
			// Parse the configuration file
		    config = configs.xml ("assets/configuration/sample-config.xml");
		    
		    
		    // Package Dimensions
		    // @todo Fetch using reflection
		    String[] packages = {
		    	"",
		    	".AffectDimension",
		    	".BiologicalDimenssionProcesses",
		    	".CharacterCountDimension",
		    	".CognitiveProcesses",
		    	".CorePrinciplesDimension",
		    	".FunctionWordsDimension",
		    	".Grammar",
		    	".InformalSpeechDimenion",
		    	".LanguageMetricsDimension",
		    	".PerpetualProcessesDimension",
		    	".PersonalConcernsDimension",
		    	".RelativityDimension",
		    	".SentencesEndingWithCharacterDimension",
		    	".SocialDimension",
		    	".SummaryVariableDimension",
		    	".TimeOrientationDimension"
		    };
		    
		    
		    System.out.println("Loading dimensions...");

		    
		    // Search for the configuration
		    for (String key : config.getString ("dimensions").split(",")) {
		    	
		    	System.out.println ("   Loading..." + key);
		    	
		    	
		    	// Search!
		    	next_key_loop: {
		    		
		    		// Inside a package
		    		for (String internal_package : packages) {
		    		
		    			// Inside a class
					    for (Class test : getAllClasses ("main.Dimensions" + internal_package)) {
					    	
					    	// Reflection load of the class
					    	Class<?> c = Class.forName(test.getName());
					    	
					    	
					    	// Excluding base dimensions
					    	if (Modifier.isAbstract(c.getModifiers())) {
					    		continue;		
					    	}
					    	
					    	if (Modifier.isInterface(c.getModifiers())) {
					    		continue;		
					    	}
					    	
					    	
					    	// Looking for the constructor
					    	DimensionInterface o = (DimensionInterface) c.getConstructor().newInstance();
					    	Method method = c.getMethod ("getDimensionKey");
					    	String internal_key = (String) method.invoke (o);
					    	
					    	if ( ! key.equals(internal_key)) {
					    		continue;
					    	}
					    	
					    	dimensions.add(o);
					    	break next_key_loop;
					    	
					    }
		    		}
		    	}
		    }
			
		} catch (ConfigurationException e) {
		    System.out.println("config-error");
		    System.out.println(e);
		    return;
		}
	    
		
		System.out.println("Loading dictionaries...");

		
		// Configure dictionaries
		for (DimensionInterface dimension : dimensions) {

			// If the dimension contains a dictionary
	    	if (MatchingWordsFromDictionary.class.isAssignableFrom(dimension.getClass())) {
	    		
	    		Dictionary d = new Dictionary ();
	    		
	    		// Look for a dictionary
	    		try {
		    		d.loadFromFile (config.getString ("directory_folder") +dimension.getDimensionKey() + ".txt");
	    			
	    		} catch (Exception e) {
	    			// An empty dictionary will be used
	    			System.out.println("   Dictionary not found for " + dimension.getDimensionKey());
	    		}
	    		
	    		
	    		// Assign
	    		((MatchingWordsFromDictionary) dimension).setDictionary (d);
	    		
	    	}
		}
		
		
		// Start!
		try {
			
			// Start file reader
			filereader = new FileReader ();
			

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
	
	
	/**
	 * getAllClasses
	 * 
	 * @link https://coderanch.com/t/328491/java/classes-package-programatically
	 * 
	 * @param pckgname
	 * @return
	 */
	private static Class[] getAllClasses (String pckgname) {
		
		try {
		   
			ArrayList classes=new ArrayList();
			

			// Get a File object for the package 
		    File directory=null; 
		    
		    try { 
		    	directory=new File(Thread.currentThread().getContextClassLoader().getResource(pckgname.replace('.', '/')).getFile()); 
		    
		    } catch(NullPointerException x) { 
		    	System.out.println("Nullpointer");
		    	throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
		    } 
		    
		    if (directory.exists()) { 
		    	// Get the list of the files contained in the package 
		    	String[] files=directory.list(); 
		    	for (int i=0; i<files.length; i++) { 
		    		// we are only interested in .class files 
		    		if (files[i].endsWith(".class")) { 
		    			// removes the .class extension 
		    			classes.add(Class.forName(pckgname+'.'+files[i].substring(0, files[i].length()-6))); 
		    		} 
		    	}
		    	
		    } else { 
		    	
		    	System.out.println("Directory does not exist");
		    	throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
		    } 
		    
		    Class[] classesA=new Class[classes.size()]; 
		    classes.toArray (classesA); 
		     
		    return classesA;
		   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
}

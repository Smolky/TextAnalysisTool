package es.um.dis.umutextstats.configuration;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;

import es.um.dis.umutextstats.DimensionsContainer;
import es.um.dis.umutextstats.compositestrategies.CompositeStrategyInterface;
import es.um.dis.umutextstats.compositestrategies.CompositeStrategySum;
import es.um.dis.umutextstats.dictionaries.Dictionary;
import es.um.dis.umutextstats.dimensions.CharacterCountDimension;
import es.um.dis.umutextstats.dimensions.CharacterPercentageDimension;
import es.um.dis.umutextstats.dimensions.CompositeDimension;
import es.um.dis.umutextstats.dimensions.DimensionInterface;
import es.um.dis.umutextstats.dimensions.MatchingRegularExpressionsFromDictionary;
import es.um.dis.umutextstats.dimensions.PatternDimension;
import es.um.dis.umutextstats.dimensions.PatternPercentageDimension;
import es.um.dis.umutextstats.dimensions.WordsEqualToNDimension;
import es.um.dis.umutextstats.dimensions.WordsEqualToNPercentageDimension;
import es.um.dis.umutextstats.dimensions.WordsLongerThanNDimension;
import es.um.dis.umutextstats.dimensions.WordsLongerThanNPercentageDimension;


/**
 * ConfigurationLoader
 * 
 * This class parses the configuration files
 * and creates the dimensions
 * 
 * Configuration files are splitted in two files
 * - Base configuration
 * - Dimensions configuration
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class ConfigurationLoader {
	
	/** Configurations configs */
	protected Configurations abstractconfiguration;
	
	
	/** XMLConfiguration configuration */
	protected XMLConfiguration configuration;	    
	
	
    // Package Dimensions
    protected String[] packages = {
    	""
    };	
	
    
    /**
     * ConfigurationLoader
     * 
     * @param file
     * @throws ConfigurationException
     */
	public ConfigurationLoader (String file) throws ConfigurationException {
		
		// Load configuration
		this.abstractconfiguration = new Configurations();
		

		// Parse the configuration file
		configuration = abstractconfiguration.xml (file);
		
	}
	
	
	/**
	 * getTagger
	 * 
	 * @package TextAnalysis
	 */
	
	public String getTagger () {
		return configuration.getString ("tagger");	
	}
	
	
	/**
	 * LoadDimensions
	 * 
	 * This method will load all the dimensions 
	 * based on the configuration
	 * @throws Exception 
	 */
	public DimensionsContainer LoadDimensions () throws Exception {
		
		// Container
		DimensionsContainer dimensions = new DimensionsContainer ();
		
		
		// Get dimensions 
		List<HierarchicalConfiguration<ImmutableNode>> customdimension = configuration.configurationsAt ("dimensions(0).dimension");
		
	    
	    // Load complex dimensions
    	for (DimensionInterface dimension : createCustomDimension (customdimension)) {
    		dimensions.add (dimension);
    	}

	    
	    // Return the dimensions
	    return dimensions;
	    
	}
	
	
	/**
	 * loadDictionaries
	 * 
	 * This method will auto-load dictionaries
	 * to the dimensions that needs one to work
	 * 
	 * This function will try to guess what are
	 * the dictionary based on the key
	 * 
	 * Custom dictionaries can be used through 
	 * configuration files
	 * 
	 * @param dimensions
	 */
	public void loadDictionaries (DimensionsContainer dimensions) {
		this.assignDictionaries (dimensions.getDimensions ());
	}
	
	
	/**
	 * assignDictionaries
	 * 
	 * @param dimensions
	 */
	private void assignDictionaries (List<DimensionInterface> dimensions) {
		
		// Configure dictionaries
		for (DimensionInterface dimension : dimensions) {
			
    		// Assign children
    		if (dimension instanceof CompositeDimension) {
    			assignDictionaries (((CompositeDimension) dimension).getDimensions ());
    		}
			
			
			// Exclude dimensions which to allow dictionaries
			if ( ! (MatchingRegularExpressionsFromDictionary.class.isAssignableFrom (dimension.getClass()))) {
				continue;
			}
			
			
			// Exclude dimensions with custom dictionaries
			if (((MatchingRegularExpressionsFromDictionary) dimension).hasDictionary ()) {
				continue;
			}
			
			
	    	// Create our dictionary	
    		Dictionary d = new Dictionary ();
    		
    		
    		// Look for a dictionary
    		try {
	    		d.loadFromFile (configuration.getString ("directory_folder") + dimension.getDimensionKey() + ".txt");
    			
    		} catch (Exception e) {
    			// An empty dictionary will be used
    			System.err.println (" - Dictionary not found for " + configuration.getString ("directory_folder") + dimension.getDimensionKey());
    		}
	    		
	    		
    		// Assign
    		((MatchingRegularExpressionsFromDictionary) dimension).setDictionary (d);
	    		
		}
	}
	
	
	/**
	 * getAllClasses
	 * 
	 * Returns all classes inside a package
	 * 
	 * @link https://coderanch.com/t/328491/java/classes-package-programatically
	 * 
	 * @param pckgname
	 * @return Class
	 */
	private Class<DimensionInterface>[] getAllClasses (String pckgname) {
		
		try {
		    
			// Classes will store our results
			ArrayList classes = new ArrayList ();
			

			// Get a File object for the package 
		    File directory; 
		    
		    
		    // Load the package 
		    try { 
		    	directory = new File (
		    		Thread.currentThread ()
		    			.getContextClassLoader()
		    			.getResource (pckgname.replace('.', '/'))
		    			.getFile()
		    	); 
		    
		    } catch (NullPointerException x) { 
		    	System.out.println ("Nullpointer");
		    	throw new ClassNotFoundException (pckgname + " does not appear to be a valid package"); 
		    }
		    
		    
		    // IF we have found our package, then
		    // obtain the files withtin
		    if ( ! directory.exists ()) {
		    	System.out.println ("Directory does not exist");
		    	throw new ClassNotFoundException(pckgname + " does not appear to be a valid package"); 
		    } 		    	
		    	
		    
	    	// Get the list of the files contained in the package 
	    	String[] files = directory.list ();
		    	
		    	
	    	// Get the files
	    	for (int i=0; i<files.length; i++) { 

	    		// we are only interested in .class files 
	    		if ( ! files[i].endsWith(".class")) {
	    			continue;
	    		}
	    			
    			// removes the .class extension 
    			classes.add(Class.forName (pckgname + '.' + files[i].substring (0, files[i].length() - 6)));
	    			
	    	}
		    
		    
	    	// Convert the result in an array
		    Class[] classesA = new Class[classes.size()]; 
		    classes.toArray (classesA); 
		     
		    
		    // Return
		    return classesA;
		   
		// Generic error
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	/**
	 * getDimensionFromClass
	 * 
	 * Search into the packages looking for 
	 * the dimension which matches the class name
	 * 
	 * Can return null if no dimensions was found
	 * 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
 
	 * @throws InstantiationException 
	 * 
	 * @return DimensionInterface
	 */
	private DimensionInterface getDimensionFromClass (String class_name) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
	    	
    	// Reflection load of the class
    	Class<?> c = Class.forName("es.um.dis.umutextstats.dimensions." + class_name);
    	
    	
    	// Create the dimension
    	Constructor<?> constructor = c.getConstructor();
    	DimensionInterface instance = (DimensionInterface) constructor.newInstance();
    	return instance;
	    	
	}
	
	
	/**
	 * getStrategyFromClass
	 * 
	 * Search into the packages looking for 
	 * the dimension which matches the class name
	 * 
	 * Can return null if no dimensions was found
	 * 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
 
	 * @throws InstantiationException 
	 * 
	 * @return CompositeStrategyInterface
	 */
	private CompositeStrategyInterface getStrategyFromClass (String class_name) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
	    	
    	// Reflection load of the class
    	Class<?> c = Class.forName("es.um.dis.umutextstats.compositestrategies." + class_name);
    	
    	
    	// Create the dimension
    	CompositeStrategyInterface o = (CompositeStrategyInterface) c.getConstructor().newInstance();
    	
    	return o;
	    	
	}
	
	
	

	/**
	 * createCustomDimension
	 * 
	 * @param customdimension
	 * 
	 * @return DimensionInterface
	 * @throws Exception 
	 */
	private List<DimensionInterface> createCustomDimension (List<HierarchicalConfiguration<ImmutableNode>> customdimensions) throws Exception {
    	
		// Create our list
		List<DimensionInterface> dimensions = new ArrayList<DimensionInterface>();

		
		// Fetch dimensions
    	for (HierarchicalConfiguration<ImmutableNode> customdimension : customdimensions) {
    		
    		// Create dimension
        	DimensionInterface newDimension;
        	
        	
        	// Get params from
        	String custom_key = customdimension.getString ("key");
        	String custom_class = customdimension.getString ("class");
        	String length = customdimension.getString ("wordlength");
        	String character = customdimension.getString ("character");
        	String pattern = customdimension.getString ("pattern");
        	String strategy= customdimension.getString ("strategy");
        	String description = customdimension.getString ("description");
        	
        	List<HierarchicalConfiguration<ImmutableNode>> inner_dimensions_config = customdimension.configurationsAt ("dimensions.dimension");
	    	
	    	
	    	// If the dimension has sub dimensions is a composite one
	    	if (inner_dimensions_config.size() > 0) {
	    		newDimension = new CompositeDimension ();
	    		
	    		CompositeStrategyInterface CompositeStrategy;
	    		if (strategy != null) {
	    			CompositeStrategy = getStrategyFromClass (strategy);
	    			
	    		} else {
	    			CompositeStrategy = new CompositeStrategySum ();
	    		}
	    		
	    		((CompositeDimension) newDimension).setStrategy (CompositeStrategy);
	    	
	    	// If the dimension has a specific class load it.
	    	} else if (custom_class != null) {
	    		newDimension = getDimensionFromClass (custom_class);
	    		
	    	} else {
	    		// @todo. Throw correct exception
	    		throw new Exception ("error in config: " + custom_key);
	    		
	    	}
	    	
	    	
	    	// No dimension found!
	    	if (newDimension == null) {
	    		// continue;
	    	}

    	
	    	// Assign key
	    	newDimension.setDimensionKey (custom_key);
	    	
	    	
	    	// Assign description
	    	newDimension.setDescription (description);
	    	
	    	
	    	// Assign length
	    	if (length != null && newDimension instanceof WordsLongerThanNDimension) {
	    		((WordsLongerThanNDimension) newDimension).setLength (Integer.valueOf(length));	 
	    	}
	    	
	    	if (length != null && newDimension instanceof WordsLongerThanNPercentageDimension) {
	    		((WordsLongerThanNPercentageDimension) newDimension).setLength (Integer.valueOf(length));	 
	    	}
	    	
	    	if (length != null && newDimension instanceof WordsEqualToNDimension) {
	    		((WordsEqualToNDimension) newDimension).setLength (Integer.valueOf(length));	 
	    	}
	    	
	    	if (length != null && newDimension instanceof WordsEqualToNPercentageDimension) {
	    		((WordsEqualToNPercentageDimension) newDimension).setLength (Integer.valueOf(length));	 
	    	}
	    	
	    	
	    	// Assign character
	    	if (character != null && newDimension instanceof CharacterCountDimension) {
	    		((CharacterCountDimension) newDimension).setChar (character);	 
	    	}
	    	
	    	if (character != null && newDimension instanceof CharacterPercentageDimension) {
	    		((CharacterPercentageDimension) newDimension).setChar (character);	 
	    	}		    	
	    	
	    	
	    	// Assign pattern
	    	if (pattern != null && newDimension instanceof PatternDimension) {
	    		((PatternDimension) newDimension).setPattern (pattern);	 
	    	}
	    	
	    	if (pattern != null && newDimension instanceof PatternPercentageDimension) {
	    		((PatternPercentageDimension) newDimension).setPattern (pattern);	 
	    	}	 	    	
	    	
	    	
	    	
	    	// Load custom dictionary
	    	if (newDimension instanceof MatchingRegularExpressionsFromDictionary) {
	    		
	    		// Load dictionary
	    		String dictionary = customdimension.getString("dictionary");
	    		if (dictionary != null) {
	
	    			// Create
	    			Dictionary d = new Dictionary ();
	    		
		    		// Look for a dictionary
		    		try {
			    		d.loadFromFile (configuration.getString ("directory_folder") + dictionary + ".txt");
		    			
		    		} catch (Exception e) {
		    			// An empty dictionary will be used
		    			System.err.println("   Dictionary not found for " + configuration.getString ("directory_folder") + dictionary);
		    		}
		    		
		    		
		    		// Assign
		    		((MatchingRegularExpressionsFromDictionary) newDimension).setDictionary (d);	    		
		    		
	    		}
	    	}
	    	
	    	
	    	// Load sub dimensions for composite dimensions
	    	if (newDimension instanceof CompositeDimension) {
	    		
	    		List<DimensionInterface> subdimensions = new ArrayList<DimensionInterface>();
	    		subdimensions = createCustomDimension (inner_dimensions_config);
	    		
	    		for (DimensionInterface subdimension : subdimensions) {
	    			((CompositeDimension) newDimension).add(subdimension);
	    		}
	    	}    	
	
	    	
	    	
	    	dimensions.add (newDimension);
	    	
		}
    	
    	
		return dimensions;

    	
	}
}

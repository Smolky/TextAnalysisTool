package main.Configuration;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;

import main.DimensionsContainer;
import main.Dictionaries.Dictionary;
import main.Dimensions.CompositeDimension;
import main.Dimensions.DimensionInterface;
import main.Dimensions.MatchingWordsFromDictionary;


/**
 * ConfigurationLoader
 * 
 * This class parses the configuration files
 * and creates the dimensions 
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class ConfigurationLoader {
	
	/** Configurations configs */
	protected Configurations abstractconfiguration;
	
	
	/** XMLConfiguration configuration */
	protected XMLConfiguration configuration;	    
	
	
    // Package Dimensions
    // @todo Fetch using reflection
    protected String[] packages = {
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
		configuration = abstractconfiguration.xml ("assets/configuration/" + file);
		
	}
	
	
	/**
	 * LoadDimensions
	 * 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public DimensionsContainer LoadDimensions () throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		// Container
		DimensionsContainer dimensions = new DimensionsContainer ();
		
		
		// Get dimensions 
		List<HierarchicalConfiguration<ImmutableNode>> customdimension = configuration.configurationsAt ("dimensions(0).dimension");
		
	    
	    // Load complex dimensions
    	for (DimensionInterface dimension : createCustomDimension (customdimension)) {
    		dimensions.add (dimension);
    	}

	    
	    
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
		
		// Configure dictionaries
		for (DimensionInterface dimension : dimensions) {
			
			// Exclude dimensions which to allow dictionaries
			if ( ! (MatchingWordsFromDictionary.class.isAssignableFrom(dimension.getClass()))) {
				continue;
			}
			
			
			// Exclude dimensions with custom dictionaries
			if (((MatchingWordsFromDictionary) dimension).hasDictionary ()) {
				continue;
			}
			
			
	    	// Create our dictionary	
    		Dictionary d = new Dictionary ();
    		
    		
    		// Look for a dictionary
    		try {
	    		d.loadFromFile (configuration.getString ("directory_folder") +dimension.getDimensionKey() + ".txt");
    			
    		} catch (Exception e) {
    			// An empty dictionary will be used
    			System.out.println("   Dictionary not found for " + dimension.getDimensionKey());
    		}
	    		
	    		
    		// Assign
    		((MatchingWordsFromDictionary) dimension).setDictionary (d);
	    		
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
	private Class<DimensionInterface>[] getAllClasses (String pckgname) {
		
		try {
		    
			// Classes will store our results
			ArrayList classes = new ArrayList();
			

			// Get a File object for the package 
		    File directory=null; 
		    
		    
		    // Load the package 
		    try { 
		    	directory = new File(Thread.currentThread().getContextClassLoader().getResource(pckgname.replace('.', '/')).getFile()); 
		    
		    } catch(NullPointerException x) { 
		    	System.out.println("Nullpointer");
		    	throw new ClassNotFoundException (pckgname + " does not appear to be a valid package"); 
		    }
		    
		    
		    // IF we have found our package, then
		    // obtain the files withtin
		    if ( ! directory.exists()) {
		    	System.out.println("Directory does not exist");
		    	throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
		    } 		    	
		    	
		    
	    	// Get the list of the files contained in the package 
	    	String[] files = directory.list();
		    	
		    	
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
	 * getDimensionFromKey
	 * 
	 * Search into the packages looking for 
	 * the dimension which matches the key
	 * 
	 * Can return null if no dimensions was found
	 * 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 * @return DimensionInterface
	 */
	private DimensionInterface getDimensionFromKey (String key) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		// Container
		DimensionsContainer dimensions = new DimensionsContainer ();
	    	
    		
		// Inside a package
		for (String internal_package : packages) {
		
			// Inside a class
		    for (Class<DimensionInterface> test : getAllClasses ("main.Dimensions" + internal_package)) {
		    	
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
		    	
		    	if ( ! key.toLowerCase ().equals(internal_key.toLowerCase ())) {
		    		continue;
		    	}
		    	
		    	return o;
		    	
		    }
		}
		
		
		// No one found!
		return null;
	}
	

	/**
	 * createCustomDimension
	 * 
	 * @param customdimension
	 * 
	 * @return DimensionInterface
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 */
	private List<DimensionInterface> createCustomDimension (List<HierarchicalConfiguration<ImmutableNode>> customdimensions) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
    	
		// Create our list
		List<DimensionInterface> dimensions = new ArrayList<DimensionInterface>();

		
		// Fetch dimensions
    	for (HierarchicalConfiguration<ImmutableNode> customdimension : customdimensions) {
    		
    		// Create dimension
        	DimensionInterface newDimension;
    		
    	    	
	    	// Create custom dimension
	    	// Composite dimensions
	    	
	    	List<HierarchicalConfiguration<ImmutableNode>> customDimensionsParent2 = customdimension.configurationsAt ("dimensions.dimension");
	    	if (customDimensionsParent2.size() > 0) {
	    		newDimension = new CompositeDimension ();
	    		
	    	} else {
	    		newDimension = getDimensionFromKey (customdimension.getString ("key"));
	    		
	    	}

    	
	    	// Assign key
	    	newDimension.setDimensionKey (customdimension.getString("key"));
	    	
	    	
	    	// Load custom dictionary
	    	if (newDimension instanceof MatchingWordsFromDictionary) {
	    		
	    		// Load dictionary
	    		String dictionary = customdimension.getString("dictionary");
	    		if (dictionary != null) {
	
	    			// Create
	    			Dictionary d = new Dictionary ();
	    		
		    		// Look for a dictionary
		    		try {
			    		d.loadFromFile (configuration.getString ("directory_folder")  + dictionary + ".txt");
		    			
		    		} catch (Exception e) {
		    			// An empty dictionary will be used
		    			System.out.println("   Dictionary not found for " + dictionary);
		    		}
		    		
		    		
		    		// Assign
		    		((MatchingWordsFromDictionary) newDimension).setDictionary (d);	    		
		    		
	    		}
	    		
	    	}
	    	
	    	
	    	// Load sub dimensions for composite dimensions
	    	if (newDimension instanceof CompositeDimension) {
	    		
	    		List<DimensionInterface> subdimensions = new ArrayList<DimensionInterface>();
	    		subdimensions = createCustomDimension (customDimensionsParent2);
	    		
	    		for (DimensionInterface subdimension : subdimensions) {
	    			((CompositeDimension) newDimension).add(subdimension);
	    		}
	    	}    	
	
	    	
	    	
	    	dimensions.add (newDimension);
	    	
		}
    	
    	
		// Create dimension
    	DimensionInterface newDimension;
		return dimensions;

    	
	}
}

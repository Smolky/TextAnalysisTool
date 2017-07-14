package es.um.dis.umutextstats.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import es.um.dis.umutextstats.dictionaries.Dictionary;
import es.um.dis.umutextstats.dimensions.MatchingRegularExpressionsFromDictionary;
import es.um.dis.umutextstats.dimensions.EmoticonsDimension;


/**
 * MatchingWordsFromDictionaryTest
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class EmoticonsDimensionTest {

	@Test
	public void test() {
		
		// Create dimension
		EmoticonsDimension dimension = new EmoticonsDimension (); 
		
		
		// Create a dictionary
		Dictionary dictionary = new Dictionary ();
		dictionary
			.clear ()
			.add (":(")
		;
		
		
		// Create the class to be tested
		dimension.setDictionary(dictionary);
		
		
		// Test
		assertTrue (dimension.setInput ("I feel blue :(").process () == 1);
		
	}

}

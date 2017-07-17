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
		
		
		// Test
		assertTrue (dimension.setInput ("Text with no emoticons").process () == 0);
		assertTrue (dimension.setInput ("Text between (parenthesis)").process () == 0);
		assertTrue (dimension.setInput (":(").process () == 1);
		assertTrue (dimension.setInput (":((").process () == 1);
		assertTrue (dimension.setInput ("At the begining :(").process () == 1);
		assertTrue (dimension.setInput (":( At the end").process () == 1);
		assertTrue (dimension.setInput ("I feel blue :( right now").process () == 1);
		
		
		// With texts
		assertTrue (dimension.setInput (":wink:").process () == 1);
		

		
	}

}

package es.um.dis.umutextstats.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.um.dis.umutextstats.dictionaries.Dictionary;
import es.um.dis.umutextstats.dimensions.MatchingWordsFromDictionary;


/**
 * MatchingWordsFromDictionaryTest
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class MatchingWordsFromDictionaryTest {

	@Test
	public void test() {
		
		// Create a dictionary
		Dictionary dictionary = new Dictionary ();
		dictionary
			.clear ()
			.add ("lorem")
			.add ("ipsum")
		;
		
		
		// Create the class to be tested
		MatchingWordsFromDictionary dimension = new MatchingWordsFromDictionary ();
		dimension.setDictionary(dictionary);
		
		
		// Base test
		assertTrue (dimension.setInput ("dolor").process () == 0);
		assertTrue (dimension.setInput ("lorem").process () == 1);
		assertTrue (dimension.setInput ("lorem").process () == 1);
		assertTrue (dimension.setInput ("lorem lorem").process () == 2.0);
		assertTrue (dimension.setInput ("loremlorem").process () == 0);
		
		
		// Complex words
		dictionary.clear ();
		dictionary
			.clear ()
			.add ("as part of")
		;
		
		assertTrue (dimension.setInput ("as").process () == 0);
		assertTrue (dimension.setInput ("as part of").process () == 1);
		assertTrue (dimension.setInput ("assuming A as part of B").process () == 1);
		
		
		// Formated text
		assertTrue (dimension.setInput ("<strong>as part of B</strong>").process () == 1);
		assertTrue (dimension.setInput ("<b>as part of B</b>").process () == 1);
		
		
		// Regular expressions
		// Complex words
		dictionary.clear ();
		dictionary
			.clear ()
			.add ("lorem.*")
		;
		
		assertTrue (dimension.setInput ("lorem").process () == 1);
		assertTrue (dimension.setInput ("lorema").process () == 1);
		assertTrue (dimension.setInput ("loremb").process () == 1);
		assertTrue (dimension.setInput ("loremaa").process () == 1);
		assertTrue (dimension.setInput ("loremaab").process () == 1);
		

	}

}

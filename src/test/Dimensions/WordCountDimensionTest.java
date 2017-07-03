package test.Dimensions;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Dimensions.WordCountDimension;

/**
 * WordCountDimensionTest

 * 
 * @author José Antonio García Díaz
 * @package TextAnalysis
 *
 */
public class WordCountDimensionTest {

	@Test
	public void test() {
		
		// Create the class to be tested
		WordCountDimension dimension = new WordCountDimension ();
		
		
		// Empty words
		assertTrue (dimension.setInput ("").process () == 0.0);
		
		
		// Combinations of one word
		assertTrue (dimension.setInput ("lorem").process () == 1.0);
		assertTrue (dimension.setInput ("lorem ").process () == 1.0);
		assertTrue (dimension.setInput (" lorem").process () == 1.0);
		assertTrue (dimension.setInput (" lorem ").process () == 1.0);
		
		
		// Combinations of two words
		assertTrue (dimension.setInput ("lorem ipsum").process () == 2.0);
		assertTrue (dimension.setInput ("lorem   ipsum").process () == 2.0);
		assertTrue (dimension.setInput ("lorem \n  ipsum").process () == 2.0);
		assertTrue (dimension.setInput ("lorem?.\n<p>ipsum</p>").process () == 2.0);
		assertTrue (dimension.setInput ("lorem\r\nipsum").process () == 2.0);
		
		
		// Combinations of three words
		assertTrue (dimension.setInput ("lorem ipsum dolor").process () == 3.0);
		assertFalse (dimension.setInput ("lorem.ipsum.dolor").process () == 3.0);
		assertTrue (dimension.setInput ("lorem. ipsum. dolor").process () == 3.0);
		assertTrue (dimension.setInput ("\r\n lorem. ipsum. dolor").process () == 3.0);
		
		
	}

}

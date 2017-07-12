package es.um.dis.textstats.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.um.dis.textstats.dimensions.WordsPerSentenceDimension;


/**
 * WordsPerSentenceDimensionTest
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class WordsPerSentenceDimensionTest {

	@Test
	public void test() {
		
		// Create the class to be tested
		WordsPerSentenceDimension dimension = new WordsPerSentenceDimension ();
		
		
		// Empty words
		assertTrue (dimension.setInput ("").process () == 0.0);
		
		
		// One word per sentence
		assertTrue (dimension.setInput ("lorem").process () == 1.0);
		assertTrue (dimension.setInput ("lorem. ipsum").process () == 1.0);		
		assertTrue (dimension.setInput ("lorem. ipsum. dolor").process () == 1.0);
		
		
		// Two words per sentence
		assertTrue (dimension.setInput ("lorem ipsum").process () == 2.0);
		assertTrue (dimension.setInput ("lorem ipsum. dolor amet.").process () == 2.0);
		
		
		// Mixed values
		assertTrue (dimension.setInput ("lorem ipsum. amet.").process () == 1.5);
		assertTrue (dimension.setInput ("lorem ipsum. amet").process () == 1.5);

	}

}

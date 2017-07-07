package test.Dimensions;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Dimensions.WordCountDimension;
import main.Dimensions.LanguageMetricsDimension.WordsPerSentenceDimension;

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

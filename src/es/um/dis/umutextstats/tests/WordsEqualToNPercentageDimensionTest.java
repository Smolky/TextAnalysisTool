package es.um.dis.umutextstats.tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import es.um.dis.umutextstats.dimensions.WordsEqualToNPercentageDimension;



/**
 * WordsEqualToNPercentageDimensionTest
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class WordsEqualToNPercentageDimensionTest {

	@Test
	public void test() {
		
		// Create the class to be tested
		WordsEqualToNPercentageDimension dimension = new WordsEqualToNPercentageDimension ();
		dimension.setLength (4);
		
		// Empty words
		assertTrue (dimension.setInput ("mi casa es bonita").process () == 25);
		

	}

}

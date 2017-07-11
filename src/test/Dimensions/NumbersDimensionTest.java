package test.Dimensions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Dimensions.NumbersDimension;


/**
 * NumbersDimensionTest
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class NumbersDimensionTest {

	@Test
	public void test() {
		
		// Create the class to be tested
		NumbersDimension dimension = new NumbersDimension ();
		
		// Sample cases
		assertTrue (dimension.setInput ("").process () == 0);
		assertTrue (dimension.setInput ("0").process () == 1);
		assertTrue (dimension.setInput ("3").process () == 1);
		
		
		// Negative
		assertTrue (dimension.setInput ("-1").process () == 1);
		assertTrue (dimension.setInput (".3").process () == 1);
		
		
		// Decimals
		assertTrue (dimension.setInput ("30.3").process () == 1);
		assertTrue (dimension.setInput ("30,3").process () == 2);
		assertTrue (dimension.setInput ("30, 3").process () == 2);
		
		
		// Scientific notation
		assertTrue (dimension.setInput ("7.51e9").process () == 1);
		assertTrue (dimension.setInput ("-4.70e+9").process () == 1);
		
		
		// Context numbers
		assertTrue (dimension.setInput ("123-456-7890").process () == 1);
		
		
		// Mixed
		assertTrue (dimension.setInput ("lorem 30").process () == 1);
		assertTrue (dimension.setInput ("lorem 30 ipsum").process () == 1);
		assertTrue (dimension.setInput ("123-456-7890 50").process () == 2);
		
		
	}

}

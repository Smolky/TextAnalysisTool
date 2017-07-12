package es.um.dis.textstats.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import es.um.dis.textstats.dimensions.PatternDimension;


/**
 * PatternDimensionTest
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class PatternDimensionTest {

	@Test
	public void test() {
		
		// Create dimension
		PatternDimension dimension = new PatternDimension ();
		
		// Test
		assertTrue (dimension.setInput ("lorem").setPattern ("lorem").process () == 1);
		
		
	}

}

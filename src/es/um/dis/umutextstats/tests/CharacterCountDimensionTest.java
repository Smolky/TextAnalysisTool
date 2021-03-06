package es.um.dis.umutextstats.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import es.um.dis.umutextstats.dimensions.CharacterCountDimension;


/**
 * CharacterCountDimensionTest
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class CharacterCountDimensionTest {

	@Test
	public void test() {
		
		// Create class to test
		CharacterCountDimension dimension = new CharacterCountDimension ();
		
		
		// Base test case
		assertTrue (dimension.setChar (".").setInput ("").process () == 0);
		assertTrue (dimension.setChar ("").setInput (".").process () == 0);
		assertTrue (dimension.setChar (".").setInput (".").process () == 1);
		
		
		// With more results
		assertTrue (dimension.setChar (".").setInput ("..").process () == 2);
		assertTrue (dimension.setChar (".").setInput (".#.").process () == 2);
		assertTrue (dimension.setChar (" ").setInput ("lorem ipsum").process () == 1);
		assertTrue (dimension.setChar (".").setInput ("lorem ipsum. dolor amet.").process () == 2);
		assertTrue (dimension.setChar ("!").setInput ("!!!!").process () == 4);
		
		
		// Scape chars
		assertTrue (dimension.setChar ("\"").setInput ("\"").process () == 1);
		assertFalse (dimension.setChar ("\"").setInput ("\"").process () != 1);
		
		
		// Double
		assertTrue (dimension.setChar ("()").setInput ("(lorem)").process () == 2);
		assertTrue (dimension.setChar ("'").setInput ("Lorem's ipsum").process () == 1);
		
	}

}

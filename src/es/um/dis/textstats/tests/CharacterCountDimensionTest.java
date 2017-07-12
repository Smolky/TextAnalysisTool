package es.um.dis.textstats.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import es.um.dis.textstats.dimensions.CharacterCountDimension;


/**
 * CharacterCountDimensionTest
 *
 * @author José Antonio García Díaz
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
		
		
		// Base test case
		
	}

}

package es.um.dis.textstats.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import es.um.dis.textstats.dimensions.UniqueWordsDimension;

/**
 * UniqueWordsDimensionTest
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class UniqueWordsDimensionTest {

	@Test
	public void test() {
		
		// Create dimension
		UniqueWordsDimension dimension = new UniqueWordsDimension ();
		
		
		// Test
		assertTrue (dimension.setInput ("").process () == 0);
		assertTrue (dimension.setInput ("lorem").process () == 1);
		assertTrue (dimension.setInput ("lorem lorem").process () == 1);
		assertTrue (dimension.setInput ("lorem ipsum").process () == 2);
		assertTrue (dimension.setInput ("composed.word").process () == 1);
		assertTrue (dimension.setInput ("composed. word.").process () == 2);
		
		
	}

}

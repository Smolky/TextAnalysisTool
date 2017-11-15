package es.um.dis.umutextstats.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import es.um.dis.umutextstats.Asset;
import es.um.dis.umutextstats.compositestrategies.CompositeStrategyAvg;
import es.um.dis.umutextstats.compositestrategies.CompositeStrategyMax;
import es.um.dis.umutextstats.compositestrategies.CompositeStrategyMin;
import es.um.dis.umutextstats.compositestrategies.CompositeStrategySum;
import es.um.dis.umutextstats.dimensions.CompositeDimension;
import es.um.dis.umutextstats.dimensions.WordCountDimension;
import es.um.dis.umutextstats.dimensions.WordsPerSentenceDimension;

public class CompositeDimensionTest {

	@Test
	public void test() {
		
		// Class to test
		CompositeDimension dimension = new CompositeDimension ();
		
		
		// Dimensions
		dimension.add(new WordCountDimension ());
		dimension.add(new WordsPerSentenceDimension ());
		
		
		// Input
		Asset asset = new Asset ();
		asset.setAsset ("Lorem. Lorem Ipsum");
		
		
		
		
		// Sample patterns
		assertTrue (dimension.setInput (asset).setStrategy (new CompositeStrategySum ()).process () == Double.sum(3, (3.0 / 2.0)));
		assertTrue (dimension.setInput (asset).setStrategy (new CompositeStrategyMax ()).process () == Double.max(3, (3.0 / 2.0)));
		assertTrue (dimension.setInput (asset).setStrategy (new CompositeStrategyMin ()).process () == Double.min(3, (3.0 / 2.0)));
		assertTrue (dimension.setInput (asset).setStrategy (new CompositeStrategyAvg ()).process () == Double.sum (3, (3.0 / 2.0)) / 2);
		
	}

}

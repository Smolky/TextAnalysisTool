package es.um.dis.umutextstats.compositestrategies;

import java.util.List;

import es.um.dis.umutextstats.dimensions.DimensionInterface;

/**
 * CompositeStrategySum
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class CompositeStrategySum implements CompositeStrategyInterface {

	@Override
	public double process(List<DimensionInterface> dimensions) {
		
		double result = 0;
		for (DimensionInterface dimension : dimensions) {
			result += dimension.process ();
		}
		
		return result;
	}
}

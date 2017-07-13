package es.um.dis.umutextstats.compositestrategies;

import java.util.List;

import es.um.dis.umutextstats.dimensions.DimensionInterface;

/**
 * CompositeStrategyMin
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class CompositeStrategyMin implements CompositeStrategyInterface {

	@Override
	public double process(List<DimensionInterface> dimensions) {
		
		double result = Double.POSITIVE_INFINITY;
		
		for (DimensionInterface dimension : dimensions) {
			if (dimension.process () < result) {
				result = dimension.process ();
			}
		}
		
		return result;
	}
}

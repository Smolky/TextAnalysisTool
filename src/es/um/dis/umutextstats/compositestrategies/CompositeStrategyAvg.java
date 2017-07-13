package es.um.dis.umutextstats.compositestrategies;

import java.util.List;

import es.um.dis.umutextstats.dimensions.DimensionInterface;

/**
 * CompositeStrategyAvg
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class CompositeStrategyAvg implements CompositeStrategyInterface {

	@Override
	public double process(List<DimensionInterface> dimensions) {
		
		double result = 0;
		
		if (dimensions.size () == 0) {
			return 0;
		}
		
		for (DimensionInterface dimension : dimensions) {
			result += dimension.process ();
		}
		
		return result / dimensions.size ();
	}
}

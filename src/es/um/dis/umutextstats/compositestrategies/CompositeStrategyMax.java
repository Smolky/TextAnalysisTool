package es.um.dis.umutextstats.compositestrategies;

import java.util.List;

import es.um.dis.umutextstats.dimensions.DimensionInterface;

/**
 * CompositeStrategyMax
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class CompositeStrategyMax implements CompositeStrategyInterface {

	@Override
	public double process(List<DimensionInterface> dimensions) {
		
		double result = 0;
		
		for (DimensionInterface dimension : dimensions) {
			if (dimension.process () > result) {
				result = dimension.process ();
			}
		}
		
		return result;
	}
}

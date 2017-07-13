package es.um.dis.umutextstats.compositestrategies;

import java.util.List;

import es.um.dis.umutextstats.dimensions.DimensionInterface;

/**
 * CompositeStrategyInterface
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public interface CompositeStrategyInterface {
	
	/**
	 * process
	 * @param dimensions
	 * @return
	 */
	public double process (List<DimensionInterface> dimensions) ;
		
}

package es.um.dis.umutextstats.compositestrategies;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
		
		
		// Calculate percentage
		BigDecimal bd = new BigDecimal (100 * result / dimensions.size ());
		bd = bd.setScale (2, RoundingMode.HALF_UP);
		
		
		// Return the average value
		return bd.doubleValue();			
		
	}
}

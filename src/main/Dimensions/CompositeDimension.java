package main.Dimensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.Asset;
import main.helpers.ExtractSentencesFromString;

/**
 * CompositeDimension
 * 
 * This dimension allows to create dimension with the
 * composite pattern
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
abstract public class CompositeDimension extends BaseDimension implements Iterable<DimensionInterface> {
	
	/** List<DimensionInterface> dimensions */
	protected List<DimensionInterface> dimensions = new ArrayList<DimensionInterface>();
	
	
	@Override
	public Iterator<DimensionInterface> iterator() {
		return this.dimensions.iterator();
	}	
	
	
	/**
	 * add
	 * @param dimension
	 */
	public void add (DimensionInterface dimension) {
		this.dimensions.add(dimension);
	}
	
	
	/**
	 * setInput
	 * 
	 * @override
	 */	
	public BaseDimension setInput (Asset asset) {
		for (DimensionInterface dimension : this.dimensions) {
			dimension.setInput(asset);
		}
		return this;
	}
	
	
	/**
	 * setInput
	 * 
	 * @override
	 */	
	public BaseDimension setInput (String asset) {
		for (DimensionInterface dimension : this.dimensions) {
			dimension.setInput(asset);
		}
		return this;
	}
	

	/**
	 * process
	 */
	public double process () {
		
		double result = 0;
		for (DimensionInterface dimension : this.dimensions) {
			result += dimension.process ();
		}
		
		return result;
	} 
	
}

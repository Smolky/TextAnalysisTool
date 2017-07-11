package main.Dimensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.Asset;

/**
 * CompositeDimension
 * 
 * This dimension allows to create dimension with the
 * composite pattern
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class CompositeDimension extends BaseDimension implements Iterable<DimensionInterface> {
	
	/** List<DimensionInterface> dimensions */
	protected List<DimensionInterface> dimensions = new ArrayList<DimensionInterface>();
	
	
	@Override
	public Iterator<DimensionInterface> iterator() {
		return this.dimensions.iterator();
	}
	
	
	/**
	 * getDimensions
	 * 
	 * @return List<DimensionInterface>
	 */
	public List<DimensionInterface> getDimensions () {
		return this.dimensions;
	}	
	
	
	/**
	 * setDimensionKey
	 * 
	 * @return String
	 */
	public CompositeDimension setDimensionKey (String key) {
		this.key = key;
		return this;
	}	
	
	
	/**
	 * add
	 * @param dimension
	 */
	public CompositeDimension add (DimensionInterface dimension) {
		this.dimensions.add(dimension);
		return this;
	}
	
	
	/**
	 * setInput
	 * 
	 * @override
	 */	
	public BaseDimension setInput (Asset asset) {
		super.setInput(asset);
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
		super.setInput(asset);
		for (DimensionInterface dimension : this.dimensions) {
			dimension.setInput(asset);
		}
		return this;
	}
	

	/**
	 * process
	 */
	public double subprocess () {
		
		double result = 0;
		for (DimensionInterface dimension : this.dimensions) {
			result += dimension.process ();
		}
		
		return result;
	} 
	
}

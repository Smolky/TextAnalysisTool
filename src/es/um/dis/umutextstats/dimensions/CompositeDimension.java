package es.um.dis.umutextstats.dimensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.um.dis.umutextstats.Asset;
import es.um.dis.umutextstats.compositestrategies.CompositeStrategyInterface;

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
public class CompositeDimension extends BaseDimension implements Iterable<DimensionInterface> {
	
	/** List<DimensionInterface> dimensions */
	protected List<DimensionInterface> dimensions = new ArrayList<DimensionInterface>();
	protected CompositeStrategyInterface strategy;
	
	
	@Override
	public Iterator<DimensionInterface> iterator() {
		return this.dimensions.iterator();
	}
	
	
	/**
	 * getStrategy
	 * 
	 * @return List<DimensionInterface>
	 */
	public CompositeStrategyInterface getStrategy () {
		return this.strategy;
	}
	
	
	/**
	 * setStrategy
	 * 
	 * @return CompositeDimension
	 */
	public CompositeDimension setStrategy (CompositeStrategyInterface strategy) {
		this.strategy = strategy;
		return this;
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
	public CompositeDimension setInput (Asset asset) {
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
	public CompositeDimension setInput (String asset) {
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
		return this.getStrategy ().process(dimensions);
	} 
	
}

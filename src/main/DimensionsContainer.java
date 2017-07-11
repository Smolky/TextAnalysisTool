package main;

import java.util.List;

import main.Dimensions.DimensionInterface;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * DimensionsContainer
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class DimensionsContainer implements Iterable<DimensionInterface> {

	/** List<DimensionInterface> bList */
	protected List<DimensionInterface> bList = new ArrayList<DimensionInterface>();
	
	
	@Override
	public Iterator<DimensionInterface> iterator() {
		return this.bList.iterator();
	}
	
	
	/**
	 * getDimensions
	 * 
	 * @return List<DimensionInterface>
	 */
	public List<DimensionInterface> getDimensions () {
		return this.bList;
	}
	
	
	/**
	 * size
	 * 
	 * @return
	 */
	public int size () {
		return this.bList.size();
	}	
	
	/**
	 * DimensionsContainer
	 * @param dimension
	 * @return
	 */
	public DimensionsContainer add (DimensionInterface dimension) {
		this.bList.add(dimension);
		return this;
	}

}

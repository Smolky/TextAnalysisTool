package es.um.dis.umutextstats;

import java.util.List;

import es.um.dis.umutextstats.dimensions.DimensionInterface;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * DimensionsContainer
 *
 * @author Jos� Antonio Garc�a D�az
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

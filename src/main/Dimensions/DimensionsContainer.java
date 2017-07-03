package main.Dimensions;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class DimensionsContainer implements Iterable<DimensionInterface> {

	protected List<DimensionInterface> bList = new ArrayList<DimensionInterface>();
	
	
	@Override
	public Iterator<DimensionInterface> iterator() {
		return this.bList.iterator();
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

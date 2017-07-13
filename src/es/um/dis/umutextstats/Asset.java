package es.um.dis.umutextstats;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Asset
 *
 * This class represents an asset or the content
 * of a text file.
 *
 * The reason to have assets outside the rest
 * of the classes is to save memory avoiding copying
 * the same strings to the different dimensions.
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class Asset {

	protected String asset;
	
	
	/**
	 * setAsset
	 * 
	 * @param asset
	 *
	 * @package TextAnalysis
	 */
	public void setAsset (String asset) {
		this.asset = asset;
	}
	
	
	/**
	 * getAsset
	 *
	 * @package TextAnalysis
	 */
	public String getAsset () {
		return this.asset;
	}
	
	
	/**
	 * __toString
	 *
	 * @package TextAnalysis
	 */
	
	public String toString () {
		return this.getAsset ().toString ();
	}
	

}
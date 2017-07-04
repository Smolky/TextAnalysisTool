package main.Readers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * FileReader
 * 
 * A filereader reads the content from plain text
 * files
 * 
 * @author José Antonio García Díaz
 */
public class FileReader {

	/**
	 * read
	 * 
	 * Read the content from a file
	 * 
	 * @param file
	 * @return String
	 * @throws IOException
	 */
	public String read (String file) throws IOException {
		return String
			.join ("\n", Files.readAllLines(Paths.get (file), Charset.forName ("ISO-8859-1")))
			.trim ()
		;
	}
	
	
	/**
	 * getLines
	 * 
	 * Read the content from a file
	 * 
	 * @param file
	 * @return String
	 * @throws IOException
	 */
	public String[] getLines (String file) throws IOException {
		List<String> stringList = Files.readAllLines(Paths.get (file), Charset.forName ("ISO-8859-1"));
		return stringList.toArray(new String[]{});
	}
	
	
}

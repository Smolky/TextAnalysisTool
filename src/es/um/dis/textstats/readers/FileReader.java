package es.um.dis.textstats.readers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
			.join ("\n", Files.readAllLines(Paths.get (file), Charset.forName ("UTF-8")))
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
	public List<String> getLines (String file) throws IOException {
		return Files.readAllLines(Paths.get (file), Charset.forName ("ISO-8859-1"));
	}
	
	
}

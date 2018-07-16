/**
 * 
 */
package com.learning.resturant.reader;

import java.util.List;

import com.learning.resturant.exception.FileReaderException;

/**
 * @author VINAY
 *
 */
public class BaseFileReader implements IReader {

	private String filePath;
	private String delimiter;
	
	/**
	 * @param filePath
	 * @param delimiter
	 */
	public BaseFileReader(String filePath, String delimiter){
		this.filePath = filePath;
		this.delimiter = delimiter;
	}
	
	/* (non-Javadoc)
	 * @see restaurant.reader.IReader#readData()
	 */
	public List<? extends Object> readData() throws FileReaderException{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @return the delimiter
	 */
	public String getDelimiter() {
		return delimiter;
	}
}
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
public interface IReader {
	
	public static final String COMMA_DELIMITER = ",";
	public static final String PIPE_DELIMITER = "|";
	
	public List<? extends Object> readData() throws FileReaderException;
}
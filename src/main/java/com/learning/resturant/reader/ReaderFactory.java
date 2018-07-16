/**
 * 
 */
package com.learning.resturant.reader;

import com.learning.resturant.enums.FileFormatTypeEnum;

/**
 * @author VINAY
 * 
 */
public class ReaderFactory {
	
	/**
	 * @param formatType
	 * @param filePath
	 * @param delimiter
	 * @return
	 */
	public static IReader getInstance(FileFormatTypeEnum formatType,
			String filePath, String delimiter) {
		IReader reader = null;
		if (FileFormatTypeEnum.CSV.equals(formatType)) {
			reader = new CSVFileReader(filePath,delimiter);
		} else {
			reader = new BaseFileReader(filePath,delimiter);
		}
		return reader;
	}
}

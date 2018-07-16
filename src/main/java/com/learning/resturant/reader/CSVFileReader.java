/**
 * 
 */
package com.learning.resturant.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learning.resturant.exception.FileReaderException;
import com.learning.resturant.model.ItemMenu;
import com.learning.resturant.model.Restaurant;


/**
 * @author VINAY
 * 
 */
public class CSVFileReader extends BaseFileReader {

	private final int COLUMN_RESTURANT_ID = 0;
	private final int COLUMN_PRICE = 1;

	/**
	 * @param filePath
	 * @param delimiter
	 */
	public CSVFileReader(String filePath, String delimiter) {
		super(filePath, delimiter);
	}

	/* (non-Javadoc)
	 * @see restaurant.reader.BaseFileReader#readData()
	 */
	@Override
	public List<? extends Object> readData() throws FileReaderException {
		BufferedReader bufferReader = null;
		String line = "";
		String[] values = null;
		boolean flag = false;
		List<Restaurant> result = new ArrayList<Restaurant>();
		Map<String, Restaurant> hMap = new HashMap<String, Restaurant>();

		try {
			bufferReader = new BufferedReader(new FileReader(getFilePath()));
			Restaurant resturant = null;
			ItemMenu itemMenu = null;
			while ((line = bufferReader.readLine()) != null) {
				values = line.split(getDelimiter());
				flag = true;

				if (values != null && values.length >= 3) {
					itemMenu = new ItemMenu();
					itemMenu.setPrice(Double.parseDouble(values[COLUMN_PRICE]));
					for (int i = 2; i < values.length; i++) {
						itemMenu.getItemName().add(values[i]);
					}

					if (hMap.containsKey(values[COLUMN_RESTURANT_ID])) {
						resturant = hMap.get(values[COLUMN_RESTURANT_ID]);
						flag = false;
					} else {
						resturant = new Restaurant();
						resturant.setRestaurantId(Integer.parseInt(values[COLUMN_RESTURANT_ID]));
					}
					resturant.getMenuList().add(itemMenu);

					if (flag) {
						result.add(resturant);
						hMap.put(values[COLUMN_RESTURANT_ID], resturant);
					}
				}
			}
		} catch (FileNotFoundException fileNotFoundExp) {
			throw new FileReaderException("File Not Found exception while loading file",fileNotFoundExp);
		} catch (IOException ioExp) {
			throw new FileReaderException("IOException occured while reading file",ioExp);
		} catch (NumberFormatException formatException) {
			throw new FileReaderException("NumberFormatException occured while parsing data",formatException);
		} finally {
			if (bufferReader != null) {
				try {
					bufferReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
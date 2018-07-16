/**
 * 
 */
package com.learning.resturant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.learning.resturant.common.GeneralConstants;
import com.learning.resturant.enums.FileFormatTypeEnum;
import com.learning.resturant.exception.FileReaderException;
import com.learning.resturant.model.ItemMenu;
import com.learning.resturant.model.Restaurant;
import com.learning.resturant.reader.IReader;
import com.learning.resturant.reader.ReaderFactory;

/**
 * @author VINAY
 * 
 */
public class RestaurantHelper {

	public static boolean _debug = false;
	public static boolean _error = false;
	
	private static final Double ZERO = new Double(0.0);
	
	/**
	 * @param requestedItems
	 * @param restaurants
	 * @return
	 */
	public static String identifyRestaurant(Set<String> requestedItems,
			List<Restaurant> restaurants) {
		if(_debug){
			printRestaurantInfo(restaurants);
		}
		String result = "";
		if (restaurants != null && !restaurants.isEmpty()) {
			Double price = new Double(0.0);
			Double tempPrice = new Double(0.0);
			
			int tempRestId = 0;
			for (Restaurant rest : restaurants) {
				price = getItemPrice(requestedItems, rest);

				if (!ZERO.equals(price)) {
					if (price.compareTo(tempPrice) <= 0) {
						tempRestId = (tempRestId < rest.getRestaurantId()) ? tempRestId
								: rest.getRestaurantId();
						if (tempPrice.compareTo(price) == 0) {
							result = tempRestId + GeneralConstants.COMMA_DELIMITER + price;
						} else {
							result = rest.getRestaurantId() + GeneralConstants.COMMA_DELIMITER + price;
						}
						tempPrice = price;
						continue;
					}
					// Below lines will be invoked for first time
					if (ZERO.equals(tempPrice)) {
						result = rest.getRestaurantId() + GeneralConstants.COMMA_DELIMITER + price;
						tempPrice = price;
						tempRestId = rest.getRestaurantId();
					}
				}
			}
		}
		return result;
	}

	/**
	 * @param requestedItems
	 * @param rest
	 * @return
	 */
	public static Double getItemPrice(Set<String> requestedItems,
			Restaurant rest) {
		Iterator<ItemMenu> itemMenus = rest.getMenuList().iterator();
		Double price = new Double(0.0);
		Double tempPrice = new Double(0.0);

		int reqItemSize = requestedItems.size();
		int count = 0;

		ItemMenu itemMenu = null;
		Set<String> itemNames = null;

		List<String> tempList = null;
		List<String> pendingList = new ArrayList<String>(requestedItems);
		Set<String> addedList = new HashSet<String>();

		while (itemMenus.hasNext()) {
			itemMenu = itemMenus.next();
			itemNames = itemMenu.getItemName();

			count = 0;
			tempList = new ArrayList<String>();

			for (String item : itemNames) {
				if (requestedItems.contains(item)) {
					tempList.add(item);
					count++;
				}
				if (pendingList.contains(item)) {
					pendingList.remove(item);
				}
			}

			if (count > 0) {
				if (reqItemSize == count && itemNames.size() == count) {
					price = itemMenu.getPrice();
					break;
				}

				tempPrice = computePrice(pendingList, addedList, tempList,
						itemMenu.getPrice(), tempPrice);
				
				addedList.addAll(tempList);
				
				if (pendingList.isEmpty()) {
					price = tempPrice;
				}
			}
		}
		return price;
	}

	/**
	 * @param pendingList
	 * @param addedList
	 * @param tempList
	 * @param currentValue
	 * @param price
	 * @return
	 */
	public static Double computePrice(List<String> pendingList, Set<String> addedList,
			List<String> tempList, Double currentValue, Double price) {
		Double result = price;
		if (!pendingList.contains(tempList) && !addedList.containsAll(tempList)) {
			result = currentValue + price;
		}

		return result;
	}

	/**
	 * @param file
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Restaurant> getRestaurantList(String file) {
		if(_debug){
			System.out.println("Source File : "+file);
		}
		IReader reader = ReaderFactory.getInstance(FileFormatTypeEnum.CSV,
				file, IReader.COMMA_DELIMITER);
		List<Restaurant> resturants = null;
		try {
			resturants = (List<Restaurant>) reader.readData();
		} catch (FileReaderException e) {
			if(_error){
				System.out.println("Exception while processing file :"+e.getMessage());
			}
		}

		return resturants;
	}
	
	private static void printRestaurantInfo(List<Restaurant> restaurants) {
		for (Restaurant rest : restaurants) {
			System.out.println(rest + " : " + rest.getMenuList());
		}
	}
}
/**
 * 
 */
package com.learning.resturant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.learning.resturant.enums.ExitStatusEnum;
import com.learning.resturant.model.Restaurant;

/**
 * @author VINAY
 * 
 */
public class FindRestaurants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExitStatusEnum exitStatusEnum = ExitStatusEnum.FAILURE;

		String sourceFile = ""; // sourceFile = System.getProperty("user.dir") +
								// "\\src\\main\\java\\restaurant\\test.csv";

		Set<String> requestedItems = new HashSet<String>();
		/*
		 * requestedItems.add("sandwich"); requestedItems.add("burger");
		 * requestedItems.add("ice_cream"); requestedItems.add("test");
		 */

		String split[] = null;
		if (args != null && args.length >= 2) {
			sourceFile = args[0]; // Source File
			for (int i = 1; i < args.length; i++) {
				if (args[i] != null && args[i].indexOf('=') != -1) {
					split = args[i].substring(args[i].indexOf('=') + 1).split(
							"\\,");
					break;
				}
				requestedItems.add(args[i]);
			}
			if (split != null) {
				for (String val : split) {
					if (val.equalsIgnoreCase("debug")) {
						RestaurantHelper._debug = true;
					} else if (val.equalsIgnoreCase("error")) {
						RestaurantHelper._error = true;
					}
				}
			}
		}

		if (requestedItems != null && !requestedItems.isEmpty()) {
			List<Restaurant> restaurants = RestaurantHelper.getRestaurantList(sourceFile);

			if(restaurants!=null && !restaurants.isEmpty()){
				String result = RestaurantHelper.identifyRestaurant(requestedItems,	restaurants);
				if (!"".equals(result)) {
					System.out.println("Best Restaurant : " + result);
					exitStatusEnum = ExitStatusEnum.SUCCESS;
				}
			}
		}
		System.out.println("Exit : " + exitStatusEnum.getValue());
	}
}
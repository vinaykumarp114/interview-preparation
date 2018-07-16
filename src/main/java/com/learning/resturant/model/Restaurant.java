/**
 * 
 */
package com.learning.resturant.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author VINAY
 * 
 */
public class Restaurant {

	private Integer restaurantId;
	private Set<ItemMenu> menuList = new HashSet<ItemMenu>();

	/**
	 * @return the restaurantId
	 */
	public Integer getRestaurantId() {
		return restaurantId;
	}

	/**
	 * @param restaurantId
	 *            the restaurantId to set
	 */
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	/**
	 * @return the menuList
	 */
	public Set<ItemMenu> getMenuList() {
		return menuList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Restaurants [restaurantId=" + restaurantId + "]";
	}
}
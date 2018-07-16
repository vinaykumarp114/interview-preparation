/**
 * 
 */
package com.learning.resturant.enums;

/**
 * @author VINAY
 * 
 */
public enum ExitStatusEnum {

	SUCCESS("0"), FAILURE("1");

	private String value;

	/**
	 * @param value
	 */
	private ExitStatusEnum(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
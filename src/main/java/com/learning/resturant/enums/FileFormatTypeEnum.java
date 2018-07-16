/**
 * 
 */
package com.learning.resturant.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VINAY
 * 
 */
public enum FileFormatTypeEnum {

	CSV(1, "csv");

	private int id;
	private String type;
	private static Map<Integer, FileFormatTypeEnum> _mapping;

	/**
	 * @param id
	 * @param type
	 */
	private FileFormatTypeEnum(int id, String type) {
		this.id = id;
		this.type = type;
	}

	/**
	 * @param key
	 * @return
	 */
	public static FileFormatTypeEnum getFileFormatType(int key) {
		if (_mapping == null || _mapping.isEmpty()) {
			initMapping();
		}
		return _mapping.get(key);
	}

	/**
	 * 
	 */
	public static void initMapping() {
		_mapping = new HashMap<Integer, FileFormatTypeEnum>();
		for (FileFormatTypeEnum e : values()) {
			_mapping.put(e.id, e);
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
}
/**
 * 
 */
package com.learning.basic.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author VINAY
 * 
 */
public class TestPrintCharCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> result = printCharCount("Helloworld");
		printOutput(result);
	}

	public static void printOutput(Map<String, Integer> result) {
		if(result!=null && !result.isEmpty()) {
			for(Map.Entry<String, Integer> entry : result.entrySet()){
				System.out.println(entry.getKey() + "-"+ entry.getValue());
			}
		}
	}

	public static Map<String, Integer> printCharCount(String val) {
		Map<String, Integer> result = null;
		if (val != null && !"".equals(val)) {
			int count = 0;
			result = new LinkedHashMap<String, Integer>();			
			for (int i = 0; i < val.length(); i++) {
				if(result.containsKey(""+val.charAt(i))){
					count = result.get(""+val.charAt(i));
					++count;
				} else {
					count = 1;
				}
				result.put(""+val.charAt(i) , count);				
			}
		}
		return result;
	}
}

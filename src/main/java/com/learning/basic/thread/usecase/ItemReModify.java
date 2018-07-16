/**
 * 
 */
package com.learning.basic.thread.usecase;

import java.util.Collections;
import java.util.List;

/**
 * @author VINAY
 * 
 */
public class ItemReModify implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see basic.thread.usecase.IModifyItems#modify()
	 */
	public void modify() {
		ItemHandler itemHandler = ItemHandler.getInstance();
		List<Item> items = itemHandler.getItemList();
		
		if (items.isEmpty()) {
			System.out.println(Thread.currentThread().getName()	+ ".............list is Empty");
			synchronized (itemHandler) {
				try {
					System.out.println(Thread.currentThread().getName()	+ ".............Before Wait");
					itemHandler.wait();
					System.out.println(Thread.currentThread().getName()	+ ".............After Wait");
				} catch (InterruptedException ie) {
				}
			}
		}
		
		Collections.reverse(items);	
		for (Item item : items) {
			item.setName("Reverse Modify - " + item.getName());
			item.setDescription("Reverse Modify by " + item.getDescription());
		}
		System.out.println(Thread.currentThread().getName() + ": size : "+items.size() +" : items : "	+ items);
	}

	public void run() {
		System.out.println("Running : " + Thread.currentThread().getName());
		modify();
	}
}

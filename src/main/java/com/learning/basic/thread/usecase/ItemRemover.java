/**
 * 
 */
package com.learning.basic.thread.usecase;

import java.util.List;
import java.util.Random;

/**
 * @author VINAY
 * 
 */
public class ItemRemover implements Runnable {

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

		Random r = new Random();
		int index = 0;
		for(int i=0;i<10 && i<items.size()-1;i++){
			index = r.nextInt(itemHandler.getItemList().size());
			itemHandler.getItemList().remove(itemHandler.getItemList().get(index));
			System.out.println(Thread.currentThread().getName() + " : ..............Remove Index : "	+ index);
		}
		
		System.out.println(Thread.currentThread().getName() + ": size : "+items.size() +" : items : "	+ items);
	}

	public void run() {
		System.out.println("Running : " + Thread.currentThread().getName());
		modify();
	}
}

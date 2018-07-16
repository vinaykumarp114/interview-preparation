/**
 * 
 */
package com.learning.basic.thread.usecase;


/**
 * @author VINAY
 * 
 */
public class ItemAdder implements Runnable {

	public void run() {
		System.out.println("Running : "+Thread.currentThread().getName());
		Item item = null;
		ItemHandler itemHandler = ItemHandler.getInstance();
		for (int i = 0; i < 50; i++) {
			item = new Item("JustCreated" + i, "Item Just Created - " + i);
			synchronized (itemHandler) {
				itemHandler.addItem(item);
				itemHandler.notifyAll();
			}
		}
		System.out.println(Thread.currentThread().getName() + ": size : "+itemHandler.getItemList().size() 
				+" : items : "	+ itemHandler.getItemList());
	}
}
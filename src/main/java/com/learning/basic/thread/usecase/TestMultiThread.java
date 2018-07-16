/**
 * 
 */
package com.learning.basic.thread.usecase;


/**
 * @author VINAY
 * 
 */
public class TestMultiThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread one = new Thread(new ItemAdder(), "Thread-ItemAdder");
		Thread two = new Thread(new ItemModifier(), "Thread-ItemModifier");
		Thread three = new Thread(new ItemReModify(), "Thread-ItemReModify");
		Thread four = new Thread(new ItemRemover(), "Thread-ItemRemover");

		one.start();
		two.start();
		three.start();
		four.start();
		
		System.out.println("End Main Thread : "+Thread.currentThread());
	}
}
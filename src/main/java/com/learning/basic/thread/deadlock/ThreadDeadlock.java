/**
 * 
 */
package com.learning.basic.thread.deadlock;

/**
 * @author VINAY
 * 
 */
public class ThreadDeadlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadDeadlock threadDeadLock = new ThreadDeadlock();
		//threadDeadLock.testDeadlock();

		threadDeadLock.testDeadlock1();
	}

	void testDeadlock() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();

		SyncThread s1 = new SyncThread(obj1, obj2);
		SyncThread s2 = new SyncThread(obj2, obj3);
		SyncThread s3 = new SyncThread(obj3, obj2);
		Thread t1 = new Thread(s1, "t1");
		Thread t2 = new Thread(s2, "t2");
		Thread t3 = new Thread(s3, "t3");

		t1.start();
		s1.work(5000);
		t2.start();
		s2.work(5000);
		t3.start();
	}

	void testDeadlock1() {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		new Thread(new Runnable() {
			public void run() {
				alphonse.bow(gaston);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				gaston.bow(alphonse);
			}
		}).start();
	}
}

class SyncThread implements Runnable {
	private Object obj1;
	private Object obj2;

	public SyncThread(Object o1, Object o2) {
		this.obj1 = o1;
		this.obj2 = o2;
	}

	public void run() {
		// deadlock();
		deadlockCorrection();
	}

	public void deadlock() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " acquiring lock on " + obj1);
		synchronized (obj1) {
			System.out.println(name + " acquired lock on " + obj1);
			work(30000);
			System.out.println(name + " acquiring lock on " + obj2);
			synchronized (obj2) {
				System.out.println(name + " acquired lock on " + obj2);
				work(30000);
			}
			System.out.println(name + " released lock on " + obj2);
		}
		System.out.println(name + " released lock on " + obj1);
		System.out.println(name + " finished execution.");
	}

	public void deadlockCorrection() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " acquiring lock on " + obj1);
		synchronized (obj1) {
			System.out.println(name + " acquired lock on " + obj1);
			work(30000);
		}
		System.out.println(name + " released lock on " + obj1);
		System.out.println(name + " acquiring lock on " + obj2);
		synchronized (obj2) {
			System.out.println(name + " acquired lock on " + obj2);
			work(30000);
		}
		System.out.println(name + " released lock on " + obj2);

		System.out.println(name + " finished execution.");
	}

	public void work(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

 class Friend {
	private final String name;

	public Friend(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public synchronized void bow(Friend bower) {
		System.out.format("%s: %s" + "  has bowed to me!%n", this.name,
				bower.getName());
		bower.bowBack(this);
	}

	public synchronized void bowBack(Friend bower) {
		System.out.format("%s: %s" + " has bowed back to me!%n", this.name,
				bower.getName());
	}
}
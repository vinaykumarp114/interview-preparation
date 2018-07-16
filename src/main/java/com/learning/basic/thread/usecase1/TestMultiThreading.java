/**
 * 
 */
package com.learning.basic.thread.usecase1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author VINAY
 * 
 */
public class TestMultiThreading {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		if (args != null && args.length == 3) {			
			executeService(args);
//			executeThreads(args);
		}
	}

	/**
	 * @param val
	 */
	public static void executeService(String[] val) {
		int nThreads = Integer.parseInt(val[1]);
		int nTimes = Integer.parseInt(val[2]);

		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		try {
			for (int i = 0; i < nThreads; i++) {
				Runnable worker = new Thread(new Job(val[0], nTimes));
				executor.execute(worker);
			}
		} finally {
			executor.shutdown();
			while (!executor.isTerminated())
				;
			printTotal(nThreads, nTimes);
		}
	}

	/**
	 * @param nThreads
	 * @param nTimes
	 */
	public static void printTotal(int nThreads, int nTimes) {
		double totalTime = Job.SHARED_TIME.get() / 1000;
		int totalRequest = nTimes * nThreads;
		double nResPerSec = totalRequest / totalTime;
		System.out.println("Total Number of Request = " + totalRequest
				+ ",Total Time Spent = " + totalTime
				+ ",Number of response per second " + nResPerSec);
	}
	
	/**
	 * @param val
	 */
	public static void executeThreads(String[] val) {
		int nThreads = Integer.parseInt(val[1]);
		int nTimes = Integer.parseInt(val[2]);
		Thread[] threads = new Thread[nThreads];

		try {
			for (int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new Job(val[0], nTimes));
				threads[i].setName("Thread" + i);
				threads[i].start();
			}

			for (int i = 0; i < threads.length; i++) {
				threads[i].join();
			}

			printTotal(nThreads, nTimes);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException : " + e.getMessage());
		}
	}

	
}

class Job implements Runnable {

	static volatile AtomicInteger SHARED_TIME = new AtomicInteger(0);
	private String link;
	private int count;

	/**
	 * @param val
	 */
	public Job(String link, int count) {
		this.link = link;
		this.count = count;
	}

	public void run() {
		for (int j = 1; j < count; j++) {
			long startTime = System.currentTimeMillis();
			int statusCode = getResponseStatusCode();
			long endTime = System.currentTimeMillis() - startTime;

			System.out.println("request" + j + "/"
					+ Thread.currentThread().getName() + ", HTTP " + statusCode
					+ ", " + endTime + " milliseconds");

			totalTimeSpent(endTime);
		}
	}

	/**
	 * @param endTime
	 */
	private void totalTimeSpent(long endTime) {
		SHARED_TIME.addAndGet((int) endTime);
	}

	/**
	 * @return
	 */
	public int getResponseStatusCode() {
		int response = 0;
		try {
			URL url = new URL(link);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			response = http.getResponseCode();
		} catch (IOException ioExp) {

		}
		return response;
	}
}
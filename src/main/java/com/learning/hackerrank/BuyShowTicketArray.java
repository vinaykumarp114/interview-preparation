/**
 * 
 */
package com.learning.hackerrank;

import java.util.Scanner;

/**
 * @author vinay
 *
 */
public class BuyShowTicketArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BuyShowTicketArray buyTicket = new BuyShowTicketArray();
		buyTicket.waitingTime();
	}

	/**
	 * There are n people standing in line to buy show tickets.
	 * Due to high demand, the venue sells tickets according to the following rules: 
	 * - The person at the head of the line can buy exactly 1 ticket and must then exit the line. 
	 * - If a person needs to purchase additional tickets, they must re-enter the end of the line 
	 * 		and wait to be sold their next ticket (assume exit and re-entry takes 0 seconds). 
	 * - Each ticket sale takes exactly 1 second. 
	 * 
	 * We express initial line of n people as an array, tickets = [tickets0, tickets1 ...
	 * ticketsN-1], where tickets i denotes the number of tickets that person i
	 * wishes to buy. If Jesse is located at a position p, how many seconds will it
	 * take for him to purchase tickets p tickets. 
	 * Complete the waitingTime function in the editor below. It has two parameters: 
	 * - An array, tickets, of n positive integers describing initial sequence of people standing in line.
	 * 		Each tickets i describes number of tickets that a person waiting at initial position i needs to purchase. 
	 * - An integer p, denoting Jesse's position in tickets. 
	 * Sample Input: 5 2 6 3 4 5 2  Output: 12 	(array size = 5, p=2)
	 * Sample Input: 4 5 5 2 3 3  Output 11 	(array size = 4, p=3)
	 */
	private void waitingTime() {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] tickets = new int[size];

		for (int i = 0; i < size; i++) {
			tickets[i] = scanner.nextInt();
		}
		int p = scanner.nextInt();	
		scanner.close();
		
		int count = 0;
		boolean done = false;
		while (!done) {
			for (int j = 0; j < tickets.length; j++) {
				if (tickets[j] == 0) {
					continue;
				}
				if (tickets[p] == 0) {
					done = true;
					break;
				}
				tickets[j] = tickets[j]-1;
				count++;
			}
		}
		System.out.println("Wait Time in sec :: "+ count);
	}
}

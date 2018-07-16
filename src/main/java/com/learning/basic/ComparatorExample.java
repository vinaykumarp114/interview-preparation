/**
 * 
 */
package com.learning.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections.comparators.ComparatorChain;

/**
 * @author VINAY
 * 
 */
public class ComparatorExample {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComparatorExample example = new ComparatorExample();
		List<StudentBean> studentList = example.prepareData();

		ComparatorChain studentChain = new ComparatorChain();
		studentChain.addComparator(new FirstNameComparator());
		studentChain.addComparator(new SecondNameComparator());
		studentChain.addComparator(new DivisionComparator());

		System.out.println("BEFORE");

		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i));
		}

		Collections.sort(studentList, studentChain);

		System.out.println("AFTER");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i));
		}
	}

	public List<StudentBean> prepareData() {
		Random idRandomizer = new Random();
		List<StudentBean> studentList = new ArrayList<StudentBean>();

		StudentBean stBean1 = new StudentBean(idRandomizer.nextInt(), "Jagan",
				"Asokan", "III", "Bangalore");
		StudentBean stBean2 = new StudentBean(idRandomizer.nextInt(), "Jagan",
				"Asokan", "II", "Bangalore");
		StudentBean stBean3 = new StudentBean(idRandomizer.nextInt(), "Satya",
				"Asokan", "III", "Chennai");
		StudentBean stBean4 = new StudentBean(idRandomizer.nextInt(), "Balaji",
				"MK", "I", "Chennai");
		StudentBean stBean5 = new StudentBean(idRandomizer.nextInt(), "Satya",
				"Asokan", "IV", "Chennai");
		StudentBean stBean6 = new StudentBean(idRandomizer.nextInt(), "Balaji",
				"MK", "V", "Chennai");
		StudentBean stBean7 = new StudentBean(idRandomizer.nextInt(), "Jagan",
				"Asokan", "VI", "Chennai");
		StudentBean stBean8 = new StudentBean(idRandomizer.nextInt(), "Venu",
				"Karthik", "I", "Bangalore");

		studentList.add(stBean1);
		studentList.add(stBean2);
		studentList.add(stBean3);
		studentList.add(stBean4);
		studentList.add(stBean5);
		studentList.add(stBean6);
		studentList.add(stBean7);
		studentList.add(stBean8);

		return studentList;
	}
}

class FirstNameComparator implements Comparator<StudentBean> {
	public int compare(StudentBean s1, StudentBean s2) {
		return s1.getFirstName().compareTo(s2.getFirstName());
	}
}

class SecondNameComparator implements Comparator<StudentBean> {
	public int compare(StudentBean s1, StudentBean s2) {
		return s1.getSecondName().compareTo(s2.getSecondName());
	}
}

class DivisionComparator implements Comparator<StudentBean> {
	public int compare(StudentBean s1, StudentBean s2) {
		return s1.getDivision().compareTo(s2.getDivision());
	}
}

class StudentBean {
	private int rollNumber;
	private String firstName;
	private String secondName;
	private String division;
	private String address;

	public String toString() {
		return "StudentBean [rollNumber=" + rollNumber + ", firstName="
				+ firstName + ", secondName=" + secondName + ", division="
				+ division + ", address=" + address + "]";
	}

	public StudentBean(int rollNumber, String firstName, String secondName,
			String division, String address) {
		super();
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.secondName = secondName;
		this.division = division;
		this.address = address;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
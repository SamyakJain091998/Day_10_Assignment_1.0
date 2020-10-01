package com.javaStream.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Address_Book {
	private ArrayList<Contacts> arrList = new ArrayList<Contacts>();
	private ArrayList<Contacts> arrCityList = new ArrayList<Contacts>();
	private ArrayList<Contacts> arrStateList = new ArrayList<Contacts>();
	
	public boolean addToAddressBook(Contacts con) {
		if(getArrList().contains(con)) {
			System.out.println("Sorry! The details already exist...");
			return false;
		}
		getArrList().add(con);
		return true;
	}
	
	public void printArrayList() {
		System.out.println("Updated array list is: ");
		System.out.println(getArrList());
	}
	
	public void printCityArrayList() {
		System.out.println("Updated city array list is: ");
		System.out.println(getCityArrList());
	}
	
	public void printStateArrayList() {
		System.out.println("Updated state array list is: ");
		System.out.println(getStateArrList());
	}
	
	public void getDetailsAccCity(String cityOfPerson) {
		Predicate<Contacts> isDesiredCity = cityStr -> cityOfPerson.equals(cityStr.getCity());
		Integer countCity = arrList.stream().filter(isDesiredCity).collect(Collectors.toList()).size();
		boolean flagIndex = false;
		if(countCity != 0) {
			flagIndex = true;
		}
		System.out.println("Calling the countByCity function. Count is: " + countCity);
		if(flagIndex == false) {
			System.out.println("Sorry! There's no detail regarding this city.");
		}
	}
	
	public void getDetailsAccState(String stateOfPerson) {
		Predicate<Contacts> isDesiredState = stateStr -> stateOfPerson.equals(stateStr.getState());
		Integer countState = arrList.stream().filter(isDesiredState).collect(Collectors.toList()).size();
		boolean flagIndex1 = false;
		if(countState != 0) {
			flagIndex1 = true;
		}
		System.out.println("Calling the countByState function. Count is: " + countByState());
		if(flagIndex1 == false) {
			System.out.println("Sorry! There's no detail regarding this state.");
			System.out.println("Thank you for using the address book system. Do visit again!");
			System.exit(0);;
		}
		System.out.println("Thank you for using the address book system. Do visit again!");
		System.exit(0);
	}
	
	public void sortByName() {
		List<Contacts> sortedNameList = arrList.stream().sorted(Comparator.comparing(Contacts::getFirstName)).collect(Collectors.toList());
		System.out.println("Sorted name list is : " + sortedNameList);
	}
	
	public ArrayList<Contacts> getArrList() {
		return arrList;
	}
	
	public ArrayList<Contacts> getCityArrList() {
		return arrCityList;
	}
	
	public ArrayList<Contacts> getStateArrList() {
		return arrStateList;
	}
	
	public int countByCity() {
		return arrCityList.size();
	}
	
	public int countByState() {
		return arrStateList.size();
	}
	
	public int getArrListSize() {
		return arrList.size();
	}
}
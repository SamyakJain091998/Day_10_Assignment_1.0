package com.javaStream.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Address_Book {
	private ArrayList<Contacts> arrList = new ArrayList<Contacts>();
	private ArrayList<Contacts> arrCityList = new ArrayList<Contacts>();
	private ArrayList<Contacts> arrStateList = new ArrayList<Contacts>();
	private Map<String, ArrayList<Contacts>> cityMap = new HashMap<String, ArrayList<Contacts>>();
	private Map<String, ArrayList<Contacts>> stateMap = new HashMap<String, ArrayList<Contacts>>();
	
	public boolean addToAddressBook(Contacts con) {
		if(arrList.stream().anyMatch(dummy -> arrList.contains(con))) {
			System.out.println("Sorry! The details already exist...");
			System.exit(0);
		};
		arrList.add(con);
		
		if(!(cityMap.containsKey(con.getCity()))) {
			cityMap.put(con.getCity(), arrCityList);
		}
		
		if(!(stateMap.containsKey(con.getState()))) {
			stateMap.put(con.getState(), arrStateList);
		}
		//cityMap.put(con.getCity(), getArrList());
		return true;
	}
	
	public void getDetailsAccCity(String cityOfPerson) {
		boolean flagIndex = false;
		Predicate<Contacts> contactFunction = dummyCon -> cityOfPerson.equals(dummyCon.getCity());
		List<Contacts> contactList = arrList.stream().filter(contactFunction).collect(Collectors.toList());
		if(contactList.size() != 0) {
			flagIndex = true;
			
		}
		System.out.println();
		System.out.println("City based list is : " + contactList);
		if(flagIndex == false) {
			System.out.println("Sorry! There's no detail regarding this city.");
		}
	}
	
	public void getDetailsAccState(String stateOfPerson) {
		Predicate<Contacts> contactFunctionSecond = dummyCon -> stateOfPerson.equals(dummyCon.getState());
		boolean flagIndex1 = false;
		
		List<Contacts> contactListSecond = arrList.stream().filter(contactFunctionSecond).collect(Collectors.toList());
		if(contactListSecond.size() != 0) {
			flagIndex1 = true;
		}
		System.out.println();
		System.out.println("State based list is : " + contactListSecond);
		if(flagIndex1 == false) {
			System.out.println("Sorry! There's no detail regarding this state.");
			System.out.println("Thank you for using the address book system. Do visit again!");
			System.exit(0);;
		}
		System.out.println("Thank you for using the address book system. Do visit again!");
		System.exit(0);
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
	
	public void printCityMap() {
		System.out.println("Updated city map is: ");
		System.out.println(getCityMap());
	}
	
	public void printStateMap() {
		System.out.println("Updated state map is: ");
		System.out.println(getStateMap());
	}
	
	public void addToCityMap() {
		
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
	
	public Map<String, ArrayList<Contacts>> getCityMap() {
		return cityMap;
	}
	
	public Map<String, ArrayList<Contacts>> getStateMap() {
		return stateMap;
	}
	
	public int getArrListSize() {
		return arrList.size();
	}
}
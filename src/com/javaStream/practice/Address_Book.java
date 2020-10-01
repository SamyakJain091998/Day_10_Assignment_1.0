package com.javaStream.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Address_Book {
	private ArrayList<Contacts> arrList = new ArrayList<Contacts>();
	
	public boolean addToAddressBook(Contacts con) {
		//System.out.println("arrList.contains(con) : " + arrList.contains(con));
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
		//System.exit(0);
	}
	
	public void getDetailsAccCity(String cityOfPerson) {
//		Iterator itr = arrList.iterator();
//		int flag = 0;
		boolean flagIndex = false;
//		Contacts c = (Contacts) itr.next();
		Predicate<Contacts> contactFunction = dummyCon -> cityOfPerson.equals(dummyCon.getCity());
//		while(itr.hasNext()) {
//			Contacts c = (Contacts) itr.next();
//			
//			
//			Predicate<Contacts> contactFunction = dummyCon -> dummyCon.getCity() == c.getCity();
			List<Contacts> contactList = arrList.stream().filter(contactFunction).collect(Collectors.toList());
			if(contactList.size() != 0) {
				flagIndex = true;
			}
			System.out.println();
			System.out.println("City based list is : " + contactList);
			
			
//			if(cityOfPerson.equals(c.getCity())){
//				flagIndex = true;
//				System.out.print("Here's detail #" + (flag+1) + " : ");
//				System.out.println(arrList.get(flag));
//				System.out.println();
//			}
//			flag++;
//		}
		if(flagIndex == false) {
			System.out.println("Sorry! There's no detail regarding this city.");
		}
	}
	
	public void getDetailsAccState(String stateOfPerson) {
//		Iterator itr1 = arrList.iterator();
//		int flag1 = 0;
		Predicate<Contacts> contactFunctionSecond = dummyCon -> stateOfPerson.equals(dummyCon.getState());
		boolean flagIndex1 = false;
		
		List<Contacts> contactListSecond = arrList.stream().filter(contactFunctionSecond).collect(Collectors.toList());
		if(contactListSecond.size() != 0) {
			flagIndex1 = true;
		}
		System.out.println();
		System.out.println("State based list is : " + contactListSecond);
		
//		while(itr1.hasNext()) {
//			Contacts c = (Contacts) itr1.next();
//			if(stateOfPerson.equals(c.getState())){
//				flagIndex1 = true;
//				System.out.print("Here's detail #" + (flag1+1) + " : ");
//				System.out.println(arrList.get(flag1));
//				System.out.println();
//			}
//			flag1++;
//		}
		if(flagIndex1 == false) {
			System.out.println("Sorry! There's no detail regarding this state.");
			System.out.println("Thank you for using the address book system. Do visit again!");
			System.exit(0);;
		}
		System.out.println("Thank you for using the address book system. Do visit again!");
		System.exit(0);
	}
	
	public ArrayList<Contacts> getArrList() {
		return arrList;
	}
	
	public int getArrListSize() {
		return arrList.size();
	}
}
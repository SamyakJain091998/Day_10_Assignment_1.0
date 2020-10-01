package com.javaStream.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Predicate;

public class Address_Book {
	private ArrayList<Contacts> arrList = new ArrayList<Contacts>();
//	Contacts dummyCon = new Contacts();
//	
//	Predicate<Contacts> isExist = dummyCon -> {
//		if(arrList.contains(dummyCon)) {
//			return dummyCon;
//		}
//	};
	public void addToAddressBook(Contacts con) {
//		System.out.println("arrList.contains(con) : " + arrList.contains(con));
		if(arrList.stream().anyMatch(dummy -> arrList.contains(con))) {
			System.out.println("Sorry! The details already exist...");
			System.exit(0);
		};
//		if(arrList.contains(con)) {
//			System.out.println("Sorry! The details already exist...");
//			System.exit(0);
//		}
		arrList.add(con);
	}
	
	public void printArrayList() {
		System.out.println("Updated array list is: ");
		System.out.println(arrList);
	}
}
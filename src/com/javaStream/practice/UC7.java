package com.javaStream.practice;

import java.util.Scanner;

public class UC7 {
	
	public static Address_Book ab = new Address_Book();
	
	public static void main(String[] args) {
		UC7 u = new UC7();
		Scanner sc = new Scanner(System.in);
		int count;
		System.out.print("Enter the count of person you want to add details of: ");
		count = sc.nextInt();
		for(int i=0; i<count; i++) {
			System.out.println("Enter the details as specified below for person " + (i+1));
			u.Details();	
		}
	}

	private static void Details() {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter first name:");
		String firstName = sc.nextLine();
		
		System.out.println("Enter last name:");
		String lastName = sc.nextLine();
		
		System.out.println("Enter address:");
		String address = sc.nextLine();
		
		System.out.println("Enter city:");
		String city = sc.nextLine();	
		
		System.out.println("Enter state:");
		String state = sc.nextLine();
		
		System.out.println("Enter zip:");
		long zip = sc.nextLong();
		
		System.out.println("Enter 10 digit phone number without country code:");
		long phoneNumber = sc.nextLong();

		sc.nextLine();
		
		System.out.println("Enter email-Id:");
		String emailId = sc.nextLine();
		
		Contacts c = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, emailId);
		
		System.out.println("Please wait.....");
		
		try
		{
		    Thread.sleep(2000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}

		ab.addToAddressBook(c);
		System.out.println("Thank you! The details have been added successfully!");
		ab.printArrayList();				
	}
}
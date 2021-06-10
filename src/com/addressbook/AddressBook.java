package com.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class AddressBook {

	AddressMethods addressMethod=new AddressMethods();
	void address_Book(AddressMethods addressMethod) {
		while (true) {
			System.out.println("Press 1 : Add Contact");
			System.out.println("Press 2 : Edit Contact");
			System.out.println("Press 3 : Print Contact");
			System.out.println("Press 4 : Delete Contact");
			System.out.println("Press 5 : Sort Contact By Name");
			System.out.println("Press 6 : Sort Contact By City");
			System.out.println("Press 7 : Sort Contact By State");
			System.out.println("Press 8 : Sort Contact By Zip");
			System.out.println("Press 0 : Exit");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addressMethod.add();
				break;
			case 2:
				addressMethod.edit();
				break;
			case 3:
				addressMethod.show();
				break;
			case 4:
				addressMethod.delete();
				break;
			case 5:
				addressMethod.sortByName();
				
			case 6:
				addressMethod.sortByCity();
				break;
			case 7:
				addressMethod.sortByState();
				break;
			case 8:
				addressMethod.sortByZip();
				break;
			case 0:
				return;
			default:
				System.out.println("Please Enter Valid Option");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address book");
		// AddressMethods address=new AddressMethods();
		Map<String, AddressMethods> addressbookMap = new HashMap<String, AddressMethods>();
		String name = null;
		while (true) {

			System.out.println("Enter the Address book name");
			Scanner scanner = new Scanner(System.in);
			name = scanner.nextLine();
			AddressMethods addressMethods = addressbookMap.get(name);
			if (addressMethods == null) {
				addressMethods = new AddressMethods();
				addressbookMap.put(name, addressMethods);
			}
			AddressBook book = new AddressBook();
			book.address_Book(addressMethods);
			System.out.println("Press 1 : Want to enter in other addressbook");
			System.out.println("Press any other key to exit");
			String choise = scanner.nextLine();
			if (!choise.equals("1"))
				break;
		}
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Press 1: Search By city");
			System.out.println("Press 2: Search By state");
			System.out.println("Press 0: Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter city for search");
				String city = scanner.next();
				System.out.println("Enter first name");
				String firstName = scanner.next();
				System.out.println("Enter last name");
				String lastName = scanner.next();
				SearchCity(addressbookMap, city, firstName, lastName);
				break;
			case 2:
				System.out.println("Enter state for search");
				String state = scanner.next();
				System.out.println("Enter first name");
				String FirstName = scanner.next();
				System.out.println("Enter last name");
				String LastName = scanner.next();
				SearchState(addressbookMap, state, FirstName, LastName);
				break;
			case 0:
				return;
			default:
				System.out.println("Please Enter Correct choise ");
			}
		}
	}

	static void SearchCity(Map<String, AddressMethods> addressbookMap, String city, String firstName, String lastName) {
		for (AddressMethods iterator : addressbookMap.values()) {
			ArrayList<ContactInfo> addressBooks = (ArrayList<ContactInfo>) iterator.addressBook;
			  addressBooks.stream().forEach(addressBook -> {
				if (addressBook.getCity().equalsIgnoreCase(city))
					if (addressBook.getFirst_Name().equalsIgnoreCase(firstName))
						if (addressBook.getLast_Name().equalsIgnoreCase(lastName))
							System.out.println(addressBook.getFirst_Name() + " " + addressBook.getLast_Name() +" is in  "+addressBook.getCity());
						else
							System.out.println("No person of name " + firstName + " " + lastName + " is present in "+city);

			});
		}
	}

	static void SearchState(Map<String, AddressMethods> addressbookMap, String state, String firstName,String lastName) {
		for (AddressMethods iterator : addressbookMap.values()) {
			ArrayList<ContactInfo> addressBooks = (ArrayList<ContactInfo>) iterator.addressBook;
			addressBooks.stream().forEach(addressBook -> {
				if (addressBook.getState().equalsIgnoreCase(state))
					if (addressBook.getFirst_Name().equalsIgnoreCase(firstName))
						if (addressBook.getLast_Name().equalsIgnoreCase(lastName))
							System.out.println(addressBook.getFirst_Name() + " " + addressBook.getLast_Name() +" is in  "+addressBook.getState());
						else
							System.out.println("No person of name " + firstName + " " + lastName + " is present in "+state);

			});
		}
	}
	
}



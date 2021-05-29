package com.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class AddressBook {

	void address_Book(AddressMethods addressMethod) {
		while (true) {
			System.out.println("Press 1 : Add Contact");
			System.out.println("Press 2 : Edit Contact");
			System.out.println("Press 3 : Print Contact");
			System.out.println("Press 4 : Delete Contact");
			System.out.println("Press 0 : Exit");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addressMethod.Add();
				break;
			case 2:
				addressMethod.Edit();
				break;
			case 3:
				addressMethod.Show();
				break;
			case 4:
				addressMethod.Delete();
				break;
			case 0:
				return;
			default:
				System.out.println("Please Enter Correct Option");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address book");
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
			System.out.println("Press 1: Search Name By city");
			System.out.println("Press 2: Search Name By state");
			System.out.println("Press 3: Search all contacts in city");
			System.out.println("Press 4: Search all contacts in state");
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
				SearchPersonINCity(addressbookMap, city, firstName, lastName);
				break;
			case 2:
				System.out.println("Enter state for search");
				String state = scanner.next();
				System.out.println("Enter first name");
				String FirstName = scanner.next();
				System.out.println("Enter last name");
				String LastName = scanner.next();
				SearchPersonInState(addressbookMap, state, FirstName, LastName);
				break;
			case 3:
				System.out.println("Enter city for search");
				String City = scanner.next();
				SearchINCity(addressbookMap, City);
				break;
			case 4:
				System.out.println("Enter city for search");
				String State = scanner.next();
				SearchINState(addressbookMap, State);
				break;
			case 0:
				return;
			default:
				System.out.println("Please Enter Correct choise ");
			}
		}
	}

	static void SearchPersonINCity(Map<String, AddressMethods> addressbookMap, String city, String firstName,
			String lastName) {
		for (AddressMethods iterator : addressbookMap.values()) {
			ArrayList<ContactInfo> addressBooks = iterator.addressBook;
			addressBooks.stream().forEach(addressBook -> {
				if (addressBook.getCity().equalsIgnoreCase(city))
					if (addressBook.getFirst_Name().equalsIgnoreCase(firstName))
						if (addressBook.getLast_Name().equalsIgnoreCase(lastName))
							System.out.println(addressBook.getFirst_Name() + " " + addressBook.getLast_Name());

			});

		}
	}

	static void SearchPersonInState(Map<String, AddressMethods> addressbookMap, String state, String firstName,
			String lastName) {
		for (AddressMethods iterator : addressbookMap.values()) {
			ArrayList<ContactInfo> addressBooks = iterator.addressBook;
			addressBooks.stream().forEach(addressBook -> {
				if (addressBook.getState().equalsIgnoreCase(state))
					if (addressBook.getFirst_Name().equalsIgnoreCase(firstName))
						if (addressBook.getLast_Name().equalsIgnoreCase(lastName))
							System.out.println(addressBook.getFirst_Name() + " " + addressBook.getLast_Name());
			});

		}
	}

	static void SearchINCity(Map<String, AddressMethods> addressbookMap, String city) {
		for (AddressMethods iterator : addressbookMap.values()) {
			ArrayList<ContactInfo> addressBooks = iterator.addressBook;
			addressBooks.stream().forEach(addressBook -> {
				if (addressBook.getCity().equalsIgnoreCase(city))
					System.out.println(addressBook.getFirst_Name() + " " + addressBook.getLast_Name());

			});

		}
	}
	
	static void SearchINState(Map<String, AddressMethods> addressbookMap, String state) {
		for (AddressMethods iterator : addressbookMap.values()) {
			ArrayList<ContactInfo> addressBooks = iterator.addressBook;
			addressBooks.stream().forEach(addressBook -> {
				if (addressBook.getState().equalsIgnoreCase(state))
					System.out.println(addressBook.getFirst_Name() + " " + addressBook.getLast_Name());

			});

		}
	}


		
	}



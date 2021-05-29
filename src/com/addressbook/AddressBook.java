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
			System.out.println("Press 5 : Sort Contact By Name");
			System.out.println("Press 6 : Sort Contact By City");
			System.out.println("Press 7 : Sort Contact By State");
			System.out.println("Press 8 : Sort Contact By Zip");
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
			case 5:
				addressMethod.sortByName();
				break;
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
		Map<String, AddressMethods> addressbookMap = new HashMap<String, AddressMethods>();
		String name = null;
		while (true) {

			System.out.println("Enter the Address Book Name");
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
			System.out.println("Press 5: Count in city");
			System.out.println("Press 6: Count in State");
			System.out.println("Press 0: Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter city for Search");
				String city = scanner.next();
				System.out.println("Enter first name");
				String firstName = scanner.next();
				System.out.println("Enter last name");
				String lastName = scanner.next();
				SearchPersonINCity(addressbookMap, city, firstName, lastName);
				break;
			case 2:
				System.out.println("Enter state for Search");
				String state = scanner.next();
				System.out.println("Enter first name");
				String FirstName = scanner.next();
				System.out.println("Enter last name");
				String LastName = scanner.next();
				SearchPersonInState(addressbookMap, state, FirstName, LastName);
				break;
			case 3:
				System.out.println("Enter city for Search");
				String City = scanner.next();
				SearchINCity(addressbookMap, City);
				break;
			case 4:
				System.out.println("Enter state for Search");
				String State = scanner.next();
				SearchINState(addressbookMap, State);
				break;
			case 5:
				System.out.println("Enter city for Search");
				String cityCount = scanner.next();
				CountCity(addressbookMap, cityCount);
				break;
			case 6:
				System.out.println("Enter State for Search");
				String stateCount = scanner.next();
				CountState(addressbookMap, stateCount);
				break;
			case 0:
				return;
			default:
				System.out.println("Please Enter Valid choise ");
			}
		}
	}

	static void SearchPersonINCity(Map<String, AddressMethods> addressbookMap, String city, String firstName,
			String lastName) {
		for (AddressMethods iterator : addressbookMap.values()) {
			Set<ContactInfo> addressBooks = iterator.addressBook;
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
			Set<ContactInfo> addressBooks = iterator.addressBook;
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
			Set<ContactInfo> addressBooks = iterator.addressBook;
			addressBooks.stream().forEach(addressBook -> {

				if (addressBook.getCity().equalsIgnoreCase(city)) {
					System.out.println(addressBook.getFirst_Name() + " " + addressBook.getLast_Name());

				}
			});

		}
	}

	static void SearchINState(Map<String, AddressMethods> addressbookMap, String state) {
		for (AddressMethods iterator : addressbookMap.values()) {
			Set<ContactInfo> addressBooks = iterator.addressBook;
			addressBooks.stream().forEach(addressBook -> {
				if (addressBook.getState().equalsIgnoreCase(state))
					System.out.println(addressBook.getFirst_Name() + " " + addressBook.getLast_Name());

			});

		}
	}

	static void CountCity(Map<String, AddressMethods> addressbookMap, String city) {
		long count = 0;
		for (AddressMethods iterator : addressbookMap.values()) {
			Set<ContactInfo> addressBooks = iterator.addressBook;
			long count1 = addressBooks.stream().filter(s -> s.getCity().equalsIgnoreCase(city)).count();
			count = count1;
		}
		System.out.println("Person=" + count);
	}

	static void CountState(Map<String, AddressMethods> addressbookMap, String state) {
		long count = 0;
		for (AddressMethods iterator : addressbookMap.values()) {
			Set<ContactInfo> addressBooks = iterator.addressBook;
			long count1 = addressBooks.stream().filter(s -> s.getState().equalsIgnoreCase(state)).count();
			count = count1;
		}
		System.out.println("Person=" + count);
	}
}



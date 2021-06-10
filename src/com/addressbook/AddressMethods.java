package com.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AddressMethods  implements IaddressbookMethods {

	  ArrayList<ContactInfo>addressBook=new ArrayList<>();
	    FileOperatios file=new FileOperatios();

		
		@SuppressWarnings("unchecked")
		@Override
		public void add() {
				ContactInfo address = new ContactInfo();
				addressBook.add(address);
				file.addContactToFile(address);

			}

		public List<ContactInfo> getAddressBook()
		{
			return addressBook;
		}

		@Override
		public void show() {
			Iterator itr = addressBook.iterator();
			while (itr.hasNext()) {
				ContactInfo address = (ContactInfo) itr.next();
				System.out.println("Name- " + address.getFirst_Name() + " " + address.getLast_Name());
				System.out.println("Address- " + address.getAddress());
				System.out.println("City- " + address.getCity());
				System.out.println("State- " + address.getState());
				System.out.println("Zip- " + address.getZip());
				System.out.println("Phone Number- " + address.getPhone_Number());
				System.out.println("Email - " + address.getEmail());
				System.out.println("=======================================");
			}
		}
			


		@Override
		public void edit() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the name whose deatils need to change  ");
			String name = scanner.nextLine();
			System.out.println("Enter the detail you have to edit");
			while (true) {
				
				System.out.println("Press 1 : Address");
				System.out.println("Press 2 : City");
				System.out.println("Press 3 : State");
				System.out.println("Press 4 : Zip");
				System.out.println("Press 5 : Phone Number");
				System.out.println("Press 0 : Exit");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the new Address Name");
					String Addresss = scanner.next();
					for (ContactInfo iterator : addressBook) {
						if (iterator.getFirst_Name().equalsIgnoreCase(name))
							iterator.setAddress(Addresss);
					}
					break;
				case 2:
					System.out.println("Enter the new City");
					String City = scanner.next();
					for (ContactInfo iterator : addressBook) {
						if (iterator.getFirst_Name().equalsIgnoreCase(name))
							iterator.setCity(City);
					}
					break;
				case 3:
					System.out.println("Enter the new State");
					String State = scanner.next();
					for (ContactInfo iterator : addressBook) {
						if (iterator.getFirst_Name().equalsIgnoreCase(name))
							iterator.setState(State);
					}
					break;
				case 4:
					System.out.println("Enter the new Zip");
					String Zip = scanner.next();
					for (ContactInfo iterator : addressBook) {
						if (iterator.getFirst_Name().equalsIgnoreCase(name))
							iterator.setZip(Zip);
					}
					break;
				case 5:
					System.out.println("Enter the new Phone Number");
					String Phone_Number = scanner.next();
					for (ContactInfo iterator : addressBook) {
						if (iterator.getFirst_Name().equalsIgnoreCase(name))
							iterator.setPhone_Number(Phone_Number);
					}
					break;
				case 0:
					return;
				default:
					System.out.println("Please Enter Correct Option");
				}
				file.writeToFile(addressBook);
			}
			
		
		}

		@Override
		public void delete() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Name whose data to delete");
			String name = scanner.nextLine();
			JSONArray arr=file.readJsonFile();
			for(int i=0;i<arr.size();i++)
			{
				JSONObject jo=(JSONObject) arr.get(i);
				if(name.equalsIgnoreCase(jo.get("FirstName").toString()))
				{
					arr.remove(i);
					file.writeToFile(arr);
					break;
				}
			}
		}
		
			

		@Override
		public void Show(List<ContactInfo> addressBook) {
			Iterator<ContactInfo> itr = addressBook.iterator();
			while (itr.hasNext()) {
				ContactInfo address = (ContactInfo) itr.next();
				System.out.println("Name- " + address.getFirst_Name() + " " + address.getLast_Name());
				System.out.println("Address- " + address.getAddress());
				System.out.println("City- " + address.getCity());
				System.out.println("State- " + address.getState());
				System.out.println("Zip- " + address.getZip());
				System.out.println("Phone Number- " + address.getPhone_Number());
				System.out.println("Email - " + address.getEmail());
			}
		}

		@Override
		public void sortByName() {
			List<String> unsortedArrayName = new ArrayList<>();
			for (ContactInfo iterator : addressBook) {
				unsortedArrayName.add(iterator.getFirst_Name());
			}
			Stream<String> sorted = unsortedArrayName.stream().sorted();
			List<String> sortedNames = sorted.collect(Collectors.toList());

			List<ContactInfo> sortedAddressBook = new ArrayList<ContactInfo>();
			for (String sortedName : sortedNames) {
				for (ContactInfo iterator : addressBook) {
					if (sortedName.equals(iterator.getFirst_Name()))
						sortedAddressBook.add(iterator);
				}
				
			}

			Show(sortedAddressBook);
		}

		@Override
		public void sortByCity() {
			List<String> unsortedArrayCity = new ArrayList<>();
			for (ContactInfo iterator : addressBook) {
				unsortedArrayCity.add(iterator.getCity());
			}
			Stream<String> sorted = unsortedArrayCity.stream().sorted();
			List<String> sortedCity = sorted.collect(Collectors.toList());

			List<ContactInfo> sortedAddressBook = new ArrayList<ContactInfo>();
			for (String sortedCitys : sortedCity) {
				for (ContactInfo iterator : addressBook) {
					if (sortedCitys.equals(iterator.getCity()))
						sortedAddressBook.add(iterator);
				}
			}

			Show(sortedAddressBook);
		}

			

		@Override
		public void sortByState() {
			List<String> unsortedArrayState = new ArrayList<>();
			for (ContactInfo iterator : addressBook) {
				unsortedArrayState.add(iterator.getState());
			}
			Stream<String> sorted = unsortedArrayState.stream().sorted();
			List<String> sortedState = sorted.collect(Collectors.toList());

			List<ContactInfo> sortedAddressBook = new ArrayList<ContactInfo>();
			for (String sortedStates : sortedState) {
				for (ContactInfo iterator : addressBook) {
					if (sortedStates.equals(iterator.getState()))
						sortedAddressBook.add(iterator);
				}
			}

			Show(sortedAddressBook);
		}

		@Override
		public void sortByZip() {
			List<String> unsortedArrayZip = new ArrayList<>();
			for (ContactInfo iterator : addressBook) {
				unsortedArrayZip.add(iterator.getZip());
			}
			Stream<String> sorted = unsortedArrayZip.stream().sorted();
			List<String> sortedZip = sorted.collect(Collectors.toList());

			List<ContactInfo> sortedAddressBook = new ArrayList<ContactInfo>();
			for (String sortedZips : sortedZip) {
				for (ContactInfo iterator : addressBook) {
					if (sortedZips.equals(iterator.getZip()))
						sortedAddressBook.add(iterator);
				}
			}

			Show(sortedAddressBook);
		}

}

package com.addressbook;

import java.util.ArrayList;
import java.util.Iterator;

public class AddressMethods {
	ArrayList<ContactInfo> addressBook = new ArrayList<ContactInfo>();

	void Add() {
		ContactInfo address = new ContactInfo();
		addressBook.add(address);
	}

	void Show() {
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
}

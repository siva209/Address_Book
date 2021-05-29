package com.addressbook;

import java.util.Scanner;

public class ContactInfo {
	private String First_Name;
	private String Last_Name;
	private String Address;
	private String City;
	private String State;
	private String Zip;
	private String Phone_Number;
	private String Email;

	ContactInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the first name");
		First_Name = sc.nextLine();
		System.out.println("enter the last name");
		Last_Name = sc.nextLine();
		System.out.println("enter the address");
		Address = sc.nextLine();
		System.out.println("enter the city");
		City = sc.nextLine();
		System.out.println("enter the state");
		State = sc.nextLine();
		System.out.println("enter the zip");
		Zip = sc.nextLine();
		System.out.println("enter the phone number");
		Phone_Number = sc.nextLine();
		System.out.println("enter the email");
		Email = sc.nextLine();
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}

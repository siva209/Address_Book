package com.addressbook;

import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) {
			System.out.println("Welcome to Address Book Problem");
			AddressMethods address=new AddressMethods();
			while (true) {
				System.out.println("Press 1 : Add Address");
				System.out.println("Press 2 : Edit Address");
				System.out.println("Press 3 : Print Address");
				System.out.println("Press 4 : Delete Address");
				System.out.println("Press 0 : Exit");
				Scanner scanner = new Scanner(System.in);
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					address.Add();
					break;
				case 2:
					address.Edit();
					break;
				case 3:
					address.Show();
					break;
				case 4:
					address.Delete();
					break;
				case 0:
					return;
				default:
					System.out.println("Please Enter Correct Option");
				}
			}

			
		}
	}



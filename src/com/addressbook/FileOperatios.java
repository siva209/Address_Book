package com.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class FileOperatios {
	@SuppressWarnings("unchecked")
	public void addContactToFile(ContactInfo address) {
		JSONObject jsonObject=new JSONObject();
		JSONArray array=new JSONArray();
		String filePath="E:\\Siva Projects\\Java projects All\\Java Projects All\\address.json";
		//for(ContactInfo address:addresss)
		//{
			
				jsonObject.put("First_Name",address.getFirst_Name());
				jsonObject.put("Last_Name", address.getLast_Name());
				jsonObject.put("Address", address.getAddress());
				jsonObject.put("City", address.getCity());
				jsonObject.put("State", address.getState());
				jsonObject.put("Zip", address.getZip());
				jsonObject.put("Phone_Number", address.getPhone_Number());
				jsonObject.put("Email", address.getEmail());
				
				
				File f=new File(filePath);
				System.out.println("Filepath :"+f);
				if(f.length()!=0)
				{
					try {
						array=(JSONArray)new JSONParser().parse(new FileReader(filePath));
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try
				{
					System.out.println("Entered");
					FileWriter fw=new FileWriter(filePath);
					PrintWriter pw=new PrintWriter(fw);
					array.add(jsonObject);
					pw.print(array.toString());
					pw.flush();
					pw.close();
					fw.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
		//}
	}

	@SuppressWarnings("unchecked")
	public void writeToFile(ArrayList<ContactInfo> addresss) {
		JSONObject jsonObject=new JSONObject();
		JSONArray array=new JSONArray();
		String filePath="E:\\Siva Projects\\Java projects All\\Java Projects All\\address.json";
		for(ContactInfo address:addresss)
		{
			
				jsonObject.put("First_Name",address.getFirst_Name());
				jsonObject.put("Last_Name", address.getLast_Name());
				jsonObject.put("Address", address.getAddress());
				jsonObject.put("City", address.getCity());
				jsonObject.put("State", address.getState());
				jsonObject.put("Zip", address.getZip());
				jsonObject.put("Phone_Number", address.getPhone_Number());
				jsonObject.put("Email", address.getEmail());
				
				
				File f=new File(filePath);
				System.out.println("Filepath :"+f);
				try
				{
					System.out.println("Entered");
					FileWriter fw=new FileWriter(filePath);
					PrintWriter pw=new PrintWriter(fw);
					array.add(jsonObject);
					pw.print(array.toString());
					pw.flush();
					pw.close();
					fw.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
		}
	}
	
	public static JSONArray readJsonFile()
	{
		String filePath="E:\\Siva Projects\\Java projects All\\Java Projects All\\address.json";
		JSONArray arr=new JSONArray();
		try
		{
			arr=(JSONArray)new org.json.simple.parser.JSONParser().parse(new FileReader(filePath));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arr;
	}
}

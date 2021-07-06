package utils;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestDataUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getValidLoginDataExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(".\\TestDataExcel\\AssignmentData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("ValidLoginTestData"); rowNum++) {
			String userName = reader.getCellData("ValidLoginTestData", "username", rowNum);
			String passWord = reader.getCellData("ValidLoginTestData", "password", rowNum);
			
			Object ob[] = {userName, passWord};
			
			myData.add(ob);
		}
		
		return myData;
	}
	
	
	
	public static ArrayList<Object[]> getInvalidPassDataExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(".\\TestDataExcel\\AssignmentData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("InvalidPassTestData"); rowNum++) {
			String userName = reader.getCellData("InvalidPassTestData", "username", rowNum);
			String passWord = reader.getCellData("InvalidPassTestData", "password", rowNum);
			
			Object ob[] = {userName, passWord};
			
			myData.add(ob);
		}
		
		return myData;
	}
	
	
	public static ArrayList<Object[]> getInvalidUsernameDataExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(".\\TestDataExcel\\AssignmentData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("InvalidUsernameTestData"); rowNum++) {
			String userName = reader.getCellData("InvalidUsernameTestData", "username", rowNum);
			String passWord = reader.getCellData("InvalidUsernameTestData", "password", rowNum);
			
			Object ob[] = {userName, passWord};
			
			myData.add(ob);
		}
		
		return myData;
	}
	
	
	public static ArrayList<Object[]> getBlankDetailsDataExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(".\\TestDataExcel\\AssignmentData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("BlankDetailsTestData"); rowNum++) {
			String userName = reader.getCellData("BlankDetailsTestData", "username", rowNum);
			String passWord = reader.getCellData("BlankDetailsTestData", "password", rowNum);
			
			Object ob[] = {userName, passWord};
			
			myData.add(ob);
		}
		
		return myData;
	}
	
	
	public static ArrayList<Object[]> getValidRegisterDataExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(".\\TestDataExcel\\AssignmentData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("ValidRegTestData"); rowNum++) {
			String email = reader.getCellData("ValidRegTestData", "Email", rowNum);
			String firstname = reader.getCellData("ValidRegTestData", "Firstname", rowNum);
			String lastname = reader.getCellData("ValidRegTestData", "Lastname", rowNum);
			String password = reader.getCellData("ValidRegTestData", "Password", rowNum);
			String address1 = reader.getCellData("ValidRegTestData", "Address1", rowNum);
			String city = reader.getCellData("ValidRegTestData", "City", rowNum);
			String zipcode = reader.getCellData("ValidRegTestData", "ZipCode", rowNum);
			zipcode = zipcode.substring(0, 5);
			String country = reader.getCellData("ValidRegTestData", "Country", rowNum);
			String state = reader.getCellData("ValidRegTestData", "State", rowNum);
			String mobile = reader.getCellData("ValidRegTestData", "Mobile", rowNum);
			mobile = mobile.substring(0, 6);

			
			Object ob[] = {email, firstname, lastname, password, address1, city, zipcode, country, state, mobile};
			
			myData.add(ob);
		}
		
		return myData;
	}
	
	public static ArrayList<Object[]> getInvalidRegisterDataExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(".\\TestDataExcel\\AssignmentData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("InvalidRegEmail"); rowNum++) {
			String email = reader.getCellData("InvalidRegEmail", "Email", rowNum);
			
			Object ob[] = {email};
			
			myData.add(ob);
		}
		
		return myData;
	}
	
	public static ArrayList<Object[]> getAlreadyRegisterDataExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(".\\TestDataExcel\\AssignmentData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("AlreadyRegEmail"); rowNum++) {
			String email = reader.getCellData("AlreadyRegEmail", "Email", rowNum);
			
			Object ob[] = {email};
			
			myData.add(ob);
		}
		
		return myData;
	}
	
	
	public static ArrayList<Object[]> getInvalidPinExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(".\\TestDataExcel\\AssignmentData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("InvalidPinCode"); rowNum++) {
			String email = reader.getCellData("InvalidPinCode", "Email", rowNum);
			String firstname = reader.getCellData("InvalidPinCode", "Firstname", rowNum);
			String lastname = reader.getCellData("InvalidPinCode", "Lastname", rowNum);
			String password = reader.getCellData("InvalidPinCode", "Password", rowNum);
			String address1 = reader.getCellData("InvalidPinCode", "Address1", rowNum);
			String city = reader.getCellData("InvalidPinCode", "City", rowNum);
			String zipcode = reader.getCellData("InvalidPinCode", "ZipCode", rowNum);
			String country = reader.getCellData("InvalidPinCode", "Country", rowNum);
			String state = reader.getCellData("InvalidPinCode", "State", rowNum);
			String mobile = reader.getCellData("InvalidPinCode", "Mobile", rowNum);
			mobile = mobile.substring(0, 6);

			
			Object ob[] = {email, firstname, lastname, password, address1, city, zipcode, country, state, mobile};
			
			myData.add(ob);
		}
		
		return myData;
	}
	
	public static ArrayList<Object[]> getBlankRequiredFieldExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(".\\TestDataExcel\\AssignmentData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("BlankRequiredField"); rowNum++) {
			String email = reader.getCellData("BlankRequiredField", "Email", rowNum);
			String firstname = reader.getCellData("BlankRequiredField", "Firstname", rowNum);
			String lastname = reader.getCellData("BlankRequiredField", "Lastname", rowNum);
			String password = reader.getCellData("BlankRequiredField", "Password", rowNum);
			String address1 = reader.getCellData("BlankRequiredField", "Address1", rowNum);
			String city = reader.getCellData("BlankRequiredField", "City", rowNum);
			String zipcode = reader.getCellData("BlankRequiredField", "ZipCode", rowNum);
			zipcode = zipcode.substring(0, 5);
			String country = reader.getCellData("BlankRequiredField", "Country", rowNum);
			String state = reader.getCellData("BlankRequiredField", "State", rowNum);
			String mobile = reader.getCellData("BlankRequiredField", "Mobile", rowNum);
			mobile = mobile.substring(0, 6);

			
			Object ob[] = {email, firstname, lastname, password, address1, city, zipcode, country, state, mobile};
			
			myData.add(ob);
		}
		
		return myData;
	}
	
	
	public static ArrayList<Object[]> getBlankEmailExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(".\\TestDataExcel\\AssignmentData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("BlankEmail"); rowNum++) {
			String email = reader.getCellData("BlankEmail", "Email", rowNum);
			
			Object ob[] = {email};
			
			myData.add(ob);
		}
		
		return myData;
	}
}

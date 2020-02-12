import java.awt.List;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class stub {
	static Scanner input = new Scanner(System.in);
	static List userList = new List();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadAllUsers();
		loginScreen();
		
		
		for (userObject item : userList) {   
		    System.out.println(item.name);
		}
		

	}
	static void loginScreen(){
		int selection;
		while(true){
			System.out.println("1: Login");
			System.out.println("2: Make an Account");
			System.out.println("Make selection: ");
			selection = input.nextInt();
			if(selection == 1  || selection == 2)
				break;
		}
		if(selection == 1)
			login();
		else
			createProfile();
	}
	static void createProfile(){
		String name, imgLoc, status, password;
		System.out.println("Enter your name: ");
		name = input.next();
		System.out.println("Enter your Image file location: ");
		imgLoc = input.next();
		System.out.println("Enter your status: ");
		status = input.next();
		System.out.println("Enter your password: ");
		password = input.next();
		

		
			userObject me = new userObject(name, imgLoc, status, password);
			userList.add(me);

			try (ObjectOutputStream oos =
					new ObjectOutputStream(new FileOutputStream("C:\\Users\\Computer\\workspace\\chap 13 pro 16\\users.ser", true))) {

				oos.writeObject(userList);
				System.out.println("Done");
				oos.close();
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}

	}
		
		//write input to file
		//save close file
		//read file to arraylist
		
	
	static void login(){
		String name, password;
		System.out.print("Enter your name: ");
		name = input.nextLine();
		System.out.print("Enter your password: ");
		password = input.nextLine();
		
		//find name in array list if exists and password is correct load profile and set isMe to true.
		
	}
	
	@SuppressWarnings("unchecked")
	static void loadAllUsers(){
		
		
		
		
		try {

	         // create an ObjectInputStream for the file we created before
	         ObjectInputStream ois =
	                 new ObjectInputStream(new FileInputStream("C:\\Users\\Computer\\workspace\\chap 13 pro 16\\users.ser"));
	       

	         
	         while(true) // check if the file stream is at the end
	         {
	        	try{
	            userList = (ArrayList<userObject>) ois.readObject();
	         	            
	            // read from the object stream,
	                                         
	        
	        	} catch (EOFException ex){
	        		System.out.println("EOF");
	        		break;
	        	}
	         }


	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } 
	}

}

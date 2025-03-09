package com.main;

import java.util.Scanner;

import com.entity.UserDetails;
import com.implementingInterfaceActions.BankActionImp;
import com.implementingInterfaceActions.UserActionImp;
import com.service.BankAccount;

public class Main {
	static void displayMenu(Scanner sc)
	{   
		UserActionImp uai=new UserActionImp();
		System.out.println("Welcome To CommandLine Payment App !");
		boolean loop=true;
		while(loop) {
		System.out.println("1.Registration");
		System.out.println("2.Login");
		System.out.println("3.Number of System Users");
		System.out.println("4.Exit From System");
		System.out.println("CHoose Your Choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1: 
			UserDetails user=registration(sc);
			uai.userRegistration(user);
			System.out.println("Registered Successfully !");
			break;
		case 2:
			sc.nextLine();
			System.out.println("Please Login With Your Details");
			System.out.println("Enter User Name");
			String userName=sc.nextLine();
			System.out.println("Enter Your Password");
			String userPassword=sc.nextLine();
			if(uai.userLogin(userName, userPassword))
			{
			       loginMenu(sc,uai.loggedInUser,uai);	
			}else {
				System.out.println("Invalid Credentials");
				System.out.println("Try Again !");
				
			}
			break;
		case 3 :
			System.out.println("Number of Users");
			System.out.println(UserActionImp.userList.size());
			break;
			
		case 4:
			System.out.println("Exiting from the System!");
			System.out.println("Thank You!");
			loop=false;
			break;
			
		}
		
		if(choice!=4) {
			System.out.println("Do You Want To Continue To Home Page y/n");
			char proceed=sc.next().charAt(0);
			if(proceed=='y')
			{
				loop=true;
			}else {
				System.out.println("Exiting from the System!");
				System.out.println("Thank You!");
				loop=false;
			}
		}
		
			
		
	}
	}
	
	public static UserDetails registration(Scanner sc)
	{       sc.nextLine();
			System.out.println("Enter User Name");
			String userName=sc.nextLine();
			System.out.println("Enter  Password");
			String userPassword=sc.nextLine();
			System.out.println("Enter First Name");
			String userFirstName=sc.nextLine();
			System.out.println("Enter Last Name");
			String userLastName=sc.nextLine();
			System.out.println("Enter Phone Number");
			String userPhoneNumber=sc.nextLine();
			System.out.println("Enter Email Id");
			String userEmailId=sc.nextLine();
			System.out.println("Enter Address");
			String userAddress=sc.nextLine();
			
			UserDetails user=new UserDetails(userName,userPassword,userFirstName,userLastName,userPhoneNumber,userEmailId,userAddress);
			return user;
			
	}
	
	public static void loginMenu(Scanner sc,UserDetails user,UserActionImp uai) {
		BankActionImp bai=new BankActionImp();
		System.out.println("Welcome "+user.getFirstName() + user.getLastName()+"!");
		System.out.println("1.View Your Profile");
		System.out.println("2.Bank Accounts");
		System.out.println("3.Transactions");
		System.out.println("4.Send Money");
		System.out.println("5.Logout");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			uai.displayUserDetalis(user);
			break;
			
		case 2:
		    BankAccount.start(sc,user,bai);
		    break;
		}
		
			
		
	}
	
	
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	displayMenu(sc);
	
}
}

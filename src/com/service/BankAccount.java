package com.service;

import java.util.Scanner;

import com.entity.BankAccountDetails;
import com.entity.UserDetails;
import com.implementingInterfaceActions.BankActionImp;

public class BankAccount {
	
	
	static void removeBank(Scanner sc,UserDetails user,BankActionImp bai)
	{     
		 System.out.println("User Banks :");
		 for(BankAccountDetails bank:user.getBanks())
		 {
			 System.out.println(bank.getBankName());
		 }
		 System.out.println("Enter The Bank Name You Want To Remove");
		 String bankName=sc.nextLine();
		 bai.removeBankAccount(user, bankName);
	}
	
	static void editBankStatus(Scanner sc,UserDetails user,BankActionImp bai)
	{    
		 System.out.println("USer Banks :");
		 for(BankAccountDetails bank:user.getBanks())
		 {
			 System.out.println(bank.getBankName());
		 }
		 System.out.println("Enter The Bank Name You Want To Edit");
		 String bankName=sc.nextLine();
		 System.out.println("Enter Your Bank Account Status");
		 String accountStatus=sc.nextLine();
		 bai.updateBankStatus(accountStatus, bankName, user);
	}
	
	static void getAllBanks(Scanner sc,UserDetails user,BankActionImp bai)
	{    
		
		 System.out.println("User Banks :");
		 for(BankAccountDetails bank:user.getBanks())
		 {
			 System.out.println(bank.getBankName());
		 }
		 System.out.println("Enter The Bank Name You Want To View ");
		 String bankName=sc.nextLine();
		 bai.viewAccountDetails(user,bankName);
		 }
		 
	
	
  	static BankAccountDetails getBank(Scanner sc,UserDetails user)
	{
		System.out.println("Enter Account Number");
		long accountNumber=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter IFSC CODE");
		String ifscCode=sc.nextLine();
		System.out.println("Enter Account Status");
		String accountStatus=sc.nextLine();
		System.out.println("Enter Bank Name");
		String bankName=sc.nextLine();
		System.out.println("Enter Bank Branch Location");
		String bankLocation=sc.nextLine();
		BankAccountDetails bank=new BankAccountDetails(accountNumber,ifscCode,accountStatus,bankName,bankLocation,user);
		return bank;
	}
	
  public static void start(Scanner sc,UserDetails user,BankActionImp bai)
  {    
	  boolean loop=true;
	  while(loop)
	  {
		  
	  
	  System.out.println("1.Add Bank Account");
	  System.out.println("2.View Bank Account");
	  System.out.println("3.Edit Bank Account Status");
	  System.out.println("4.Remove A  Bank Account");
	 
	  int choice=sc.nextInt();
	  switch(choice)
	  {
	  case 1:
		  
		     BankAccountDetails bank=getBank(sc,user);
		     bai.addBankAccount(bank);
		     break;
		     
	  case 2:
		   sc.nextLine();
		   getAllBanks(sc,user,bai);
		   break;
		   
	  case 3:
		  sc.nextLine();
		   editBankStatus(sc,user,bai);
		   break;
	
	  case 4:
		     sc.nextLine();
		     removeBank(sc,user,bai);
		     break;
		     
	 default :
		 System.out.println("Invalid Choice..!");
		     
	  } 
	  System.out.println("Do You Want To Continue Bank Section ? y/n");
	  char proceed=sc.next().charAt(0);
	  if(proceed=='y')
	  {
		  loop=true;
	  }
	  else
	  {
		  loop=false;
	  }
		 
	  }
	  
	  
	  
  }
}

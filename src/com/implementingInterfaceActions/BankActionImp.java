package com.implementingInterfaceActions;

import com.entity.BankAccountDetails;
import com.entity.UserDetails;
import com.interfaceActions.BankActions;

public class BankActionImp implements BankActions{

	@Override
	public void updateBankStatus(String accountStatus,String bankName,UserDetails user) {
		   for(BankAccountDetails ac:user.getBanks())
		   {
			   if(ac.getBankName().equals(bankName))
			   {
				  ac.setAccountStatus(accountStatus);
			   }
		   }
		   System.out.println("Status Updated!");
	        	
	}

	
	public void addBankAccount(BankAccountDetails bank) {
		bank.getUser().setBanks(bank);
		System.out.println("Bank Added Successfully");
		
	}

	@Override
	public void removeBankAccount(UserDetails user,String bankName)
	{
		for(BankAccountDetails bank:user.getBanks())
		{
			if(bank.getBankName().equals(bankName))
			{
				user.getBanks().remove(bank);
				System.out.println("Bank Is Removed");
				break;
			}else
				System.out.println("Bank Not Found!");
		}
		
	}

	@Override
	public void viewAccountDetails(UserDetails user,String bankName) {
		for(BankAccountDetails bank:user.getBanks())
		 {
			 if(bank.getBankName().equals(bankName))
			 {
				 System.out.println(bank);
			 }
		 }
	}

}

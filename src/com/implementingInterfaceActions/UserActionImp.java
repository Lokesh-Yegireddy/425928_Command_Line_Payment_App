package com.implementingInterfaceActions;

import java.util.ArrayList;
import java.util.List;

import com.entity.UserDetails;
import com.interfaceActions.UserActions;

public class UserActionImp implements UserActions {
	
	public static List<UserDetails> userList=new ArrayList<UserDetails>();
    public UserDetails loggedInUser;
	@Override
	public void userRegistration(UserDetails user) {
	     userList.add(user);
	}
	
	@Override
	public boolean userLogin(String userName,String password) {
		boolean loginStatus=false;
		for(UserDetails user:userList)
		{
			if(user.getUserName().equals(userName) && user.getPassword().equals(password))
			{
				System.out.println("Login Successfull!");
				loggedInUser=user;
				loginStatus=true;
			}
				
		}
		
		return loginStatus;
	}

	@Override
	public void displayUserDetalis(UserDetails user) {
		 System.out.println(user);
		
	}

	

	
	
}

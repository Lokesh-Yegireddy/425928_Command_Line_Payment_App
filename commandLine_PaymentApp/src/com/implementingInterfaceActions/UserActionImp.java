package com.implementingInterfaceActions;

import java.util.ArrayList;
import java.util.List;

import com.entity.UserDetails;
import com.interfaceActions.UserActions;

public class UserActionImp implements UserActions {
	
	List<UserDetails> userList=new ArrayList<UserDetails>();
    public UserDetails loggedInUser;
	@Override
	public void userRegistration(UserDetails user) {
	     userList.add(user);
	}
	
	@Override
	public void userLogin(UserDetails user) {
		loggedInUser=user;
		
	}

	@Override
	public void displayUserDetalis(UserDetails user) {
		 System.out.println(user);
		
	}

	

	
	
}

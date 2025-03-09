package com.interfaceActions;

import com.entity.UserDetails;

public interface UserActions {
     void userRegistration(UserDetails user);
     void displayUserDetalis(UserDetails user);
     boolean userLogin(String userName,String password);
     
     
}

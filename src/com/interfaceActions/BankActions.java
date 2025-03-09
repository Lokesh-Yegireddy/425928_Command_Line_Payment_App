package com.interfaceActions;

import com.entity.BankAccountDetails;
import com.entity.UserDetails;

public interface BankActions {
void updateBankStatus(String accountStatus,String bankName,UserDetails user);
void addBankAccount(BankAccountDetails bank);
void removeBankAccount(UserDetails user,String bankName);
void viewAccountDetails(UserDetails user,String bankName);

}

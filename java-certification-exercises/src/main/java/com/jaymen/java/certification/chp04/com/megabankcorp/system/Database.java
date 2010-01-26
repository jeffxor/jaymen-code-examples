package com.jaymen.java.certification.chp04.com.megabankcorp.system;

import com.jaymen.java.certification.chp04.com.megabankcorp.records.Account;

/**
 * Implementation based of the exercise described in the BankDatabase.txt
 * file.
 *
 */
public abstract class Database {
	
	abstract public void depoist(Account account, double amount);
	abstract public void withdraw(Account account, double amount);
	abstract protected double getBalance(Account account);
	
	final void transfer(Account fromAccount, Account toAccount, double amount){
		withdraw(fromAccount, amount);
		depoist(toAccount, amount);
	}
}
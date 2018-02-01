package bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	private Map <String, BankAccount> accounts = new HashMap<String, BankAccount>();

	public void addAccount(BankAccount newAccount) {
		accounts.put(newAccount.getAccountNumber(), newAccount);
	}

	public int listSize() {
		return accounts.size();
	}

	public BankAccount getAccount(String accountNumber) {
		BankAccount check =  accounts.get(accountNumber);
		return check;
		
	}
	public String getAccountNumber(String accountNumber) {
		return accounts.get(accountNumber).getAccountNumber();
	}
	public double getAccountBalance(String accountNumber) {
		return accounts.get(accountNumber).getBalance();
		
	}

	public String getAccountType(String accountNumber) {
		return accounts.get(accountNumber).getAccountType();
	}

	public boolean withdraw(String accountNumber, double amountToWithdraw) {
		if (amountToWithdraw <= getAccountBalance(accountNumber)) {
		BankAccount accountToWithdraw = getAccount(accountNumber);
		accountToWithdraw.withdraw(amountToWithdraw);
		return true;
		}
		return false;
	}

	public boolean deposit(String accountNumber, int amountToDeposit) {
		if (amountToDeposit > 0) {
			BankAccount accountToDeposit = getAccount(accountNumber);
			accountToDeposit.deposit(amountToDeposit);
			return true;
			}
			return false;
	}

	public void removeAccount(String accountNumber) {
		accounts.remove(accountNumber);
	}
	
	

	

}

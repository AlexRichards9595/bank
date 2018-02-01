package bank;

public class BankAccount {

	private String accountNumber;
	private String accountType;
	private double balance;
	
	public BankAccount(String accountNumber, String accountType, double balance) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	@Override
	public String toString() {
		return (accountNumber + accountType + balance);
	}

	public void withdraw(double amount ) {
		balance = getBalance()-amount;
	}

	public void deposit(int amount) {
		balance = getBalance()+amount;
	}

}

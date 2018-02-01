package bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
	
	private Bank underTest;
	
	@Before
	public void setup() {
		Bank underTest = new Bank();
	}

	@Test
	public void assertThatAnAccountHasBeenAdded() {
		Bank underTest = new Bank();
		underTest.addAccount(new BankAccount("","",0));
		int check = underTest.listSize();
		assertEquals(1, check);
	}
	@Test
	public void assertThatTwoOrdersHaveBeenAdded() {
		Bank underTest = new Bank();
		underTest.addAccount(new BankAccount("1","", 0));
		underTest.addAccount(new BankAccount("","", 0));

		int check = underTest.listSize();
		
		assertEquals(2, check);
	}
	@Test 
	public void assertThatAccountNumberPullsAccountInfo() {
		Bank underTest = new Bank();
		BankAccount expected = new BankAccount("1111", "Checking", 500.00);
		underTest.addAccount(expected);
		BankAccount check = underTest.getAccount("1111");
		
		assertEquals(expected, check);
	}
	@Test
	public void assertsThatAccountNumberPullsNumberFromCorrectAccount() {
		Bank underTest= new Bank();
		underTest.addAccount(new BankAccount("1111","Checking", 250));
		underTest.addAccount(new BankAccount("2222","Savings", 5000));
		String check = underTest.getAccountNumber("1111");
		
		assertEquals("1111", check);
		
	}
	@Test
	public void assertsThatAccountNumberPullsTypeFromCorrectAccount() {
		Bank underTest= new Bank();
		underTest.addAccount(new BankAccount("1111","Checking", 250));
		underTest.addAccount(new BankAccount("2222","Savings", 5000));
		String check = underTest.getAccountType("1111");
		
		assertEquals("Checking", check);
	}
	@Test
	public void assertsThatAccountNumberPullsBalanceFromCorrectAccount() {
		Bank underTest = new Bank();
		underTest.addAccount(new BankAccount("1111","Checking", 250));
		underTest.addAccount(new BankAccount("2222","Savings", 5000));
		double check = underTest.getAccountBalance("1111");
		
		assertEquals(250, check,.01);
	}
	@Test
	public void assertsThatMoneyHasBeenWithdrawn() {
		Bank underTest = new Bank();
		underTest.addAccount(new BankAccount("1111","Checking", 250));
		underTest.withdraw("1111", 50);
		double check = underTest.getAccountBalance("1111");
		assertEquals(200, check,.01);
	}
	@Test
	public void assertsThatWithdrawalWasSuccessful() {
		Bank underTest = new Bank();
		underTest.addAccount(new BankAccount("1111", "Checking", 250));
		boolean check = underTest.withdraw("1111", 50);
		
		Assert.assertTrue(check);
	}
	@Test
	public void assertsThatMoneyHasBeenDeposited() {
		Bank underTest = new Bank();
		underTest.addAccount(new BankAccount("1111","Checking", 250));
		underTest.deposit("1111", 50);
		double check = underTest.getAccountBalance("1111");
		assertEquals(300, check,.01);
	}
	@Test
	public void assertsThatDepositWasSuccessful() {
		Bank underTest = new Bank();
		underTest.addAccount(new BankAccount("1111", "Checking", 250));
		boolean check = underTest.deposit("1111", 50);
		
		Assert.assertTrue(check);
	}
	@Test
	public void assertsThatAccountWasRemoved() { 
		Bank underTest = new Bank();
		underTest.addAccount(new BankAccount("1111", "Checking", 250));
		underTest.addAccount(new BankAccount("2222", "Savings", 1000));
		underTest.removeAccount("1111");
		BankAccount check = underTest.getAccount("1111");
		Assert.assertNull(check);
	}
} 

package bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;



public class BankAccountTest {
	
	


	@Test
	public void shouldInstantiateAnAccountObjectWithATypeAndBalance() {
		BankAccount underTest = new BankAccount("","", 0);

		assertNotNull(underTest);
	}
	
	@Test
	public void shouldReturnAnAccountNumberAsOnes() {
		BankAccount underTest = new BankAccount("","",0);
		String check = underTest.getAccountNumber();
		
		assertEquals("1111", check);
	}
	
	@Test
	public void shouldReturnAnAccountTypeAsChecking() {
		BankAccount underTest = new BankAccount("","Checking", 0);
		String check = underTest.getAccountType();
		
		
		assertEquals("Checking", check);
		
	}
	
	@Test
	public void shouldReturnNumberOfBalanceAsOne() {
		BankAccount underTest = new BankAccount("","", 1);
		double check = underTest.getBalance();
		
		
		assertEquals(1, check,.001);
	}

}

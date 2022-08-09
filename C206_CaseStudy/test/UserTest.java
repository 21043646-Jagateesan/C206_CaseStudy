//Done by Trina Ng

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user1;
	private User user2;
	private ArrayList<User> customerList;

	@Before
	public void setUp() throws Exception {
		user1 = new User("Alice", "customer", "alice@gmail.com", 12345678, "pass@customer1");
		user2 = new User("Norman", "customer", "norman@gmail.com", 87654321, "pass@customer2");
		
		customerList = new ArrayList<User>();
	}
	
	@Test
	public void testAddUser() {
		// Before new account is added, test that customer list is not null. - boundary
		assertNotNull(customerList);
		
		//Test that after adding one user, the size of the list is one  - normal
		//user just added is the same as first account in the list.
		UserMain.addUser(customerList, user1);
		assertEquals(1, customerList.size());
		assertSame(user1, customerList.get(0));
		
		//Test adding another item - normal
		//and testing that the size of the list becomes 2
		//the item just added is the same as second account in the list.
		UserMain.addUser(customerList, user2);
		assertEquals(2, customerList.size());
		assertSame(user2, customerList.get(1));
	}
	
	@Test
	public void testRetrieveUser() {
		//Test that customer list is not null
		assertNotNull(customerList);
		
		//Test that when the list is empty, system displays a message “List is empty”
		String allUsers = UserMain.retrieveAllUser(customerList);
		String testOutput = "";
		assertEquals(testOutput, allUsers);
		
		//Given an empty list
		//after adding 2 items
		//test if the size of the list is 2
		customerList.add(user1);
		customerList.add(user2);
		assertEquals(2, customerList.size());
		
		//Test whether expected output string is the same as the list of customers retrieved from case study.
		allUsers = UserMain.retrieveAllUser(customerList);
		testOutput = String.format("%-10s %-20s %-20s %-17d %-20s %-10s\n","Alice", "customer", "alice@gmail.com", 12345678, "pass@customer1", "New");
		testOutput += String.format("%-10s %-20s %-20s %-17d %-20s %-10s\n","Norman", "customer", "norman@gmail.com", 87654321, "pass@customer2", "New");
		assertEquals(testOutput, allUsers);
	}
	
	@Test
	public void testDeleteUser() {
		customerList.add(user1);
		customerList.add(user2);
		
		//Test that customer list is not null
		assertNotNull(customerList);
		
		//Test whether the account name input by the administrator is in the customer list.
		String inputName = "Norman";
		boolean exists = UserMain.testExists(customerList, inputName);
		assertTrue(exists);
		
		//Given 2 accounts have been added to the list
		//test whether deleting an account will affect the customer list size accordingly
		//(customer list size should decrease by 1).
		customerList.remove(user2);
		assertEquals(1, customerList.size());
		
		//Test whether the deleted account is in the customer list
		boolean exists2 = UserMain.testExists(customerList, inputName);
		assertFalse(exists2);
	}
	
	@After
	public void tearDown() throws Exception {
	}
}

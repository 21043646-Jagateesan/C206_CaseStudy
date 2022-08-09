import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PackageTest {
	
	private Package Package1;
	private Package Package2;
	private Package Package3;
	
	ArrayList<Package> pList = new ArrayList<Package>();

	public PackageTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		Package1 = new Package("Jack", 1001, "12/02/2022", "15/05/2023", 100.23);
		Package2 = new Package("Shaun", 1032, "16/08/2022", "14/09/2024", 455.24);
		Package3 = new Package("David", 1112, "22/06/2022", "04/05/2024", 150.10);
		
		ArrayList<Package> pList = new ArrayList<Package>();
	}
	@Test
	public void testAddPackage() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid PackageArrayList to add to", pList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		PackageMain.testAdd(pList, Package1);		
		assertEquals("Test if that Package arraylist size is 1?", 1, pList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Package is added same as 1st item of the list?", Package1, pList.get(0));
		
		//Add another item. test The size of the list is 2?
		PackageMain.testAdd(pList, Package2);
		PackageMain.testAdd(pList, Package3);
		assertEquals("Test that Package arraylist size is 3?", 3, pList.size());
		assertSame("Test that Package is added same as 3rd item of the list?", Package3, pList.get(2));
	}
	@Test
	public void testDeletePackage() {
		// Test delete of existing building name in array list - Boundary Test
		int code = 1001;
		boolean deleted = PackageMain.testDelete(code);
		assertTrue(deleted);
		
		// Test delete for non-existent building in array list - Exceptional Test
		int code2 = 1002;
		boolean deleted2 = PackageMain.testDelete(code2);
		assertFalse(deleted2);
		
		// Test invalid input - empty string - Exceptional Test
		int code3 = 1003;
		boolean deleted3 = PackageMain.testDelete(code3);
		assertFalse(deleted3);
	}
	@Test
    public void testRetrieveAllPackage() {
        // Test if Item list is not null but empty -boundary
        assertNotNull("Test if there is valid Quotation arraylist to retrieve item", pList);

        //test if the list of packages retrieved from the SourceCentre is empty - boundary
        String allPackages= PackageMain.retrieveAllPackage(pList);
        String testOutput = "";
        assertEquals("Check that ViewAllPackagelist", testOutput, allPackages);

        //Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
        PackageMain.addPackage(pList, Package1);
        PackageMain.addPackage(pList, Package2);
        assertEquals("Test that Package arraylist size is 2", 2, pList.size());

        //test if the expected output string same as the list of package retrieved from the PackageMain  
        allPackages= PackageMain.retrieveAllPackage(pList);
        testOutput = String.format("%-10s %-20d %-25s %-30s %-20.1f\n", "Jack", 1001, "12/02/2022", "15/05/2023", 100.23);
        testOutput += String.format("%-10s %-20d %-25s %-30s %-20.1f\n", "Shaun", 1032, "16/08/2022", "14/09/2024", 455.24);

        assertEquals("Test that ViewAllPackagelist", testOutput, allPackages);

    }
}

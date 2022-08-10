import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QuotationTest {
	
	public ArrayList<Quotation> quotationlist;
	
	public QuotationTest() {
		super();
	}
	
	public void setUp() {
		q1 = new Quotation("Amani", "85113257", 2000.00);
		q2 = new Quotation("James", "99807721", 2341.00);
		
		quotationlist = new ArrayList<Quotation>();
	}
	
	//@Test
	private Quotationmain Quotation;
	private Quotation q1;
	private Quotation q2;
	
	@Before
	public void initOperator() {
		
		Quotation = new Quotationmain();
		Quotation.listadd();
		
		Quotation q1 = new Quotation("Amani", "85113257", 2000.00);
		Quotation q2 = new Quotation("James", "99807721", 2341.00);
		
	}
	
	@Test
	public void addQuotationNull() {
		
		assertFalse(Quotation.addQuotation(null));
		assertEquals(2, Quotation.getQuotation().size());
		//change size
		
	}
	
	@Test
	public void addQuotation_1() {
		assertEquals(2, Quotation.getQuotation().size());
		assertTrue(Quotation.addQuotation(q1));
		assertEquals(3, Quotation.getQuotation().size());
		
	}
	
	@Test
	public void addQuotation_2() {
		assertEquals(2, Quotation.getQuotation().size());
		assertTrue(Quotation.addQuotation(q1));
		assertTrue(Quotation.addQuotation(q1));
		assertEquals(4, Quotation.getQuotation().size());
	}
	
	
	

	
	
	

}

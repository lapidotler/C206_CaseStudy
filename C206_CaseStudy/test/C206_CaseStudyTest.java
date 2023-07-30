import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Quote qr1;
	private Quote qr2;
	private Appointment ap1;
	private Appointment ap2;
	
	private ArrayList<Quote> quoteList;
	private ArrayList<Appointment> appointmentList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		qr1 = new Quote("QR001", "Kitchen Remodeling", "John Doe", 91827364, "Kitchen Renovation Price Query");
		qr2 = new Quote("QR002", "Bathroom Renovation", "Jane Smith", 98765432, "Bathroom Remodeling Availability");
		ap1 = new Appointment("AP001", "Kitchen Remodeling", "Michael Johnson", "2023-07-25", "10:00 AM", "123 Main Street");
		ap2 = new Appointment("AP002", "Bathroom Renovation", "Emily Brown", "2023-07-26", "2:30 PM", "456 Oak Avenue");

		quoteList= new ArrayList<Quote>();
		appointmentList= new ArrayList<Appointment>();
	}
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest", true);
	}
	
	//============================================ START HERE ==============================================
	
	//=========================== Irfan's Test Code ===========================
	
	@Test
	public void testCreateQuote() {
		assertNotNull("Check if there is valid Quote arraylist to add to", quoteList);
		
		// Test case 1: Check that list is not null, so that can add a new quote
		C206_CaseStudy.createQuote(quoteList, qr1);
		assertEquals("Check that Quote arraylist size is 1", 1, quoteList.size());
		assertSame("Check that Quote is added", qr1, quoteList.get(0));
		// Given an empty list, after adding 1 item, the size of the list is 1
		
		
		
		// Test case 2: Add another quote. Test the size of the list is 2
		C206_CaseStudy.createQuote(quoteList, qr2);
		assertEquals("Check that Quote arraylist size is 2", 2, quoteList.size());
		assertSame("Check that Quote is added", qr2, quoteList.get(1));

	    
		
	    // Test case 3: Add an item that already exists in the list
	    C206_CaseStudy.createQuote(quoteList, qr2);
	    assertEquals("Test that the Quote ArrayList size is unchanged.", 2, quoteList.size());
	    
	    
	    
	    // Test case 4: Add an item that has missing detail
	    Quote qr_missing = new Quote("QR0015", "", "Jane Doe", 98765432, "Bathroom Renovation Inquiry");
	    C206_CaseStudy.createQuote(quoteList, qr_missing);
	    assertEquals("Test that the Quote ArrayList size is unchanged.", 2, quoteList.size());
	}
	
	@Test
	public void testTrackQuoteStatus() {
	    // Test case 1: Retrieve existing quotes for an existing user (recipientName: "John Doe")
	    quoteList.add(qr1);
	    quoteList.add(qr2);
	    ArrayList<Quote> johnDoeQuotes = C206_CaseStudy.getUserQuote(quoteList, "John Doe");
	    assertNotNull("Test that the list of quotes for user 'John Doe' is not null", johnDoeQuotes);
	    assertEquals("Test that the list of quotes for user 'John Doe' has the expected number of quotes", 1, johnDoeQuotes.size());

	    
	    
	    // Test case 2: Retrieve existing quotes for an existing user with multiple quotes (recipientName: "Jane Smith")
	    ArrayList<Quote> janeSmithQuotes = C206_CaseStudy.getUserQuote(quoteList, "Jane Smith");
	    assertNotNull("Test that the list of quotes for user 'Jane Smith' is not null", janeSmithQuotes);
	    assertEquals("Test that the list of quotes for user 'Jane Smith' has the expected number of quotes", 1, janeSmithQuotes.size());

	    
	    
	    // Test case 3: Retrieve existing quotes for an existing user with no quotes (recipientName: "Emily Brown")
	    ArrayList<Quote> emilyBrownQuotes = C206_CaseStudy.getUserQuote(quoteList, "Emily Brown");
	    assertNull("Test that the list of quotes for user 'Emily Brown' is null", emilyBrownQuotes);
	}
	
	//=========================== Syaza's Test Code ===========================
	
	//=========================== Yongyi's Test Code ===========================
	
	//=========================== Jovan's Test Code ===========================
	
	//=========================== Ernest's Test Code ===========================
	
	
	
	//============================================= END HERE ===============================================
	@After
	public void tearDown() throws Exception {
		qr1 = null;
		qr2 = null;
		ap1 = null;
		ap2 = null;
		quoteList = null;
		appointmentList = null;
	}

}

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	
	private User sp1;
	private User sp2;
	private User admin;
	
	private RenovationServices rs1;
	private RenovationServices rs2;
	
	private Quote qr1;
	private Quote qr2;
	
	private Appointment ap1;
	private Appointment ap2;
	
	private ArrayList<User> userList;
	private ArrayList<RenovationServices> serviceList;
	private ArrayList<Quote> quoteList;
	private ArrayList<Appointment> appointmentList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		
		// Users
		u1 = new User("John Doe", "1990-01-01", "john.doe@gmail.com", "password123", "User");
		u2 = new User("Jane Smith", "1985-05-15", "jane.smith@gmail.com", "securepass", "User");
		u3 = new User("Michael Johnson", "1988-09-20", "michael.johnson@hotmail.com", "pass123", "User");
		u4 = new User("Emily Brown", "1992-04-30", "emily.brown@gmail.com", "brownie456", "User");
		
		// Service Providers
		sp1 = new User("Kitchen Remodeling Service", "1980-10-10", "krs@hotmail.com", "krs123", "Service Provider");
		sp2 = new User("Bathroom Renovation Service", "1975-06-20", "brs@gmail.com", "brs456", "Service Provider");
		
		// Admin*
		admin = new User("Admin User", "1985-03-25", "admin@gmail.com", "admin123", "Admin");
		
		
		rs1 = new RenovationServices("RS001", "Kitchen Remodeling Service", "Full kitchen remodeling and renovations", "Mon-Fri: 9am-5pm", true);
	    rs2 = new RenovationServices("RS002", "Bathroom Renovation Service", "Bathroom renovation and upgrades", "Mon-Sat: 8am-6pm", true);
		
		qr1 = new Quote("QR001", "Kitchen Remodeling Service", "John Doe", 91827364, "Kitchen Renovation Price Query");
		qr2 = new Quote("QR002", "Bathroom Renovation Service", "Jane Smith", 98765432, "Bathroom Remodeling Availability");
		
		ap1 = new Appointment("AP001", "Kitchen Remodeling Service", "Michael Johnson", "2023-07-25", "10:00 AM", "123 Main Street");
		ap2 = new Appointment("AP002", "Bathroom Renovation Service", "Emily Brown", "2023-07-26", "2:30 PM", "456 Oak Avenue");

		serviceList= new ArrayList<RenovationServices>();
		quoteList= new ArrayList<Quote>();
		appointmentList= new ArrayList<Appointment>();
		userList = new ArrayList<User>();
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
	
	@Test
	public void testDeleteQuote() {
	    // Test case 1: Normal Test - Delete existing quote
	    quoteList.add(qr1);
	    quoteList.add(qr2);
	    
	    boolean deleted = C206_CaseStudy.deleteQuote(quoteList, "QR001");
	    assertTrue("Test normal deletion - quote should be deleted", deleted);
	    assertEquals("Test normal deletion - quote list size should decrease by 1", quoteList.size(), 1);
	
	
	
	    // Test case 2: Boundary Test - Delete with empty assertTag
	    boolean emptyDeleted = C206_CaseStudy.deleteQuote(quoteList, "");
	    assertFalse("Test empty assertTag deletion - quote should not be deleted", emptyDeleted);
	    assertEquals("Test empty assertTag deletion - quote list size should remain unchanged", quoteList.size(), quoteList.size());
	
	
	
	    // Test case 3: Error Test - Delete with invalid assertTag
	    boolean invalidDeleted = C206_CaseStudy.deleteQuote(quoteList, "InvalidTag");
	    assertFalse("Test invalid assertTag deletion - quote should not be deleted", invalidDeleted);
	    assertEquals("Test invalid assertTag deletion - quote list size should remain unchanged", quoteList.size(), quoteList.size());
	}
	
	@Test
	public void testRetrieveAllRenovationServices() {
	    // Test Case 1: Empty list
	    String allRenovationServices = C206_CaseStudy.retrieveAllRenovationServices(serviceList);
	    String testOutput = "";
	    assertEquals("Test that nothing is displayed", testOutput, allRenovationServices);

	    
	    // Test Case 2: Two renovation services in the list
	    serviceList.add(rs1);
	    serviceList.add(rs2);
	    assertEquals("Test that renovation services arraylist size is 2.", 2, serviceList.size());
	    
	    allRenovationServices = C206_CaseStudy.retrieveAllRenovationServices(serviceList);
	    testOutput = String.format("%-15s %-30s %-45s %-20s %-20s\n", "RS001", "Kitchen Remodeling Service",
	            "Full kitchen remodeling and renovations", "Mon-Fri: 9am-5pm", "Pending");
	    testOutput += String.format("%-15s %-30s %-45s %-20s %-20s\n", "RS002", "Bathroom Renovation Service",
	            "Bathroom renovation and upgrades", "Mon-Sat: 8am-6pm", "Pending");
	    assertEquals("Test that the display is correct.", testOutput, allRenovationServices);

	    
	    // Test Case 3: Add a renovation service with isAvailable = false
	    RenovationServices rs3 = new RenovationServices("RS003", "Hotel Accommodation Service",
	            "Hotel room renovation and upgrade", "24/7", false);
	    serviceList.add(rs3);
	    assertEquals("Test that renovation services arraylist size is 3.", 3, serviceList.size());
	    
	    allRenovationServices = C206_CaseStudy.retrieveAllRenovationServices(serviceList);
	    testOutput += String.format("%-15s %-30s %-45s %-20s %-20s\n", "RS003", "Hotel Accommodation Service",
	            "Hotel room renovation and upgrade", "24/7", "Resolved");
	    assertEquals("Test that the display is correct.", testOutput, allRenovationServices);
	}
	
	@Test
	public void testDeleteRenovationService() {
	    // Test case 1: Normal Test - Delete existing service
	    serviceList.add(rs1);
	    serviceList.add(rs2);
	    
	    boolean deleted = C206_CaseStudy.deleteService(serviceList, "RS001");
	    assertTrue("Test normal deletion - service should be deleted", deleted);
	    assertEquals("Test normal deletion - quote list size should decrease by 1", quoteList.size(), 1);
	
	
	
	    // Test case 2: Boundary Test - Delete with empty assertTag
	    boolean emptyDeleted = C206_CaseStudy.deleteService(serviceList, "");
	    assertFalse("Test empty assertTag deletion - quote should not be deleted", emptyDeleted);
	    assertEquals("Test empty assertTag deletion - quote list size should remain unchanged", serviceList.size(), serviceList.size());
	
	
	
	    // Test case 3: Error Test - Delete with invalid assertTag
	    boolean invalidDeleted = C206_CaseStudy.deleteService(serviceList, "InvalidTag");
	    assertFalse("Test invalid assertTag deletion - quote should not be deleted", invalidDeleted);
	    assertEquals("Test invalid assertTag deletion - quote list size should remain unchanged", serviceList.size(), serviceList.size());
	}
	
	//=========================== Syaza's Test Code ===========================
	
	/*
	@Test
	public void testRegisterUser() {
		assertNotNull("Test that there is valid user list to add to", userList);
		// sorry i might need help, shd i check if the arraysize changes instead? i was following L09 code
		//idk what im doing ongg
		// note to self to consult irfan
		
		
		/// Irfan's Note:
		 * 
		 * for userList.registerUser():
		 * 
		 * brackets shld be ..registerUser(userList, u1.getEmail(),u1.getPassword())
		 * 
		 * CHANGE the registerUser() JAVA method to have (userList, email, password) instead of (userList, user)
		
		
		// Test case 1: Normal test - valid user
	    boolean validUser = userList.registerUser("John Doe", "1990-01-01", "john.doe@gmail.com", "password123", "User");
	    assertTrue("User will be registered", validUser);
	    
	    
	    // Test case 2: Error test - invalid email
        boolean invalidEmail = userList.registerUser("John Doe", "1990-01-01", "invalidemail", "password123", "User");
        assertFalse(invalidEmail);
        
        
        // Test case 3: Error test - weak password
        boolean weakpw = userList.registerUser("John Doe", "1990-01-01", "johndoe@example.com", "weakpw", "User");
        assertFalse(weakpw);
        
        
        // Test case 4: Error test - missing details
        boolean missingName = userList.registerUser("", "1990-01-01", "johndoe@example.com", "password123", "User");
        assertFalse(missingName);
        
        boolean missingEmail = userList.registerUser("John Doe", "1990-01-01", "", "password123", "User");
        assertFalse(missingEmail);
        
        boolean missingPassword = userList.registerUser("John Doe", "1990-01-01", "johndoe@example.com", "", "User");
        assertFalse(missingPassword);
        
        
        // Test case 5: Error test - user already exists - check by email
        userList.add(u2);
        
        User u5 = new User("Jane Smith", "1985-05-15", "jane.smith@gmail.com", "securepass", "User");
        boolean checkUser = userList.registerUser(u5);
		assertEquals(u2, u5);
        
	}
	
    @Test
    public void testRetrieveQuoteRequests() { // and view
    	quoteList.add(qr1);
    	quoteList.add(qr2);
    	
    	assertNotNull("Test if there is valid quote req arraylist to retrieve from", quoteList);
    	
    	//test if the list of Chromebook retrieved from the SourceCentre is empty - boundary
		String allChrombook= C206_CaseStudy.retrieveAllQuoteRequest(quoteList);
		String testOutput = "";
		assertEquals("Test that the retrieved Chromebooklist is empty?", testOutput, allChrombook);
	   
	}
	
	*/
	
	//=========================== Yongyi's Test Code ===========================
	
	@Test
	public void testCreateAppointment() {
		assertNotNull("Check if there is a valid appointment arraylist to add to", appointmentList);
		
		// test 1: check that list is not null, so that you can add a new appointment
		C206_CaseStudy.createAppointment(appointmentList, ap1);
		assertEquals("Check that appointment arraylist size is 1", 1, appointmentList.size());
		assertSame("Check that appointment is added", ap1, appointmentList.get(0));
	    
		// test 2: add another appointment. Test the size of the list is 2
	    C206_CaseStudy.createAppointment(appointmentList, ap2);
	    assertEquals("Check that appointment arraylist size is 2", 2, appointmentList.size());
	    assertSame("Check that appointment is added", ap2, appointmentList.get(1));
	    
	    // test 3: add an appointment that already exists in the list
	    C206_CaseStudy.createAppointment(appointmentList, ap2);
	    assertEquals("Test that the appointment arraylist size is unchanged.", 2, appointmentList.size());
	    
	    // test 4: add an appointment with missing details
	    Appointment ap_missing = new Appointment("AP003", "", "Recipient Name", "2023-08-10", "3:00 PM", "Location");
	    C206_CaseStudy.createAppointment(appointmentList, ap_missing);
	    assertEquals("Test that the appointment arraylist size is unchanged.", 2, appointmentList.size());
	}
	
	@Test
	public void testTrackAppointments() {
	    appointmentList.add(ap1);
	    appointmentList.add(ap2);
	    
	    assertNotNull("Test if there is a valid appointment arraylist to retrieve from", appointmentList);
	    
	    // test 1: retrieve appointments for an existing user (recipientName: "Michael Johnson")
	    ArrayList<Appointment> michaelJohnsonAppointments = C206_CaseStudy.getUserAppointments(appointmentList, "Michael Johnson");
	    assertNotNull("Test that the list of appointments for user 'Michael Johnson' is not null", michaelJohnsonAppointments);
	    assertEquals("Test that the list of appointments for user 'Michael Johnson' has the expected number of appointments", 1, michaelJohnsonAppointments.size());
	    
	    // test 2: retrieve appointments for an existing user with multiple appointments (recipientName: "Emily Brown")
	    ArrayList<Appointment> emilyBrownAppointments = C206_CaseStudy.getUserAppointments(appointmentList, "Emily Brown");
	    assertNotNull("Test that the list of appointments for user 'Emily Brown' is not null", emilyBrownAppointments);
	    assertEquals("Test that the list of appointments for user 'Emily Brown' has the expected number of appointments", 1, emilyBrownAppointments.size());
	    
	    // test 3: retrieve appointments for an existing user with no appointments (recipientName: "Jane Smith")
	    ArrayList<Appointment> janeSmithAppointments = C206_CaseStudy.getUserAppointments(appointmentList, "Jane Smith");
	    assertNull("Test that the list of appointments for user 'Jane Smith' is null", janeSmithAppointments);
	}


	//=========================== Jovan's Test Code ===========================
	
	//=========================== Ernest's Test Code ===========================
	@Test
	public void testUserLogin()
	{
		//normal test
		boolean userExist = C206_CaseStudy.loginUser(userList,u1.getEmail(),u1.getPassword());
		assertFalse("User should be able to log in", userExist);
		
		//error test - invalid email
		boolean userInvalidEmail = C206_CaseStudy.loginUser(userList,"nonUser@gmail.com",u1.getPassword());
		assertFalse(userInvalidEmail);
		
		//error test - invalid password
		boolean userInvalidPW = C206_CaseStudy.loginUser(userList,u1.getEmail(),"pass123");
		assertFalse(userInvalidPW);
		
		//error test - non-existing user
		boolean userNotExist = C206_CaseStudy.loginUser(userList,u1.getEmail(),u1.getPassword());
		assertFalse(userNotExist);
	}
	
	
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

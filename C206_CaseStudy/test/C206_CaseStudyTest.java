import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
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
    public void testCreateService() {
		assertNotNull("Check if there is a valid service arraylist to add to", serviceList);
		
        // Test Case 1: Check that list is not null, so that you can add a new service
        C206_CaseStudy.createService(serviceList, rs1);
        assertEquals("Check that service arraylist size is 1", 1, serviceList.size());
        assertSame("Check that service is added", rs1, serviceList.get(0));
        
        // Test Case 2: Add another service. Test the size of the list is 2
        C206_CaseStudy.createService(serviceList, rs2);
        assertEquals("Check that service arraylist size is 2", 2, serviceList.size());
        assertSame("Check that service is added", rs2, serviceList.get(1));
        
        // Test Case 3: Add a service that already exists in the list
        C206_CaseStudy.createService(serviceList, rs2);
        assertEquals("Test that the service arraylist size is unchanged.", 2, serviceList.size());
        
        // Test Case 4: Add a service with missing details
        RenovationServices service_missing = new RenovationServices("RS003", "", "Service Description", "Mon-Sun: 9am-7pm", false);
        C206_CaseStudy.createService(serviceList, service_missing);
        assertEquals("Test that the service arraylist size is unchanged.", 2, serviceList.size());
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
	    testOutput = String.format("%-15s %-30s %-50s %-25s %-30s\n", "RS001", "Kitchen Remodeling Service",
	            "Full kitchen remodeling and renovations", "Mon-Fri: 9am-5pm", "Available");
	    testOutput += String.format("%-15s %-30s %-50s %-25s %-30s\n", "RS002", "Bathroom Renovation Service",
	            "Bathroom renovation and upgrades", "Mon-Sat: 8am-6pm", "Available");
	    assertEquals("Test that the display is correct.", testOutput, allRenovationServices);

	    // Test Case 3: Add a renovation service with isAvailable = false
	    RenovationServices rs3 = new RenovationServices("RS003", "Hotel Accommodation Service",
	            "Hotel room renovation and upgrade", "24/7", false);
	    serviceList.add(rs3);
	    assertEquals("Test that renovation services arraylist size is 3.", 3, serviceList.size());
	    
	    allRenovationServices = C206_CaseStudy.retrieveAllRenovationServices(serviceList);
	    testOutput += String.format("%-15s %-30s %-50s %-25s %-30s\n", "RS003", "Hotel Accommodation Service",
	            "Hotel room renovation and upgrade", "24/7", "No Longer Available");
	    assertEquals("Test that the display is correct.", testOutput, allRenovationServices);
	}
	
	@Test
	public void testDeleteRenovationService() {
	    // Test case 1: Normal Test - Delete existing service
	    serviceList.add(rs1);
	    serviceList.add(rs2);
	    
	    boolean deleted = C206_CaseStudy.deleteService(serviceList, "RS001");
	    assertTrue("Test normal deletion - service should be deleted", deleted);
	    assertEquals("Test normal deletion - quote list size should decrease by 1", quoteList.size(), 0);
	
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
	
	@Test
    public void testRegisterUser() {
        assertNotNull("Test that there is valid user list to add to", userList);
            
        // Test case 1: Normal test - valid user
        boolean validUserRegistered = C206_CaseStudy.registerUser(userList, "John Doe", "john.doe@gmail.com", "password123");
        assertTrue("User should be registered successfully", validUserRegistered);
        assertEquals("Test if User is added", 1, userList.size());

        
        // Test case 2: Error test - invalid email
        boolean invalidEmailRegistered = C206_CaseStudy.registerUser(userList, "John Doe", "invalidemail", "password123");
        assertFalse("User with invalid email should not be registered", invalidEmailRegistered);
        
        
        // Test case 3: Error test - weak password
        boolean weakPasswordRegistered = C206_CaseStudy.registerUser(userList, "John Doe", "johndoe@example.com", "weakpw");
        assertFalse("User with weak password should not be registered", weakPasswordRegistered);
        
        
        // Test case 4: Error test - missing details
        boolean missingNameRegistered = C206_CaseStudy.registerUser(userList, "", "johndoe@example.com", "password123");
        assertFalse("User with missing name should not be registered", missingNameRegistered);


        boolean missingEmailRegistered = C206_CaseStudy.registerUser(userList, "John Doe", "", "password123");
        assertFalse("User with missing email should not be registered", missingEmailRegistered);

        
        boolean missingPasswordRegistered = C206_CaseStudy.registerUser(userList, "John Doe", "johndoe@example.com", "");
        assertFalse("User with missing password should not be registered", missingPasswordRegistered);

        
        // Test case 5: Error test - user already exists - check by email
        userList.add(u2);

 
        User newUser = new User("Jane Smith", "1985-05-15", "jane.smith@gmail.com", "securepass", "User");
        boolean userAlreadyExists = C206_CaseStudy.registerUser(userList, newUser.getRecipientName(), newUser.getEmail(), newUser.getPassword());
        assertFalse("User with duplicate email should not be registered", userAlreadyExists);
        
    }
    
    @Test
    public void testViewQuoteRequests() { // and retrieve
        
        // Test case 1: Boundary test - Test that the array exists (not null)
        assertNotNull("Test if there is valid quote req arraylist to retrieve from", quoteList);
        
        // Test case 2: Boundary test - Test that the list of Quotes retrieved from the CaseStudy is empty
        String allQuotes = C206_CaseStudy.retrieveAllQuoteRequests(quoteList);
        String testOutput = "";
        assertEquals("Test that the retrieved quoteList is empty", testOutput, allQuotes);
        
        // Test case 3: Normal test - test the expected output string
        quoteList.add(qr1);
        String allQuotes2 = C206_CaseStudy.retrieveAllQuoteRequests(quoteList);
        testOutput = String.format("%-15s %-35s %-20s %-15s %-20d %-50s\n", "QR001", "Kitchen Remodeling Service", "John Doe", "Pending", 91827364, "Kitchen Renovation Price Query");
        assertEquals("Test that the display is correct", testOutput, allQuotes2);
    }
    
    @Test
    public void testReplyQuote() { // add reply
        
        // Test case 1: Boundary test - Test that the array exists (not null)
        assertNotNull("Test if there is valid quote req arraylist to retrieve from", quoteList);
        
        // Test case 2: Normal test - adding reply
        quoteList.add(qr1);
        boolean qr1reply = C206_CaseStudy.replyQuote(quoteList, "QR001", "yes");
        assertEquals("Test if the reply is added", qr1.getReply(), "yes");
        assertNotNull("Test if reply is added", qr1.getReply());
        assertTrue(qr1reply);
        
        // Test case 3: Error test - add reply to quote that does not exist
        boolean qrNullreply = C206_CaseStudy.replyQuote(quoteList, "QR003", "yes");
        assertFalse(qrNullreply);
        
        // Test case 4: Boundary test - add empty reply
        quoteList.add(qr2);
        boolean qr2reply = C206_CaseStudy.replyQuote(quoteList, "QR002", "");
        assertEquals("Test if the reply is added", qr2.getReply(), "");
        assertNotNull("Test if reply is added", qr2.getReply());
        assertTrue(qr2reply);
    }
    
    @Test
    public void testDeleteQuote() { // deleteQuote
        quoteList.add(qr1);
        quoteList.add(qr2);
        
        // Test case 1: Normal Test - Delete existing quote
        boolean deletedQuote = C206_CaseStudy.deleteQuote(quoteList, "QR001");
        assertTrue("Test that quote is deleted", deletedQuote);
        assertEquals("Quote list size should decrease by 1", quoteList.size(), 1);
        
        // Test case 2: Boundary Test - Delete quote with empty assertTag
    boolean emptyQuoteDelete = C206_CaseStudy.deleteQuote(quoteList, "");
        assertFalse("Quote should not be deleted", emptyQuoteDelete);
        assertEquals("Quote list size should remain unchanged", quoteList.size(), quoteList.size());
    
        // Test case 3: Error Test - Delete with invalid assertTag
        boolean invalidQuoteDelete = C206_CaseStudy.deleteQuote(quoteList, "InvalidTag");
        assertFalse("Quote should not be deleted", invalidQuoteDelete);
        assertEquals("Quote list size should remain unchanged", quoteList.size(), quoteList.size());
	}
	
	
	//=========================== Yongyi's Test Code ===========================
    @Test
    public void testScheduleAppointment() {
        assertNotNull("Check if there is a valid appointment arraylist to add to", appointmentList);

        // input appointment data
        String taskID = "AP003";
        String serviceName = "Plumbing Service";
        String recipientName = "Alice Johnson";
        LocalDate date = LocalDate.parse("2023-08-10");
        LocalTime time = LocalTime.parse("11:30");
        String location = "123 Plumbing Avenue";

        // create an appointment
        Appointment newAppointment = new Appointment(taskID, serviceName, recipientName, date.toString(), time.toString(), location);

        // test 1: schedule a new appointment
        C206_CaseStudy.createAppointment(appointmentList, newAppointment);
        assertEquals("Check that appointment arraylist size is 1", 1, appointmentList.size());
        assertSame("Check that appointment is added", newAppointment, appointmentList.get(0));

        // test 2: schedule an appointment with missing details
        Appointment appointmentWithMissingDetails = new Appointment("AP004", "", "Recipient Name", "2023-08-15", "4:00 PM", "Location");
        C206_CaseStudy.createAppointment(appointmentList, appointmentWithMissingDetails);
        assertEquals("Test that the appointment arraylist size is unchanged.", 1, appointmentList.size());

        // test 3: schedule an appointment with invalid date and time format
        Appointment appointmentWithInvalidDateTime = new Appointment("AP005", "Painting Service", "Bob Smith", "2023-08-15", "invalid-time", "Location");
        C206_CaseStudy.createAppointment(appointmentList, appointmentWithInvalidDateTime);
        assertEquals("Test that the appointment arraylist size is unchanged.", 2, appointmentList.size());

        // test 4: schedule an appointment with existing task id
        C206_CaseStudy.createAppointment(appointmentList, newAppointment); // Attempt to schedule again
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
//	@Test
//	public void testDeleteAppointment() { // deleteAppointment
//	    appointmentList.add(ap1);
//	    appointmentList.add(ap2);
//	    
//	    // Test case 1: Normal Test - Delete existing appointment
//	    boolean deletedappt= C206_CaseStudy.deleteAppointment(appointmentList, "QR001");
//	    assertTrue("Test that Appointment is deleted", deletedappt);
//	    assertEquals("Appointment list size should decrease by 1", appointmentList.size(), 1);
//	    
//	    // Test case 2: Boundary Test - Delete appointment with no ID
//    boolean emptyapptdel = C206_CaseStudy.deleteAppointment(appointmentList, "");
//	    assertFalse("Appointment must not be deleted", emptyapptdel);
//	    assertEquals("Appointment list size should remain unchanged", appointmentList.size(), appointmentList.size());
//	
//	    // Test case 3: Error Test - Delete with invalid ID
//	    boolean invalappt = C206_CaseStudy.deleteAppointment(appointmentList, "InvalidID");
//	    assertFalse("Appointment must not be deleted", invalappt);
//	    assertEquals("Appointment list size should remain unchanged", appointmentList.size(), appointmentList.size());
//	}
	
	@Test
	public void testAddAppointment() { // addAppointment
	    appointmentList.add(ap1);
	    appointmentList.add(ap2);
	    
		// Test case 1: Check that list is not null, so that we are able to add a new appointment
		C206_CaseStudy.createAppointment(appointmentList, ap1);
		assertEquals("Check that appointmentList size is equals to 1", 1, appointmentList.size());
		assertSame("Check that the appointment has been added", ap1, appointmentList.get(0));
		
	    // Test case 2: Add an appointment that has missing detail
	    Appointment apptmiss = new Appointment("AP0078", "", "Jane Doe", "","", "258 Oak Street");
	    C206_CaseStudy.createAppointment(appointmentList, apptmiss);
	    assertEquals("Test that the Appointment ArrayList size does not change.", 2, appointmentList.size());
	    
	    // Test case 3: Add an item that already exists in the list
	    C206_CaseStudy.createAppointment(appointmentList, ap2);
	    assertEquals("Test that the AppointmentList size remains unchanged.", 2, appointmentList.size());
	}
	//=========================== Ernest's Test Code ===========================
	@Test
	public void testUserLogin()
	{
		userList.add(u1);
		
		//normal test
		boolean userExist = C206_CaseStudy.loginUser(userList,u1.getEmail(),u1.getPassword());
		assertTrue("User should be able to log in", userExist);
		
		//error test - invalid email
		boolean userInvalidEmail = C206_CaseStudy.loginUser(userList,"nonUser@gmail.com",u1.getPassword());
		assertFalse(userInvalidEmail);
		
		//error test - invalid password
		boolean userInvalidPW = C206_CaseStudy.loginUser(userList,u1.getEmail(),"pass123");
		assertFalse(userInvalidPW);
		
		//error test - non-existing user
		boolean userNotExist = C206_CaseStudy.loginUser(userList,u3.getEmail(),u3.getPassword());
		assertFalse(userNotExist);
	}
	
	@Test
	public void testUserDelete()
	{
		//User successsfully deleted
		boolean userDeleted = C206_CaseStudy.deleteUser(userList, u1);
		assertFalse("User successfully deleted", userDeleted);
		assertNotEquals("Test normal deletion - user list size should decrease by 1", userList.size(), 1);
		
		//empty email
	    boolean emptyEmailDelete = C206_CaseStudy.deleteUser(userList, new User("EmptyEmail", "", "pass123", "User"));
	    assertFalse("Test empty email deletion - user should not be deleted", emptyEmailDelete);
	    assertEquals("Test empty email deletion - user list size should stay the same", userList.size(), userList.size());
		
		//Invalid email to delete
		boolean userInvalidEmail = C206_CaseStudy.deleteUser(userList, new User("InvalidEmail", "blank", "pass123456", "User"));
		assertFalse("Test invalid email deletion - user should not be deleted", userInvalidEmail);
		assertEquals("Test invalid email deletion - user list size should stay the samme", userList.size(), userList.size());
		
		//empty password
	    boolean emptyPasswordDelete = C206_CaseStudy.deleteUser(userList, new User("EmptyPassword", "empPas@gmail.com", "", "User"));
	    assertFalse("Test empty password deletion - user should not be deleted", emptyPasswordDelete);
	    assertEquals("Test empty password deletion - user list size should stay the same", userList.size(), userList.size());
		
		//Invalid password to delete
		boolean userInvalidPassword = C206_CaseStudy.deleteUser(userList, new User("InvalidPassword", "invPas@gmail.com", "a", "User"));
		assertFalse("Test invalid password deletion - user should not be deleted", userInvalidPassword);
		assertEquals("Test invalid password deletion - user list size should stay the samme", userList.size(), userList.size());
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

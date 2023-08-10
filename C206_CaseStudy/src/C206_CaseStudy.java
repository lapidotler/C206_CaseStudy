import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int USER_LOGOUT = -1;

	private static final int OPTION_QUIT = 99;
	
	private static final int OPTION_REGISTER = 1;
	private static final int OPTION_LOGIN = 2;

	public static void main(String[] args) {
		
		ArrayList<User> userList = new ArrayList<User>();
		
		ArrayList<RenovationServices> serviceList = new ArrayList<RenovationServices>();
		
		ArrayList<Quote> quoteList = new ArrayList<Quote>();
		
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		
		// Users
		userList.add(new User("John Doe", "1990-01-01", "john.doe@gmail.com", "password123", "User"));
		userList.add(new User("Jane Smith", "1985-05-15", "jane.smith@gmail.com", "securepass", "User"));
		userList.add(new User("Michael Johnson", "1988-09-20", "michael.johnson@hotmail.com", "pass123", "User"));
		userList.add(new User("Emily Brown", "1992-04-30", "emily.brown@gmail.com", "brownie456", "User"));
		
		// Service Providers
		userList.add(new User("Kitchen Remodeling Service", "krs@hotmail.com", "krs123", "Service Provider"));
		userList.add(new User("Bathroom Renovation Service", "brs@gmail.com", "brs456", "Service Provider"));
		
		// Admin*
		userList.add(new User("Admin User", "1985-03-25", "admin@gmail.com", "admin123", "Admin"));
		
		serviceList.add(new RenovationServices("RS001", "Kitchen Remodeling Service", "Full kitchen remodeling and renovations", "Mon-Fri: 9am-5pm", true));
		serviceList.add(new RenovationServices("RS002", "Bathroom Renovation Service", "Bathroom renovation and upgrades", "Mon-Sat: 8am-6pm", true));
		
		quoteList.add(new Quote("QR001", "Kitchen Remodeling Service", "John Doe", 91827364, "Kitchen Renovation Price Query"));
		quoteList.add(new Quote("QR002", "Bathroom Renovation Service", "Jane Smith", 98765432, "Bathroom Remodeling Availability"));
		
		appointmentList.add(new Appointment("AP001", "Kitchen Remodeling Service", "Michael Johnson", "2023-07-25", "10:00 AM", "123 Main Street"));
		appointmentList.add(new Appointment("AP002", "Bathroom Renovation Service", "Emily Brown", "2023-07-26", "2:30 PM", "456 Oak Avenue"));
		// usersList.add

		int option = 0;

		while (option != OPTION_QUIT) {
		    C206_CaseStudy.loginMenu();
		    option = Helper.readInt("Enter an option > ");

		    if (option == OPTION_REGISTER) {
		        // Register new user
		        User user = C206_CaseStudy.registerForm();
		        if (user != null) {
		            C206_CaseStudy.registerUser(userList, user.getRecipientName(), user.getEmail(), user.getPassword());
		        }
		    } else if (option == OPTION_LOGIN) {
		        String email = Helper.readString("Enter email > ");
		        String password = Helper.readString("Enter password > ");

		        User loggedInUser = null;
		        for (User user : userList) {
		            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
		                loggedInUser = user;
		                break;
		            }
		        }
		        
		        if (loggedInUser != null) {
		            userLoginForm(userList, email, password);
		            
		            // Display different options based on the user's role
		            if (loggedInUser.getRole().equals("User")) {
		                // User options
		            	int optionUser = 0;
		            	
		            	C206_CaseStudy.menuUser();
		            	optionUser = Helper.readInt("Enter an option (or type -1 to logout > ");

		            	while (optionUser != USER_LOGOUT) {
			            	if (optionUser == 1) {
			            		C206_CaseStudy.viewAllRenovationServices(serviceList);
			            	
			            	} else if (optionUser == 2) {
			            		// Add a quote
								Quote qr = inputQuote();
								C206_CaseStudy.createQuote(quoteList, qr);
								System.out.println("Quote Added");
								
			            	} else if (optionUser == 3) {
			            		// Add an appointment - Yongyi
								Appointment ap = inputAppointment();
								C206_CaseStudy.createAppointment(appointmentList, ap);
								System.out.println("Appointment Scheduled");
								
			            	} else if (optionUser == 4) {
			            		// Track quotes of specific user
			            		trackQuoteStatus(quoteList);
			            		
			            	} else if (optionUser == 5) {
			            		// Track appointments of specific user - Yongyi
								trackAppointments(appointmentList, loggedInUser);
								
			            	} else if (optionUser == 99) {
			            		// Delete User
			            		// deleteUser(userList, loggedInUser);
								
			            	} else if (optionUser == USER_LOGOUT) {
			            		loggedInUser = null;
			            		
			            	} else {
			            		System.out.println("Invalid option");
			            	}
		            	}
		            	
		            } else if (loggedInUser.getRole().equals("Service Provider")) {
		                // Service Provider options
		            	int optionProvider = 0;
		            	
		            	C206_CaseStudy.menuProvider();
		            	optionProvider = Helper.readInt("Enter an option (or type -1 to logout > ");

		            	while (optionProvider != USER_LOGOUT) {
			            	if (optionProvider == 1) {
			            		C206_CaseStudy.viewQuoteRequests(quoteList);
			            		
			            	} else if (optionProvider == 2) {
			            		C206_CaseStudy.setHeader("RESPOND TO QUOTE REQUEST");
								C206_CaseStudy.viewQuoteRequests(quoteList);
								System.out.println("1. Reply to Quote Request");
								System.out.println("2. Reject and Delete Quote Request");
								int response = Helper.readInt("Enter option >");
								
								if (response == 1) {
									String quoteID = Helper.readString("Enter Quote ID to reply to > ");
									replyQuote(quoteList, quoteID);
								} else {
									String quoteID = Helper.readString("Enter Quote ID to reject and delete > ");
									rejectQuote(quoteList, quoteID);
								}
			            		
			            	} else if (optionProvider == 3) {
			            		C206_CaseStudy.viewAppointments(appointmentList);
			            		
			            	} else if (optionProvider == 4) {
			            		manageAppointments(appointmentList);
			            		
			            	} else if (optionProvider == 5) {
			            		// Track appointments of specific user - Yongyi
								trackAppointments(appointmentList, loggedInUser);
								
			            	} else if (optionProvider == 99) {
			            		// Delete User
			            		// deleteUser(userList, loggedInUser);
								
			            	} else if (optionProvider == USER_LOGOUT) {
			            		loggedInUser = null;
			            		
			            	} else {
			            		System.out.println("Invalid option");
			            	}
		            	}

		            } else if (loggedInUser.getRole().equals("Admin")) {
		                // Admin options
		            	int optionAdmin = 0;
		            	
		            	C206_CaseStudy.menuAdmin();
		            	optionAdmin = Helper.readInt("Enter an option (or type -1 to logout > ");
		            	
		            	while (optionAdmin != USER_LOGOUT) {
		            		if (optionAdmin == 1) {
			            		// Add New Service - Irfan
		            			RenovationServices sp = inputService();
								C206_CaseStudy.createService(serviceList, sp);
								System.out.println("Service Created");
						        
			            	} else if (optionAdmin == 2) {
			            		String taskID = "Enter the Task ID of the item you want to delete? > ";
						        
			            		if (taskID.isEmpty()) {
			            			deleteService(serviceList, taskID);
			            		}
						        
			            	} else if (optionAdmin == 3) {
			            		String taskID = "Enter the Task ID of the item you want to delete? > ";
					        	
					        	if (taskID.isEmpty()) {
					        		deleteQuote(quoteList, taskID);
					        	}
					        	
			            	} else if (optionAdmin == 4) {
			            		String taskID = "Enter the Task ID of the item you want to delete? > ";
						        
			            		if (taskID.isEmpty()) {
			            			deleteAppointment(appointmentList, taskID);
			            		}
			            		
			            	} else if (optionAdmin == USER_LOGOUT) {
			            		loggedInUser = null;
			            		
			            	} else {
			            		System.out.println("Invalid option");
			            	}
		            	}
		            	
		           }

		    } else {
		            System.out.println("Invalid login credentials.");
		        }
		    }
		}
	}

	/**
	 * 
	 */
	
	private static void loginMenu() {
		C206_CaseStudy.setHeader("REGISTER/LOGIN");
		System.out.println("1. Register");
		System.out.println("2. Login");
	}

	public static void menuUser() {
	    C206_CaseStudy.setHeader("USER/CUSTOMER OPTIONS");
	    System.out.println("1. View All Services");
	    System.out.println("2. Request Quote");
	    System.out.println("3. Schedule Appointment");
	    System.out.println("4. Track Quote");
	    System.out.println("5. Track Appointment");
	    System.out.println("99. Delete Account");
	}

	public static void menuProvider() {
	    C206_CaseStudy.setHeader("MERCHANT/SERVICE PROVIDER OPTIONS");
	    System.out.println("1. View All Quotes");
	    System.out.println("2. Respond/Reject to Quote");
	    System.out.println("3. View All Appointments");
	    System.out.println("4. Manage Appointment");
	    System.out.println("5. Track Appointment Status");
	    System.out.println("99. Delete Account");
	}

	public static void menuAdmin() {
	    C206_CaseStudy.setHeader("ADMIN OPTIONS");
	    System.out.println("1. Add new Service");
	    System.out.println("2. Delete Service");
	    System.out.println("3. Delete Quote");
	    System.out.println("4. Delete Appointment");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	// To be removed after code refactoring (EVERYONE) -> Services
	public static String showAvailability(boolean availability) {
        String avail;

        if (availability == true) {
            avail = "Available";
        } else {
            avail = "No Longer Available";
        }
        return avail;
    }
	
	// To be removed after code refactoring (EVERYONE) -> Quotes & Appointments
	public static String showStatus(boolean status) {
        String avail;

        if (status == true) {
            avail = "Pending";
        } else {
            avail = "Resolved";
        }
        return avail;
    }

	
	//================================= Option 1 System (CRUD - Create) =================================
	
	// User Registration - Syaza
	// CHECKED and MODIFIED BY: Irfan, assisted with registerUser 
	
	public static User registerForm() {
	  	String recipientName = Helper.readString("Enter name > ");
		String email = Helper.readString("Enter email > "); 
		String password = Helper.readString("Enter password > ");     
		
		User newUser;      // make newUser to return
		
		if (!recipientName.contains("Service")) {      // Option to see if name DOES NOT include "Service" for DOB
	  		String dateOfBirth = Helper.readString("Enter date of birth (yyyy-mm-dd) > ");
	  		newUser = new User(recipientName, dateOfBirth, email, password, "User");
	  	} else {
	  		newUser = new User(recipientName, "-NA-", email, password, "Service Provider");
	  	}
		
		if (recipientName.isEmpty() || email.isEmpty() || password.isEmpty()) {
			System.out.println("Registration failed. Please fill in all fields.");     // Validation 1: Empty Fields
	        return null;
		}
		
		if (!email.contains("@") || password.length() < 12) {
			System.out.println("Registration failed. Invalid email or weak password.");   // Validation 2: Email & Password
	        return null;
		}  
		
		return newUser; 
	}
	
	public static boolean registerUser(ArrayList<User> userList, String recipientName, String email, String password) {
		String dob = "";
		
		for (User user : userList) {
	        if (email.equals(user.getEmail())) {          // Use equals to compare strings
	            System.out.println("Registration failed as email is already in use.");
	            return false;   // Exit the loop if the email is already in use
	        }
	        
	        if (recipientName.isEmpty() || email.isEmpty() || password.isEmpty()) {
				System.out.println("Registration failed. Please fill in all fields.");     // Validation 1: Empty Fields
		        return false;
			}
			
			if (!email.contains("@") || password.length() < 12) {
				System.out.println("Registration failed. Invalid email or weak password.");   // Validation 2: Email & Password
		        return false;
			}  
	        
	        dob = user.getDOB();
	    }
	    
	    User newUser;
	    
	    // Create the newUser here and add it to the userList
	    if (recipientName.contains("Service")) {
	    	newUser = new User(recipientName, "-NA-", email, password, "Service Provider");
	    } else {
	    	newUser = new User(recipientName, dob, email, password, "User");
	    }
	    userList.add(newUser);
        System.out.println("Successfully registered");
	    return true;    // Registration Successful
	}			                        
	
	// User Login - Ernest
	// CHECKED and MODIFIED BY: Irfan -> Removed inputs of email and password, shifted them to menu
    public static void userLoginForm(ArrayList<User> userList, String email, String password)
    {
    	boolean loggedIn = false;
		
		String output = String.format("%-15s %-20s %-30s %-20s %-20s\n",
	             "Name", "Date of Birth", "Email", "Password", "Status");
		
		for (User user : userList) {
			if (email.contains(user.getEmail()) && password.contains(user.getPassword()))
				{
				output += String.format("%-109s\n", user.toString());
				loggedIn = true;
		        break;
				}
		}
		
		if (loggedIn) {
	        System.out.println("Login successful.");
	        System.out.println(output);
	    } else {
	        System.out.println("User login failed, Invalid user.");
	    }
    }
    
    public static boolean loginUser(ArrayList<User> userList, String email, String password) {
        for (User user : userList) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
	// deleteUser method() -> if possible
	// Add Submenu

	
	//================================= Option 2 Display (CRUD - Read) =================================
	
    // View All Services (+ delete function for Admin) - Irfan
    public static String retrieveAllRenovationServices(ArrayList<RenovationServices> serviceList) {
	    String output = "";

	    for (int i = 0; i < serviceList.size(); i++) {
	        RenovationServices service = serviceList.get(i);
	        output += String.format("%-154s", service.toStringDisplay());
	    }
	    
	    return output;
	}

	public static void viewAllRenovationServices(ArrayList<RenovationServices> serviceList) {
		C206_CaseStudy.setHeader("RENOVATION SERVICES LIST");
	    String output = String.format("%-15s %-30s %-50s %-25s %-30s\n", "Task ID", "Service Name",
	            "Service Description", "Contact Hours", "Status");
	    output += retrieveAllRenovationServices(serviceList);
	    System.out.println(output);
	}
	
	public static boolean deleteService(ArrayList<RenovationServices> serviceList, String idToDelete) {
	    for (int i = 0; i < serviceList.size(); i++) {
	        RenovationServices service = serviceList.get(i);
	        if (service.getAssertTag().equalsIgnoreCase(idToDelete)) {
	            serviceList.remove(i);
	            System.out.println("Service with Task ID " + idToDelete + " has been deleted.");
	            return true;
	        }
	    }
	    
	    System.out.println("Service with Task ID " + idToDelete + " not found.");
	    return false;
	}
	
	//================================= Option 3 Add (CRUD - Create) =================================
	
	// Adding new Service (Admin) - Irfan
	public static RenovationServices inputService() {
	    String taskID = Helper.readString("Enter task ID > ");
	    String serviceName = Helper.readString("Enter service name > ");
	    String serviceDescription = Helper.readString("Enter service description > ");
	    String contactHours = Helper.readString("Enter contact hours > ");
	    boolean isAvailable = Helper.readBoolean("Is the service available? (true/false) > ");

	    RenovationServices service = new RenovationServices(taskID, serviceName, serviceDescription, contactHours, isAvailable);
	    return service;
	}

	public static void createService(ArrayList<RenovationServices> serviceList, RenovationServices service) {
	    RenovationServices existingService;
	    for (int i = 0; i < serviceList.size(); i++) {
	        existingService = serviceList.get(i);
	        if (existingService.getAssertTag().equalsIgnoreCase(service.getAssertTag())) {
	            return;
	        }
	    }
	    if ((service.getAssertTag().isEmpty()) || (service.getServiceName().isEmpty())) {
	        return;
	    }
	    serviceList.add(service);
	}
	
	// Requesting a Quote - Irfan
	public static Quote inputQuote() {
		String tag = Helper.readString("Enter task ID > ");
		String serviceName = Helper.readString("Enter service name > ");
		String recipientName = Helper.readString("Enter your name > ");
		int contactNumber = Helper.readInt("Enter contact number > ");
		String description = Helper.readString("Enter description > ");
		

		Quote qr= new Quote(tag, serviceName, recipientName, contactNumber, description);
		return qr;
		
	}
	
	public static void createQuote(ArrayList<Quote> quoteList, Quote qr) {
		Quote item;
		for(int i = 0; i < quoteList.size(); i++) {
			item = quoteList.get(i);
			if (item.getAssertTag().equalsIgnoreCase(qr.getAssertTag()) )
				return;
		}
		if ((qr.getAssertTag().isEmpty()) || (qr.getServiceName().isEmpty()) || (qr.getRecipientName().isEmpty()) ) {
			return;
		}
		quoteList.add(qr);
	}
	
	// Scheduling an appointment - Yongyi
    public static Appointment inputAppointment() {
    	String taskID = Helper.readString("Enter task ID > ");
        String serviceName = Helper.readString("Enter service name > ");
        String recipientName = Helper.readString("Enter recipient name > ");
        String date = Helper.readString("Enter appointment date > ");
        String time = Helper.readString("Enter appointment time > ");
        String location = Helper.readString("Enter appointment location > ");
        
        return new Appointment(taskID, serviceName, recipientName, date, time, location);
    }
    
    public static void createAppointment(ArrayList<Appointment> appointmentList, Appointment appointment) {
        // Check for missing details
        if (appointment.getServiceName().isEmpty() || appointment.getRecipientName().isEmpty() ||
            appointment.getDate().isEmpty() || appointment.getTime().isEmpty() || appointment.getLocation().isEmpty()) {
            System.out.println("Appointment details are missing. Appointment not added.");
            return;
        }
        
        // Checking if appointment already exists based on task ID
        for (Appointment existingAppointment : appointmentList) {
            if (existingAppointment.getAssertTag().equalsIgnoreCase(appointment.getAssertTag())) {
                System.out.println("Appointment with the same task ID already exists.");
                return; // Exit the method if appointment already exists
            }
        }
        
        appointmentList.add(appointment);
    }

	//================================= Option 4 View (CRUD - Read) =================================
	
	// View All Quotes - Syaza
	public static String retrieveAllQuoteRequests(ArrayList<Quote> quoteList) {
		String output = "";

		for (int i = 0; i < quoteList.size(); i++) {
			output += String.format("%-170s\n", quoteList.get(i).toStringDisplay());
		}
		return output;     // Fixed Spacing of List: Irfan
	}
	
	public static void viewQuoteRequests(ArrayList<Quote> quoteList) {
		C206_CaseStudy.setHeader("QUOTE REQUESTS");
		String output = String.format("%-15s %-35s %-20s %-15s %-20s %-50s\n", "QUOTE ID", "SERVICE NAME",
				"RECIPIENT NAME", "STATUS", "CONTACT NUMBER","DESCRIPTION");
		 output += retrieveAllQuoteRequests(quoteList);	
		System.out.println(output);
	}
	
	
	//View All Appointments - Jovan
	public static void viewAppointments(ArrayList<Appointment> appointmentList) {
		 //Title
		 Helper.line(75, "-");
		 System.out.println(String.format("%-15s %-30s %-20s %-15s %-10s %-20s\n",
		 "ID", "Service Name", "Recipient Name", "Date", "Time", "Location"));
		 Helper.line(75, "-");
	
		 
		 //Show details
		 for (int b = 0; b< appointmentList.size();b++) {
		 System.out.println(String.format("\"%-15s %-30s %-20s %-15s %-10s %-20s\n",
			 appointmentList.get(b).getAssertTag(),appointmentList.get(b).getServiceName(),
			 appointmentList.get(b).getRecipientName(),appointmentList.get(b).getDate(),
			 appointmentList.get(b).getTime(),appointmentList.get(b).getLocation()));
		 }
	 }
	
	//================================= Option 5 Track (CRUD - Read) =================================
	
	// Tracking appointments - Irfan
	public static void trackQuoteStatus(ArrayList<Quote> quoteList) {
	    String recipientName = Helper.readString("Enter your name > ");

	    ArrayList<Quote> userQuotes = getUserQuote(quoteList, recipientName);
	    if (userQuotes != null && !userQuotes.isEmpty()) {
	    	setHeader("Quotes for " + recipientName + ":");
	        
	        String output = String.format("%-15s %-35s %-20s %-15s %-20s %-50s\n",
	            "Task ID", "Service Name", "Recipient Name", "Status", "Contact Number", "Description");
	        
	        for (Quote quote : userQuotes) {
	        	
	            output += String.format("%-170s\n", quote.toStringDisplay());
	            
	        }
	        
	        System.out.println(output);
	    } else {
	        System.out.println("No quotes found for " + recipientName);
	    }
	}

    public static ArrayList<Quote> getUserQuote(ArrayList<Quote> quoteList, String recipientName) {
    	ArrayList<Quote> userQuotes = new ArrayList<>();
        for (Quote quote : quoteList) {
            if (quote.getRecipientName().equalsIgnoreCase(recipientName)) {
                userQuotes.add(quote);
            }
        }
        
        if (userQuotes.isEmpty()) {
            return null; // Return null if no quotes are found
        }
        
        return userQuotes;
    }
	
    public static boolean deleteQuote(ArrayList<Quote> quoteList, String idToDelete) {
	    for (int i = 0; i < quoteList.size(); i++) {
	        Quote quote = quoteList.get(i);
	        if (quote.getAssertTag().equalsIgnoreCase(idToDelete)) {
	            quoteList.remove(i);
	            System.out.println("Quote with Task ID " + idToDelete + " has been deleted.");
	            return true;
	        }
	    }
	
	    System.out.println("Quote with Task ID " + idToDelete + " not found.");
	    return false;
	}
    
    // Tracking appointments - Yongyi
    public static void trackAppointments(ArrayList<Appointment> appointmentList, User loggedInUser) {
        ArrayList<Appointment> userAppointments = getUserAppointments(appointmentList, loggedInUser.getRecipientName());
        
        if (userAppointments != null && !userAppointments.isEmpty()) {
            setHeader("Your Appointments:");
            
            String output = String.format("%-15s %-30s %-20s %-15s %-10s %-20s\n",
                    "Task ID", "Service Name", "Recipient Name", "Date", "Time", "Location");
            
            for (Appointment appointment : userAppointments) {
                output += String.format("%-15s %-30s %-20s %-15s %-10s %-20s\n",
                        appointment.getAssertTag(), appointment.getServiceName(),
                        appointment.getRecipientName(), appointment.getDate(),
                        appointment.getTime(), appointment.getLocation());
            }
            
            System.out.println(output);
        } else {
            System.out.println("No appointments found for " + loggedInUser.getRecipientName());
        }
    }

    public static ArrayList<Appointment> getUserAppointments(ArrayList<Appointment> appointmentList, String recipientName) {
        ArrayList<Appointment> userAppointments = new ArrayList<>();
        
        for (Appointment appointment : appointmentList) {
            if (appointment.getRecipientName().equalsIgnoreCase(recipientName)) {
                userAppointments.add(appointment);
            }
        }
        
        if (userAppointments.isEmpty()) {
            return null; // Return null if no appointments are found
        }
        
        return userAppointments;
    }
	
	//================================= Option 6 Manage (CRUD - Update) =================================
    
    // Reply to Quote - Syaza (Add)
    public static void replyQuote(ArrayList<Quote> quoteList, String quoteID) {
    	String reply = Helper.readString("Enter reply to this quote request > ");
    	
		for (int i = 0; i < quoteList.size(); i++) {
			Quote quoteRef = quoteList.get(i);
			if (quoteID.equalsIgnoreCase(quoteRef.getAssertTag())) {
				quoteRef.setReply(reply);
				String output = String.format("\n%-15s %-35s %-20s %-15s %-20s %-50s %-5s\n", "QUOTE ID", "SERVICE NAME",
						"RECIPIENT NAME", "STATUS", "CONTACT NUMBER","DESCRIPTION", "REPLY");
				output += String.format("%-170s\n", quoteRef.toStringReply());
				System.out.println(output);
			} 
		}
    }
    
    // Reject Quote - Syaza (Delete)
    
    public static void rejectQuote(ArrayList<Quote> quoteList, String quoteID) {
	    for (int i = 0; i < quoteList.size(); i++) {
	        Quote quoteRef = quoteList.get(i);
	        if (quoteRef.getAssertTag().equalsIgnoreCase(quoteID)) {
	        	String confirm = Helper.readString("Are you sure you want to reject and delete this quote? (Y/N) >");
	        	
	        	if (confirm == "Y") {
	        		quoteList.remove(i);
		            System.out.println("Quote with ID " + quoteID + " has been deleted.");
	        	} else if (confirm == "N") {
	        		System.out.println("Quote with ID " + quoteID + " was not deleted.");
	        	}
	        	
	        } else {
	
	        	System.out.println("Quote with ID " + quoteID + " not found.");
	        }
	    }
    }
    	
 
 // Managing appointments - edit

    public static void manageAppointments(ArrayList<Appointment> appointmentList) {
		// Manage Appointment Editing
    	String editTag=Helper.readString("Enter the Appointment's Task ID to edit > ");
    	Appointment editAppt= apptByTag(appointmentList, editTag);
	
	    if (editAppt != null) {
		    //Appointment details that need to change
		    String newDate = Helper.readString("Enter new appointment date > ");		
		    String newTime = Helper.readString("Enter new appointment time > ");	
		    String newLocation = Helper.readString("Enter new appointment location > ");
	
		    //Enhancement that I will fix later
		    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		    //LocalDate newDate = LocalDate.parse(DateString, formatter);    
		
		    //Edit appointment
		    editAppt.editAppointment(newDate, newTime, newLocation);
		
		    
		    //message output
		    System.out.println("Appointment edited successfully");
	    } else {
	    	System.out.println("Appointment not found");
	    }
    }
	
    // Manage Appointment Delete
    public static void deleteAppointment(ArrayList<Appointment> appointmentList, String delTag) {
	    for (int a = 0; a < appointmentList.size(); a++) {
		    Appointment appt = appointmentList.get(a);

		    if (appt.getAssertTag().equalsIgnoreCase(delTag)) {
			    // Confirmation
		    	String confirm = Helper.readString("Are you sure you would like to delete the appointment with ID "+ delTag +"? Y/N > ");
			
			    //deletion
			
			    if (confirm == "Y"||confirm == "y") {
			    	appointmentList.remove(a);
				    System.out.println("Appointment has been deleted.");
			    } else {
			    	System.out.println("Deletion process has been stopped");
			    }
		
		    } else { 
		
		    	System.out.println("The Tag has not been found. Please try again.");
		    }
	    }
    }

    private static Appointment apptByTag(ArrayList<Appointment> appointmentList, String taskID) {
    	for(Appointment appointment : appointmentList) {
    		if (appointment.getAssertTag().equalsIgnoreCase(taskID)) {
    			return appointment;
    		}
    	}
    
    	return null;
    }
    
}

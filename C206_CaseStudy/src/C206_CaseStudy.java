import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int EXIT_PROGRAM = -1;

	private static final int USER_LOGOUT = -1;
	
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
		
		while (option != EXIT_PROGRAM) {
			C206_CaseStudy.loginMenu();
		    option = Helper.readInt("Enter an option (or type -1 to exit program) > ");
		    
	        User loggedInUser = null;
	        
		    if (option == OPTION_REGISTER) {
		        // Register new user
		        User user = C206_CaseStudy.registerForm();
		        if (user != null) {
		            C206_CaseStudy.registerUser(userList, user.getRecipientName(), user.getEmail(), user.getPassword());
		        }
		        
		    } else if (option == OPTION_LOGIN) {
		        String email = Helper.readString("Enter email > ");
		        String password = Helper.readString("Enter password > ");
	
		        userLoginForm(userList, email, password);
		        
		        for (User user : userList) {   
		            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
		                loggedInUser = user;
		                break;
		            }
		        }
		        
		        if (loggedInUser != null) {
		            int optionLogin = 0;
		            
		            while (optionLogin != USER_LOGOUT && optionLogin != 99) {
			            // Display different options based on the user's role
			            if (loggedInUser.getRole().equals("User")) {
			                // User options
			            	C206_CaseStudy.menuUser();
			            	optionLogin = Helper.readInt("Enter an option (or type -1 to logout) > ");
		
			            	if (optionLogin == 1) {
			            		C206_CaseStudy.viewAllRenovationServices(serviceList);
			            	
			            	} else if (optionLogin == 2) {
			            		// Add a quote
								Quote qr = inputQuote();
								C206_CaseStudy.createQuote(quoteList, qr);
								System.out.println("Quote Added");
								
			            	} else if (optionLogin == 3) {
			            		// Add an appointment - Yongyi
								Appointment ap = scheduleAppointment();
								C206_CaseStudy.createAppointment(appointmentList, ap);
								System.out.println("Appointment Scheduled");
								
			            	} else if (optionLogin == 4) {
			            		// Track quotes of specific user
			            		trackQuoteStatus(quoteList, loggedInUser);
			            		
			            	} else if (optionLogin == 5) {
			            		// Track appointments of specific user - Yongyi
								trackAppointments(appointmentList, loggedInUser);
								
			            	} else if (optionLogin == 99) {
			            		// Delete User - Ernest
			            		deleteUser(userList, loggedInUser);
			            		System.out.println("User Deleted, Returning to System\n");
								
			            	} else if (optionLogin == USER_LOGOUT) {
			            		System.out.println("Logged Out Successfully\n");
								
			            	} else {
			            		System.out.println("Invalid option");
			            		
			            	}	
			            	
			            	
			            } else if (loggedInUser.getRole().equals("Service Provider")) {
			                // Service Provider options
			            	C206_CaseStudy.menuProvider();
			            	optionLogin = Helper.readInt("Enter an option (or type -1 to logout) > ");
			            	
			            	if (optionLogin == 1) {
			            		C206_CaseStudy.viewQuoteRequests(quoteList);
			            		
			            	} else if (optionLogin == 2) {
			            		C206_CaseStudy.setHeader("RESPOND TO QUOTE REQUEST");
								C206_CaseStudy.viewQuoteRequests(quoteList);
								
								String quoteID = Helper.readString("Enter Quote ID to reply to > ");
								String reply = Helper.readString("Enter reply > ");
								
								if (!quoteID.isEmpty()) {
									replyQuote(quoteList, quoteID, reply);
								}
			            		
			            	} else if (optionLogin == 3) {
			            		C206_CaseStudy.viewAppointments(appointmentList);
			            		
			            	} else if (optionLogin == 4) {
			            		manageAppointments(appointmentList);
			            		
			            	} else if (optionLogin == 5) {
			            		// Track appointments of specific user - Yongyi
								trackAppointments(appointmentList, loggedInUser);
								
			            	} else if (optionLogin == 99) {
			            		// Delete User - Ernest
			            		deleteUser(userList, loggedInUser);
			            		System.out.println("User Deleted, Returning to System\n");
								
			            	} else if (optionLogin == USER_LOGOUT) {
			            		System.out.println("Logged Out Successfully\n");
								
			            	} else {
			            		System.out.println("Invalid option");
			            		
			            	}
		
			            } else if (loggedInUser.getRole().equals("Admin")) {
			                // Admin options
			            	C206_CaseStudy.menuAdmin();
			            	optionLogin = Helper.readInt("Enter an option (or type -1 to logout) > ");
		
			            	if (optionLogin == 1) {
			            		// Add New Service - Irfan
		            			RenovationServices sp = inputService();
								C206_CaseStudy.createService(serviceList, sp);
								System.out.println("Service Created");
								
								C206_CaseStudy.viewAllRenovationServices(serviceList);
						        
			            	} else if (optionLogin == 2) {
			            		C206_CaseStudy.viewAllRenovationServices(serviceList);
			            		String taskID = Helper.readString("Enter the Task ID of the item you want to delete? > ");
						        
			            		if (!taskID.isEmpty()) {
			            			deleteService(serviceList, taskID);
			            			C206_CaseStudy.viewAllRenovationServices(serviceList);
			            		}
						        
			            	} else if (optionLogin == 3) {
			            		C206_CaseStudy.viewQuoteRequests(quoteList);
			            		String taskID = Helper.readString("Enter the Task ID of the item you want to delete? > ");
					        	
					        	if (!taskID.isEmpty()) {
					        		deleteQuote(quoteList, taskID);
					        		C206_CaseStudy.viewQuoteRequests(quoteList);
					        	}
					        	
			            	} else if (optionLogin == 4) {
			            		C206_CaseStudy.viewAppointments(appointmentList);
			            		String taskID = Helper.readString("Enter the Task ID of the item you want to delete? > ");
						        
			            		if (!taskID.isEmpty()) {
			            			deleteAppointment(appointmentList, taskID);
			            			C206_CaseStudy.viewAppointments(appointmentList);
			            		}
			            		
			            	} else if (optionLogin == USER_LOGOUT) {
			            		System.out.println("Logged Out Successfully\n");
								
			            	} else {
			            		System.out.println("Invalid option");
			            		
			            	}
			            	
		           		} else {
		           			System.out.println("Invalid login credentials.");
		    			}
		        
		            } 
	        
			    }
	    
		    } else if (option == EXIT_PROGRAM) {
    			System.out.println("Exiting program now. Goodbye!");
    			
			} else {
    			System.out.println("Invalid option.");
			}
	    
		}
		
	}
	
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
	    System.out.println("2. Respond to Quote");
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
	
	
	//================================= Option 2 System (CRUD - Retrieve) =================================
	
	// User Login - Ernest
	// CHECKED and MODIFIED BY: Irfan -> Removed inputs of email and password, shifted them to menu
    public static void userLoginForm(ArrayList<User> userList, String email, String password)
    {
    	boolean loggedIn = false;
		
    	String output = "";
		
		for (User user : userList) {
			if (user.getRole() == ("Service Provider"))
			{
				output = String.format("%-45s %-30s %-20s %-20s\n",
			             "Name", "Email", "Password", "Role");
				
				output += String.format("%-118s", user.toString());
			}
			else
			{
				output = String.format("%-15s %-20s %-30s %-20s %-20s\n",
			             "Name", "Date of Birth", "Email", "Password", "Role");
				
				output += String.format("%-109s", user.toString());
			}
			if (email.contains(user.getEmail()) && password.contains(user.getPassword()))
			{
			
			loggedIn = true;
		    break;
			}
		}
		
		if (loggedIn) {
	        System.out.println("Login successful.\n");
	        System.out.println(output);
	    } else {
	        System.out.println("User login failed, Invalid user.\n");
	    }
    }
    
    //================================= Option 99 System (CRUD - Delete) =================================
    
    public static boolean loginUser(ArrayList<User> userList, String email, String password) {
        for (User user : userList) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
    // deleteUser - Ernest
    public static void userDeleteForm(ArrayList<User> userList, User loggedInUser)
    {
    	for (User user : userList) 
    	{
			if (loggedInUser.getEmail().contains(user.getEmail()) && loggedInUser.getPassword().contains(user.getPassword()))
				{
				String inputOption = Helper.readString("Confirm deletion? (Y/N)> ");
				for (int i = 0; i < userList.size(); i++) 
				{
			    	if (inputOption.equalsIgnoreCase("Y"))
			    	{
			    		userList.remove(i);
			    		System.out.println("User has been deleted");
			    	}
			    	else if (inputOption.equalsIgnoreCase("N"))
			    	{
			    		System.out.println("User has not been deleted");
			    	}
				}
				}
			else
			{
				System.out.println("Invalid username and password");
			}
		}
    }
    
    public static boolean deleteUser(ArrayList<User> userList, User loggedInUser) {
        for (User user : userList) {
            if (loggedInUser.getEmail().equals(user.getEmail()) && loggedInUser.getPassword().equals(user.getPassword())) {
            	userList.remove(loggedInUser);
                return true;
            }
        }
        return false;
    }

	
	//================================= Service (User + Admin) (CRUD - Create) =================================
    
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
	
	//======================== Quotes (User & SP) (CRUD - Create, Retrieve, Delete) ========================
	
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
	
	
	
	// View All Quotes - Syaza
    public static String retrieveAllQuoteRequests(ArrayList<Quote> quoteList) {
        String output = "";

 

        for (int i = 0; i < quoteList.size(); i++) {
            output += String.format("%-160s\n", quoteList.get(i).toStringDisplay());
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
	
    
    
    // Tracking quotes - Irfan
 	public static void trackQuoteStatus(ArrayList<Quote> quoteList, User loggedInUser) {
 		String name = loggedInUser.getRecipientName();
 		
 	    ArrayList<Quote> userQuotes = getUserQuote(quoteList, name);
 	    if (userQuotes != null && !userQuotes.isEmpty()) {
 	    	setHeader("Quotes for " + loggedInUser + ":");
 	        
 	        String output = String.format("%-15s %-35s %-20s %-15s %-20s %-50s\n",
 	            "Task ID", "Service Name", "Recipient Name", "Status", "Contact Number", "Description");
 	        
 	        for (Quote quote : userQuotes) {
 	        	
 	            output += String.format("%-170s\n", quote.toStringDisplay());
 	            
 	        }
 	        
 	        System.out.println(output);
 	    } else {
 	        System.out.println("No quotes found for " + loggedInUser);
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
     
    
    
    // Delete quote - Syaza
    public static boolean deleteQuote(ArrayList<Quote> quoteList, String quoteID) {
 	    for (int i = 0; i < quoteList.size(); i++) {
 	        Quote quote = quoteList.get(i);
 	        if (quote.getAssertTag().equalsIgnoreCase(quoteID)) {
 	            quoteList.remove(i);
 	            System.out.println("Quote with ID " + quoteID + " has been deleted.");
 	            return true;
 	        }
 	    }
 	
 	    System.out.println("Quote with ID " + quoteID + " was not found.");
 	    return false;
 	}
    
    
    
    // Reply to Quote - Syaza (Add)
    public static boolean replyQuote(ArrayList<Quote> quoteList, String quoteID, String reply) {
        for (int i = 0; i < quoteList.size(); i++) {
            Quote quoteRef = quoteList.get(i);
            if (quoteID.equalsIgnoreCase(quoteRef.getAssertTag())) {
                quoteRef.setReply(reply);
                String output = String.format("\n%-15s %-35s %-20s %-15s %-20s %-50s %-5s\n", "QUOTE ID", "SERVICE NAME",
                        "RECIPIENT NAME", "STATUS", "CONTACT NUMBER","DESCRIPTION", "REPLY");
                output += String.format("%-170s\n", quoteRef.toStringReply());
                System.out.println(output);
                return true;
            }
        }
       
        System.out.println("Quote with ID " + quoteID + " was not found.");
        return false;
    }
    
    
    
  //===================== Appointments (User & SP) (CRUD - Create, Retrieve, Update, Delete) =====================
    
	// Scheduling an appointment - Yongyi
    public static Appointment scheduleAppointment() {
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

	
    
    //View All Appointments - Jovan
	public static void viewAppointments(ArrayList<Appointment> appointmentList) {
		 //Title
		 Helper.line(75, "-");
		 System.out.println(String.format("%-15s %-30s %-20s %-15s %-10s %-20s",
		 "ID", "Service Name", "Recipient Name", "Date", "Time", "Location"));
		 Helper.line(75, "-");
	
		 
		 //Show details
		 for (int b = 0; b< appointmentList.size();b++) {
		 System.out.println(String.format("%-15s %-30s %-20s %-15s %-10s %-20s\n",
			 appointmentList.get(b).getAssertTag(),appointmentList.get(b).getServiceName(),
			 appointmentList.get(b).getRecipientName(),appointmentList.get(b).getDate(),
			 appointmentList.get(b).getTime(),appointmentList.get(b).getLocation()));
		 }
	}
	
	
	
	// Tracking appointments - Yongyi
    public static void trackAppointments(ArrayList<Appointment> appointmentList, User loggedInUser) {
        String userName = loggedInUser.getRecipientName();
		ArrayList<Appointment> userAppointments = getUserAppointments(appointmentList, userName);
        
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
            System.out.println("No appointments found for " + userName);
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
	
    // Manage Appointment - delete
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
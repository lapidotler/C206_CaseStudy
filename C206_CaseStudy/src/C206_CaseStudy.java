import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUOTE = 1;
	private static final int OPTION_APPOINTMENT = 2;
	
	private static final int OPTION_ACCOUNT = 1;
	private static final int OPTION_SERVICEVIEW = 2;
	private static final int OPTION_ADD = 3;
	private static final int OPTION_VIEW = 4;
	private static final int OPTION_TRACK = 5;
	private static final int OPTION_MANAGE = 6;
	
	private static final int OPTION_QUIT = 99;


	public static void main(String[] args) {
		
		ArrayList<User> userList = new ArrayList<User>();
		
		ArrayList<RenovationServices> serviceList = new ArrayList<RenovationServices>();
		
		ArrayList<Quote> quoteList = new ArrayList<Quote>();
		
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

		// ArrayList<User> userRegistration = new ArrayList<User>();
		/* User class not implemented */
		
		// Users
		userList.add(new User("John Doe", "1990-01-01", "john.doe@gmail.com", "password123", "User"));
		userList.add(new User("Jane Smith", "1985-05-15", "jane.smith@gmail.com", "securepass", "User"));
		userList.add(new User("Michael Johnson", "1988-09-20", "michael.johnson@hotmail.com", "pass123", "User"));
		userList.add(new User("Emily Brown", "1992-04-30", "emily.brown@gmail.com", "brownie456", "User"));
		
		// Service Providers
		userList.add(new User("Kitchen Remodeling Service", "1980-10-10", "krs@hotmail.com", "krs123", "Service Provider"));
		userList.add(new User("Bathroom Renovation Service", "1975-06-20", "brs@gmail.com", "brs456", "Service Provider"));
		
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

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			// USERS OR SP (Service Provider), OR Both (ALL)
			
			if (option == OPTION_ACCOUNT) {
				// Register/Login into System (USERS)			
				loginMenu();
				
				int loginOption = Helper.readInt("Enter option to login or register > ");
				
				if (loginOption == 1) {
					// Login for registered users
					
					String email = Helper.readString("Enter email > ");
			        String password = Helper.readString("Enter password > ");

			        if (loginUser(userList, email, password)) {
			            userLoginForm(userList, email, password);
			        }
					
				} else if (loginOption == 2) {
					// Register new user
					User user = C206_CaseStudy.registerForm();
			        if (user != null) {
			            C206_CaseStudy.registerUser(userList, user.getRecipientName(), user.getEmail(), user.getPassword());
			        }
					
				}
								
			} else if (option == OPTION_SERVICEVIEW) {
				// Display Renovation Services (USERS)
				
				C206_CaseStudy.viewAllRenovationServices(serviceList);
				
				// Display sub-menu for admin options
				C206_CaseStudy.setHeader("Admin Options");
			    String adminSubMenu = "1. Delete a Service\n" +
			                          "2. Return to Main Menu\n" +
			                          "Enter your choice > ";
			    
			    int adminChoice = Helper.readInt(adminSubMenu);
			    
			    if (adminChoice == 1) {
			    	String assertTag = "Enter the Assert Tag of the item you want to delete? > ";
			        deleteService(serviceList, assertTag);
			    }

				
			} else if (option == OPTION_ADD) {
				// Request Quote, Schedule an Appointment (USERS)
				C206_CaseStudy.setHeader("ADD");			
				actionTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == OPTION_QUOTE) {
					// Add a quote
					Quote qr = inputQuote();
					C206_CaseStudy.createQuote(quoteList, qr);
					System.out.println("Quote added");

				} else if (itemType == OPTION_APPOINTMENT) {
					// Add an appointment - Yongyi
					Appointment ap=inputAppointment();
					C206_CaseStudy.createAppointment(appointmentList, ap);
					System.out.println("Appointment scheduled");
				} else {
					System.out.println("Invalid type");
				}
		
			} else if (option == OPTION_VIEW) {
				// View Quotes, Appointments (SP)
				C206_CaseStudy.setHeader("VIEW");			
				actionTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == OPTION_QUOTE) {
					// View all Quotes in a List
					C206_CaseStudy.viewQuoteRequests(quoteList);

					
				} else if (itemType == OPTION_APPOINTMENT) {
					// View all Appointments in a List

				} else {
					System.out.println("Invalid type");
				}
	
			} else if (option == OPTION_TRACK) {
				// Track Status of Quote Requests, Appointments
				// All USERS, only SP track appointment status
				C206_CaseStudy.setHeader("TRACK");			
				actionTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == OPTION_QUOTE) {
					// Track quotes of specific user
					trackQuoteStatus(quoteList);
					
				}else if (itemType==OPTION_APPOINTMENT) {
					// Track appointments of specific user - Yongyi
					String recipientName=Helper.readString("Enter your name > ");
					trackAppointments(appointmentList, recipientName);
					
				}else {
					System.out.println("Invalid type");
				}
					
					// Display sub-menu for user options
					C206_CaseStudy.setHeader("User Options");
			        String userSubMenu = "1. Delete a Quote\n" +
			        					 "2. Return to Main Menu\n" +
			        					 "Enter your choice > ";

			        int userChoice = Helper.readInt(userSubMenu);

			        if (userChoice == 1) {
			        	String assertTag = "Enter the Assert Tag of the item you want to delete? > ";
			            deleteQuote(quoteList, assertTag);

			        } else {
			        	System.out.println("Invalid type");
			        }

			} else if (option == OPTION_MANAGE) {
				// Respond to Quote, Manage Appointments (SP)
				C206_CaseStudy.setHeader("MANAGE");			
				actionTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == OPTION_QUOTE) {
					// Respond to specific Quote (w/ display)

				} else if (itemType == OPTION_APPOINTMENT) {
					// Manage specific Appointment (w/ display)
					manageAppointments(appointmentList);

				} else {
					System.out.println("Invalid type");
				}

				
				
			} else if (option == 99) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	/**
	 * 
	 */
	
	private static void loginMenu() {
		C206_CaseStudy.setHeader("LOGIN/REGISTER");
		System.out.println("1. Login");
		System.out.println("2. Register");
	}
	
	private static void actionTypeMenu() {
		C206_CaseStudy.setHeader("ACTION TYPES");
		System.out.println("1. Quote Request");
		System.out.println("2. Appointment");
	}

	public static void menu() {
		C206_CaseStudy.setHeader("RENOVATION PORTAL APP");
		System.out.println("1. Register/Login");	
		System.out.println("2. Display Renovation Services");
		System.out.println("3. Arrange an Action");
		System.out.println("4. View List");
		System.out.println("5. Track Status");
		System.out.println("6. Manage Action");
		
		System.out.println("99. Quit");
		Helper.line(80, "-");
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
	// CHECKED and MODIFIED BY: Irfan
	
	public static User registerForm() {
	  	String recipientName = Helper.readString("Enter name > ");
		String email = Helper.readString("Enter email > "); 
		String password = Helper.readString("Enter password > ");     
		
		User newUser;      // make newUser to return
		
		if (!recipientName.contains("Service")) {      // Option to see if name DOES NOT include "Service" for DOB
	  		String dateOfBirth = Helper.readString("Enter date of birth (yyyy-mm-dd) > ");
	  		newUser = new User(recipientName, dateOfBirth, email, password, "User");
	  	} else {
	  		newUser = new User(recipientName, "", email, password, "Service Provider");
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
		for (User user : userList) {
	        if (email.equals(user.getEmail())) {          // Use equals to compare strings
	            System.out.println("Registration failed as email is already in use.");
	            return true;   // Exit the loop if the email is already in use
	        }
	        
	        return false;
	    }
	    
	    User newUser;
	    
	    // Create the newUser here and add it to the userList
	    if (recipientName.contains("service")) {
	    	newUser = new User(recipientName, "", email, password, "Service Provider");
	    } else {
	    	newUser = new User(recipientName, "", email, password, "User");
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
	    String output = String.format("%-15s %-30s %-50s %-25s %-30s\n", "Assert Tag", "Service Name",
	            "Service Description", "Contact Hours", "Status");
	    output += retrieveAllRenovationServices(serviceList);
	    System.out.println(output);
	}
	
	public static boolean deleteService(ArrayList<RenovationServices> serviceList, String assertTagToDelete) {
	    for (int i = 0; i < serviceList.size(); i++) {
	        RenovationServices service = serviceList.get(i);
	        if (service.getAssertTag().equalsIgnoreCase(assertTagToDelete)) {
	            serviceList.remove(i);
	            System.out.println("Service with Assert Tag " + assertTagToDelete + " has been deleted.");
	            return true;
	        }
	    }
	    
	    System.out.println("Service with Assert Tag " + assertTagToDelete + " not found.");
	    return false;
	}
	
	//================================= Option 3 Add (CRUD - Create) =================================
	
	// Requesting a Quote - Irfan
	public static Quote inputQuote() {
		String tag = Helper.readString("Enter asset tag > ");
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
    	String assertTag = Helper.readString("Enter assert tag > ");
        String serviceName = Helper.readString("Enter service name > ");
        String recipientName = Helper.readString("Enter recipient name > ");
        String date = Helper.readString("Enter appointment date > ");
        String time = Helper.readString("Enter appointment time > ");
        String location = Helper.readString("Enter appointment location > ");
        
        return new Appointment(assertTag, serviceName, recipientName, date, time, location);
    }
    
    public static void createAppointment(ArrayList<Appointment> appointmentList, Appointment appointment) {
        // Check for missing details
        if (appointment.getServiceName().isEmpty() || appointment.getRecipientName().isEmpty() ||
            appointment.getDate().isEmpty() || appointment.getTime().isEmpty() || appointment.getLocation().isEmpty()) {
            System.out.println("Appointment details are missing. Appointment not added.");
            return;
        }
        
        // Checking if appointment already exists based on asset tag
        for (Appointment existingAppointment : appointmentList) {
            if (existingAppointment.getAssertTag().equalsIgnoreCase(appointment.getAssertTag())) {
                System.out.println("Appointment with the same asset tag already exists.");
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
		String output = String.format("%-15s %-35s %-20s %-15s %-20s %-50s\n", "ASSERT TAG", "SERVICE NAME",
				"RECIPIENT NAME", "STATUS", "CONTACT NUMBER","DESCRIPTION");
		 output += retrieveAllQuoteRequests(quoteList);	
		System.out.println(output);
	}
	
	//================================= Option 5 Track (CRUD - Read) =================================
	
	// Tracking appointments - Irfan
	public static void trackQuoteStatus(ArrayList<Quote> quoteList) {
	    String recipientName = Helper.readString("Enter your name > ");

	    ArrayList<Quote> userQuotes = getUserQuote(quoteList, recipientName);
	    if (userQuotes != null && !userQuotes.isEmpty()) {
	    	setHeader("Quotes for " + recipientName + ":");
	        
	        String output = String.format("%-15s %-35s %-20s %-15s %-20s %-50s\n",
	            "Assert Tag", "Service Name", "Recipient Name", "Status", "Contact Number", "Description");
	        
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
	
    public static boolean deleteQuote(ArrayList<Quote> quoteList, String assertTagToDelete) {
	    for (int i = 0; i < quoteList.size(); i++) {
	        Quote quote = quoteList.get(i);
	        if (quote.getAssertTag().equalsIgnoreCase(assertTagToDelete)) {
	            quoteList.remove(i);
	            System.out.println("Quote with Assert Tag " + assertTagToDelete + " has been deleted.");
	            return true;
	        }
	    }
	
	    System.out.println("Quote with Assert Tag " + assertTagToDelete + " not found.");
	    return false;
	}
    
    // Tracking appointments - Yongyi
    public static void trackAppointments(ArrayList<Appointment> appointmentList, String recipientName) {
        ArrayList<Appointment> userAppointments = getUserAppointments(appointmentList, recipientName);
        
        if (userAppointments != null && !userAppointments.isEmpty()) {
            setHeader("Your Appointments:");
            
            String output = String.format("%-15s %-30s %-20s %-15s %-10s %-20s\n",
                    "Assert Tag", "Service Name", "Recipient Name", "Date", "Time", "Location");
            
            for (Appointment appointment : userAppointments) {
                output += String.format("%-15s %-30s %-20s %-15s %-10s %-20s\n",
                        appointment.getAssertTag(), appointment.getServiceName(),
                        appointment.getRecipientName(), appointment.getDate(),
                        appointment.getTime(), appointment.getLocation());
            }
            
            System.out.println(output);
        } else {
            System.out.println("No appointments found for " + recipientName);
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
    
    public static void replyQuoteRequests(ArrayList<Quote> quoteList) {
    	// add. i need help
    	// String reply = Helper.readString("Enter reply to this quote request > ");
    	
    	
    	
    }
    
    public static void rejectQuoteRequest(ArrayList<Quote> quoteList) {
    	// delete
    	
    }
    
    
    
 // Managing appointments - edit

    public static void manageAppointments(ArrayList<Appointment> ApptList) {
		// Manage Appointment Editing
    	String EditTag=Helper.readString("Enter the Appointment's Assert Tag to edit > ");
    	Appointment EditAppt= apptByTag(ApptList, EditTag);
	
	    if (EditAppt != null) {
		    //Appointment details that need to change
		    String newDate = Helper.readString("Enter new appointment date > ");		
		    String newTime = Helper.readString("Enter new appointment time > ");	
		    String newLocation = Helper.readString("Enter new appointment location > ");
	
		    //Enhancement that I will fix later
		    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		    //LocalDate newDate = LocalDate.parse(DateString, formatter);    
		
		    //Edit appointment
		    EditAppt.editAppointment(newDate, newTime, newLocation);
		
		    
		    //message output
		    System.out.println("Appointment edited successfully");
	    } else {
	    	System.out.println("Appointment not found");
	    }
    }
	
    // Manage Appointment Delete
    public static void deleteAppointment(ArrayList<Appointment> ApptList, String DelTag) {
	    for (int a = 0; a < ApptList.size(); a++) {
		    Appointment appt = ApptList.get(a);

		    if (appt.getAssertTag().equalsIgnoreCase(DelTag)) {
			    // Confirmation
			    String confirm = Helper.readString("Are you sure you would like to delete this appointment? Y/N > ");
			
			    //deletion
			
			    if (confirm == "Y"||confirm == "y") {
				    ApptList.remove(a);
				    System.out.println("Appointment has been deleted.");
			    } else {
			    	System.out.println("Deletion process has been stopped");
			    }
		
		    } else { 
		
		    	System.out.println("The Tag has not been found. Please try again.");
		    }
	    }
    }

    private static Appointment apptByTag(ArrayList<Appointment> ApptList, String assertTag) {
    	for(Appointment appointment : ApptList) {
    		if (appointment.getAssertTag().equalsIgnoreCase(assertTag)) {
    			return appointment;
    		}
    	}
    
    	return null;
    }
    
}

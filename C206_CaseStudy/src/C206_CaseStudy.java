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
					
				// User user = loginForm(ArrayList<User> usersList);
				// Ernest code
					
				} else if (loginOption == 2) {
				// Register new user
					
				// User user = registerForm();
				// C206_CaseStudy.registerUser(userList, user);
				// System.out.println("Successfully registered");
					
				}
				
				// Add sample SP (3), create register form for USERS
				
				// Create Login Form for ALL
				

				
			} else if (option == OPTION_SERVICEVIEW) {
				// Display Renovation Services (USERS)
				
				C206_CaseStudy.viewAllRenovationServices(serviceList);
				
				// Display sub-menu for admin options
			    String adminSubMenu = "\nAdmin Options:\n" +
			                          "1. Delete a Service\n" +
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
					// Add an appointment
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
					
					// Display sub-menu for user options
			        String userSubMenu = "\nUser Options:\n" +
			                              "1. Delete a Quote\n" +
			                              "2. Return to Main Menu\n" +
			                              "Enter your choice > ";

			        int userChoice = Helper.readInt(userSubMenu);

			        if (userChoice == 1) {
			        	String assertTag = "Enter the Assert Tag of the item you want to delete? > ";
			            deleteQuote(quoteList, assertTag);
			        }
					

				} else if (itemType == OPTION_APPOINTMENT) {
					// Track appointments of specific user
					

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
	
	/*
	// need to double check :cold:
	public static User registerForm() {
	  	String recipientName = Helper.readString("Enter name > ");
	  	String dateOfBirth = Helper.readString("Enter date of birth > ");
		String email = Helper.readString("Enter email > ");
		String username = Helper.readString("Enter username > ");     // To be replaced with DOB instead, will still use the name as the main name
		String password = Helper.readString("Enter password > ");     // For SERVICES: no need to add "DOB"
		
		User newUser = new User(recipientName, dateOfBirth, email, password, "");
		
		// soryr if forgot how to do this uhhhh
		if (recipientName.isEmpty() || email.isEmpty() || password.isEmpty()) {
			if (email.contains("@") && password.length() >= 12) {
			} if (recipientName.contains("Service")) {
				newUser.setRole("SP");
			} else {
				newUser.setRole("User");
			}
		}         
		return newUser; 
	}
	
	public static void registerUser(ArrayList<User> userList, User newUser) {
		for (int i=0; i < userList.size(); i++) {
			if (newUser.getEmail() != userList.get(i).getEmail()) {
				System.out.println("Registration failed as email is already in use.");
			} else {
				userList.add(newUser);
			}
		}               // *IF YOU CAN: Add option for users to delete/deactivate account
	}				                         // Need to add new US, PBI, SBI, and test cases
	
}
*/
	
	//================================= Option 2 Display (CRUD - Read) =================================
	public static String retrieveAllRenovationServices(ArrayList<RenovationServices> serviceList) {
	    String output = "";

	    for (int i = 0; i < serviceList.size(); i++) {
	        RenovationServices service = serviceList.get(i);
	        output += String.format("%-129s", service.toStringDisplay());
	    }
	    
	    return output;
	}

	public static void viewAllRenovationServices(ArrayList<RenovationServices> serviceList) {
		C206_CaseStudy.setHeader("RENOVATION SERVICES LIST");
	    String output = String.format("%-15s %-30s %-50s %-25s %-10s\n", "Assert Tag", "Service Name",
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
	
	//================================= Option 4 View (CRUD - Read) =================================
	
	// added status as toStringDisplay ..
	public static String retrieveAllQuoteRequests(ArrayList<Quote> quoteList) {
		String output = "";

		for (int i = 0; i < quoteList.size(); i++) {
			output += String.format("%-10s \n", quoteList.get(i).toStringDisplay());
		}
		return output;
	}
	
	public static void viewQuoteRequests(ArrayList<Quote> quoteList) {
		C206_CaseStudy.setHeader("QUOTE REQUESTS");
		String output = String.format("%-10s %17s %37s %12s %23s %17s\n", "ASSERT TAG", "SERVICE NAME",
				"RECIPIENT NAME", "STATUS", "CONTACT NUMBER","DESCRIPTION");
		 output += retrieveAllQuoteRequests(quoteList);	
		System.out.println(output);
	}
	
	//================================= Option 5 Track (CRUD - Read) =================================
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
	
	//================================= Option 6 Manage (CRUD - Update) =================================
    
    public static void replyQuoteRequests(ArrayList<Quote> quoteList) {
    	// add. i need help
    	//String reply = Helper.readString("Enter reply to this quote request > ");
    	
    	
    	
    }
    
    public static void rejectQuoteRequest(ArrayList<Quote> quoteList) {
    	// delete
    	
    }
    
    // Scheduling an appointment
    public static Appointment inputAppointment() {
    	String assertTag = Helper.readString("Enter asset tag > ");
        String serviceName = Helper.readString("Enter service name > ");
        String recipientName = Helper.readString("Enter recipient name > ");
        String date = Helper.readString("Enter appointment date > ");
        String time = Helper.readString("Enter appointment time > ");
        String location = Helper.readString("Enter appointment location > ");
        
        return new Appointment(assertTag, serviceName, recipientName, date, time, location);
    }
    
    public static void createAppointment(ArrayList<Appointment> appointmentList, Appointment appointment) {
    	// Checking if appointment already exist based on asset tag
    	for (Appointment existingAppointment : appointmentList) {
            if (existingAppointment.getAssertTag().equalsIgnoreCase(appointment.getAssertTag())) {
                System.out.println("Appointment with the same asset tag already exists.");
                return; // Exit the method if appointment already exists
            }
        }
    	
    	appointmentList.add(appointment);
    }
    
    // Managing appointments - edit
    public static void manageAppointments(ArrayList<Appointment> appointmentList) {
    	String assertTagToEdit=Helper.readString("Enter the Assert Tag of the appointment to edit > ");
    	Appointment appointmentToEdit=getAppointmentByAssertTag(appointmentList, assertTagToEdit);
    	
    	if (appointmentToEdit != null) {
            // Gather new appointment details from user input
            String newDate = Helper.readString("Enter new appointment date > ");
            String newTime = Helper.readString("Enter new appointment time > ");
            String newLocation = Helper.readString("Enter new appointment location > ");

            // Edit the appointment
            appointmentToEdit.editAppointment(newDate, newTime, newLocation);

            System.out.println("Appointment edited successfully");
        } else {
            System.out.println("Appointment not found");
        }
    }
    
    public static Appointment getAppointmentByAssertTag(ArrayList<Appointment> appointmentList, String assertTag) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAssertTag().equalsIgnoreCase(assertTag)) {
                return appointment;
            }
        }
        return null; // Return null if appointment is not found
    }
}

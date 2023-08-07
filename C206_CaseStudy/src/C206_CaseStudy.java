import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<RenovationServices> serviceList = new ArrayList<RenovationServices>();
		ArrayList<Quote> quoteList = new ArrayList<Quote>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		
		// ArrayList<User> userList = new ArrayList<User>();
		// ArrayList<User> userRegistration = new ArrayList<User>();
		/* User class not implemented */
		
		
		// Refer to the C206_CaseStudyTest for the new sample users	
		
		serviceList.add(new RenovationServices("RS001", "Kitchen Remodeling Service", "Full kitchen remodeling and renovations", "Mon-Fri: 9am-5pm", true));
		serviceList.add(new RenovationServices("RS002", "Bathroom Renovation Service", "Bathroom renovation and upgrades", "Mon-Sat: 8am-6pm", true));
		
		quoteList.add(new Quote("QR001", "Kitchen Remodeling Service", "John Doe", 91827364, "Kitchen Renovation Price Query"));
		quoteList.add(new Quote("QR002", "Bathroom Renovation Service", "Jane Smith", 98765432, "Bathroom Remodeling Availability"));
		
		appointmentList.add(new Appointment("AP001", "Kitchen Remodeling Service", "Michael Johnson", "2023-07-25", "10:00 AM", "123 Main Street"));
		appointmentList.add(new Appointment("AP002", "Bathroom Renovation Service", "Emily Brown", "2023-07-26", "2:30 PM", "456 Oak Avenue"));
		// usersList.add

		int option = 0;

		while (option != 99) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			// USERS OR SP (Service Provider), OR Both (ALL)
			
			if (option == 1) {
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
				

				
			} else if (option == 2) {
				// Display Renovation Services (USERS)
				
				C206_CaseStudy.viewAllRenovationServices(serviceList);

				
			} else if (option == 3) {
				// Request Quote, Schedule an Appointment (USERS)
				C206_CaseStudy.setHeader("ADD");			
				actionTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a quote
					Quote qr = inputQuote();
					C206_CaseStudy.createQuote(quoteList, qr);
					System.out.println("Quote added");

				} else if (itemType == 2) {
					// Add an appointment
					/*
					 
					Appointment ap = inputAppointment();
					C206_CaseStudy.addAppointment(appointmentList, ap);
					System.out.println("Chromebook added");
					
					*/

				} else {
					System.out.println("Invalid type");
				}
			
				

			} else if (option == 4) {
				// View Quotes, Appointments (SP)
				C206_CaseStudy.setHeader("VIEW");			
				actionTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// View all Quotes in a List
					C206_CaseStudy.viewQuoteRequests(quoteList);
					//doesnt work yet

					
				} else if (itemType == 2) {
					// View all Appointments in a List

					
				} else {
					System.out.println("Invalid type");
				}

				
				
			} else if (option == 5) {
				// Track Status of Quote Requests, Appointments
				// All USERS, only SP track appointment status
				C206_CaseStudy.setHeader("TRACK");			
				actionTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Track quotes of specific user
					trackQuoteStatus(quoteList);
					

				} else if (itemType == 2) {
					// Track appointments of specific user
					

				} else {
					System.out.println("Invalid type");
				}

				
				
			} else if (option == 6) {
				// Respond to Quote, Manage Appointments (SP)
				C206_CaseStudy.setHeader("MANAGE");			
				actionTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Respond to specific Quote (w/ display)

				} else if (itemType == 2) {
					// Manage specific Appointment (w/ display)

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
	
	public static String showAvailability(boolean availability) {
        String avail;

        if (availability == true) {
            avail = "Available";
        } else {
            avail = "No Longer Available";
        }
        return avail;
    }
	
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
	
	/* <---- User class not implemented ---> TO REVIEW bc im not sure
	
	public static registerForm() {
	  	String name = Helper.readString("Enter name > ");
		String email = Helper.readString("Enter email > ");
		String username = Helper.readString("Enter username > ");     // To be replaced with DOB instead, will still use the name as the main name
		String password = Helper.readString("Enter password > ");
		
		if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
			if (email.contains("@") && password.length() >= 12) {
			User newUser = new User(name, email, username, password);         // name, dob, email, password
			}
		}
		return newUser;
	}
	
	public static void registerUser(ArrayList<User> userList, newUser) {      // to check if name (or recipientName) exists
		for (int i=0; i < userList.size(); i++) {
			if (newUser.getUsername() != userList.get(i).getUsername) {
			check if username exists
			}
		}
		userList.add(newUser)
	} */
	
	
	
	//================================= Option 2 Display (CRUD - Read) =================================
	public static String retrieveAllRenovationServices(ArrayList<RenovationServices> serviceList) {
	    String output = "";

	    for (int i = 0; i < serviceList.size(); i++) {
	        RenovationServices service = serviceList.get(i);
	        output += String.format("%-15s %-30s %-50s %-20s %-20s\n", service.getAssertTag(),
	                service.getServiceName(), service.getServiceDescription(),
	                service.getContactHours(), C206_CaseStudy.showStatus(service.getIsAvailable()));
	    }
	    return output;
	}

	public static void viewAllRenovationServices(ArrayList<RenovationServices> serviceList) {
		C206_CaseStudy.setHeader("RENOVATION SERVICES LIST");
	    String output = String.format("%-15s %-30s %-50s %-20s %-20s\n", "Assert Tag", "Service Name",
	            "Service Description", "Contact Hours", "Status");
	    output += retrieveAllRenovationServices(serviceList);
	    System.out.println(output);
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
	
	public static void viewQuoteRequests(ArrayList<Quote> quoteList) {
		Quote item;
		for (int i=0; i < quoteList.size(); i++) {
			item = quoteList.get(i);
			String desc = item.getDescription();
			int contact = item.getContactNumber();
			System.out.println(i + ". " + desc + contact);
		}
		
	}
	
	
	
	//================================= Option 5 Track (CRUD - Read) =================================
	public static void trackQuoteStatus(ArrayList<Quote> quoteList) {
	    String recipientName = Helper.readString("Enter your name > ");

	    ArrayList<Quote> userQuotes = getUserQuote(quoteList, recipientName);
	    if (userQuotes != null && !userQuotes.isEmpty()) {
	    	setHeader("Quotes for " + recipientName + ":");
	        
	        String output = String.format("%-15s %-35s %-20s %-10s %-20s %-50s\n",
	            "Assert Tag", "Service Name", "Recipient Name", "Status", "Contact Number", "Description");
	        
	        for (Quote quote : userQuotes) {
	        	
	            output += String.format("%-15s %-35s %-20s %-10s %-20d %-50s\n",
	                quote.getAssertTag(), quote.getServiceName(), quote.getRecipientName(),
	                showStatus(quote.getStatus()), quote.getContactNumber(), quote.getDescription());
	            
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
	
	
	//================================= Option 6 Manage (CRUD - Update) =================================
    
    public static void replyQuoteRequests(ArrayList<Quote> quoteList) {
    	
    }
	
	
}

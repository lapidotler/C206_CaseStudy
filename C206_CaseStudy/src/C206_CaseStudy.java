import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<Quote> quoteList = new ArrayList<Quote>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

		quoteList.add(new Quote("QR001", "Kitchen Remodeling", "John Doe", 91827364, "Kitchen Renovation Price Query"));
		quoteList.add(new Quote("QR002", "Bathroom Renovation", "Jane Smith", 98765432, "Bathroom Remodeling Availability"));
		appointmentList.add(new Appointment("AP001", "Kitchen Remodeling", "Michael Johnson", "2023-07-25", "10:00 AM", "123 Main Street"));
		appointmentList.add(new Appointment("AP002", "Bathroom Renovation", "Emily Brown", "2023-07-26", "2:30 PM", "456 Oak Avenue"));

		int option = 0;

		while (option != 99) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			// USERS OR SP (Service Provider), OR Both (ALL)
			
			if (option == 1) {
				// Register/Login into System (USERS)
				// Add sample SP (3), create register form for USERS
				
				// Create Login Form for ALL
				

			} else if (option == 2) {
				// Display Renovation Services (USERS)
				

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
				

			} else if (option == 5) {
				// Track Status of Quote Requests, Appointments
				// All USERS, only SP track appointment status
				C206_CaseStudy.setHeader("TRACK");			
				actionTypeMenu();
				

			} else if (option == 6) {
				// Respond to Quote, Manage Appointments (SP)
				C206_CaseStudy.setHeader("MANAGE");			
				actionTypeMenu();
				

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
	
	public String showStatus(boolean status) {
        String avail;

        if (status == true) {
            avail = "Resolved";
        } else {
            avail = "Pending";
        }
        return avail;
    }


	//================================= Option 1 System (CRUD - Create) =================================
	
	
	
	//================================= Option 2 Display (CRUD - Read) =================================
	
	
	
	//================================= Option 3 Add (CRUD - Create) =================================
	public static Quote inputQuote() {
		String tag = Helper.readString("Enter asset tag > ");
		String serviceName = Helper.readString("Enter service name > ");
		String recipientName = Helper.readString("Enter recipient name > ");
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
	
	
	
	//================================= Option 5 Track (CRUD - Read) =================================
	
	
	
	//================================= Option 6 Manage (CRUD - Update) =================================
	
	
}

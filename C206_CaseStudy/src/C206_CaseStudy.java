import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

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
		System.out.println("1. Account System.");	
		System.out.println("2. Display Renovation Services");
		System.out.println("3. Arrange Action");
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
	
	
	
	//================================= Option 4 View (CRUD - Read) =================================
	
	
	
	//================================= Option 5 Track (CRUD - Read) =================================
	
	
	
	//================================= Option 6 Manage (CRUD - Update) =================================
	
	
}

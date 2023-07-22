import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		int option = 0;

		while (option != 99) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			// SP = Service Provider
			
			if (option == 1) {
				// Register into System (USERS)
				// Add sample SP (3), while creating form for USERS
				

			} else if (option == 2) {
				// Login to System (ALL)
				

			} else if (option == 3) {
				// Display Renovation Services (USERS)
				

			} else if (option == 4) {
				// Request Quote, Schedule an Appointment (USERS)
				

			} else if (option == 5) {
				// View Quotes, Appointments (SP)
				

			} else if (option == 6) {
				// Track Status of Quote Requests, Appointments
				// All USERS, only SP track appointment status
				

			} else if (option == 7) {
				// Respond to Quote, Manage Appointments (SP)
				

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
		System.out.println("1. Register into System");
		System.out.println("2. Login to System");
		
		System.out.println("3. Display Renovation Services");
		System.out.println("4. Arrange Action");
		System.out.println("5. View List");
		System.out.println("6. Track Status");
		System.out.println("7. Manage Action");
		
		System.out.println("99. Quit");
		Helper.line(80, "-");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	
}

import java.util.ArrayList;

public class C206_CaseStudy {
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_QUIT = 4;
	
	ArrayList<User> customerList = new ArrayList<User>();
	
	public static void main(String[] args) {
		ArrayList<User> customerList = new ArrayList<User>();
		
		customerList.add(new User("Alice", "customer", "alice@gmail.com", 12345678, "pass@customer1"));
		customerList.add(new User("Norman", "customer", "norman@gmail.com", 87654321, "pass@customer2"));

		int option = 0;
		
		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				// View all users
				C206_CaseStudy.viewAllUser(customerList);
				
			} else if (option == OPTION_ADD) {
				// Add a new user
				C206_CaseStudy.setHeader("ADD USER ACCOUNT");
				User user = inputUser();
				C206_CaseStudy.addUser(customerList, user);
				System.out.println("User account added");

			} else if (option == OPTION_DELETE) {
				C206_CaseStudy.setHeader("DELTE USER ACCOUNT");
				
				
//				// Loan item
//				C206_CaseStudy.setHeader("LOAN");			
//				itemTypeMenu();
//				
//				int itemType = Helper.readInt("Enter option to select item type > ");
//
//				if (itemType == 1) {
//					// Loan camcorder
//					C206_CaseStudy.loanCamcorder(camcorderList);
//				} else if (itemType == 2) {
//					// Loan Chromebook
//					C206_CaseStudy.loanChromebook(chromebookList);
//				} else {
//					System.out.println("Invalid type");
//				}

			}  else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	} //END OF MAIN METHOD
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	private static void menu() {
		C206_CaseStudy.setHeader("MANAGE CUSTOMER");
		System.out.println("1. View All Users");
		System.out.println("2. Add User Account");
		System.out.println("3. Delete User Account");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	// =================================== OPTION 1: ADD ============================================
	public static User inputUser() {
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter email > ");
		int contactNumber = Helper.readInt("Enter contact number > ");
		String password = Helper.readString("Enter password > ");
		
		User user = new User(name, role, email, contactNumber, password);
		return user;
	}
	
	public static void addUser(ArrayList<User> customerList, User user) {
		customerList.add(user);
	}
	
	// ================================== OPTION 2: VIEW ===========================================
	public static String retrieveAllUser(ArrayList<User> customerList) {
		String output = "";
		
		for (int i = 0; i < customerList.size(); i++) {
			output += String.format("%-102s\n", customerList.get(i).toString());
		}
		
		return output;
	}
	
	public static void viewAllUser(ArrayList<User> customerList) {
		C206_CaseStudy.setHeader("CUSTOMER LIST");
		String output = String.format("%-10s %-20s %-20s %-17s %-20s %-10s\n", "NAME", "ROLE",
				"EMAIL", "CONTACT_NUMBER","PASSWORD", "STATUS");
		 output += retrieveAllUser(customerList);	
		System.out.println(output);
	}
	
	// ================================== OPTION 3: DELETE ==========================================
	public static void deleteUser() {
		
	}
	
	public static void testExists(User user) {
		String searchName = Helper.readString("Enter name of user to delete > ");
		
	}
}

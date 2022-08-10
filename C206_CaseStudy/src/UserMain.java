//Done by Trina Ng

import java.util.ArrayList;

public class UserMain {
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_QUIT = 4;
	
	private static ArrayList<User> customerList = new ArrayList<User>();
	
	public static void main(String[] args) {
		ArrayList<User> customerList = new ArrayList<User>();
		
		customerList.add(new User("Alice", "customer", "alice@gmail.com", 12345678, "pass@customer1"));
		customerList.add(new User("Norman", "customer", "norman@gmail.com", 87654321, "pass@customer2"));

		int option = 0;
		
		while (option != OPTION_QUIT) {

			UserMain.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				// View all users
				UserMain.viewAllUser(customerList);
				
			} else if (option == OPTION_ADD) {
				// Add a new user
				UserMain.setHeader("ADD USER ACCOUNT");
				User user = inputUser();
				UserMain.addUser(customerList, user);

			} else if (option == OPTION_DELETE) {
				UserMain.setHeader("DELTE USER ACCOUNT");
				UserMain.deleteUser(customerList);

			}  else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}//END OF MAIN METHOD
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	private static void menu() {
		UserMain.setHeader("MANAGE CUSTOMER");
		System.out.println("1. View All Users");
		System.out.println("2. Add User Account");
		System.out.println("3. Delete User Account");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	// ================================== OPTION 1: VIEW ===========================================
		public static String retrieveAllUser(ArrayList<User> customerList) {
			String output = "";
			
			for (int i = 0; i < customerList.size(); i++) {
				output += String.format("%-102s\n", customerList.get(i).toString());
			}
			
			return output;
		}
		
		public static void viewAllUser(ArrayList<User> customerList) {
			if (customerList.size() > 0) {
				UserMain.setHeader("CUSTOMER LIST");
				String output = String.format("%-10s %-20s %-20s %-17s %-20s %-10s\n", "NAME", "ROLE",
						"EMAIL", "CONTACT_NUMBER","PASSWORD", "STATUS");
				 output += retrieveAllUser(customerList);	
				System.out.println(output);
			} else {
				System.out.println("List is empty!");
			}
		}
	
	// =================================== OPTION 2: ADD ============================================
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
		if (C206_CaseStudy.testExists(customerList, user.getName()) == false) {
			customerList.add(user);
			System.out.println("User account added!");
		} else {
			System.out.println("User account already exists in list!");
		}
	}
		
	// ================================== OPTION 3: DELETE ==========================================
	public static void deleteUser(ArrayList<User> customerList) {
		String inputName = Helper.readString("Enter name of user to delete > ");
		char confirmDelete = '\u0000';//default value
		
		if (UserMain.testExists(customerList, inputName)) {
			
			for(User user : customerList) {
				
				if(inputName.equals(user.getName())) {
					System.out.println(user.toString());
					confirmDelete = Helper.readChar("Delete User Above? > "); //match with user story with7 user story id 03
				}
				
				if (confirmDelete == 'y') {
					if(inputName.equals(user.getName())) {
						customerList.remove(user);
						System.out.println("User has been deleted!");
						break;
					}
				} else if (confirmDelete == 'n'){
					System.out.println("Cancel delete!");
					break;
				}
			}
		} else {
			System.out.println("User not found!");
		}
	}
	
	public static boolean testExists(ArrayList<User> customerList, String inputName) {
		boolean exist = false;
		
		for(int i = 0; i < customerList.size(); i++) {
			if (inputName.equals(customerList.get(i).getName())){
				exist = true;
			}
		}
		
		if (exist == true) {
			return true;
		} else {
			return false;
		}
	}
}

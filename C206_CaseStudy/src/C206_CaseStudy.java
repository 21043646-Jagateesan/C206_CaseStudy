//done by team 2
public class C206_CaseStudy {
	
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {

		int option = -1;
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == OPTION_VIEW) {
				// Trina code
				// View all customers
				UserMain.main(args);

			} else if (option == OPTION_ADD) {
				//Jaga code
				// View all for package item
				PackageMain.main(args);

			} else if (option == OPTION_DELETE) {
				//Amani code
				//Lucas code
				Quoterequestmain.main(args);
				QuotationLucas.main(args);
				
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
				
			} else {
				System.out.println("Invalid option");
			}
		}		
	}
	public static void menu() {
		PackageMain.setHeader("Renovation ACE Website");
		System.out.println("1. Enter as a Customer");
		System.out.println("2. Enter as an Admin");
		System.out.println("3. Enter as an Designer");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
}
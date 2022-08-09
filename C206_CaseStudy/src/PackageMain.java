import java.util.ArrayList;

public class PackageMain {
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_QUIT = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Package> pList = new ArrayList<Package>();
		
		pList.add(new Package("Jack", 1001, "12/02/2022", "15/05/2023", 100.23));
		pList.add(new Package("Shaun", 1032, "16/08/2022", "14/09/2024", 455.24));
		pList.add(new Package("David", 1112, "22/06/2022", "04/05/2024", 150.10));
		
		int option = 0;

		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				// View all items
				PackageMain.viewAllPackage(pList);

			} else if (option == OPTION_ADD) {
				// Add a new item
				setHeader("ADD");		
				
					// Add a package
					Package pa = inputPackage();
					PackageMain.addPackage(pList, pa);
					System.out.println("Package added");

			} else if (option == OPTION_DELETE) {
				// Delete item
				setHeader("DELETE");			

					// Delete package
					int code = inputDeletePackage();
					PackageMain.deletePackage(pList, code);
					System.out.println("Package Deleted!");
			
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
				
			} else {
				System.out.println("Invalid option");
			}
		}		
	}	

	//END OF MAIN METHOD
	public static void menu() {
		setHeader("Renovation ACE ");
		System.out.println("1. View All Package");
		System.out.println("2. Add Package");
		System.out.println("3. Delete Package");
		System.out.println("4. Quit");
		Helper.line(100, "-");
	}
	public static void setHeader(String header) {
		Helper.line(100, "-");
		System.out.println(header);
		Helper.line(100, "-");
	}
	//================================= Option 1 View (CRUD - Read) =================================
		public static String retrieveAllPackage(ArrayList<Package> pList) {
			String output = "";

			for (int i = 0; i < pList.size(); i++) {

				output += String.format("%-10s %-20d %-25s %-30s %-20.1f\n", 
						pList.get(i).getCustomerName(), pList.get(i).getPackageCode(), pList.get(i).getPackageSD(),
						pList.get(i).getPackageED(), pList.get(i).getPackageAmt());
			}
			return output;
		}
	public static void viewAllPackage(ArrayList<Package> pList) {
		PackageMain.setHeader("PACKAGE LIST");
		String output = String.format("%-10s %-20s %-25s %-30s %-20s\n", "NAME", "CODE",
				"START_DATE", "END_DATE","AMOUNT");
		 output += retrieveAllPackage(pList);	
		System.out.println(output);
	}
	//================================= Option 2 Add (CRUD - Create)=================================
	public static Package inputPackage() {
		String name = Helper.readString("Enter Name > ");
		int code = Helper.readInt("Enter Package Code > ");
		String SD = Helper.readString("Enter Package Start Date (dd/mm/yyyy) > ");
		String ED = Helper.readString("Enter Package End Date (dd/mm/yyy) > ");
		double Amt = Helper.readDouble("Enter the Package Amount > ");

		Package pa= new Package(name, code, SD, ED, Amt);
		return pa;
		
	}
	public static void addPackage(ArrayList<Package> pList, Package pa) {
		
		pList.add(pa);
		
	}
	//================================= Option 3 Delete (CURD- Delete) =================================
	 public static  void deletePackage(ArrayList<Package> pList, int code) {
		   
		   for (int i = 0; i < pList.size(); i++) {
		    if (code==(pList.get(i).getPackageCode() )) {
		     pList.remove(i);
		    }
		   } 
		  }
		  public static int inputDeletePackage() {
		    int code = Helper.readInt("Please enter the Package Code > ");
		   return code;
		  }
		  
	//================================= testAdd (CURD- test add method) =================================
		  public static void testAdd(ArrayList<Package> pList, Package pa) {
				
				pList.add(pa);
				
			}
	//================================= testDelete (CURD- test delete method) ============================
		  public static boolean testDelete(int code) {
				ArrayList<Package> pList = new ArrayList<Package>();
				pList.add(new Package("Jack", 1001, "12/02/2022", "15/05/2023", 35));
				pList.add(new Package("Shaun", 1032, "16/08/2022", "14/09/2024", 45));
				int size = pList.size();
				boolean check = false;
				for (Package p : pList) {
					if (code==(p.getPackageCode())) {
						pList.remove(p);
					}
				}
				if (pList.size() < size) {
					check = true;
				}
				return check;
			}
}

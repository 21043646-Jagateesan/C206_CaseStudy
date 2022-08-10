
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

//lucas
public class QuotationLucas {

	
	private static ArrayList <Quotations> quotationList = new ArrayList<Quotations>();
	private static ArrayList <Package> packageList = new ArrayList<Package>();
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_QUIT = 4;

	private static String rId = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuotationLucas mw = new QuotationLucas();
		ArrayList <Quotations> quotationList = new ArrayList<Quotations>();
		
		quotationList.add(new Quotations("RV001", "QT001", "Kitchen", "Flooring", 550.00, "Anne", LocalDate.of(2022, 10, 8), 700.00));
		quotationList.add(new Quotations("RV001", "QT002", "Bedroom", "Closet", 350.00, "Anne", LocalDate.of(2022, 10, 12), 550.00));
		quotationList.add(new Quotations("RV002", "QT003", "Living Room", "Door", 200.00, "Ben", LocalDate.of(2022, 12, 14), 220.00));
		quotationList.add(new Quotations("RV003", "QT004", "Toilet", "Flooring", 550.00, "Carrol", LocalDate.of(2023, 05, 9), 600.00));
		try {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		} catch (Exception e) 
		{
			
		}
		mw.start();
	}
	
	public void start() {
		int option = -1;
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter choice - ");
			
			if (option == OPTION_VIEW) {
				
				QuotationLucas.viewAllQuotation(quotationList);
				
				
			} else if (option == OPTION_ADD) {
				Quotations qt = inputQuotation();
				QuotationLucas.addQuotation(quotationList, qt);
				
			} else if (option == OPTION_DELETE) {
				String Qid = Helper.readString("\nEnter quotation id > ");
				QuotationLucas.deleteQuotation(quotationList, Qid);
				
			}else if (option == OPTION_QUIT) {
				System.out.println("Thank You");
			}
		}
	}
	
	public static void setHeader(String header) {
		Helper.line(145, "-");
		System.out.println(header);
		Helper.line(145, "-");
	}
	
	
		
	
	

			

	
	
	
	private static void viewAllQuotation(ArrayList<Quotations> quotationList1) {
		if (quotationList.size() > 0) {
			QuotationLucas.setHeader("QuotationList LIST");
			String output = String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "REQUEST_ID", "QUOTATION_ID", "RENOVATION CATEGORY", 
					"RENOVATION ITEM", "RENOVATION ITEM PRICE", "DESIGNER", "START DATE", "TOTAL QUOTATION SUM");
			
			 output += retrieveAllUser(quotationList);	
			System.out.println(output);
		} else {
			System.out.println("List is empty!");
		}
	}
	

	private static String retrieveAllUser(ArrayList<Quotations> quotationList) {
		String output = "";
		
		for (int i = 0; i < quotationList.size(); i++) {
			output += String.format("%-102s\n", quotationList.get(i).toString());
		}
		
		return output;
	}
	

	
	private static void menu() {
		QuotationLucas.setHeader("Designer Interface");
		System.out.println("1. View All Quotations");
		System.out.println("2. Add New Quotations");
		System.out.println("3. Delete Quotations by Quotation ID");
		System.out.println("4. Quit");
	}
	
	
	
	
	

		
	
	
	
	
	public Quotations inputQuotation() {
		Quotations qt = new Quotations("", "", "", "", 0, "", LocalDate.now(), 0);
		String requestID = Helper.readString("Please enter request id > ");
		String quotationID = Helper.readString("Please enter quotation id > ");
		String renocat = Helper.readString("Please enter renovation catergory > ");
		String renocatItem = Helper.readString("Please enter renovation item > ");
		double itemPrice = Helper.readDouble("please enter price of renovation item > ");
		String designerName = Helper.readString("Please enter designer name > ");
		int sDayDate = Helper.readInt("Please enter day in month of start date > ");
		int sMonthDate = Helper.readInt("Please enter month of start date > ");
		int sYearDate = Helper.readInt("Please enter year of start date > ");
		double totalSum = Helper.readDouble("Please enter total quotation amount > ");

		if(!requestID.isEmpty() && !quotationID.isEmpty() & !renocat.isEmpty() && !renocatItem.isEmpty() && itemPrice > 0 && !designerName.isEmpty() && sDayDate > 0 
				&& sMonthDate > 0 && sYearDate > 0 && totalSum > 0) {
			qt = new Quotations(requestID.toUpperCase(), quotationID.toUpperCase(), renocat, renocatItem, itemPrice, designerName, LocalDate.of(sYearDate, sMonthDate, sDayDate), totalSum);
		}
		return qt;
	}
	
	//add
	public static void addQuotation(ArrayList<Quotations> quotationList, Quotations qt) {
		boolean add = false;
		if(quotationList.size() == 0) {
			add = true;
		}
		else if (quotationList.size() > 0){
			for (int q = 0; q < quotationList.size(); q++) {
				if (!quotationList.get(q).getQID().equalsIgnoreCase(qt.getQID())) {
					add = true;
				}
				else {
					add = false;
					break;
				}
			}
		}	
		if(add == true) {
			quotationList.add(qt);
			System.out.println("Quotation added successfully.");
		}
		else {
			System.out.println("Quotation failed to add due to duplication.");
		}
	}
	
	//delete
	public static void deleteQuotation(ArrayList<Quotations> quotationList, String Qid) {
		char confirmDelete = '\u0000';//default value
		
		if (QuotationLucas.testExists(quotationList, Qid)) {
			
			for(Quotations quotations : quotationList) {
				
				if(Qid.equals(quotations.getQID())) {
					System.out.println(Qid.toString());
					confirmDelete = Helper.readChar("Delete User Above?(y/n) > "); 
				}
				
				if (confirmDelete == 'y') {
					if(quotationList.equals(quotations.getQID())) {
						quotationList.remove(Qid);
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
	public static boolean testExists(ArrayList<Quotations> quotationList, String qID) {
		boolean exist = false;
		
		for(int i = 0; i < quotationList.size(); i++) {
			if (qID.equals(quotationList.get(i).getQID())){
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Quoterequestmain {
	
	private ArrayList<QuoteRequests> requestlist = new ArrayList<QuoteRequests>();
	//empty ArrayLists though
	
	public void listadd() {
		
		
	
	    //requestlist.add(new QuoteRequests(String propertyType, double area, String requestorName, int requestorNum, String requestorEmail,double budget, String completeDate, String renoType, String renoStyle, int NumRoom, int NumToilet, String UrgentReq)
	
		requestlist.add(new QuoteRequests("2202","hdb", 87.1, "Amani", 85113257, "hud.msg@gmail.com", 2340.00, "11/8/2022", "Living Room", "Modern", 2, 1, "-"));
		requestlist.add(new QuoteRequests("2203","Landed", 300.00, "James", 90887531, "james.msg@gmail.com",3900.00, "27/8/2022", "Whole House", "Classic", 1, 1, "Urgent"));		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quoterequestmain qm = new Quoterequestmain();
		qm.listadd();
		int mainchoice = 0;
		
		do {

			qm.menu();
			mainchoice = Helper.readInt("Enter choice > ");
			while (mainchoice != 1 && mainchoice != 2 && mainchoice != 3 && mainchoice != 4 ) {
				System.out.println("Invalid Input!");
				mainchoice = Helper.readInt("Enter choice > ");
			}
			
			if (mainchoice == 1) {
				String id = Helper.readString("Enter request id > ");
				String propertyType = Helper.readString("Enter propertyType > ");
				double area = Helper.readDouble("Enter area > ");
				String requestorName = Helper.readString("Enter name > ");
				int requestorNum = Helper.readInt("Enter number > ");
                String requestorEmail = Helper.readString("Enter email > ");
                double budget = Helper.readDouble("Enter budget > ");
                String completeDate = Helper.readString("Enter completed date(dd/mm/yyyy) > ");
                String renoType = Helper.readString("Enter renovation type > ");
	            String renoStyle = Helper.readString("Enter renovation style > ");
	            int NumRoom = Helper.readInt("Enter number of rooms > ");
	            int NumToilet = Helper.readInt("Enter number of toilets > ");
	            String UrgentReq = Helper.readString("Enter Urgency > ");
				
				// create inputs 
				//requestlist.add(new QuoteRequests(String propertyType, double area, String requestorName, int requestorNum, String requestorEmail,double budget, String completeDate, String renoType, String renoStyle, int NumRoom, int NumToilet, String UrgentReq)
				qm.addRequest(new QuoteRequests(id, propertyType, area, requestorName, requestorNum, requestorEmail, budget, completeDate, renoType, renoStyle, NumRoom, NumToilet, UrgentReq));
				System.out.println("Request added!");
				
			}else if (mainchoice == 2) {
				
				System.out.println(qm.viewAllRequests());
				
			}else if (mainchoice == 3) {
				String id = Helper.readString("Enter request id > ");
				if (qm.deleteRequest(id)) {
					System.out.println("Delete successfull!");
				}else {
					System.out.println("Delete failed!");
				}
			}
			
		} while (mainchoice != 4);
	}
	
	//Food no submenu cos its just viewing
	
	
	private void menu() {
		System.out.println("1. Add Request");
		System.out.println("2. View Request");
		System.out.println("3. Delete Request");
		System.out.println("4. Exit to main menu\n");
	}
	
	public String viewAllRequests() {
		
		//requestlist.add(new QuoteRequests(String propertyType, double area, String requestorName, int requestorNum, String requestorEmail,double budget, String completeDate, String renoType, String renoStyle, int NumRoom, int NumToilet, String UrgentReq)
		//String output = String.format("%-5s %-10s %-10s\n", "ID", "promoPrice", "promoDate");
		String output = String.format("%-15s %-15s %-15s %-15s %-15s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "ID", "PropertyType", "Area", "RequestorName","RequestorNum", "RequestorEmail", "Budget", "CompleteDate", "RenoType", "RenoStyle", "NumRoom", "NumToilet", "UrgentReq");
		for (QuoteRequests q : requestlist) {
			
			output += String.format("%-15s %-15s %-15.2f %-15s %-15d %-20s %-15.2f %-15s %-15s %-15s %-15d %-15d %-15s\n", q.getid(), q.getPropertyType(), q.getarea(), q.getrequestorName(), q.getrequestorNum(), q.getrequestorEmail(), q.getbudget(), q.getcompleteDate(), q.getrenoType(), q.getrenoStyle(), q.getNumRoom(), q.getNumToilet(), q.getUrgentReq());
		}
		return output;
	}
	
	public boolean addRequest(QuoteRequests theRequest) {
		
		if (theRequest == null) {
			return false;
		} else {
			this.requestlist.add(theRequest);
			return true;
		}
		
	}
	
	public boolean deleteRequest(String id) {
		
		int i = 0;
		boolean removed = false;
		while (i < requestlist.size()) {
			if (requestlist.get(i).getid().equalsIgnoreCase(id)) {
				requestlist.remove(i);
				removed = true;
			}
			i++;
		}
		return removed;
		
	}
	
	public ArrayList<QuoteRequests> getRequests(){
		
		return requestlist;
		
	}

}

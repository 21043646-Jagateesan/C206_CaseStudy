
import java.util.ArrayList;
//amani
public class QuotationMain {

	public ArrayList<Quotation> quotationlist = new ArrayList<Quotation>();
	public ArrayList<Customer> customerlist = new ArrayList<Customer>();

	public void listadd() {
		quotationlist.add(new Quotation("Amani", "85113257", 2000.00));
		quotationlist.add(new Quotation("James", "99807721", 2341.00));
	}

	public boolean addQuotation(Quotation newQuote) {

		if (newQuote == null) {
			return false;
		}else {
			this.quotationlist.add(newQuote);
			return true;
		}
	}

	public String viewAllQuotation() {
		String output = String.format("%-15s %-15s %-10s", "QuotationID" , "CustomerName" , "QuotationPrice\n" );
		int i = 0;
		int a = 0;
		String name = "";
		while (i < quotationlist.size()) {
			while (a < customerlist.size()) {
				if (quotationlist.get(i).getcusid().equalsIgnoreCase(customerlist.get(i).getID())) {
					name = customerlist.get(a).getName();
				}
				a++;
			}
			String id = quotationlist.get(i).getid();
			double price = quotationlist.get(i).getPrice();
			output += String.format("%-15s %-15s $%-10.2f\n", id, name, price);
			i++;
		}
		return output;
	}

	public boolean deleteQuotation(String id) {
		int i = 0;
		boolean removed = false;
		while (i < quotationlist.size()) {
			if (quotationlist.get(i).getid().equalsIgnoreCase(id)) {
				quotationlist.remove(i);
				removed = true;
			}
			i++;
		}
		return removed;
	}

	public ArrayList<Quotation> getQuotation(){

		return quotationlist;

	}

	//public void viewAllPromotions()

	//public static void addcustomer() {
		//Customer newcustomer = new Customer("J30532","John wick");
		//customerlist.add(newcustomer);
	//}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addcustomer();
		QuotationMain qm = new QuotationMain();
		qm.menu();
		int option = 0;

		while (option != 4) {
			qm.menu();
			option = Helper.readInt("Enter choice > ");

			if (option == 1) {
					String quotationid = Helper.readString("Enter quotation ID > ");
					String customerid = "";
					int i = 0;
					customerid = Helper.readString("Enter valid customer ID > ");

					double price = Helper.readDouble("Enter quotation price > ");
					Quotation newQuote = new Quotation(quotationid, customerid, price);
					if (qm.addQuotation(newQuote)){
						System.out.println("Quotation added");
					}else {
						System.out.println("Quotation add failed!");
					}

				qm.menu();
				option = Helper.readInt("Enter choice > ");
			}else if (option == 2) {

				System.out.println(qm.viewAllQuotation());
				//view all

				qm.menu();
				option = Helper.readInt("Enter choice > ");
			}else if (option == 3) {
				String id = Helper.readString("Enter ID > ");

				//give id to the method

				if (qm.deleteQuotation(id)) {
					System.out.println("Quotation removed");
				}else {
					System.out.println("Error removing quotation with id " + id );
				}

				qm.menu();
				option = Helper.readInt("Enter choice > ");
			}else if (option == 4){
				//skips to the end of while loop

			}else {
				System.out.println("Invalid choice!");
			}
		}


	}

	private void menu() {
		System.out.println("1. Add Quotations");
		System.out.println("2. View  all Quotations");
		System.out.println("3. Delete Quotations");
		System.out.println("4. Quit");
	}

}
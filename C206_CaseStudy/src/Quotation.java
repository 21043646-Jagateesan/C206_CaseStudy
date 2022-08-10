	public class Quotation {
		private String id;
		private double price;
		private String customerid;
		
		public Quotation(String id, String customerid, double price) {
			this.id = id;
			this.price = price;
			this.customerid = customerid;
		}
		
		public String getid() {
			return id;
		}
		
		public String getcusid() {
			return customerid;
		}
		
		public double getPrice() {
			return price;
		}
		
	}
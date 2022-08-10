public class QuoteRequests {
	private String id;
	private String propertyType; 
	 private double area;
	 private String requestorName;
	 private int requestorNum;
	 private String requestorEmail;
	 private double budget;
	 private String completeDate;
	 private String renoType;
	 private String renoStyle;
	 private int NumRoom;
	 private int NumToilet;
	 private String UrgentReq;
	 

	 public QuoteRequests(String id, String propertyType, double area, String requestorName, int requestorNum, String requestorEmail,
			 double budget, String completeDate, String renoType, String renoStyle, int NumRoom, int NumToilet,String UrgentReq) {
	  this.id = id;
	  this.propertyType = propertyType;
	  this.area = area;
	  this.requestorName = requestorName;
	  this.requestorNum = requestorNum;
	  this.requestorEmail = requestorEmail;
	  this.budget = budget;
	  this.completeDate = completeDate;
	  this.renoType = renoType;
	  this.renoStyle = renoStyle;
	  this.NumRoom = NumRoom;
	  this.NumToilet = NumToilet;
	  this.UrgentReq = UrgentReq;
	  
	  
	 }
	 
	 public String getid() {
		 return id;
	 }
	 
	 public String getPropertyType() {
		 return propertyType;
	 }
	 
	 public double getarea() {
		 return area;
	 }
	 
	 public String getrequestorName() {
		 return requestorName;
	 }
	 
	 public int getrequestorNum() {
		 return requestorNum;
	 }
	 
	 public  String getrequestorEmail() {
		 return requestorEmail;
	 }
	 
	 public double getbudget() {
		 return budget;
	 }
	 
	 public String getcompleteDate() {
		 return completeDate;
	 }
	  
	 public String getrenoType() {
		 return renoType;
	 }
	 
	 public String getrenoStyle() {
		 return renoStyle;
	 }
	 
	 public int getNumRoom() {
		 return NumRoom;
	 }
	 
	 public int getNumToilet() {
		 return NumToilet;
	 }
	 
	 public String getUrgentReq() {
		 return UrgentReq;
	 }
	 
}
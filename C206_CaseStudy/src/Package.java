
public class Package {
	private String customerName;
	private int PackageCode;
	private String PackageSD;
	private String PackageED;
	private double PackageAmt;
	

	public Package(String customerName, int PackageCode, String PackageSD, String PackageED, double PackageAmt) {
		this.customerName = customerName;
		this.PackageCode = PackageCode;
		this.PackageSD = PackageSD;
		this.PackageED = PackageED;
		this.PackageAmt = PackageAmt;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public int getPackageCode() {
		return PackageCode;
	}


	public void setPackageCode(int PackageCode) {
		this.PackageCode = PackageCode;
	}


	public String getPackageSD() {
		return PackageSD;
	}


	public void setPackageSD(String PackageSD) {
		this.PackageSD = PackageSD;
	}

	public String getPackageED() {
		return PackageED;
	}


	public void setPackageED(String PackageED) {
		this.PackageED = PackageED;
	}
	
	
	public double getPackageAmt() {
		return PackageAmt;
	}


	public void setPackageAmt(double PackageAmt) {
		this.PackageAmt = PackageAmt;
	}

}

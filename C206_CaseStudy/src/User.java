public class User {
	
	private String name;
	private String role;
	private String email;
	private int contactNumber;
	private String password;
	private String status;
	
	public User(String name, String role, String email, int contactNumber, String password) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
		status = "New";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus() {
		this.status = status;
	}
	
	public String toString(){
		String output = String.format("%-10s %-20s %-20s %-17d %-20s %-10s", name, role, email, contactNumber, 
				password, status);
		return output;
	}
}

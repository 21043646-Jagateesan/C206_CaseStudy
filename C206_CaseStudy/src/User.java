public class User {
	
	private String name;
	private String role;
	private String email;
	private int contactNumber;
	private String password;
	private String status;
	
	public User(String name, String role, String email, int contactNumber, String password, String status) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
		this.status = status;
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

	public void setStatus(String status) {
		this.status = status;
	}
	
}

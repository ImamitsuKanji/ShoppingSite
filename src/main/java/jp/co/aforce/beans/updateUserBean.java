package jp.co.aforce.beans;

public class updateUserBean {
	private String id;
	private String password;
	private String lastName;
	private String firstName;
	private String address;
	private String mailAddress;
	private String role;

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getAddress() {
		return address;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getRole() {
		return role;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

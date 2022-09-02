package Pojo;

public class LoginPojo {
private int accountId;
private String userEmail;
private String firstName;
private String lastName;
private String password;
public LoginPojo() {
	super();
	// TODO Auto-generated constructor stub
}
public LoginPojo( String userEmail, String firstName, String lastName, String password,int accountId) {
	super();
	this.userEmail = userEmail;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.accountId = accountId;
}

public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getAccountId() {
	return accountId;
}
public void setAccountId(int accountId) {
	this.accountId = accountId;
}

public String toString() {
	return "LoginPojo [userEmail=" + userEmail + ", firstName=" + firstName + ", lastName="
			+ lastName + ", password=" + password + " accountId=\" + accountId + \"]";
}



}


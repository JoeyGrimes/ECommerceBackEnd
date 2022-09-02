package Pojo;

public class AccountPojo {
private int accountId;
private String email;
private int accountBalance;
public AccountPojo() {
	super();
	// TODO Auto-generated constructor stub
}
public AccountPojo(int accountBalance, int accountId) {
	super();
	this.accountId = accountId;
	
	this.accountBalance = accountBalance;
}
public int getAccountId() {
	return accountId;
}
public void setAccountId(int accountId) {
	this.accountId = accountId;
}


public int getAccountBalance() {
	return accountBalance;
}
public void setAccountBalance(int accountBalance) {
	this.accountBalance = accountBalance;
}
@Override
public String toString() {
	return "AccountPojo [accountId=" + accountId + ", accountBalance=" + accountBalance + "]";
}


}





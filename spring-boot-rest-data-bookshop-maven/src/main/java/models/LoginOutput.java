package models;

public class LoginOutput {
	private int accountid;

	public LoginOutput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginOutput(int accountid) {
		super();
		this.accountid = accountid;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	@Override
	public String toString() {
		return "LoginOutput [accountid=" + accountid + "]";
	}
	
	
}

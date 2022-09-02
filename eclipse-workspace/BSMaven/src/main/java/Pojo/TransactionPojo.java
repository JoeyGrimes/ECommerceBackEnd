package Pojo;

public class TransactionPojo {

private String date;
private String transactionType;
private int changedAmount;
private int id_number;
 
public TransactionPojo(String date, String transactionType, int changedAmount, int id_number) {
	super();
	this.date = date;
	this.transactionType = transactionType;
	this.changedAmount = changedAmount;
	this.id_number = id_number;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}
public int getChangedAmount() {
	return changedAmount;
}
public void setChangedAmount(int changedAmount) {
	this.changedAmount = changedAmount;
}
public int getId_number() {
	return id_number;
}
public void setId_number(int id_number) {
	this.id_number = id_number;
}

public String toString() {
	return "TransactionPojo [date=" + date + ", transactionType=" + transactionType + ", changedAmount=" + changedAmount
			+ ", id_number=" + id_number + "]";
}

	
	
	
}

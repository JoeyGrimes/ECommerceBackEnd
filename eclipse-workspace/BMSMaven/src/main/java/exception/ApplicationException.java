package exception;

public class ApplicationException extends Exception{
	
	public String getMessage() {
		return "Internal Database Server Error!! Please try again later!!"; 
	}
}
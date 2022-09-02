package Pojo;

public class BookPojo {

	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookGenre;
	private int bookCost;
	private String bookImageUrl; // this is not very useful while working with a console based application
	
	public BookPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookPojo(int bookId, String bookTitle, String bookAuthor, String bookGenre, int bookCost,
			String bookImageUrl) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.bookCost = bookCost;
		this.bookImageUrl = bookImageUrl;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public String getBookGenre() {
		return bookGenre;
	}
	
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	
	public int getBookCost() {
		return bookCost;
	}
	
	public void setBookCost(int bookCost) {
		this.bookCost = bookCost;
	}
	public String getBookImageUrl() {
		return bookImageUrl;
	}
	
	public void setBookImageUrl(String bookImageUrl) {
		this.bookImageUrl = bookImageUrl;
	}
	
	@Override
	public String toString() {
		return "BookPojo [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookGenre="
				+ bookGenre + ", bookCost=" + bookCost + ", bookImageUrl=" + bookImageUrl + "]";
	}

	// if required place the equals() and hashcode()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + bookCost;
		result = prime * result + ((bookGenre == null) ? 0 : bookGenre.hashCode());
		result = prime * result + bookId;
		result = prime * result + ((bookImageUrl == null) ? 0 : bookImageUrl.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookPojo other = (BookPojo) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookCost != other.bookCost)
			return false;
		if (bookGenre == null) {
			if (other.bookGenre != null)
				return false;
		} else if (!bookGenre.equals(other.bookGenre))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookImageUrl == null) {
			if (other.bookImageUrl != null)
				return false;
		} else if (!bookImageUrl.equals(other.bookImageUrl))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		return true;
	}
	
	
}

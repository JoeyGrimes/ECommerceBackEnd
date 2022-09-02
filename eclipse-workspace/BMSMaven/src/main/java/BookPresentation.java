import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.BookDaoJdbcImpl;
import exception.ApplicationException;
import Pojo.BookPojo;
import service.BookService;
import service.BookServiceImpl;


public class BookPresentation {

	// Logging Step 1 - obtain an instance of Logger
	private static final Logger logger = LoggerFactory.getLogger(BookPresentation.class);
	
	public static void main(String[] args) {

		// here we will have the input and the outputs
		// the menus are displayed here
		
		// presentation layers calls the methods of the service layer
		// so i need an object of BookServiceImpl
		BookService bookService = new BookServiceImpl(); // always the interface reference variable should point to the object of the implementation class
		
		Scanner scan = new Scanner(System.in);
		char continueApp = 'y';

		while (continueApp == 'y' || continueApp == 'Y') {

			System.out.println("*************************************************");
			System.out.println("\t\tBOOK MANAGEMENT SYSTEM");
			System.out.println("*************************************************");
			System.out.println("MAIN MENU");
			System.out.println("*************************************************");
			System.out.println("1. List all the books.");
			System.out.println("2. Add a new book.");
			System.out.println("3. Update a book.");
			System.out.println("4. Delete a book.");
			System.out.println("5. Fetch a book");
			System.out.println("6. Exit.");
			System.out.println("*************************************************");
			System.out.println("Please enter an option : ");
			int option = scan.nextInt();
			System.out.println("*************************************************");
			switch (option) {
			case 1:
				// will remove this statement later an dput the actual code here
				// System.out.println("Listing all the books....");
				
				List<BookPojo> fetchedAllBooks;
				try {
					fetchedAllBooks = bookService.getAllBooks();
				} catch (ApplicationException e) {
					// Logging Step 2 - log the exception in each catch black
					logger.error("Exception occurred : " + e.getMessage());
					System.out.println(e.getMessage()); // print the exception message on the console
					break; // there is no point in continuing the case, so break out of it
				}
				System.out.println("=============================================================================");
				System.out.println("ID\tTITLE\t\t\t\t\tAUTHOR\t\tGENRE\tCOST");
				System.out.println("=============================================================================");
				for(int i=0;i<fetchedAllBooks.size();i++) {
					System.out.println(fetchedAllBooks.get(i).getBookId() + "\t" + fetchedAllBooks.get(i).getBookTitle() + "\t" + fetchedAllBooks.get(i).getBookAuthor() + "\t" + fetchedAllBooks.get(i).getBookGenre() + "\t" + fetchedAllBooks.get(i).getBookCost());
				}
				System.out.println("=============================================================================");
				break;
			case 2:
				System.out.println("Enter Book Title: ");
				scan.nextLine();
				String bookTitle = scan.nextLine();
				
				System.out.println("Enter Book Authur: ");
				String bookAuthur = scan.nextLine();
				
				System.out.println("Enter Book Genre: ");
				String bookGenre = scan.nextLine();
				
				System.out.println("Enter Book Cost: ");
				int bookCost = scan.nextInt();
				
				// now create a book pojo object and set these values into it
				BookPojo newBook = new BookPojo();
				newBook.setBookTitle(bookTitle);
				newBook.setBookAuthor(bookAuthur);
				newBook.setBookGenre(bookGenre);
				newBook.setBookCost(bookCost);
				
				BookPojo newBookPojoWithId;
				try {
					newBookPojoWithId = bookService.addBook(newBook);
				} catch (ApplicationException e) {
					// Logging Step 2 - log the exception in each catch black
					logger.error("Exception occurred : " + e.getMessage());
					
					System.out.println(e.getMessage()); // print the exception message on the console
					break; // there is no point in continuing the case, so break out of it
				}
				System.out.println("*************************************************");
				System.out.println("New book with ID " + newBookPojoWithId.getBookId() + " is added!! ");
				
				break;
			case 3:
				System.out.println("Please enter the Book ID: ");
				int bookId = scan.nextInt();
				BookPojo fetchedBookPojo;
				try {
					fetchedBookPojo = bookService.getABook(bookId);
				} catch (ApplicationException e) {
					// Logging Step 2 - log the exception in each catch black
					logger.error("Exception occurred : " + e.getMessage());
					
					System.out.println(e.getMessage()); // print the exception message on the console
					break; // there is no point in continuing the case, so break out of it
				}
				if(fetchedBookPojo == null) {
					// the book with the id is not found
					System.out.println("Book with ID " + bookId + " does not exist!!");
				} else {
					// the book with the id has been found
					// so display the book information
					System.out.println("=============================");
					System.out.println("BOOK ID : " + fetchedBookPojo.getBookId());
					System.out.println("BOOK TITLE : " + fetchedBookPojo.getBookTitle());
					System.out.println("BOOK AUTHOR : " + fetchedBookPojo.getBookAuthor());
					System.out.println("BOOK GENRE : " + fetchedBookPojo.getBookGenre());
					System.out.println("BOOK COST : " + fetchedBookPojo.getBookCost());
					System.out.println("=============================");
					System.out.println("Enter the new cost: ");
					int newCost = scan.nextInt();
					fetchedBookPojo.setBookCost(newCost);
					try {
						BookPojo updatedBookPojo =bookService.updateBook(fetchedBookPojo);
					} catch (ApplicationException e) {
						// Logging Step 2 - log the exception in each catch black
						logger.error("Exception occurred : " + e.getMessage());
						
						System.out.println(e.getMessage()); // print the exception message on the console
						break; // there is no point in continuing the case, so break out of it
					}
					System.out.println("*************************************************");
					System.out.println("Book cost updated successfully!!");
				}
				
				break;
			case 4:
				System.out.println("Please enter the Book ID to be removed: ");
				int inputBookId = scan.nextInt();
				BookPojo returnBookPojo;
				try {
					returnBookPojo = bookService.getABook(inputBookId);
				} catch (ApplicationException e) {
					// Logging Step 2 - log the exception in each catch black
					logger.error("Exception occurred : " + e.getMessage());
					
					System.out.println(e.getMessage()); // print the exception message on the console
					break; // there is no point in continuing the case, so break out of it
				}
				if(returnBookPojo == null) {
					// the book with the id is not found
					System.out.println("Book with ID " + inputBookId + " does not exist!!");
				} else {
					// the book with with the id has been found
					// so display the book information
					System.out.println("=============================");
					System.out.println("BOOK ID : " + returnBookPojo.getBookId());
					System.out.println("BOOK TITLE : " + returnBookPojo.getBookTitle());
					System.out.println("BOOK AUTHOR : " + returnBookPojo.getBookAuthor());
					System.out.println("BOOK GENRE : " + returnBookPojo.getBookGenre());
					System.out.println("BOOK COST : " + returnBookPojo.getBookCost());
					System.out.println("=============================");
				}
				System.out.println("Are you sure that you want to remove the book? (y/n) :");
				char deleteConfirm = scan.next().charAt(0);
				if(deleteConfirm == 'y') {
					try {
						bookService.deleteBook(inputBookId);
					} catch (ApplicationException e) {
						// Logging Step 2 - log the exception in each catch black
						logger.error("Exception occurred : " + e.getMessage());
						
						System.out.println(e.getMessage()); // print the exception message on the console
						break; // there is no point in continuing the case, so break out of it
					}
					System.out.println("Book removed!!");
				}
				break;
			case 5:
				System.out.println("Please enter the Book ID: ");
				int fetchBookId = scan.nextInt();
				BookPojo returnedBookPojo;
				try {
					returnedBookPojo = bookService.getABook(fetchBookId);
				} catch (ApplicationException e) {
					// Logging Step 2 - log the exception in each catch black
					logger.error("Exception occurred : " + e.getMessage());
					
					System.out.println(e.getMessage()); // print the exception message on the console
					break; // there is no point in continuing the case, so break out of it
				}
				if(returnedBookPojo == null) {
					// the book with the id is not found
					System.out.println("Book with ID " + fetchBookId + " does not exist!!");
				} else {
					// the with with the id has been found
					// so display the book information
					System.out.println("=============================");
					System.out.println("BOOK ID : " + returnedBookPojo.getBookId());
					System.out.println("BOOK TITLE : " + returnedBookPojo.getBookTitle());
					System.out.println("BOOK AUTHOR : " + returnedBookPojo.getBookAuthor());
					System.out.println("BOOK GENRE : " + returnedBookPojo.getBookGenre());
					System.out.println("BOOK COST : " + returnedBookPojo.getBookCost());
					System.out.println("=============================");
				
				}
				break;
			case 6:
				System.out.println("*************************************************");
				System.out.println("THANKYOU FOR USING BOOK MANAGEMENT SYSTEM!!");
				System.out.println("*************************************************");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid option!!");

			}
			System.out.println("*************************************************");
			System.out.println("Do you want to continue(y/n) ?");
			continueApp = scan.next().charAt(0); // taking out the first character of the string that was given as input
			// here
		}
		System.out.println("*************************************************");
		System.out.println("THANKYOU FOR USING BOOK MANAGEMENT SYSTEM!!");
		System.out.println("*************************************************");

	}

}

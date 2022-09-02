import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Pojo.AccountPojo;
import Pojo.LoginPojo;
import Pojo.TransactionPojo;
import service.AccountService;
import service.AccountServiceImpl;
import dao.AccountDaoJdbcImpl;
import dao.LoginDaoJdbcImpl;
import exception.ApplicationException;
import service.LoginService;
import service.LoginServiceImpl;

public class BankPresentation {
	public static void main(String[] args) throws ApplicationException {
		LoginDaoJdbcImpl x = new LoginDaoJdbcImpl();
		LoginService loginService = new LoginServiceImpl();
		AccountDaoJdbcImpl z = new AccountDaoJdbcImpl();
		Scanner scan = new Scanner(System.in);
		AccountService accountService = new AccountServiceImpl();
		char ContinueApp = 'y';
		{
			while (ContinueApp == 'y' || ContinueApp == 'Y') {
				System.out.println("---------------------------");
				System.out.println("Welcome to Southwest Banking");
				System.out.println("---------------------------");
				System.out.println("Please choose an option to login");
				System.out.println("---------------------------");
				System.out.println("1. Login as Customer");
				System.out.println("2. Login as Employee");
				System.out.println("3. Exit");
				int option;
				try {
					option = scan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input, please enter valid option");
					continue;
				} finally {
					scan.nextLine();
				}

				switch (option) {
				case 1:

					System.out.println("---------------------------");
					System.out.println("Please enter email");
					String username = scan.nextLine();
					System.out.println("---------------------------");
					System.out.println("Please enter password");
					String password = scan.nextLine();
					Integer UserID = x.compareCustomerLogin(username, password);

					if (UserID != null) {
						System.out.println("Successfully logged in as customer");

					} else {
						System.out.println("Invalid Login");
						continue;
					}

					char customerContinue = 'y';
					while (customerContinue == 'y' || customerContinue == 'Y') {
						System.out.println("---------------------------");
						System.out.println("1. View account details");
						System.out.println("2. Transfer money");
						System.out.println("3. View transaction history");
						System.out.println("4. Logout");
						int option2;
						try {
							option2 = scan.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("Invalid input, please enter valid option");
							continue;
						} finally {
							scan.nextLine();
						}

						switch (option2) {
						case 1:
							// need to draw from database to view account details

							AccountPojo accountPojo = accountService.viewAccount(UserID);
							System.out.println("Present account details for: ");
							System.out.println(username);
							
							System.out.println("ACCOUNT BALANCE  " + accountPojo.getAccountBalance());
							System.out.println("ID NUMBER  " + accountPojo.getAccountId());
							

							break;
						case 2:

							char transactionMenu = 'y';
							while (transactionMenu == 'y' || transactionMenu == 'Y') {

								System.out.println("1. Deposit");

								System.out.println("2. Withdraw");

								System.out.println("3. Send money to another account");

								System.out.println("4. Log out");

								int option3;
								try {
									option3 = scan.nextInt();
								} catch (InputMismatchException e) {
									System.out.println("Invalid input, please enter valid option");
									continue;
								} finally {
									scan.nextLine();
								}
								switch (option3) {
								case 1:
									System.out.println("Please enter the amount you would like to deposit");
									int depositCash;
									try {
										depositCash = scan.nextInt();
									} catch (InputMismatchException e) {
										System.out.println("Invalid input, please try again later");
										continue;
									} finally {
										scan.nextLine();
									}

									z.depositCash(depositCash, UserID);
									break;
								case 2:
									System.out.println("Please enter the amount you would like to withdraw");
									int withdrawCash;
									try {
										withdrawCash = scan.nextInt();
									} catch (InputMismatchException e) {
										System.out.println("Invalid input, please try again later");
										continue;
									} finally {
										scan.nextLine();
									}

									z.withdrawCash(withdrawCash, UserID);
									break;
								case 3:
									System.out.println(
											"Please enter the ID of the account you would like to send money to");
									int otherID;
									try {
										otherID = scan.nextInt();
									} catch (InputMismatchException e) {
										System.out.println("Invalid input, please try again later");
										continue;
									} finally {
										scan.nextLine();
									}

									System.out.println("Enter the amount you would like to send to receipient");

									int transferAmount;
									try {
										transferAmount = scan.nextInt();
									} catch (InputMismatchException e) {
										System.out.println("Invalid input, please try again later");
										continue;
									} finally {
										scan.nextLine();
									}
									z.transferMoney(transferAmount, UserID, otherID);
									System.out.println("Money sent successfully!");
									break;
								case 4:
									System.out.println("================================================");
									System.out.println("Thank you for choosing Southwest Banking!");
									System.out.println("================================================");
									System.exit(0);

								default:
									System.out.println("Please enter a valid option");
								}
								System.out.println("=========================================");
								System.out.println("Do you want to continue y/n?");
								transactionMenu = scan.next().charAt(0);
								if (transactionMenu == 'n' || transactionMenu == 'N') {
									System.out.println("================================================");
									System.out.println("Thank you for choosing Southwest Banking");
									System.out.println("================================================");
									System.exit(0);
								}
								if (transactionMenu != 'y' || transactionMenu != 'n') {
									while (transactionMenu != 'y') {
										System.out.println("Please enter a valid response");

										transactionMenu = scan.next().charAt(0);
										if (transactionMenu == 'n') {
											System.exit(0);
										}

									}
								}

							}
							break;
						case 3:
							System.out.println("Viewing transaction history");

							List<TransactionPojo> transactionDetails = z.viewTransactions(UserID);
							System.out.println(
									"=========================================================================");
							System.out.printf("%10s | %20s | %14s | %10s\n", "DATE", "Transaction Type",
									"Changed Amount", "ID Number");
							for (int i = 0; i < transactionDetails.size(); i++) {
								TransactionPojo tPojo = transactionDetails.get(i);
								System.out.printf("%10s | %20s | %14s | %10s\n", tPojo.getDate(),
										tPojo.getTransactionType(), tPojo.getChangedAmount(), tPojo.getId_number());
								System.out.println(
										"-------------------------------------------------------------------------");
							}
							System.out.println(
									"=========================================================================");
							break;
						case 4:
							System.out.println("---------------------------");
							System.out.println("Thank you for choosing Southwest Banking!");
							System.out.println("---------------------------");
							System.exit(0);
							break;
						default:
							System.out.println("Please enter a valid option");

						}
						System.out.println("=========================================");
						System.out.println("Do you want to continue y/n?");
						customerContinue = scan.next().charAt(0);
						if (customerContinue == 'n' || customerContinue == 'N') {
							System.out.println("================================================");
							System.out.println("Thank you for choosing Southwest Banking");
							System.out.println("================================================");
							System.exit(0);
						}
						if (customerContinue != 'y' || customerContinue != 'n') {
							while (customerContinue != 'y') {
								System.out.println("Please enter a valid response");
								customerContinue = scan.next().charAt(0);
								if(customerContinue == 'n') {
									System.out.println("================================================");
									System.out.println("Thank you for choosing Southwest Banking");
									System.out.println("================================================");
									System.exit(0);
								}

							}

						}

					}

					break;
				case 2:
					System.out.println("---------------------------");
					System.out.println("Please enter email");
					username = scan.nextLine();
					System.out.println("---------------------------");
					System.out.println("Please enter password");
					password = scan.nextLine();
					Integer EmployeeID = x.compareEmployeeLogin(username, password);
					if (EmployeeID != null) {
						System.out.println("Successfully logged in as employee");
					} else {
						System.out.println("Invalid Login");
						continue;
					}
					char employeeContinue = 'y';
					while (employeeContinue == 'y' || employeeContinue == 'Y') {
						System.out.println("---------------------------");
						System.out.println("1.Register/Create a customer");
						// need to create new account pojo off constructors from other class

						System.out.println("2. List all customers");
						// need to draw from database
						System.out.println("3. Logout");
						int option4;
						try {
							option4 = scan.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("Invalid input, please enter valid option");
							continue;
						} finally {
							scan.nextLine();
						}

						switch (option4) {
						case 1:
							// need to draw from database to view account details
							System.out.println("---------------------------");
							System.out.println("Please enter the email of the customer you would like to register");
							String email = scan.nextLine();
							System.out
									.println("Please enter the first name of the customer you would like to register");
							String firstName = scan.nextLine();
							System.out.println("Please enter the last name of the customer you would like to register");
							String lastName = scan.nextLine();

							System.out.println("Please enter the password of the customer you would like to register");
							String passwordres = scan.nextLine();

							LoginPojo newloginpojo = new LoginPojo();
							newloginpojo.setUserEmail(email);
							newloginpojo.setFirstName(firstName);
							newloginpojo.setLastName(lastName);
							newloginpojo.setPassword(passwordres);

							LoginPojo loginPojoWithId;
							loginPojoWithId = loginService.createAccount(newloginpojo);
							System.out.println("---------------------------");
							System.out.println(
									"New Account with " + loginPojoWithId.getAccountId() + " has been created!! ");
							System.out.println("---------------------------");
							break;
						case 2:

							System.out.println("================================================");
							System.out.println("ID NUMBER\tACCOUNT BALANCE");
							System.out.println("================================================");
							List<AccountPojo> fetchedAllAccounts;
							fetchedAllAccounts = accountService.listAllAccounts();
							for (int i = 0; i < fetchedAllAccounts.size(); i++) {

								System.out.println(fetchedAllAccounts.get(i).getAccountId() + "\t\t"

										+ fetchedAllAccounts.get(i).getAccountBalance());
							}
							System.out.println("================================================");
							break;

						case 3:
							System.out.println("================================================");
							System.out.println("Thank you for choosing Southwest Banking!");
							System.out.println("================================================");
							System.exit(0);
							break;
						default:
							System.out.println("Please enter a valid option");

						}
						System.out.println("================================================");
						System.out.println("Do you want to continue y/n?");
						employeeContinue = scan.next().charAt(0);
						if (employeeContinue == 'n' || employeeContinue == 'N') {
							System.out.println("================================================");
							System.out.println("Thank you for choosing Southwest Banking");
							System.out.println("================================================");
							System.exit(0);
						}
						if (employeeContinue != 'y' || employeeContinue != 'n') {
							while (employeeContinue != 'y') {
								System.out.println("Please enter a valid response");

								employeeContinue = scan.next().charAt(0);
								if (employeeContinue == 'n') {
									System.out.println("================================================");
									System.out.println("Thank you for choosing Southwest Banking");
									System.out.println("================================================");
									System.exit(0);
								}

							}
						}
					}
					break;

				case 3:
					System.out.println("================================================");
					System.out.println("Thank you for choosing Southwest Banking!");
					System.out.println("================================================");
					System.exit(0);
					break;
				default:
					System.out.println("Please enter a valid option");
				}
				System.out.println("=========================================");

			}
		}
	}
}

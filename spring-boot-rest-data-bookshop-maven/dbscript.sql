CREATE DATABASE bookshop;

\c bookshop;

CREATE TABLE customer_accounts (accountID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, email VARCHAR(50) NOT NULL UNIQUE, password VARCHAR(30), firstname VARCHAR(30) NOT NULL, lastname VARCHAR(30)NOT NULL);

CREATE TABLE book (bookId INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, bookTitle VARCHAR(100) UNIQUE, bookAuthor VARCHAR(100), cost INT NOT NULL UNIQUE, bookImageUrl VARCHAR(255));

CREATE TABLE current_cart (accountID INT, cost INT NOT NULL UNIQUE, quantity INT NOT NULL, bookTitle VARCHAR(100) UNIQUE, bookId INT NOT NULL, CONSTRAINT fk_customer FOREIGN KEY(accountID) REFERENCES customer_accounts(accountID), CONSTRAINT fk_bookid FOREIGN KEY(bookId) REFERENCES book(bookId));

CREATE TABLE transactionhistory (orderNo INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, accountID INT, book VARCHAR(100), bookId INT NOT NULL, cost INT NOT NULL, quantity INT NOT NULL, CONSTRAINT fk_customer FOREIGN KEY(accountID) REFERENCES customer_accounts(accountID));



INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Catcher in The Rye', 'J.D Salinger', 35, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Unchangeable Spots of Leopards', 'Kristopher Jansma', 25, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Sun Also Rises', 'Ernest Hemingway', 40, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Stand', 'Stephen King', 20, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Screwtape Letters', 'C.S Lewis', 30, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Alchemist', 'Paulo Coelho', 28, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('Raise High The Roofbeams Carpenter' , 'J.D Salinger', 23, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('IT', 'Stephen King' , 33, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Old Man and The Sea', 'Ernest Hemingway', 27, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES  ('Into The Wild' , 'Jon Krakauer' , 36 , '');

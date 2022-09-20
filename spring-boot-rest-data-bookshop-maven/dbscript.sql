CREATE DATABASE bookshop;

\c bookshop;

CREATE TABLE customer_accounts (accountID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, email VARCHAR(50) NOT NULL UNIQUE, password VARCHAR(30), firstname VARCHAR(30) NOT NULL, lastname VARCHAR(30)NOT NULL);

CREATE TABLE current_cart (accountID INT NOT NULL, cost INT NOT NULL, quantity INT NOT NULL, totalcost INT NOT NULL, book VARCHAR(30), CONSTRAINT fk_customer FOREIGN KEY(accountID) REFERENCES customer_accounts(accountID));

CREATE TABLE transactionhistory (orderNo INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, accountID INT NOT NULL, date DATE, book VARCHAR(100), cost INT NOT NULL, quantity INT NOT NULL, CONSTRAINT fk_customer FOREIGN KEY(accountID) REFERENCES customer_accounts(accountID));

CREATE TABLE book (bookId INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, bookTitle VARCHAR(100), bookAuthor VARCHAR(100), cost INT NOT NULL, bookImageUrl VARCHAR(255));

INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Catcher in The Rye', 'J.D Salinger', 35, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Unchangeable Spots of Leopards', 'Kristopher Jansma', 25, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Sun Also Rises', 'Ernest Hemingway', 30, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Stand', 'Stephen King', 20, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Screwtape Letters', 'C.S Lewis', 30, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Alchemist', 'Paulo Coelho', 20, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('Raise High The Roofbeams Carpenter' , 'J.D Salinger', 25, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('IT', 'Stephen King' , 35, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES ('The Old Man and The Sea', 'Ernest Hemingway', 27, '');
INSERT INTO book (bookTitle, bookAuthor, cost, bookImageUrl) VALUES  ('Into The Wild' , 'Jon Krakauer' , 33 , '');

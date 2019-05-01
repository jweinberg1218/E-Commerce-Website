DROP DATABASE IF EXISTS jasonsbookstore;
CREATE DATABASE jasonsbookstore;
USE jasonsbookstore;

CREATE TABLE books (
	id int auto_increment, 
	isbn char(14), 
	title varchar(50), 
	description varchar(200), 
	author varchar(50),  
	coverart varchar(50), 
	edition varchar(3),
	price real, 
	PRIMARY KEY(id)
);

CREATE TABLE users (
	id int auto_increment, 
	emailaddress varchar(50), 
	password varchar(30), 
	firstname varchar(30), 
	lastname varchar(30), 
	streetaddress varchar(50), 
	city varchar(30), 
	state char(2), 
	zipcode char(5), 
	PRIMARY KEY(id)
);

CREATE TABLE orders (
	id int auto_increment, 
	user_id int, 
	totalprice float, 
	dateOrdered timestamp, 
	PRIMARY KEY(id), 
	FOREIGN KEY(user_id) REFERENCES users(id)
);

CREATE TABLE orderitems (
	id int auto_increment, 
	order_id int, 
	book_id int, 
	qty int, 
	itemprice float, 
	totalprice float, 
	PRIMARY KEY(id), 
	FOREIGN KEY(order_id) REFERENCES orders(id), 
	FOREIGN KEY(book_id) REFERENCES books(id)
);

INSERT INTO books (isbn, title, description, author, coverart, edition, price) 
VALUES ('978-0486280615', 'Adventures of Huckleberry Finn', '', 'Mark Twain', 'adventures-of-huckleberry-finn.jpg', '1', 9.95);

INSERT INTO books (isbn, title, description, author, coverart, edition, price) 
VALUES ('978-0062073488', 'And Then There Were None', '', 'Agatha Christie', 'and-then-there-were-none.jpg', '1', 9.95);

INSERT INTO books (isbn, title, description, author, coverart, edition, price) 
VALUES ('978-0061124952', 'Charlottes Web', '', 'E. B. White', 'charlottes-web.jpg', '1', 9.95);

INSERT INTO books (isbn, title, description, author, coverart, edition, price) 
VALUES ('978-1451635621', 'Gone with the Wind', '', 'Margaret Mitchell', 'gone-with-the-wind.jpg', '1', 9.95);

INSERT INTO books (isbn, title, description, author, coverart, edition, price) 
VALUES ('978-0316769174', 'The Catcher in the Rye', '', 'J. D. Salinger', 'the-catcher-in-the-rye.jpg', '1', 9.95);

INSERT INTO books (isbn, title, description, author, coverart, edition, price) 
VALUES ('978-0743273565', 'The Great Gatsby', '', 'F. Scott Fitzgerald', 'the-great-gatsby.jpg', '1', 9.95);

INSERT INTO books (isbn, title, description, author, coverart, edition, price) 
VALUES ('978-0547928227', 'The Hobbit', '', 'J.R.R. Tolkien', 'the-hobbit.jpg', '1', 9.95);

INSERT INTO books (isbn, title, description, author, coverart, edition, price) 
VALUES ('978-0439023481', 'The Hunger Games', '', 'Suzanne Collins', 'the-hunger-games.jpg', '1', 9.95);

INSERT INTO books (isbn, title, description, author, coverart, edition, price) 
VALUES ('978-0544003415', 'The Lord of the Rings', '', 'J.R.R. Tolkien', 'the-lord-of-the-rings.jpg', '1', 9.95);

INSERT INTO books (isbn, title, description, author, coverart, edition, price) 
VALUES ('978-0099549482', 'To Kill a Mockingbird', '', 'Harper Lee', 'to-kill-a-mockingbird.jpg', '1', 9.95);

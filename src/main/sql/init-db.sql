DROP DATABASE IF EXISTS jasonsbookstore;
CREATE DATABASE jasonsbookstore;
USE jasonsbookstore;

CREATE TABLE books (
	id int auto_increment, 
	isbn char(13), 
	title varchar(50), 
	description varchar(200), 
	authorfname varchar(30), 
	authorlname varchar(30), 
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

INSERT INTO books (isbn, title, coverart, price) 
VALUES ('0000000000001', 'Adventures of Huckleberry Finn', 'adventures-of-huckleberry-finn.jpg', 9.95);

INSERT INTO books (isbn, title, coverart, price) 
VALUES ('0000000000002', 'And Then There Were None', 'and-then-there-were-none.jpg', 9.95);

INSERT INTO books (isbn, title, coverart, price) 
VALUES ('0000000000003', 'Charlottes Web', 'charlottes-web.jpg', 9.95);

INSERT INTO books (isbn, title, coverart, price) 
VALUES ('0000000000004', 'Gone with the Wind', 'gone-with-the-wind.jpg', 9.95);

INSERT INTO books (isbn, title, coverart, price) 
VALUES ('0000000000005', 'The Catcher in the Rye', 'the-catcher-in-the-rye.jpg', 9.95);

INSERT INTO books (isbn, title, coverart, price) 
VALUES ('0000000000006', 'The Great Gatsby', 'the-great-gatsby.jpg', 9.95);

INSERT INTO books (isbn, title, coverart, price) 
VALUES ('0000000000007', 'The Hobbit', 'the-hobbit.jpg', 9.95);

INSERT INTO books (isbn, title, coverart, price) 
VALUES ('0000000000008', 'The Hunger Games', 'the-hunger-games.jpg', 9.95);

INSERT INTO books (isbn, title, coverart, price) 
VALUES ('0000000000009', 'The Lord of the Rings', 'the-lord-of-the-rings.jpg', 9.95);

INSERT INTO books (isbn, title, coverart, price) 
VALUES ('0000000000010', 'To Kill a Mockingbird', 'to-kill-a-mockingbird.jpg', 9.95);

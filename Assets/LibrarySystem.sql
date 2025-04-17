CREATE DATABASE LibrarySystem;
USE LibrarySystem;

CREATE TABLE student (
	studentID VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    course VARCHAR(50) NOT NULL,
    DOB DATE NOT NULL,
    address VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    contactNo VARCHAR(10) NOT NULL
);

CREATE TABLE books (
	bookID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    yearPublished DATE,
    isbn VARCHAR(20),
    category VARCHAR(100),
    price DECIMAL(10, 2),
    stockQuantity INT NOT NULL
);

CREATE TABLE issuedBooks (
	issuedID INT AUTO_INCREMENT PRIMARY KEY,
    bookID INT NOT NULL,
    studentID VARCHAR(10) NOT NULL,
    issuedDate DATE NOT NULL,
    dueDate DATE NOT NULL,
    returnedDate DATE,  
    returnState VARCHAR(20) NOT NULL DEFAULT 'Not Returned',
    FOREIGN KEY (bookID) REFERENCES books(bookID) ON UPDATE CASCADE,
    FOREIGN KEY (studentID) REFERENCES student(studentID) ON UPDATE CASCADE
);

DELIMITER $$
	CREATE TRIGGER afterBookIssued
    AFTER INSERT ON issuedBooks
    FOR EACH ROW
    BEGIN
     UPDATE books
     SET stockQuantity = stockQuantity - 1
     WHERE bookID = NEW.bookID;
	END $$
DELIMITER ;

CREATE TABLE returnedBooks (
    returnID INT AUTO_INCREMENT PRIMARY KEY,
    issuedID INT NOT NULL,                
    studentID VARCHAR(10) NOT NULL,       
    bookID INT NOT NULL,                 
    returnedDate DATE NOT NULL,           
    fineAmount DECIMAL(10, 2) DEFAULT 0, 
    remarks VARCHAR(255),                 -- Optional notes (e.g. "book damaged", "late return")
    
    FOREIGN KEY (issuedID) REFERENCES issuedBooks(issuedID),
    FOREIGN KEY (studentID) REFERENCES student(studentID),
    FOREIGN KEY (bookID) REFERENCES books(bookID)
);

DELIMITER $$
	CREATE TRIGGER afterBookReturned
    AFTER INSERT ON returnedBooks
    FOR EACH ROW
    BEGIN
     UPDATE books
     SET stockQuantity = stockQuantity + 1
     WHERE bookID = NEW.bookID;
     
     UPDATE issuedBooks
     SET returnState = "Returned", returnedDate = NEW.returnedDate
     WHERE issuedID = NEW.issuedID;
	END $$ 
DELIMITER ; 

-- for view both book and issuedBook data
CREATE VIEW booksIssued AS
SELECT
    b.bookID, b.title, b.author, b.stockQuantity, b.yearPublished, b.category,
    ib.issuedID, ib.studentID, ib.issuedDate, ib.dueDate, ib.returnedDate, ib.returnState,
    s.name
FROM books b
JOIN issuedBooks ib ON b.bookID = ib.bookID
JOIN student s ON s.studentID = ib.studentID;

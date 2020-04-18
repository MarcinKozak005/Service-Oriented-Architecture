CREATE DATABASE books;

CREATE TABLE books_table
(
    author_surname VARCHAR(30) NOT NULL,
    author_name VARCHAR(30) NOT NULL,
    book_title VARCHAR(30) NOT NULL,
    isbn_number CHAR(13) NOT NULL, -- leading zeros
    date_of_issue DATE NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    id INT NOT NULL PRIMARY KEY
);

INSERT INTO books_table VALUES ('Rowling', 'J.K','Harry Potter 1' ,'1243623443411', '1997-01-01', 40, 1);
INSERT INTO books_table VALUES ('Rowling', 'J.K','Harry Potter 2' ,'6234625245124', '1998-02-02', 80, 2);
INSERT INTO books_table VALUES ('Rowling', 'J.K','Harry Potter 3' ,'2513251341342', '1999-03-03', 120, 3);
INSERT INTO books_table VALUES ('Rowling', 'J.K','Harry Potter 4' ,'1361464513277', '2000-04-04', 160, 4);
INSERT INTO books_table VALUES ('Rowling', 'J.K','Harry Potter 5' ,'8787024527412', '2003-05-05', 200, 5);
INSERT INTO books_table VALUES ('Rowling', 'J.K','Harry Potter 6' ,'8357384641281', '2005-06-06', 240, 6);
INSERT INTO books_table VALUES ('Rowling', 'J.K','Harry Potter 7' ,'7631767839317', '2007-07-07', 280, 7);
INSERT INTO books_table VALUES ('Rowling', 'J.K','Harry Potter: Cursed Child','1234567890123', '2016-12-12', 320, 8);
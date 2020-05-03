-- SETTING THE DATABASE UP
BEGIN;
    -- reader
    INSERT INTO library.public.reader (reader_id, deleted, reader_name, reader_surname) VALUES
    (1,false,'Adam','A'),
    (2,false,'Bob','B'),
    (3,false,'Charles','C');
    -- category
    INSERT INTO library.public.category (category_id, category_name, deleted) VALUES
    (1,'Science Fiction',false),
    (2,'Documentary',false),
    (3,'Fantasy',false);
    -- author
    INSERT INTO library.public.author (author_id, author_name, author_surname, deleted) VALUES
    (1,'Xavier','X',false),
    (2,'Yasmin','Y',false),
    (3,'Zoe','Z',false);
    -- book
    INSERT INTO library.public.book (book_id, book_title, deleted, isbn, book_author_author_id, book_category_category_id) VALUES
    (1,'Book1',false,'01231231230',1,3),
    (2,'Book2',false,'58918151322',1,1),
    (3,'Book3',false,'04811621206',2,1),
    (4,'Book4',false,'84121987912',3,2),
    (5,'Book5',false,'36522458966',1,2);
    -- specimen
    INSERT INTO library.public.specimen (specimen_id, free, deleted, specimen_book_book_id) VALUES
    (1,true,false,2),
    (2,true,false,1),
    (3,true,false,2),
    (4,true,false,2),
    (5,true,false,5),
    (6,true,false,5),
    (7,true,false,4),
    (8,true,false,3),
    (9,true,false,1),
    (10,true,false,1),
    (11,true,false,4),
    (12,true,false,3);
    -- loan
    INSERT INTO library.public.loan (loan_id, deleted, loan_reader_reader_id, loan_specimen_specimen_id, loan_end_date, loan_start_date) VALUES
    (1,false,1,1,'2010-03-02','2010-02-02'),
    (2,false,2,2,'2010-05-16','2010-04-22'),
    (3,false,3,5,'2010-08-22','2010-07-02'),
    (4,false,1,6,'2011-01-11','2010-12-02'),
    (5,false,2,3,'2011-03-02','2011-01-02'),
    (6,false,3,4,'2011-06-06','2011-05-05'),
    (7,false,1,12,'2011-07-31','2011-07-02'),
    (8,false,2,11,'2011-12-31','2011-12-02'),
    (9,false,3,9,'2012-03-07','2012-02-02'),
    (10,false,3,10,'2012-05-12','2012-04-02'),
    (11,false,2,5,'2012-07-11','2012-06-02'),
    (12,false,1,6,'2012-09-03','2012-08-02'),
    (13,false,2,7,'2013-12-20','2012-12-02'),
    (14,false,1,2,'2013-03-29','2013-02-02'),
    (15,false,3,4,'2013-03-05','2013-04-02'),
    (16,false,3,1,'2013-08-07','2013-07-02'),
    (17,false,2,6,null,'2013-07-02');
COMMIT;

-- setting appropriate number to start with
ALTER SEQUENCE library.public.hibernate_sequence RESTART WITH 20;
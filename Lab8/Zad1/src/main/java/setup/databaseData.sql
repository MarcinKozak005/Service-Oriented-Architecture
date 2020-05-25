-- \c soadb1;
-- DROP DATABASE moviesdb;
-- CREATE DATABASE moviesdb;
-- \c moviesdb;


BEGIN TRANSACTION;

INSERT INTO moviesdb.public.client (id,name,age,image) VALUES
(1,'Adam',25,'image1'),
(2,'Joe',32,'image2'),
(3,'Alex',45,'image3'),
(4,'Jenny',19,'image4'),
(5,'Tim',21,'image5');

INSERT INTO moviesdb.public.movie (id, uri, title) VALUES
(1,'localhost:8080/Zad1_war_exploded/api/movies/1','Movie1'),
(2,'localhost:8080/Zad1_war_exploded/api/movies/2','Movie2'),
(3,'localhost:8080/Zad1_war_exploded/api/movies/3','Movie3');

INSERT INTO moviesdb.public.client_movie (clientlist_id,movielist_id) VALUES
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(3,1);

ALTER SEQUENCE moviesdb.public.hibernate_sequence RESTART WITH 6;
COMMIT;
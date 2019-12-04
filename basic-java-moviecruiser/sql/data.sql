-- Include table data insertion, updation, deletion and select scripts
INSERT INTO moviecruiser.movie_item(mo_id,mo_title,mo_boxoffice,mo_active,mo_date_of_launch,mo_genre,mo_hasteaser)
VALUES(1,'Avatar',2787965087,true,'2017-03-15','Science Fiction',true),
(2,'The Avengers',1518812988,true,'2017-12-23','Superhero',false),
(3,'Titanic',2187463944,true,'2017-08-21','Romance',false),(4,'Jurassic World',1671713208,false,'2017-07-02','Science Fiction',true),
(5,'Avengers: End Game',2750760348,true,'2022-11-02','Superhero',true);


-- 1.	View Movie List Admin (MCUC001) 
SELECT 
    *
FROM
    movie_item;

-- 2.	View Movie List Customer (MCUC002)

SELECT 
    *
FROM
    movie_item
WHERE
    mo_active = 1
        AND mo_date_of_launch <= CURDATE();


-- 3.	Edit Movie (MCUC003)

SELECT 
    *
FROM
    movie_item
WHERE
    mo_id = 1;

UPDATE movie_item 
SET 
    mo_title = 'Balu',
    mo_boxoffice = '158.00',
    mo_genre = 'Science'
WHERE
    mo_id = '1';


SELECT 
    *
FROM
    movie_item;


SELECT 
    *
FROM
    user;

INSERT INTO user(us_id,us_name)values(1,'cts');
INSERT INTO user(us_id,us_name) values(2,'hgf');

-- 4.	Add to Favorites (MCUC004)
SELECT 
    *
FROM
    user;


INSERT INTO  favorites values(1,1,4);
INSERT INTO  favorites values(2,1,3);
INSERT INTO favorites values(3,1,2);

SELECT 
    *
FROM
    favorites;


-- 5.	View Favorites (MCUC005)

SELECT 
    *
FROM
    moviecruiser.movie_item
WHERE
    mo_id IN (SELECT 
            fvt_mov_id
        FROM
            moviecruiser.favorites
        WHERE
            fvt_us_id = 1);


SELECT 
    SUM(mo_boxoffice) AS 'TOTAL BOXOFFICE'
FROM
    moviecruiser.movie_item
WHERE
    mo_id IN (SELECT 
            fvt_mov_id
        FROM
            moviecruiser.favorites
        WHERE
            fvt_us_id = 1);

-- 6.	Remove Item from Favorites (MCUC005)
DELETE FROM moviecruiser.favorites 
WHERE
    fvt_us_id = 1 AND fvt_mov_id = 4;
SELECT 
    *
FROM
    favorites;


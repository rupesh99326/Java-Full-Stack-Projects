-- Include table data insertion, updation, deletion and select scripts
INSERT INTO truyum.menu_item(me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery)
VALUES(1,'Sandwich',99.00,true,'2017-03-15','Main Course',true),(2,'Burger',129.00,true,'2017-12-23','Main Course',false),(3,'Pizza',149.00,true,'2017-08-21','Main Course',false),(4,'French Fries',57.00,false,'2017-07-02','Starters',true),(5,'Chocolate Brownie',32.00,false,'2022-11-02','Dessert',false);


-- 1.	View Menu Item List Admin (TYUC001) 
SELECT 
    *
FROM
    truyum.menu_item;

-- 2.	View Menu Item List Customer (TYUC002)

SELECT * from menu_item where me_active=1 and me_date_of_launch<=curdate();

-- 3.	Edit Menu Item (TYUC003)

SELECT * FROM truyum.menu_item where 'me_id'='2';
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'balaji', '45', '1', '2017-12-03', 'Desserts', '1');


UPDATE `truyum`.`menu_item` SET `me_name`='Sand', `me_price`='999.00', `me_category`='Main' WHERE `me_id`='1';

-- 4.	Add to Cart (TYUC004)
select * from user;
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES (1, 'balu');
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES (2, 'rock');



INSERT INTO truyum.cart values(1,1,4);
INSERT INTO truyum.cart values(2,1,3);
INSERT INTO truyum.cart values(3,1,2);


-- 5.	View Cart (TYUC005)
select * from cart;

SELECT * from truyum.menu_item where me_id in(select ct_pr_id from truyum.cart where ct_us_id=1);

select SUM(me_price) as 'TOTAL PRICE' from truyum.menu_item where me_id in(select ct_pr_id from truyum.cart where ct_us_id=1);

-- 6.	Remove Item from Cart (TYUC006)

DELETE FROM truyum.cart where ct_us_id=1 AND ct_pr_id=4;

select * from cart;




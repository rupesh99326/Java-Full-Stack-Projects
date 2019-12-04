
-- VIEW MENU ITEM LIST ADMIN

INSERT INTO`truyum`.`menu_item`(`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_image`) VALUES('Sandwich', 99.00, true, '2017-03-15', 'Main Course', true,'https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1');
INSERT INTO`truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_image`) VALUES('Burger', 129.00, true, '2017-12-23','Main Course', false,'https://images.unsplash.com/photo-1512152272829-e3139592d56f?ixlib=rb-1.2.1');
INSERT INTO`truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_image`) VALUES('Pizza', 149.00, true, '2017-08-21','Main Course', false,'https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?ixlib=rb-1.2.1');
INSERT INTO`truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_image`) VALUES( 'French Fries', 57.00, false, '2017-07-02','Starters', true,'https://images.unsplash.com/photo-1526230427044-d092040d48dc?ixlib=rb-1.2.1');
INSERT INTO`truyum`.`menu_item`(`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_image`) VALUES('Chocolate Brownie', 32.00, true,'2022-11-02','Dessert', true,'https://images.unsplash.com/photo-1564355808539-22fda35bed7e?ixlib=rb-1.2.1');


SELECT `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`,`me_image` FROM menu_item;

desc menu_item;

-- VIEW MENU ITEM LIST CUSTOMER

SELECT `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery` FROM `truyum`.`menu_item` WHERE me_active='yes' AND me_date_of_launch<=CURDATE();



-- EDIT MENU ITEM

SELECT `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery` FROM `truyum`.`menu_item` WHERE me_id=4;
UPDATE `truyum`.`menu_item` SET `me_name`='French Fries', `me_price`='58', `me_active`='yes', `me_date_of_launch`='2017-07-03', `me_category`='Dessert', `me_free_delivery`='yes' WHERE `me_id`='4';


-- ADD TO CART

INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('1', 'preveen');
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('2', 'hari');

INSERT INTO `truyum`.`role` (`ro_id`, `ro_name`) VALUES ('1', 'USER');
INSERT INTO `truyum`.`role` (`ro_id`, `ro_name`) VALUES ('2', 'ADMIN');


INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_pr_id`) VALUES ('1', '2');
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_pr_id`) VALUES ('1', '3');
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_pr_id`) VALUES ('1', '4');

-- VIEW CART

SELECT `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery` FROM `truyum`.`menu_item` WHERE me_id in (SELECT ct_pr_id FROM `truyum`.`cart` WHERE ct_us_id=1);
SELECT SUM(me_price) as `Total Price` FROM `truyum`.`menu_item` WHERE me_id in (SELECT ct_pr_id FROM `truyum`.`cart` WHERE ct_us_id=1);

SELECT cart.*,menu_item.* FROM cart INNER JOIN menu_item ON cart.ct_pr_id=menu_item.me_id WHERE ct_us_id=1;
SELECT SUM(`menu_item`.`me_price`) FROM cart INNER JOIN menu_item ON cart.ct_pr_id=menu_item.me_id WHERE ct_us_id=1;
select * from cart;

-- REMOVE ITEM FROM CART

DELETE FROM `truyum`.`cart` WHERE ct_us_id=1 AND ct_pr_id=2;



select * from menu_item;
select * from user_role;
select * from role;
select * from user;
select * from cart;






-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema moviecruiser
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema moviecruiser
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moviecruiser` DEFAULT CHARACTER SET utf8 ;
USE `moviecruiser` ;

-- -----------------------------------------------------
-- Table `moviecruiser`.`movie_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`movie_item` (
  `mo_id` BIGINT(20) NOT NULL,
  `mo_title` VARCHAR(100) NULL DEFAULT NULL,
  `mo_boxoffice` BIGINT(20) NULL DEFAULT NULL,
  `mo_active` TINYINT(1) NULL DEFAULT NULL,
  `mo_date_of_launch` DATE NULL DEFAULT NULL,
  `mo_genre` VARCHAR(45) NULL DEFAULT NULL,
  `mo_hasteaser` TINYINT(1) NULL DEFAULT NULL,
  `mo_image` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`mo_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moviecruiser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_username` VARCHAR(60) NULL DEFAULT NULL,
  `us_firstname` VARCHAR(60) NULL DEFAULT NULL,
  `us_lastname` VARCHAR(60) NULL DEFAULT NULL,
  `us_password` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moviecruiser`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`favorites` (
  `fvt_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fvt_us_id` INT(11) NULL DEFAULT NULL,
  `fvt_mov_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`fvt_id`),
  INDEX `fvt_us_fk_idx` (`fvt_us_id` ASC),
  INDEX `fvt_mov_fk_idx` (`fvt_mov_id` ASC),
  CONSTRAINT `fvt_mov_fk`
    FOREIGN KEY (`fvt_mov_id`)
    REFERENCES `moviecruiser`.`movie_item` (`mo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fvt_us_fk`
    FOREIGN KEY (`fvt_us_id`)
    REFERENCES `moviecruiser`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moviecruiser`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`role` (
  `ro_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moviecruiser`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`user_role` (
  `ur_id` INT(11) NOT NULL,
  `ur_us_id` INT(11) NOT NULL,
  `ur_ro_id` INT(11) NOT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `fk_user_role_user_idx` (`ur_us_id` ASC),
  INDEX `fk_user_role_role1_idx` (`ur_ro_id` ASC),
  CONSTRAINT `fk_user_role_role1`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `moviecruiser`.`role` (`ro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_user`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `moviecruiser`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




select * from movie_item;

select * from user;
select * from role;
select * from user_role;



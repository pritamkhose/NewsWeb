SELECT * FROM NewsWeb.TOI;

DROP TABLE `NewsWeb`.`TOI` ;

CREATE TABLE `NewsWeb`.`TOI` (
  `id` DOUBLE NOT NULL AUTO_INCREMENT ,
  `articlelink` TEXT NULL,
  `heading1` VARCHAR(255) NULL,
  `image` TEXT NULL,
  `data` TEXT NULL,
  `cat` VARCHAR(255) NULL,
  `auth_detail` VARCHAR(255) NULL,
  `time_cptn` VARCHAR(255) NULL,
  `timestamp` DATETIME NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `NewsWeb`.`TOI` (
  `id` DOUBLE NOT NULL AUTO_INCREMENT ,
  `articlelink` TEXT NULL,
  `heading1` VARCHAR(255) NULL,
  `image` TEXT NULL,
  `data` TEXT NULL,
  `cat` VARCHAR(255) NULL,
  `auth_detail` VARCHAR(255) NULL,
  `time_date` datetime,
  `time_cptn` VARCHAR(255) NULL,
  `timestamp` DATETIME NOT NULL,
  PRIMARY KEY (`id`));
  
  
  
 DELETE FROM `NewsWeb`.`TOI` WHERE id > 0;
ALTER TABLE `NewsWeb`.`TOI` AUTO_INCREMENT = 1; 

INSERT INTO `NewsWeb`.`TOI` (`articlelink`, `heading1`, `image`, `data`, `cat`, `auth_detail`, `time_cptn`, `timestamp`) VALUES ('3', '54', '54', '54', '5555555554', '5', '5', CURRENT_TIMESTAMP);

UPDATE NewsWeb.TOI SET  cat = 'CITY-NOIDA',  auth_detail = 'Ayaskant Das',  time_cptn = '| TNN | Dec 13, 2017, 00:48 IST' where id = 34.0; 

INSERT INTO `NewsWeb`.`TOI` (`articlelink`, `heading1`, `image`, `data`, `cat`, `auth_detail`, `time_cptn`, `timestamp`) VALUES (?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP);

INSERT INTO `NewsWeb`.`TOI` (`articlelink`, `heading1`, `image`, `data`, `cat`, `auth_detail`, `time_cptn`, `timestamp`) VALUES 
('articlelink', 'heading1', 'image', 'data', 'cat', 'auth_detail', to_date('Dec 15, 2017, 07:18 IST','MMM dd, yyyy, HH:mm z'), CURRENT_TIMESTAMP);

INSERT INTO `NewsWeb`.`TOI` (`articlelink`, `heading1`, `image`, `data`, `cat`, `auth_detail`, `time_cptn`, `timestamp`) VALUES 
('articlelink565', 'heading1', 'image', 'data', 'cat', 'auth_detail', '', CURRENT_TIMESTAMP);


SELECT * FROM NewsWeb.TOI;


UPDATE NewsWeb.TOI SET  cat = '\'CITY-NOIDA' where id = 2.0; 
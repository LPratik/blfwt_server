
CREATE TABLE  `admin_user` (
  `id` INT NOT NULL auto_increment,
  `admin_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(13) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` TIMESTAMP NULL,
  `updated` timestamp NULL DEFAULT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE INDEX `admin_user_emailId_UNIQUE` (`email` ASC));

CREATE TABLE `members` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `address` varchar(256) NOT NULL,
  `occupation` varchar(45) NOT NULL,
  `mobile_no` int(10) unsigned NOT NULL,
  `birth_date` date NOT NULL,
  `age_on_date` int(3) unsigned NOT NULL,
  `gender` varchar(45) NOT NULL,
  `member_type` varchar(45) NOT NULL,
  `nationality` varchar(45) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `deleted` datetime NOT NULL,
  PRIMARY KEY  (`id`)
);

CREATE TABLE `admin_session` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `admin_id` INT NOT NULL,
  `session_id` VARCHAR(45) NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_access` TIMESTAMP NULL,
  `deleted` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `sessionId_UNIQUE` (`session_id` ASC),
  INDEX `FK_USER_SESSION_USERID_idx` (`admin_id` ASC),
  INDEX `idx_sessionId` (`session_id` ASC),
  CONSTRAINT `FK_USER_SESSION_USERID`
    FOREIGN KEY (`admin_id`)
    REFERENCES `admin_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
INSERT INTO admin_user (admin_name,email,password)
VALUES ('Pratik Ladkat','pratik@gmail.com','pass111111');
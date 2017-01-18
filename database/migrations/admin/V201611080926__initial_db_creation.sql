
CREATE TABLE  `admin_user` (
  `id` INT NOT NULL auto_increment,
  `admin_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(13) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` TIMESTAMP NULL,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE INDEX `admin_user_emailId_UNIQUE` (`email` ASC));

CREATE TABLE `members` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `muid` varchar(10) NOT NULL,
  `ref_muid` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(256) NOT NULL,
  `occupation` varchar(45) NOT NULL,
  `mobile_no` varchar(10)  NOT NULL,
  `aadhar_no` varchar(12) DEFAULT NULL,
  `pan_no` varchar(10) DEFAULT NULL,
  `birth_date` DATE NOT NULL,
  `age_on_date` int(3) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `member_type` varchar(45) NOT NULL,
  `nationality` varchar(45) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` TIMESTAMP NULL,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY  (`id`)
);

CREATE TABLE `admin_session` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `admin_id` INT NOT NULL,
  `session_id` VARCHAR(45) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `last_access` TIMESTAMP NULL,
  `deleted` TIMESTAMP NULL DEFAULT NULL,
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

CREATE TABLE `member_types` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `m_type` varchar(45) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  `deleted` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY  (`id`)
);

CREATE TABLE `member_transaction` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `muid` varchar(10) NOT NULL,
  `trans_date` TIMESTAMP NULL,
  `amount` varchar(45) NOT NULL,
  `trans_against` varchar(45) NOT NULL,
  `trans_type` varchar(45) NOT NULL,
  `reciept_no` varchar(10) NOT NULL,
  `is_Sms_Sent` TIMESTAMP NULL DEFAULT NULL,
  `is_Email_Sent` TIMESTAMP NULL DEFAULT NULL,
  `ledger_no` varchar(45) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  `deleted` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY  (`id`)
);

CREATE TABLE `transaction_types` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `t_type` varchar(45) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  `deleted` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY  (`id`)
);

CREATE TABLE `member_account` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `muid` varchar(10) NOT NULL,
  `ref_muid` varchar(10) NOT NULL,
  `available_balance` varchar(10) NOT NULL,
  `last_trans_id` int(10) NOT NULL,
  `start_date` TIMESTAMP NULL,
  `isShare` int(10) DEFAULT NULL,
  `isFD` int(10) DEFAULT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  `deleted` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY  (`id`)
);

CREATE TABLE `share_holders` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `muid` varchar(10) NOT NULL,
  `start_date` TIMESTAMP NULL,
  `amount` varchar(45) NOT NULL,
  `shares_from` varchar(45) NOT NULL,
  `shares_to` varchar(45) NOT NULL,
  `shares_quantity` varchar(45) NOT NULL,
  `is_Initial` int(10) DEFAULT NULL,
  `dividend` varchar(45) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  `deleted` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY  (`id`)
);


CREATE TABLE `dividend_rates` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `div_rate` varchar(45) NOT NULL,
  `declared_on` TIMESTAMP NULL,
  `effective_till` TIMESTAMP NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  `deleted` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY  (`id`)
);


CREATE TABLE `fixed_deposites` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `muid` varchar(10) NOT NULL,
  `amount` varchar(45) NOT NULL,
  `start_date` TIMESTAMP NULL DEFAULT NULL,
  `maturity_date` TIMESTAMP NULL DEFAULT NULL,
  `interest_rate` double(4,4) DEFAULT NULL,
  `reciept_no` bigint(10) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  `deleted` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY  (`id`)
);

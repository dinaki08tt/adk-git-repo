--<ScriptOptions statementTerminator=";"/>

CREATE TABLE person (
	id int,	
	name VARCHAR(30) NOT NULL,
	age INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

drop table person;

select person0_.id as id0_0_, person0_.name as name0_0_, person0_.age as age0_0_ from tempdb.person person0_ where person0_.id=1



drop TABLE profile;

CREATE TABLE profile (
	name VARCHAR(30),
	age INT,
	phoneNo INT,
	PRIMARY KEY (name)
) ENGINE=InnoDB;
show tables;

drop table `player_details`;

CREATE TABLE `Player_details` (
                `Player_id` int NOT NULL AUTO_INCREMENT,
                `Player_Name` varchar(30) NOT NULL,
                `Father_name` varchar(30) NOT NULL,
                `mother_name` varchar(30) NOT NULL,
                `Occupation` varchar(30) NOT NULL,
                `DOB` DATE NOT NULL,
                `Date_Of_Joining` DATE NOT NULL,
                `Mobile_number` varchar(15) NOT NULL,
                `Address` varchar(100) NOT NULL,
                `Age` int(2) NOT NULL,
                `is_parent_player` TINYINT NOT NULL,
                `is_parent_willing_to_learn` TINYINT NOT NULL,
                `is_parent_refere` TINYINT NOT NULL,
                PRIMARY KEY (`Player_id`)
);

CREATE TABLE `Player_score_details` (
                `row_id` int NOT NULL AUTO_INCREMENT,
                `player_id` int  NOT NULL,
                `Match_id` INT NOT NULL,
                `Match_date` DATE NOT NULL,
                `Score` INT NOT NULL,
                `Bonus` INT NOT NULL,
                `Total_Score` INT NOT NULL,
                PRIMARY KEY (`row_id`)
);

CREATE TABLE `Match_Score_details` (
                `Match_id` int NOT NULL AUTO_INCREMENT,
                `Match_date` DATE NOT NULL,
                `Player1_id` INT NOT NULL,
                `Player2_id` INT NOT NULL,
                `Result_1` varchar(100) NOT NULL,
                PRIMARY KEY (`Match_id`)
);

ALTER TABLE `Player_score_details` ADD CONSTRAINT `Player_score_details_fk0` FOREIGN KEY (`player_id`) REFERENCES `Player_details`(`Player_id`);
ALTER TABLE `Player_score_details` DROP FOREIGN KEY `Player_score_details_fk0`
ALTER TABLE `Player_score_details` ADD CONSTRAINT `Player_score_details_fk1` FOREIGN KEY (`Match_id`) REFERENCES `Match_Score_details`(`Match_id`);
ALTER TABLE `Player_score_details` DROP FOREIGN KEY `Player_score_details_fk1`




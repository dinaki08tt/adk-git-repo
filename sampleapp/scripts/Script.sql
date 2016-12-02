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


CREATE TABLE `Group_Matches_details` (
				`Group_id` int NOT NULL AUTO_INCREMENT,
				`Group_Name` varchar(100),
				`Match_id` int NOT NULL,
                `Match_date` DATE NOT NULL,
                `Player1_id` INT NOT NULL,
                `Player2_id` INT NOT NULL,
                `Player1_Score` INT,
                `Player2_Score` INT,
                `Winner` varchar(100),
                PRIMARY KEY (`Group_id`)
);

drop table `game_score`

create table `game_score`(
	`group_id` int NOT NULL,
	`match_id` int NOT NULL AUTO_INCREMENT,
	`game_id` int,
	`player_1_id` int NOT NULL,
	`player_2_id` int NOT NULL,
	`player_1_score` int,
	`player_2_score` int,	
	 PRIMARY KEY (`match_id`)
);


ALTER TABLE `game_score` ADD CONSTRAINT `game_score_fk0` FOREIGN KEY (`player_1_id`) REFERENCES `Player_details`(`Player_id`);
ALTER TABLE `game_score` DROP FOREIGN KEY `game_score_fk0`;
ALTER TABLE `game_score` ADD CONSTRAINT `game_score_fk1` FOREIGN KEY (`player_2_id`) REFERENCES `Player_details`(`Player_id`);
ALTER TABLE `game_score` DROP FOREIGN KEY `game_score_fk1`;
ALTER TABLE `game_score` ADD CONSTRAINT `game_score_fk2` FOREIGN KEY (`group_id`) REFERENCES `Group_Matches_details`(`Group_id`);
ALTER TABLE `game_score` DROP FOREIGN KEY `game_score_fk2`;
CREATE TABLE `score_card` (
                `score_id` int NOT NULL AUTO_INCREMENT,
                `player_id` int  NOT NULL,
                `Match_id` INT NOT NULL,
                `Match_date` DATE NOT NULL,
                `Score` INT NOT NULL,
                `Bonus` INT NOT NULL,
                `Total_Score` INT NOT NULL,
                PRIMARY KEY (`score_id`)
);

ALTER TABLE `score_card` ADD CONSTRAINT `score_card_fk0` FOREIGN KEY (`player_id`) REFERENCES `Player_details`(`Player_id`);

ALTER TABLE `score_card` ADD CONSTRAINT `score_card_fk1` FOREIGN KEY (`Match_id`) REFERENCES `game_score`(`match_id`);
ALTER TABLE `score_card` DROP FOREIGN KEY `score_card_fk1`;



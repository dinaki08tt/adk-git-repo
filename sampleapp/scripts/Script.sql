--<ScriptOptions statementTerminator=";"/>

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

ALTER TABLE `Player_details` ADD `player_code` varchar(30)
ALTER TABLE `Player_details` ADD CONSTRAINT uc_player_code UNIQUE (`player_code`)
ALTER TABLE `Player_details` MODIFY `player_code` varchar(30) NOT NULL;



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

ALTER TABLE `Group_Matches_details` ADD `tournament_id` int NOT NULL;
ALTER TABLE `Group_Matches_details` ADD CONSTRAINT `group_match_tour_fk0` FOREIGN KEY (`tournament_id`) REFERENCES `Tournament`(`tour_id`);
ALTER TABLE `Group_Matches_details` DROP FOREIGN KEY `group_match_tour_fk0`;

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
ALTER TABLE `score_card` DROP FOREIGN KEY `score_card_fk0`;
ALTER TABLE `score_card` ADD CONSTRAINT `score_card_fk1` FOREIGN KEY (`Match_id`) REFERENCES `game_score`(`match_id`);
ALTER TABLE `score_card` DROP FOREIGN KEY `score_card_fk1`;


CREATE TABLE `Tournament` (
				`tour_id` int NOT NULL AUTO_INCREMENT,
				`tour_name` varchar(100),
				`venue` varchar(200),
				`organizer`varchar(100),
				PRIMARY KEY (`tour_id`)
);

ALTER TABLE `Tournament` ADD `category_id` int NOT NULL;

ALTER TABLE `Tournament` ADD CONSTRAINT `tour_category_fk0` FOREIGN KEY (`category_id`) REFERENCES `Category`(`category_id`);
ALTER TABLE `Tournament` DROP FOREIGN KEY `tour_category_fk0`;

CREATE TABLE `Category` (
				`category_id` int NOT NULL AUTO_INCREMENT,
				`category_name` varchar(100),
				PRIMARY KEY (`category_id`)
);

TRUNCATE TABLE `Tournament`;

TRUNCATE TABLE `Player_details`;

TRUNCATE TABLE `Group_Matches_details`;

TRUNCATE TABLE `game_score`;

TRUNCATE TABLE `score_card`;


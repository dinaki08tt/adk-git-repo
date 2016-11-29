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


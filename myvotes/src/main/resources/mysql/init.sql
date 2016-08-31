CREATE TABLE t_candidate (
	id INT PRIMARY KEY auto_increment,
	NAME VARCHAR (20),
	imagePath VARCHAR(200),
	votes INT,
	version     INT,
	createDate  DATETIME,
	lastUpdate  DATETIME,
	lastUpdator VARCHAR(20)
);



CREATE TABLE t_vote_record (
	id INT PRIMARY KEY auto_increment,
	mobile VARCHAR (20),
	lastVoteDate date,
	ip VARCHAR (20),
	UNIQUE KEY m_d (mobile, lastVoteDate)
);

CREATE TABLE t_user (
	id       INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20),
	password VARCHAR(50),
	role     VARCHAR(20),
	UNIQUE KEY un(username)
);
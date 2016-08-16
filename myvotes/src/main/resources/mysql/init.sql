CREATE TABLE t_candidate (
	id INT PRIMARY KEY auto_increment,
	NAME VARCHAR (20),
	votes INT,
	version INT
);



CREATE TABLE t_vote_record (
	id INT PRIMARY KEY auto_increment,
	mobile VARCHAR (20),
	lastVoteDate date,
	ip VARCHAR (20),
	UNIQUE KEY m_d (mobile, lastVoteDate)
);
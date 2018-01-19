DROP TABLE MEMBER cascade constraint;

DROP SEQUENCE member_code_seq;

CREATE SEQUENCE member_code_seq;

ALTER SEQUENCE member_code_seq nocache;

CREATE TABLE member(
	member_code NUMBER(3) PRIMARY KEY,
	id 			VARCHAR(50) NOT NULL UNIQUE,
	pwd		 	VARCHAR(50) NOT NULL,
	name 		VARCHAR(20) NOT NULL,
	email 		VARCHAR(50) NOT NULL
);
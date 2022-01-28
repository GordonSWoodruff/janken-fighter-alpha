CREATE DATABASE janken_fighter_alpha;
USE janken_fighter_alpha;
CREATE TABLE users(
uid int NOT NULL AUTO_INCREMENT,
user_id varchar(200),
email varchar(200),
user_password varchar(200),
PRIMARY KEY(uid),
UNIQUE KEY (user_id)
);
ALTER TABLE users
	AUTO_INCREMENT = 1001;
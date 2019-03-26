CREATE TABLE contact (
	identifier BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	first_name varchar(100) NOT NULL,
	last_name varchar(100) NOT NULL,
	phone_number varchar(15) NOT NULL
);
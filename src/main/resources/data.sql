CREATE TABLE test.`USER` (
 uuid VARCHAR(36) NOT NULL PRIMARY KEY ,
 first_name varchar(50) NULL,
 last_name varchar(50) NULL,
 email varchar(255) NULL,
 password varchar(250) NULL,
 created_data_date TIMESTAMP NULL,
 updated_data_date TIMESTAMP NULL,
 last_login TIMESTAMP NULL,
 token varchar(100) NULL,
 status BINARY(1) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE test.PHONE (
    id_phone INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    uuid VARCHAR(36),
    phone_number INTEGER NULL,
    city_code varchar(8) NULL,
    country_code varchar(10) NULL,
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

DROP DATABASE IF EXISTS BilProjekt;

CREATE DATABASE BilProjekt;

USE BilProjekt;

CREATE TABLE cars (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      brand VARCHAR(100) NOT NULL,
                      age INT NOT NULL,
                      type VARCHAR(100) NOT NULL,
                      colour VARCHAR(50) NOT NULL,
                      licenseplate VARCHAR(50) NOT NULL,
                      img VARCHAR(255)
)

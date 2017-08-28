DROP DATABASE IF EXISTS SHVD_TEST;

CREATE DATABASE SHVD_TEST;
USE SHVD_TEST;

-- Super Hero Villain Database (SHVD_TEST) Table Creation --
CREATE TABLE SHVD_TEST.SuperSomeone
(SuperSomeoneID INT NOT NULL AUTO_INCREMENT, 
SuperSomeoneType VARCHAR(15) NOT NULL,  
SuperSomeoneName VARCHAR(45) NOT NULL, 
SuperSomeoneAlias VARCHAR(45) NOT NULL, 
SuperSomeoneDescription VARCHAR(200) NOT NULL, 
PRIMARY KEY(SuperSomeoneID), 
INDEX SuperSomeoneName(SuperSomeoneName));

CREATE TABLE SHVD_TEST.SuperPower
(SuperPowerID INT NOT NULL AUTO_INCREMENT, 
SuperPowerName VARCHAR(45) NOT NULL,  
SuperPowerDescription VARCHAR(65) NOT NULL, 
PRIMARY KEY(SuperPowerID), 
INDEX SuperPowerName(SuperPowerName));

CREATE TABLE SHVD_TEST.SuperSomeoneSuperPower
(SuperPowerID INT NOT NULL,  
SuperSomeoneID INT NOT NULL); 

CREATE TABLE SHVD_TEST.Location
(LocationID INT NOT NULL AUTO_INCREMENT, 
LocationName VARCHAR(45) NOT NULL, 
LocationDescription VARCHAR(60) NOT NULL,
LocationStreet VARCHAR(45) NULL,
LocationCity VARCHAR(45) NULL,
LocationState VARCHAR(45) NULL,
LocationCountry VARCHAR(45) NULL,
LocationLatitude DECIMAL(9,6) NULL,
LocationLongitude DECIMAL(9,6) NULL,
PRIMARY KEY(LocationID), 
INDEX LocationName(LocationName));

CREATE TABLE SHVD_TEST.SuperSomeoneSightingData
(SuperSomeoneSightingDataID INT NOT NULL AUTO_INCREMENT, 
LocationID INT NOT NULL,
SuperSomeoneSightingDescription VARCHAR(50) NOT NULL,
SuperSomeoneSightingDate DATETIME NOT NULL,
PRIMARY KEY(SuperSomeoneSightingDataID));

CREATE TABLE SHVD_TEST.SuperSomeoneSighting
(SuperSomeoneID INT NOT NULL, 
SuperSomeoneSightingDataID INT NOT NULL);

CREATE TABLE SHVD_TEST.Organization
(OrganizationID INT NOT NULL AUTO_INCREMENT, 
OrganizationType VARCHAR(15)NOT NULL,
OrganizationName VARCHAR(45) NOT NULL, 
OrganizationDescription VARCHAR(65) NOT NULL,
OrganizationContact VARCHAR(45) NOT NULL,
PRIMARY KEY(OrganizationID), 
INDEX OrganizationName(OrganizationName));

CREATE TABLE SHVD_TEST.OrganizationLocation
(OrganizationID INT NOT NULL,
LocationID INT NOT NULL);

CREATE TABLE SHVD_TEST.Member
(SuperSomeoneID INT NOT NULL,
OrganizationID INT NOT NULL);

-- Super Hero Villain Database (SHVD_TEST) Foreign Key Creation --
ALTER TABLE SHVD_TEST.OrganizationLocation
ADD CONSTRAINT fk_OrganizationID_OrgLoc
FOREIGN KEY (OrganizationID) REFERENCES Organization(OrganizationID);

ALTER TABLE SHVD_TEST.OrganizationLocation
ADD CONSTRAINT fk_LocationID_OrgLoc
FOREIGN KEY (LocationID) REFERENCES Location(LocationID);

ALTER TABLE SHVD_TEST.SuperSomeoneSightingData
ADD CONSTRAINT fk_LocationID_SupSomeSighting
FOREIGN KEY (LocationID) REFERENCES Location(LocationID);

ALTER TABLE SHVD_TEST.SuperSomeoneSighting
ADD CONSTRAINT fk_SuperSomeoneID_SupSomeSighting
FOREIGN KEY (SuperSomeoneID) REFERENCES SuperSomeone(SuperSomeoneID);

ALTER TABLE SHVD_TEST.SuperSomeoneSighting
ADD CONSTRAINT fk_SuperSomeoneSightingDataID_SupSomeSighting
FOREIGN KEY (SuperSomeoneSightingDataID) REFERENCES SuperSomeoneSightingData(SuperSomeoneSightingDataID);

ALTER TABLE SHVD_TEST.SuperSomeoneSuperPower
ADD CONSTRAINT fk_SuperPowerID_SupSomeSupPower
FOREIGN KEY (SuperPowerID) REFERENCES SuperPower(SuperPowerID);

ALTER TABLE SHVD_TEST.SuperSomeoneSuperPower
ADD CONSTRAINT fk_SuperSomeoneID_SupSomeSupPower
FOREIGN KEY (SuperSomeoneID) REFERENCES SuperSomeone(SuperSomeoneID);

ALTER TABLE SHVD_TEST.Member
ADD CONSTRAINT fk_SuperSomeoneID_Member
FOREIGN KEY (SuperSomeoneID) REFERENCES SuperSomeone(SuperSomeoneID);

ALTER TABLE SHVD_TEST.Member
ADD CONSTRAINT fk_OrganizationID_Member
FOREIGN KEY (OrganizationID) REFERENCES Organization(OrganizationID);
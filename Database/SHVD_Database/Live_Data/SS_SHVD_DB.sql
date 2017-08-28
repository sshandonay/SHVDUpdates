-- DROP DATABASE IF EXISTS SHVD;

CREATE DATABASE SHVD;
USE SHVD;

-- Super Hero Villain Database (SHVD) Table Creation --
CREATE TABLE SHVD.SuperSomeone
(SuperSomeoneID INT NOT NULL AUTO_INCREMENT, 
SuperSomeoneType VARCHAR(15) NOT NULL,  
SuperSomeoneName VARCHAR(45) NOT NULL, 
SuperSomeoneAlias VARCHAR(45) NOT NULL, 
SuperSomeoneDescription VARCHAR(200) NOT NULL, 
PRIMARY KEY(SuperSomeoneID), 
INDEX SuperSomeoneName(SuperSomeoneName));

CREATE TABLE SHVD.SuperPower
(SuperPowerID INT NOT NULL AUTO_INCREMENT, 
SuperPowerName VARCHAR(45) NOT NULL,  
SuperPowerDescription VARCHAR(65) NOT NULL, 
PRIMARY KEY(SuperPowerID), 
INDEX SuperPowerName(SuperPowerName));

CREATE TABLE SHVD.SuperSomeoneSuperPower
(SuperPowerID INT NOT NULL,  
SuperSomeoneID INT NOT NULL); 

CREATE TABLE SHVD.Location
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

CREATE TABLE SHVD.SuperSomeoneSightingData
(SuperSomeoneSightingDataID INT NOT NULL AUTO_INCREMENT, 
LocationID INT NULL,
SuperSomeoneSightingDescription VARCHAR(50) NOT NULL,
SuperSomeoneSightingDate DATETIME NOT NULL,
PRIMARY KEY(SuperSomeoneSightingDataID));

CREATE TABLE SHVD.SuperSomeoneSighting
(SuperSomeoneID INT NOT NULL, 
SuperSomeoneSightingDataID INT NOT NULL);

CREATE TABLE SHVD.Organization
(OrganizationID INT NOT NULL AUTO_INCREMENT, 
OrganizationType VARCHAR(15)NOT NULL,
OrganizationName VARCHAR(45) NOT NULL, 
OrganizationDescription VARCHAR(65) NOT NULL,
OrganizationContact VARCHAR(45) NOT NULL,
PRIMARY KEY(OrganizationID), 
INDEX OrganizationName(OrganizationName));

CREATE TABLE SHVD.OrganizationLocation
(OrganizationID INT NOT NULL,
LocationID INT NULL);

CREATE TABLE SHVD.Member
(SuperSomeoneID INT NOT NULL,
OrganizationID INT NOT NULL);

-- Super Hero Villain Database (SHVD) Foreign Key Creation --
ALTER TABLE SHVD.OrganizationLocation
ADD CONSTRAINT fk_OrganizationID_OrgLoc
FOREIGN KEY (OrganizationID) REFERENCES Organization(OrganizationID) ON DELETE CASCADE;

ALTER TABLE SHVD.OrganizationLocation
ADD CONSTRAINT fk_LocationID_OrgLoc
FOREIGN KEY (LocationID) REFERENCES Location(LocationID) ON DELETE CASCADE;

ALTER TABLE SHVD.SuperSomeoneSightingData
ADD CONSTRAINT fk_LocationID_SupSomeSighting
FOREIGN KEY (LocationID) REFERENCES Location(LocationID) ON DELETE CASCADE;

ALTER TABLE SHVD.SuperSomeoneSighting
ADD CONSTRAINT fk_SuperSomeoneID_SupSomeSighting
FOREIGN KEY (SuperSomeoneID) REFERENCES SuperSomeone(SuperSomeoneID) ON DELETE CASCADE;

ALTER TABLE SHVD.SuperSomeoneSighting
ADD CONSTRAINT fk_SuperSomeoneSightingDataID_SupSomeSighting
FOREIGN KEY (SuperSomeoneSightingDataID) REFERENCES SuperSomeoneSightingData(SuperSomeoneSightingDataID) ON DELETE CASCADE;

ALTER TABLE SHVD.SuperSomeoneSuperPower
ADD CONSTRAINT fk_SuperPowerID_SupSomeSupPower
FOREIGN KEY (SuperPowerID) REFERENCES SuperPower(SuperPowerID) ON DELETE CASCADE;

ALTER TABLE SHVD.SuperSomeoneSuperPower
ADD CONSTRAINT fk_SuperSomeoneID_SupSomeSupPower
FOREIGN KEY (SuperSomeoneID) REFERENCES SuperSomeone(SuperSomeoneID) ON DELETE CASCADE;

ALTER TABLE SHVD.Member
ADD CONSTRAINT fk_SuperSomeoneID_Member
FOREIGN KEY (SuperSomeoneID) REFERENCES SuperSomeone(SuperSomeoneID) ON DELETE CASCADE;

ALTER TABLE SHVD.Member
ADD CONSTRAINT fk_OrganizationID_Member
FOREIGN KEY (OrganizationID) REFERENCES Organization(OrganizationID) ON DELETE CASCADE;



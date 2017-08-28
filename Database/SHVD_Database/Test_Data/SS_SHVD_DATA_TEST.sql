USE SHVD_TEST;

INSERT INTO SuperSomeone(SuperSomeoneType, SuperSomeoneName, SuperSomeoneAlias, SuperSomeoneDescription) VALUES ('Hero','Parrot Boy','Steve Tucan','Skinny Legs, Beefy arms and chest, can fly for miles');
INSERT INTO SuperSomeone(SuperSomeoneType, SuperSomeoneName, SuperSomeoneAlias, SuperSomeoneDescription) VALUES ('Hero','Demolition Man','Matt Constructor','Steel Plate in skull gives him a hard head, feet turn into giant steam roller on command, fingers are wrecking balls');
INSERT INTO SuperSomeone(SuperSomeoneType, SuperSomeoneName, SuperSomeoneAlias, SuperSomeoneDescription) VALUES ('Villain','Lattenator','James Dunkin','Has hand made of latte steam wands, great for making delicious drinks and melting foes');
INSERT INTO SuperSomeone(SuperSomeoneType, SuperSomeoneName, SuperSomeoneAlias, SuperSomeoneDescription) VALUES ('Villain','Code Maniac','Sam Servlet','Great with computers, bad with girls - finds joy in hacking any and every computer network in site, causing IT mayhem wherever he goes');
INSERT INTO SuperSomeone(SuperSomeoneType, SuperSomeoneName, SuperSomeoneAlias, SuperSomeoneDescription) VALUES ('Hero','Photographica','Angie Apeture','Alone and in need of a great picture? No need to fret - Angie lives to capture the moment - but caution, her photos will steal your soul...and give her super powers!');
INSERT INTO SuperSomeone(SuperSomeoneType, SuperSomeoneName, SuperSomeoneAlias, SuperSomeoneDescription) VALUES ('Villain','Cargo-Panticus','Allen Alteration','Dressed in stolen Top Secret Military cargo pants - his many massive pockets allow hold objects of any size...away and out of sight');
INSERT INTO SuperSomeone(SuperSomeoneType, SuperSomeoneName, SuperSomeoneAlias, SuperSomeoneDescription) VALUES ('Villain','Kniterator','Wanda Wales','The fastest knitter ever - When her fingers were replaced with bionic knitting-needles, she now can knit with any material ...yarn, steel-cable, rebar');
INSERT INTO SuperSomeone(SuperSomeoneType, SuperSomeoneName, SuperSomeoneAlias, SuperSomeoneDescription) VALUES ('Hero','Cabletron','David Dongle ','After swollowing a cell-phone battery at a tiny age, conductive properties flow through is body, allowing him to be a human transfer cable for any electrical connection needs');

INSERT INTO SuperPower(SuperPowerName, SuperPowerDescription) VALUES ('Flying','The Power to fly where and whenever needed!');
INSERT INTO SuperPower(SuperPowerName, SuperPowerDescription) VALUES ('Desctruction','The Power to break anything with blunt force strength!');
INSERT INTO SuperPower(SuperPowerName, SuperPowerDescription) VALUES ('Heat','The Power to melt anything and everything in its path!');
INSERT INTO SuperPower(SuperPowerName, SuperPowerDescription) VALUES ('SuperSpeed','Speed faster than a Kentucky Derby Racehorse');
INSERT INTO SuperPower(SuperPowerName, SuperPowerDescription) VALUES ('Transformation','The Power to transform into another form!');
INSERT INTO SuperPower(SuperPowerName, SuperPowerDescription) VALUES ('Brainiac','With great knowledge comes great responsibility');

INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (1,1);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (2,1);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (2,2);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (3,3);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (6,4);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (6,5);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (1,5);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (4,5);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (5,6);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (6,6);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (1,7);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (2,7);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (5,8);
INSERT INTO SuperSomeoneSuperPower(SuperPowerID, SuperSomeoneID) VALUES (6,8);

INSERT INTO Location(LocationName, LocationDescription, LocationStreet, LocationCity, LocationState, LocationCountry, LocationLatitude, LocationLongitude) VALUES ('GoldenGate Bridge', 'The very tippy-top', 'Bridge St', 'San Francisco', 'CA','US','123.092128', '022.543456');
INSERT INTO Location(LocationName, LocationDescription, LocationStreet, LocationCity, LocationState, LocationCountry, LocationLatitude, LocationLongitude) VALUES ('Downtown NYC', 'In the Middle of the Street', 'Time Square', 'New York City', 'NY','US','151.092128', '123.543458');
INSERT INTO Location(LocationName, LocationDescription, LocationStreet, LocationCity, LocationState, LocationCountry, LocationLatitude, LocationLongitude) VALUES ('SG-Louisville', 'A Classroom in Louisville', 'Market St', 'Louisville', 'KY','US','054.112128', '045.553457');
INSERT INTO Location(LocationName, LocationDescription, LocationStreet, LocationCity, LocationState, LocationCountry, LocationLatitude, LocationLongitude) VALUES ('Bestbuy St.Matthews', 'The return line, returning an online impulse buy', 'Shelbyville Rd', 'Louisville', 'KY','US','121.654365', '115.654458');
INSERT INTO Location(LocationName, LocationDescription, LocationStreet, LocationCity, LocationState, LocationCountry, LocationLatitude, LocationLongitude) VALUES ('The Jim Beam Distillery', 'The top rafters of Barrel House 22', 'Happy Hollow Rd', 'Clermont', 'KY','US','021.765365', '098.874458');
INSERT INTO Location(LocationName, LocationDescription, LocationStreet, LocationCity, LocationState, LocationCountry, LocationLatitude, LocationLongitude) VALUES ('The Great Wall of China', 'Flying by and bowing in traditional Chinese custom', 'NULL', 'NULL', 'Gansu Province','China','124.552128', '089.452452');
INSERT INTO Location(LocationName, LocationDescription, LocationStreet, LocationCity, LocationState, LocationCountry, LocationLatitude, LocationLongitude) VALUES ('4th Street Live Post Office', 'Probably the last place they thought anyone would look', '4th St', 'Louisville', 'KY','US','032.222128', '098.112452');
INSERT INTO Location(LocationName, LocationDescription, LocationStreet, LocationCity, LocationState, LocationCountry, LocationLatitude, LocationLongitude) VALUES ('The Vue Apartments', 'Not the nicest, but great move-in specials!', '3rd Ave', 'Louisville', 'KY','US','036.652128', '094.222452');


INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (1,'I saw them!','20170102');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (2,'It was hard to tell what I saw','20170203');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (4,'Really cool to see them!','20160916');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (3,'WOWOWOW','20171103');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (1,'I think it was them','20170212');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (6,'Yes I saw them','20170106');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (3,'Seriously, I saw them','20170101');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (2,'It happened so fast','20170106');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (1,'Neato!','20170215');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (5,'Coolio!','20160115');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (6,'Yeah that was neat!','20160714');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (8,'I hope to see that again!','20160714');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (1,'It was soooo cooool','20150712');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (1,'I need to tweet this!','20160717');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (7,'Seeing is believing!','20151025');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (5,'Just ok','20171025');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (5,'Been there, seen that','20161117');
INSERT INTO SuperSomeoneSightingData(LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) VALUES (1,'Neato','20161116');

INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (1,1);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (2,2);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (3,3);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (5,4);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (4,5);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (4,6);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (6,7);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (2,8);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (3,9);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (3,10);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (3,11);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (3,12);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (3,13);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (3,14);
INSERT INTO SuperSomeoneSighting(SuperSomeoneID, SuperSomeoneSightingDataID) VALUES (3,15);

INSERT INTO Organization(OrganizationType, OrganizationName, OrganizationDescription, OrganizationContact) VALUES ('Hero','The Nice People','Just the friendliest people you might ever find','A direct phone line at Mayor Office');
INSERT INTO Organization(OrganizationType, OrganizationName, OrganizationDescription, OrganizationContact) VALUES ('Villain','The Jerks','A collective group of total jerks','Whispering into SeaShell');
INSERT INTO Organization(OrganizationType, OrganizationName, OrganizationDescription, OrganizationContact) VALUES ('Unknown','The Odd Bunch','Why they are friends, no one knows','Facebook Page');

INSERT INTO OrganizationLocation(OrganizationID, LocationID) VALUES(1,1);
INSERT INTO OrganizationLocation(OrganizationID, LocationID) VALUES(2,5);
INSERT INTO OrganizationLocation(OrganizationID, LocationID) VALUES(3,7);
INSERT INTO OrganizationLocation(OrganizationID, LocationID) VALUES(3,8);

INSERT INTO Member(SuperSomeoneID, OrganizationID) VALUES(1,1);
INSERT INTO Member(SuperSomeoneID, OrganizationID) VALUES(5,1);
INSERT INTO Member(SuperSomeoneID, OrganizationID) VALUES(2,1);
INSERT INTO Member(SuperSomeoneID, OrganizationID) VALUES(4,2);
INSERT INTO Member(SuperSomeoneID, OrganizationID) VALUES(3,2);
INSERT INTO Member(SuperSomeoneID, OrganizationID) VALUES(6,3);
INSERT INTO Member(SuperSomeoneID, OrganizationID) VALUES(7,3);
INSERT INTO Member(SuperSomeoneID, OrganizationID) VALUES(8,3);
INSERT INTO Member(SuperSomeoneID, OrganizationID) VALUES(8,1);

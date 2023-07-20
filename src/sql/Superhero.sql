DROP DATABASE IF EXISTS TestProjectSuperhero;
CREATE DATABASE TestProjectSuperhero;
USE TestProjectSuperhero;

DROP DATABASE IF EXISTS ProjectSuperhero;
CREATE DATABASE ProjectSuperhero;
USE ProjectSuperhero;

CREATE TABLE Superhero (
  SuperheroId INT AUTO_INCREMENT,
  SuperheroName VARCHAR(50),
  SuperheroDescription VARCHAR(255),
  SuperheroSuperpower VARCHAR(150),
  CONSTRAINT PK_SuperheroId PRIMARY KEY (SuperheroId));

INSERT INTO Superhero (SuperheroId, SuperheroName, SuperheroDescription, SuperheroSuperpower)
VALUES
(1, "Wonder Woman", "Princess Diana of Themyscira, a powerful Amazon warrior with enhanced strength, agility, and combat skills. She fights for justice, peace, and gender equality.",
"Enhanced strength"),
(2, "Captain Marvel", "Carol Danvers, a former U.S. Air Force pilot who gained superhuman abilities after being exposed to alien technology. She is a skilled fighter and protector of Earth.",
"energy projection"),
(3, "Black Widow", "Natasha Romanoff, a highly skilled spy, and assassin. She is a master in hand-to-hand combat and covert operations.",
"Exceptional martial arts skills"),
(4, "Storm", "Ororo Munroe, a mutant with the ability to manipulate weather. She is a member of the X-Men and a natural leader.", 
"Weather manipulation"),
(5, "Supergirl", "Kara Zor-El, the cousin of Superman, possesses similar superhuman abilities. She protects Earth from various threats alongside her cousin.",
"Heat vision"),
(6, "Gamora", "A highly skilled assassin and member of the Guardians of the Galaxy. She seeks redemption for her past actions.",
"Expert swordsmanship"),
(7, "Jessica Jones", "A former superhero who now works as a private investigator. She possesses superhuman strength and a no-nonsense attitude.",
"Enhanced durability"),
(8, "Batwoman", "Kate Kane, a highly skilled detective and martial artist who operates in Gotham City. She fights crime using her intellect, combat skills, and advanced technology.",
"Detective abilities"),
(9, "Valkyrie", "A fierce Asgardian warrior and member of Thor's team. She wields a magical sword and is skilled in combat and leadership.",
"Swordsmanship"),
(10, "Rogue","Anna Marie, a mutant with the ability to absorb the memories, powers, and life force of others through touch. She is a member of the X-Men.",
"Power absorption"),
(11, "Hawkgirl", "Kendra Saunders, a reincarnated warrior from ancient Egypt. She possesses wings, enhanced strength, and a mace, and fights alongside other superheroes.",
"combat skills"),
(12, "Scarlet Witch", "Wanda Maximoff, a mutant with reality-altering powers. She can manipulate energy, probability, and minds.",
"Telekinesis"),
(13, "Batgirl", "Barbara Gordon, the daughter of Gotham City's Police Commissioner. She operates as a skilled detective and vigilante to protect her city.",
"technological expertise");

SELECT * FROM Superhero;

CREATE TABLE Superpower (
SuperpowerId INT PRIMARY KEY, 
SuperpowerName VARCHAR(255),
SuperheroId int, CONSTRAINT FOREIGN KEY (SuperheroId) REFERENCES Superhero(SuperheroId) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Superpower VALUES
(1, "Enhanced strength", 1),
(2, "Energy projection", 2),
(3, "Exceptional martial arts skills", 3),
(4, "Weather manipulation", 4),
(5, "Heat vision", 5),
(6, "Expert swordsmanship", 6),
(7, "Enhanced durability", 7),
(8, "Detective abilities", 8),
(9, "Swordsmanship", 9),
(10, "Power absorption", 10),
(11, "Combat skills", 11),
(12, "Telekinesis", 12),
(13, "Technological expertise", 13);

SELECT * FROM Superpower;

DELETE FROM Superhero WHERE SuperheroId = 125;

CREATE TABLE Organisation (OrganisationId INT PRIMARY KEY, 
OrgName VARCHAR(255), OrgDescription VARCHAR(255), OrgInfo VARCHAR(255));

INSERT INTO Organisation (OrganisationId, OrgName, OrgDescription, OrgInfo) VALUES (101, "Avengers", 
"A team of superheroes assembled to protect the world from threats.",
 "123 Avengers Tower, New York, USA"), 
 (102, "Justice League", "A group of powerful heroes who work together to fight crime and maintain peace.", 
 "456 Hall of Justice, Metropolis, USA"), 
 (103, "X-Men", "A team of mutants with extraordinary powers fighting for a world that fears and hates them.",
 "789 Xavier's School for Gifted Youngsters, Salem Center, USA"), 
 (104, "Fantastic Four", 
 "A team of scientific explorers who gained superhuman abilities after exposure to cosmic rays.", 
 "101 Baxter Building, New York, USA"), 
 (105, "Guardians of the Galaxy", 
 "A group of intergalactic heroes protecting the universe from various threats.",
 "999 Knowhere, Outer Space"),
 (106, "S.H.I.E.L.D.",
 "A covert international agency dedicated to protecting the world from supernatural 
 and extraterrestrial threats.", "555 S.H.I.E.L.D. Helicarrier, International Waters"),
 (107, "League of Assassins", "A secret society of highly skilled assassins with their own agenda.",
 "777 League Headquarters, Unknown Location"),
 (108, "Independent (Alias Investigations)", "Private investigation agency run by Jessica Jones.", 
 "42nd Street, New York, USA"), 
(109, "Independent (Gotham City)", "Independent crime-fighting organization operating in Gotham City.", 
"123 Crime Alley, Gotham City, USA");

SELECT * FROM Organisation;

CREATE TABLE Location (
  LocationId INT PRIMARY KEY,
  LocationName VARCHAR(255),
  LocationDescription TEXT,
  Address VARCHAR(255),
  Coordinates VARCHAR(255)
);

INSERT INTO Location (locationid, locationName, locationDescription, address, coordinates)
VALUES 
(1, 'Hero Headquarters', 'Secret lair of the superhero team', '789 Hero Street', '39.9526° N, 75.1652° W'),
(2, 'Villain Hideout', 'Secret hideout of the supervillain', '123 Villain Avenue', '37.7749° N, 122.4194° W'),
(3, 'Superhero Training Facility', 'Training center for aspiring superheroes', '456 Hero Road', '34.0522° N, 118.2437° W'),
(4, 'City Skyline', 'The iconic city skyline with skyscrapers', '789 Skyline Street', '40.7128° N, 74.0060° W'),
(5, 'Hero Central Park', 'A sprawling park with training grounds and secret entrances', '123 Hero Park Avenue', '37.7749° N, 122.4194° W'),
(6, 'The Heroic Fortress', 'A massive fortress hidden in the mountains', '789 Heroic Lane', '48.8566° N, 2.3522° E'),
(7, 'The Vigilante Alley', 'A dark and mysterious alley where crime-fighting happens', '456 Vigilante Alley', '51.5074° N, 0.1278° W'),
(8, 'The Heroic Base', 'An underground base equipped with advanced technology', '789 Hero Base Street', '34.0522° N, 118.2437° W'),
(9, 'The Superhero Academy', 'A prestigious academy for training aspiring superheroes', '123 Academy Street', '40.7128° N, 74.0060° W'),
(10, 'The Heroic Tower', 'A towering structure with a high-tech headquarters', '456 Heroic Tower Avenue', '37.7749° N, 122.4194° W');

SELECT * FROM Location;

CREATE TABLE Sighting (
SightingId INT auto_increment PRIMARY KEY,
SuperheroId INT, CONSTRAINT FOREIGN KEY (SuperheroId) REFERENCES Superhero(SuperheroId) ON UPDATE CASCADE ON DELETE CASCADE,
LocationId INT, CONSTRAINT FOREIGN KEY (LocationId) REFERENCES Location(LocationId) ON UPDATE CASCADE ON DELETE CASCADE,
SightingDate DATE
);

INSERT INTO Sighting (SightingId, SuperheroId, LocationId, SightingDate)
VALUES
    (1, 1, 1, '2023-06-20'),
    (2, 3, 4, '2023-06-22'),
    (3, 5, 5, '2023-06-23'),
    (4, 2, 2, '2023-06-25'),
    (5, 6, 6, '2023-06-27'),
    (6, 9, 10, '2023-06-28'),
    (7, 4, 3, '2023-06-30'),
    (8, 7, 8, '2023-07-02'),
    (9, 8, 7, '2023-07-04'),
    (10, 12, 9, '2023-07-06');

SELECT * FROM Sighting;

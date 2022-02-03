CREATE DATABASE moonfall;
use moonfall;
CREATE TABLE Users (
    UserID int PRIMARY KEY UNIQUE NOT NULL auto_increment,
    LastName varchar(30) NOT NULL,
    FirstName varchar(30) NOT NULL,
    Email varchar(255) UNIQUE NOT NULL,
	UserPassword varchar(30) UNIQUE NOT NULL
);
CREATE TABLE Shows (
    ShowID int PRIMARY KEY UNIQUE NOT NULL auto_increment ,
    Title varchar(255)
);
CREATE TABLE User_Show (
    UserID int NOT NULL,
	ShowID int  NOT NULL,
    Progress int,
	FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (ShowID) REFERENCES Shows(ShowID)
);
CREATE TABLE Progress (
    ProgressID int UNIQUE NOT NULL,
	ProgressStatus varchar(30) UNIQUE NOT NULL                
);
   
#populating the progress table   
insert into Progress(ProgressID, ProgressStatus) values(1, 'Plan to Watch');
insert into Progress(ProgressID, ProgressStatus) values(2, 'Currently Watching');
insert into Progress(ProgressID, ProgressStatus) values(3, 'Completed');
insert into Progress(ProgressID, ProgressStatus) values(4, 'Dropped');

#populating the Users table
insert into Users(UserID, LastName, FirstName, Email, UserPassword) values(null, 'Ordway', 'Nicholas', 'ordway.nicholas@gmail.com', 'Password123');
insert into Users(UserID, LastName, FirstName, Email, UserPassword) values(null, 'Mueller', 'Arthur', 'awm21@pitt.edu', '123Password');

#populating the Shows table
insert into Shows(ShowID, Title) values(null, 'Ozark');
insert into Shows(ShowID, Title) values(null, 'Euphoria');
insert into Shows(ShowID, Title) values(null, 'The Book of Boba Fett');
insert into Shows(ShowID, Title) values(null, 'Attack on Titan');
insert into Shows(ShowID, Title) values(null, 'Archive 81');
insert into Shows(ShowID, Title) values(null, 'The Gilded Age');
insert into Shows(ShowID, Title) values(null, 'Peacemaker');
insert into Shows(ShowID, Title) values(null, 'Yellowjackets');
insert into Shows(ShowID, Title) values(null, 'Yellowstone');
insert into Shows(ShowID, Title) values(null, 'After Life');
insert into Shows(ShowID, Title) values(null, '1883');
insert into Shows(ShowID, Title) values(null, 'The Lord of the Rings: The Rings of Power');
insert into Shows(ShowID, Title) values(null, 'The Witcher');
insert into Shows(ShowID, Title) values(null, 'Game of Thrones');
insert into Shows(ShowID, Title) values(null, 'Succession');

#populating User_show
insert into User_Show(UserID, ShowID, Progress) values(1, 2, 1);
insert into User_Show(UserID, ShowID, Progress) values(2, 1, 1);
insert into User_Show(UserID, ShowID, Progress) values(1, 3, 2);
insert into User_Show(UserID, ShowID, Progress) values(2, 4, 2);
insert into User_Show(UserID, ShowID, Progress) values(1, 6, 3);
insert into User_Show(UserID, ShowID, Progress) values(2, 5, 3);
insert into User_Show(UserID, ShowID, Progress) values(1, 7, 3);
insert into User_Show(UserID, ShowID, Progress) values(2, 8, 3);
insert into User_Show(UserID, ShowID, Progress) values(1, 9, 3);
insert into User_Show(UserID, ShowID, Progress) values(2, 9, 3);
insert into User_Show(UserID, ShowID, Progress) values(1, 10, 1);
insert into User_Show(UserID, ShowID, Progress) values(2, 10, 1);
insert into User_Show(UserID, ShowID, Progress) values(1, 11, 1);
insert into User_Show(UserID, ShowID, Progress) values(2, 11, 2);
insert into User_Show(UserID, ShowID, Progress) values(1, 12, 3);
insert into User_Show(UserID, ShowID, Progress) values(2, 12, 2);

select * from Users;
select * from shows;
select * from progress;
select * from user_show;
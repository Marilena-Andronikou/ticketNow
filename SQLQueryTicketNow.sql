USE TicketNow;
DROP TABLE Users;
DROP TABLE Posts;
DROP TABLE Comments;

CREATE TABLE Users (
username varchar(50) not null primary key,
passwordU varchar(50) not null,
email varchar(50) not null unique
);
CREATE TABLE Posts (
pcode int identity(1,1) not null primary key,
labelP text not null,
likes int not null,
username varchar(50) foreign key references Users 
);
CREATE TABLE Comments (
ccode int identity(1,1) not null primary key,
comtext text not null,
pcode int foreign key references Posts,
username varchar(50) foreign key references Users
);

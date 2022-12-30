USE TicketNow;

DROP TABLE Comments;
DROP TABLE Users;
DROP TABLE Posts;

CREATE TABLE Users (
username varchar(50) not null primary key,
passwordU varchar(50) not null,
email varchar(50) not null unique
)
CREATE TABLE Posts (
pcode int not null primary key,
labelP text not null,
likes int not null
)
CREATE TABLE Comments (
ccode int not null primary key,
comtext text not null,
pcode int foreign key references Posts,
username varchar(50) foreign key references Users
)

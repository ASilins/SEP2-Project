CREATE SCHEMA IF NOT EXISTS SEP2;

SET SCHEMA 'sep2';

CREATE TABLE IF NOT EXISTS "Menu_Item"(
    ItemID SERIAL PRIMARY KEY,
    Name varchar(100) NOT NULL,
    Price int NOT NULL);

CREATE TABLE IF NOT EXISTS "Order"(
    OrderNumber SERIAL PRIMARY KEY,
    MenuItem smallint not null,
    Comment varchar(250),
    DietaryNeeds varchar(250)
);

CREATE DOMAIN user_position varchar(7) check (value IN ('Guest', 'Staff', 'Manager', 'Admin'));

CREATE TABLE IF NOT EXISTS "User"(
    PhoneNumber varchar(15) PRIMARY KEY,
    Name varchar(50),
    position user_position,
    Password varchar(32),
    ManagerPhoneNumber varchar(15)
);

CREATE TABLE IF NOT EXISTS "Take_out"(
    TakeOutNumber SERIAL PRIMARY KEY,
    Date timestamp,
    CustomerNumber varchar(15)
);

CREATE TABLE IF NOT EXISTS "Table"(
    TableNumber smallint PRIMARY KEY UNIQUE,
    Capacity smallint,
    Availability boolean
);

CREATE TABLE IF NOT EXISTS "Reservation"(
    ReservationNumber SERIAL PRIMARY KEY,
    CustomerNumber varchar(15) NOT NULL,
    Date timestamp,
    AmountOfPeople smallint,
    Comment varchar(250),
    DietaryNeeds varchar(250),
    "Table" smallint REFERENCES "Table"(TableNumber)
);

CREATE TABLE IF NOT EXISTS "PreOrder"(
    OrderNumber int REFERENCES "Order"(OrderNumber),
    ReservationNumber int REFERENCES "Reservation"(ReservationNumber)
);

CREATE TABLE IF NOT EXISTS "Walk_In"(
    WalkInID SERIAL PRIMARY KEY,
    "Table" int REFERENCES "Table"(TableNumber),
    Date timestamp
);

CREATE TABLE IF NOT EXISTS "Walk_In_Order"(
    OrderNumber int REFERENCES "Order"(OrderNumber),
    WalkInNumber int REFERENCES "Walk_In"(WalkInID)
);

CREATE TABLE IF NOT EXISTS "Take_Out_Order"(
    OrderNumber int REFERENCES "Order"(OrderNumber),
    TakeOutNumber int REFERENCES "Take_out"(TakeOutNumber)
);

ALTER TABLE "Reservation"
ALTER COLUMN Date datetime;
# Booking System for Semester 2 Project 

This is a booking system for semester 2 project.

## Installing / Getting started

A quick introduction of getting the program setup.

First you have to set up directory where the program will be.
Open cmd and go to the directories location using this command

```shell
cd directoryName
```

To speed up the process you can also use forward slash '/' to go threw multiple directories

```shell
cd directoryName/anotherDirecoryName
```

Clone this git repository in cmd
Note: When you have cloned the repository it will create a folder where all of the files are in there

```shell
git clone https://github.com/ASilins/SEP2-Project
```

### Running the programm

To run this program you have to use Intellij with Java JDK 17 installed.

In lib folder you can find javafx-17 that has to be added as global library and has to be
added in project structure for the GUI to run

#### Steps for starting the program

1. Start server application
2. Start client application

#### Steps for running the program with a remote server running

1. Start client application

## Changelog

### RBS-num-branchName

This is dummy text

### RBS-17-45

Created client side for handling an order

### RBS-17-49

Created client side that handles retrieving menu items from the server

### RBS-48

Made server classes and wrote javadocs

### RBS-47

Added few classes in the server and wrote javadocs

### RBS-46

Created classes that send and take information from 
the database.
There is a singleton class that keeps information about the 
connection to the database. Used state pattern for sending 
and receiving information from the database. Using state 
patterns allows the use of one interface and smaller code.

### RBS-50

Created server side for taking Order objects from the 
Database to the client

### RBS-52

Added methods that take from the server a list of order items

### RBS-21

Added classes for account creation and wrote javadocs

### RBS-70

Changed database instance creation server class. Testing is required 
to see the performance and to see if there is problems.
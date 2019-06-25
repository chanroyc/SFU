-- All ID are INTEGER variable, except loginID in the Account Table is VARCHAR(20)
-- All Name are VARCHAR(50)

use c275g11A

CREATE TABLE Account
(
	accountID INT IDENTITY(300000000,1),
	employeeID INT UNIQUE,
	firstName VARCHAR(50),
	middleName VARCHAR(50),
	lastName VARCHAR(50),
	loginID VARCHAR(20) UNIQUE,
	[password] VARCHAR(30),
	ispasswdtemp BIT NOT NULL,
	islocked BIT NOT NULL,
	isAssistAdmin BIT NOT NULL,
	isSysAdmin BIT NOT NULL, 
	isAdministrator BIT NOT NULL,
	isTA BIT NOT NULL,
	isInstructor BIT NOT NULL,
	-- isAcademicAdmin BIT NOT NULL,
	PRIMARY KEY (accountID)
)

CREATE TABLE Course
(
	courseID INT IDENTITY(1000,1),
	courseNum VARCHAR(50),
	courseName VARCHAR(120),
	startDate DATE,
	endDate DATE,
	instructorEmployeeID INT,
	PRIMARY KEY (courseID),
	FOREIGN KEY (instructorEmployeeID) REFERENCES Account(employeeID) ON UPDATE CASCADE ON DELETE SET NULL
)

CREATE TABLE Activity
(
        activityID INT,
        courseID INT,
        activityName VARCHAR(50),
        activityType VARCHAR(30),
        dueDate DATE,
        [language] VARCHAR(30),
        pathToSubmissions VARCHAR(100),
		numTests INT,
        pathToSolution VARCHAR(100),      
        PRIMARY KEY (activityID),
		FOREIGN KEY (courseID) REFERENCES Course(courseID)
)

CREATE TABLE TA
(
	TAEmployeeID INT,
	accountID INT,
	courseID INT,	
	PRIMARY KEY (TAEmployeeID, courseID),
	FOREIGN KEY (TAEmployeeID) REFERENCES Account(employeeID) ON UPDATE CASCADE,
	FOREIGN KEY (accountID) REFERENCES Account(accountID) ON DELETE CASCADE,
	FOREIGN KEY (courseID) REFERENCES Course(courseID) ON DELETE CASCADE,
)

CREATE TABLE RubricItem
(
        rubricItemID INT,
        activityID INT,
        rubricItemNumber INT,
        rubricItemText VARCHAR(1000),
        rubricItemValue INT,
        PRIMARY KEY (rubricItemID),
        FOREIGN KEY (activityID) REFERENCES Activity(activityID)
)

CREATE TABLE BonusPenaltyType
(
        bonusPenaltyTypeID BIT,
        [type] VARCHAR(20),
        PRIMARY KEY (bonusPenaltyTypeID)
)

CREATE TABLE BonusPenalty
(
        BonusPenaltyID INT,
		activityID INT,
		BonusPenaltyTypeID BIT,
		[hours] REAL,
        amount REAL,
        PRIMARY KEY (bonusPenaltyTypeID),
		FOREIGN KEY (activityID) REFERENCES Activity(activityID),
		FOREIGN KEY (bonusPenaltyTypeID) REFERENCES BonusPenaltyType(bonusPenaltyTypeID)
)

CREATE TABLE ProgrammingTest
(
		testID INT IDENTITY(10,1),
        activityID INT,
		testName varchar(255),
        testNum INT,
        NumofInputFiles INT,		
        NumofOutputFiles INT,		
        environment CHAR(50),
        PRIMARY KEY (testID),
        FOREIGN KEY (activityID) REFERENCES Activity(activityID)
)

CREATE TABLE Student
(
        studentID INT,
        courseID INT,
        studentFirstName VARCHAR(50),
		studentMiddleName VARCHAR(50),
		studentLastName VARCHAR(50),
		isGrouped BIT,
        PRIMARY KEY (studentID, courseID),
        FOREIGN KEY (courseID) REFERENCES Course(courseID) ON DELETE CASCADE
)

CREATE TABLE Grade
(
		gradeID INT,
        studentID INT,
		courseID INT,
        rubricItemID INT,
        earnedGrade REAL,
        PRIMARY KEY (gradeID),
        FOREIGN KEY (studentID, courseID) REFERENCES Student(studentID, courseID),
		FOREIGN KEY (rubricItemID) REFERENCES RubricItem(rubricItemID)
)
/*
CREATE TABLE TestFileType
(
        fileTypeID INT,
        [type] VARCHAR(20), -- "INPUT" OR "OUTPUT"
        PRIMARY KEY (fileTypeID)
)
*/
CREATE TABLE TestFiles
(
        fileID INT IDENTITY(100,1),
		activityID INT,
		fileType VARCHAR(20), 
		testNum INT,
        pathToFile VARCHAR(100), 
        PRIMARY KEY (fileID),
		FOREIGN KEY (activityID) REFERENCES Activity(activityID)
		--FOREIGN KEY (fileTypeID) REFERENCES TestFileType(fileTypeID)
)

CREATE TABLE IndividualSubmission
(
        individualSubID INT IDENTITY(10000000,1),
		activityID INT,
		studentID INT,
		courseID INT,
		isGraded BIT,
		pathToSubmissions VARCHAR(100),
        PRIMARY KEY (individualSubID),
		FOREIGN KEY (activityID) REFERENCES Activity(activityID),
		FOREIGN KEY (studentID, courseID) REFERENCES Student(studentID, courseID)
)

CREATE TABLE GroupSubmission
(
        groupSubID INT IDENTITY(50000000,1),
		activityID INT,
		groupName VARCHAR(50),
		submissionDateTime DATETIME,
		isGraded BIT,
        PRIMARY KEY (groupSubID),
		FOREIGN KEY (activityID) REFERENCES Activity(activityID)
)

CREATE TABLE [Group]
(
        groupID INT,
		studentID INT,
		courseID INT,
		groupName VARCHAR(50),
        PRIMARY KEY (groupID),
		FOREIGN KEY (studentID, courseID) REFERENCES Student(studentID, courseID)
)

CREATE TABLE AnswerKeyResponse
(
        answerKeyResponseID INT,
		activityID INT,
		questionNum INT,
		response VARCHAR(100),
		points INT,
        PRIMARY KEY (answerKeyResponseID),
		FOREIGN KEY (activityID) REFERENCES Activity(activityID)
)






insert into Account(employeeID, firstName, middleName, lastName, loginID,[password], ispasswdtemp, islocked, isAssistAdmin, isSysAdmin, isAdministrator, isTA, isInstructor)
values(5001,'Elisa ','Adele','Herrell','A','A',1,1,0,0,1,0,0),
(5002,'Alice ','June','Hartley','B','B',1,0,0,0,1,1,0),
(5003,'Allen ','Noah','Yee','C','C',1,1,0,0,0,0,1),
(5004,'Gabriel ','Blaise','Sauro','D','D',1,0,0,1,1,0,0),
(5005,'Lindsay ','Elein','Ward','E','E',1,0,1,0,1,0,1),
(5006,'Azam ','Preston','Bhatti','F','F',1,1,0,0,1,1,0),
(5007,'Tracey ','Alice','Sherwood','G','G',1,0,0,0,1,0,1),
(5008,'Kathryn ','Damon','Ward','H','H',1,1,0,0,1,1,0),
(5009,'Rosaline ','Winston','Baik','I','I',1,0,0,1,0,1,0),
(50010,'Lorraine ','Carson','Yam','J','J',1,0,0,0,1,1,0),
(50011,'Roberta ','Jackson','Neilson','K','K',1,0,0,0,0,0,1),
(50012,'Anne ','Marie ','Barrett','L','L',1,0,0,0,0,1,0),
(50013,'Maria ','Brooke','Hamilton','M','M',1,0,0,0,0,1,1)


insert into Course(courseNum, courseName, startDate,endDate, instructorEmployeeID)
values('CMPT120', 'Introduction to Computing Science and Programming', '2017-01-04', '2017-04-20', '5007'),
('CMPT120', 'Introduction to Computing Science and Programming', '2012-01-04', '2012-04-20', '5005'),
('CMPT120', 'Introduction to Computing Science and Programming', '2008-05-04', '2008-08-25', '5007'),
('STAT340', 'Data Structures and Programming', '2015-09-08', '2015-12-30', '5001'),
('CMPT454', 'Introduction to Software Engineering', '2016-01-04', '2016-04-20', '5006'),
('CMPT225', 'Discrete Mathematics II', '2015-01-04', '2015-04-20', '50010'),
('STAT475', 'Discrete Mathematics I', '2015-01-04', '2015-04-20', '5007'),
('CMPT275', 'Calculus I for the Social Sciences', '2015-01-04', '2015-04-20', '5005'),
('STAT490', 'Applied Linear Algebra', '2015-01-04', '2015-04-20', '5008'),
('CMPT285', 'Algebra I: Linear Algebra', '2015-01-04', '2015-04-20', '5009'),
('STAT270', 'Introduction to Probability and Statistics', '2015-01-04', '2015-04-20', '5003'),
('CMPT125', 'Introduction to Computing Science and Programming II', '2012-05-04', '2012-08-20', '5003'),
('CMPT120', 'Introduction to Computing Science and Programming', '2015-01-04', '2015-04-20', null)

insert into Activity(activityID, courseID, activityName, activityType, dueDate, [language], pathToSubmissions, numTests, pathToSolution)
values(424, 1007, 'E128', 'essay', '2015-02-25', 'English', 'U:\CMPT 275\files\PS2sub.pdf', 1, 'U:\CMPT 275\files\Essaysol.pdf'),
(233, 1001, 'MC108', 'multiple choice', '2015-02-25', 'English', 'U:\CMPT 275\files\PS2sub.pdf', 1, 'U:\CMPT 275\files\PS2sol.pdf'),
(777, 1003, 'PA77', 'programming assignment', '2015-06-25', 'English', 'U:\CMPT 275\files\PS2sub.pdf', 1, 'U:\CMPT 275\files\PS2sol.pdf'),
(601, 1000, 'E1', 'essay', '2015-06-25', 'English', 'U:\CMPT 275\files\Essay1sub.pdf', 1, 'U:\CMPT 275\files\Essay2sol.pdf'),
(610, 1008, 'MC5', 'multiple choice', '2015-06-25', 'English', 'U:\CMPT 275\files\PS2sub.pdf', 1, 'U:\CMPT 275\files\PS2sol.pdf'),
(754, 1007, 'PS78', 'problem set', '2015-06-25', 'English', 'U:\CMPT 275\files\PS1sub.pdf', 1, 'U:\CMPT 275\files\PS1sol.pdf'),
(354, 1007, 'PA55', 'programming assignment', '2015-06-25', 'Java', 'U:\CMPT 275\files\Essay1sub.pdf', 5, 'U:\CMPT 275\files\Essay1sol.pdf'),
(874, 1000, 'E11', 'essay', '2015-06-25', 'French', 'U:\CMPT 275\files\PS1sub.pdf', 9, 'U:\CMPT 275\files\PS1sol.pdf'),
(564, 1003, 'E77', 'essay', '2015-06-25', 'English', 'U:\CMPT 275\files\PS1sub.pdf', 1, 'U:\CMPT 275\files\PS1sol.pdf'),
(8987, 1001, 'PA68', 'programming assignment', '2015-06-25', 'c++', 'U:\CMPT 275\files\Essay1sub.pdf', 2, 'U:\CMPT 275\files\Essay2sol.pdf'),
(4234525, 1003, 'E877', 'essay', '2015-06-25', 'English', 'U:\CMPT 275\files\Essay1sub.pdf', 1, 'U:\CMPT 275\files\Essay3sol.pdf'),
(563463, 1003, 'E45', 'essay', '2015-06-25', 'German', 'U:\CMPT 275\files\Essay1sub.pdf', 1, 'U:\CMPT 275\files\Essay3sol.pdf')

/*
insert into TA(TAEmployeeID, accountID, courseID, activityID)
values(5002, 300000002, 1000, 601),
(5006, 300000005, 1000, 601),
(5008, 300000007, 1000, 601),
(5009, 300000008, 1007, 354),
(50010, 300000009, 1003, 563463),
(5002, 300000002, 1001, 8987),
(5002, 300000002, 1000, 874),
(5002, 300000002, 1003, 4234525),
(5009, 300000008, 1008, 610)
*/

insert into TA(TAEmployeeID, accountID, courseID)
values(50012, 300000011, 1000),
(5006, 300000005, 1000),
(5008, 300000007, 1000),
(5009, 300000008, 1007),
(50010, 300000009, 1003),
(5002, 300000002, 1001),
(5002, 300000002, 1000),
(5002, 300000002, 1003),
(5009, 300000008, 1008)
/*
select *
from Student
where courseID = 1007
*/
insert into Student
values(301167621, 1007, 'Maria ','Brooke','Hamilton', 1),
(301162684, 1007, 'Rosaline ','Winston','Baik', 1),
(301168694, 1007, 'Tracey ','Alice','Sherwood', 0),
(301169005, 1007, 'Jerry  ','Winston','Wasserman', 0),
(301169007, 1007, 'William  ','Damon','Honer', 0),
(301168655, 1000, 'John', 'Jackson', 'Lee', 1),
(301167621, 1000, 'Maria ','Brooke','Hamilton', 1),
(301162684, 1000, 'Rosaline ','Winston','Baik', 1),
(301169003, 1002, 'Charlotte  ','Damon','Johnston', 0),
(301169005, 1002, 'Jerry  ','Winston','Wasserman', 0),
(301169007, 1002, 'William  ','Damon','Honer', 0),
(301169008, 1003, 'John', 'Jackson', 'Lee', 1),
(301169009, 1003, 'Maria ','Brooke','Hamilton', 1),
(301169010, 1003, 'Rosaline ','Winston','Baik', 1),
(301169005, 1004, 'Charlotte  ','Damon','Johnston', 0),
(301169006, 1004, 'Jerry  ','Winston','Wasserman', 0),
(301169007, 1004, 'William  ','Damon','Honer', 0),
(301169008, 1005, 'John', 'Jackson', 'Lee', 1),
(301169009, 1005, 'Maria ','Brooke','Hamilton', 1),
(301169010, 1005, 'Rosaline ','Winston','Baik', 1),
(301169003, 1006, 'Steven','Damon','Jones', 0),
(301169004, 1006, 'Elizabeth','Jackson','Croft ', 0),
(301169005, 1006, 'Charlotte  ','Damon','Johnston', 0),
(301169010, 1007, 'Rosaline ','Winston','Baik', 1),
(301169001, 1007, 'Kathryn ','Damon','Ward', 0),
(301169002, 1007, 'Tracey ','Alice','Sherwood', 0),
(301169003, 1008, 'Steven','Damon','Jones', 0),
(301169004, 1008, 'Elizabeth','Jackson','Croft ', 0),
(301169005, 1008, 'Charlotte  ','Damon','Johnston', 0),
(301169010, 1009, 'Rosaline ','Winston','Baik', 1),
(301169001, 1009, 'Kathryn ','Damon','Ward', 0),
(301169002, 1009, 'Tracey ','Alice','Sherwood', 0),
(301169006, 1010, 'Jerry  ','Winston','Wasserman', 0),
(301169007, 1010, 'William  ','Damon','Honer', 0),
(301169010, 1011, 'Rosaline ','Winston','Baik', 1),
(301169001, 1011, 'Kathryn ','Damon','Ward', 0),
(301169002, 1011, 'Tracey ','Alice','Sherwood', 0),
(301169006, 1012, 'Jerry  ','Winston','Wasserman', 0),
(301169007, 1012, 'William  ','Damon','Honer', 0)

insert into Student
values(301169058, 1001, 'Steven','Damon','Jones', 0),
(301169059, 1001, 'Elizabeth','Jackson','Croft ', 0),
(301169060, 1001, 'Charlotte  ','Damon','Johnston', 0),
(301169061, 1001, 'Jerry  ','Winston','Wasserman', 0),
(301169062, 1001, 'William  ','Damon','Honer', 0)


insert into RubricItem
values(10001, 354, 3, 'test 1', 20),
(10002, 354, 3, 'test 2', 30),
(10003, 354, 3, 'test 3', 50),
(10005, 874, 2, 'postive view', 35),
(10006, 874, 3, 'negative view', 45),
(10007, 424, 3, 'arguement 1', 20),
(10008, 424, 3, 'arguement 2', 30),
(10009, 424, 3, 'arguement 3', 50),
(10010, 754, 2, 'solution 1', 35),
(10011, 754, 3, 'solution 2', 45)


insert into Grade
values(70001, 301168694, 1007, 10001, null),
(70002, 301169001, 1007, 10001, null),
(70006, 301168694, 1007, 10002, null),
(70007, 301169001, 1007, 10002, null),
(70008, 301162684, 1007, 10002, null),
(70009, 301168694, 1007, 10003, null),
(70010, 301169001, 1007, 10003, null),
(70011, 301169002, 1007, 10003, null),
(70015, 301168694, 1007, 10008, null),
(70016, 301169001, 1007, 10008, null),
(70013, 301168694, 1007, 10009, null),
(70017, 301169001, 1007, 10009, null),
(70018, 301169002, 1007, 10010, null),
(70005, 301168694, 1007, 10010, null),
(70019, 301169002, 1007, 10011, null),
(70003, 301168694, 1007, 10011, null)

/*
select G.gradeID as GradeID, R.rubricItemID as Rubric_Item_ID, R.rubricItemText, R.rubricItemValue, G.earnedGrade
from RubricItem R inner join Grade G
on R.rubricItemID = G.rubricItemID
where activityID=424 AND studentID=301169002

select *
from RubricItem R inner join Grade G
on R.rubricItemID = G.rubricItemID


UPDATE Grade
SET earnedGrade = null
*/


insert into IndividualSubmission(activityID, studentID, courseID)
select jointtable.activityID, jointtable.studentID, jointtable.courseID from
(
select activityID, studentID, Student.courseID
from Student inner join activity
on Student.courseID = activity.courseID 
) as jointtable


insert into TestFiles(activityID, testNum)
select Activity.activityID, Activity.numTests 
from Activity

update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\PSsub1.pdf'
where individualSubID = 10000030
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\PSsub2.pdf'
where individualSubID = 10000031
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\PSsub3.pdf'
where individualSubID = 10000032
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\PSsub4.pdf'
where individualSubID = 10000033
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\PSsub5.pdf'
where individualSubID = 10000034
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\PSsub6.pdf'
where individualSubID = 10000035
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\PSsub7.pdf'
where individualSubID = 10000036
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\PSsub8.pdf'
where individualSubID = 10000037



update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\Essaysub1.pdf'
where individualSubID = 10000013
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\Essaysub2.pdf'
where individualSubID = 10000014
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\Essaysub3.pdf'
where individualSubID = 10000015
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\Essaysub4.pdf'
where individualSubID = 10000016
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\Essaysub5.pdf'
where individualSubID = 10000017
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\Essaysub6.pdf'
where individualSubID = 10000018
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\Essaysub7.pdf'
where individualSubID = 10000019
update IndividualSubmission
set pathToSubmissions = 'U:\CMPT 275\files\Essaysub8.pdf'
where individualSubID = 10000020



-----------------------------------------------
--- DROP TABLE --------------------------------
-----------------------------------------------


DROP TABLE AnswerKeyResponse
DROP TABLE [Group]
DROP TABLE GroupSubmission
DROP TABLE IndividualSubmission
DROP TABLE TestFiles
--DROP TABLE TestFileType
DROP TABLE Grade
DROP TABLE Student
DROP TABLE ProgrammingTest
DROP TABLE BonusPenalty
DROP TABLE BonusPenaltyType
DROP TABLE RubricItem
DROP TABLE TA
DROP TABLE Activity
DROP TABLE Course
DROP TABLE Account



DELETE FROM TA
DELETE FROM Course
DELETE FROM Activity
DELETE FROM Account
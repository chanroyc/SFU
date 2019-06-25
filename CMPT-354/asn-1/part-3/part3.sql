CREATE TABLE Employees(
	ssn CHAR(50),
	salary REAL,
	phone CHAR(10),
	PRIMARY KEY(ssn)
	);

CREATE TABLE Children(
	name CHAR(50),
	age INTEGER,
	ssn CHAR(50),
	PRIMARY KEY(name, ssn),
	UNIQUE(name, ssn),
	FOREIGN KEY(ssn)
		REFERENCES Employees
	ON DELETE CASCADE	
	);

CREATE TABLE Dept_Mgr(
		ssn CHAR(50),
		dno CHAR(50),
		dname CHAR(50),
		budget REAL,
		PRIMARY KEY(dno),
		FOREIGN KEY(ssn)
			REFERENCES Employees
	);

CREATE TABLE Works_in(
	ssn CHAR(50),
	dno CHAR(50),
	PRIMARY KEY(ssn, dno),
	FOREIGN KEY(ssn)
		REFERENCES Employees,
	FOREIGN KEY(dno)
		REFERENCES Dept_Mgr
	ON DELETE CASCADE
	);


	


CREATE TABLE Test(
	name CHAR(50),
	test_no INTEGER,
	score_max INTEGER,
	PRIMARY KEY(name, test_no),
	UNIQUE(test_no)
	);

CREATE TABLE Plane(
	reg_no INTEGER,
	model CHAR(50),
	PRIMARY KEY(reg_no),
	UNIQUE(reg_no)
	);

CREATE TABLE Plane_Model(
	model_no CHAR(50),
	capacity INTEGER,
	weight REAL,
	PRIMARY KEY(model_no)
	);

CREATE TABLE Technician(
	name CHAR(50),
	sid CHAR(50),
	address CHAR(50),
	salary REAL,
	PRIMARY KEY(name,sid)
	);
	
CREATE TABLE Test_info(
	hours REAL,
	date CHAR(50),
	score INTEGER,
	name CHAR(50),
	test_no INTEGER,
	reg_no INTEGER,
	PRIMARY KEY(name, test_no, reg_no),
	FOREIGN KEY(name, test_no)
		REFERENCES Test,
	FOREIGN KEY(reg_no)
		REFERENCES Plane
	);

CREATE TABLE Model(
	reg_no INTEGER,
	model_no CHAR(50),
	PRIMARY KEY(model_no),
	FOREIGN KEY(reg_no)
		REFERENCES Plane,
	FOREIGN KEY(model_no)
		REFERENCES Plane_Model
	);
	
CREATE TABLE EXPERT(
	name CHAR(50),
	sid CHAR(50),
	model_no CHAR(50),
	PRIMARY KEY(name, sid, model_no),
	FOREIGN KEY(name, sid)
		REFERENCES Technician,
	FOREIGN KEY(model_no)
		REFERENCES Plane_Model	
	);
	

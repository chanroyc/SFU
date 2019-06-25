/* begin script */
CREATE VIEW QueryIV1 AS
SELECT E.ename, E.age
FROM Emp E, Works W1, Works W2, Dept D1, Dept D2
WHERE E.eid = W1.eid AND W1.did = D1.did AND D1.dname = 'Hardware' AND
E.eid = W2.eid AND W2.did = D2.did AND D2.dname = 'Software'

go
CREATE VIEW QueryIV2 AS
SELECT E.ename
FROM Emp E
WHERE E.Salary > ALL (SELECT D.budget
					FROM Dept D, Works W
					WHERE E.eid = W.eid AND D.did = W.did
					)
go
CREATE VIEW QueryIV3 AS
SELECT DISTINCT D.managerid
FROM Dept D
WHERE 1000000 < ALL (SELECT D2.budget
					FROM Dept D2
					WHERE D2.managerid = D.managerid)


go
CREATE VIEW QueryIV4 AS
SELECT E.ename
FROM Emp E
WHERE E.eid IN (SELECT D.managerid
				FROM Dept D
				WHERE D.budget = (SELECT MAX(D2.budget)
								from Dept D2
								)
				)

go
CREATE VIEW QueryV1 AS
SELECT C.Name
FROM Characters C
WHERE NOT EXISTS (SELECT P.name
				FROM Planets P
				WHERE P.Affiliation='Neutral' AND P.name NOT IN (SELECT TT.PlanetName
																FROM TimeTable TT
																WHERE TT.CharacterName = C.Name and TT.PlanetName = P.Name))


go
CREATE VIEW QueryV2 AS
SELECT DISTINCT P.Name
FROM Planets P, TimeTable T, Characters C
WHERE P.Name = T.PlanetName and C.Affiliation = 'empire' and C.Name = T.CharacterName

go
CREATE VIEW QueryV3 AS
SELECT TT1.Movie, TT1.PlanetName
FROM TimeTable TT1, Timetable TT2
WHERE TT1.CharacterName = 'Luke Skywalker' AND
TT2.CharacterName = 'Darth Vader' AND
TT1.PlanetName = TT2.PlanetName AND
TT1.Movie = TT2.Movie AND
((TT1.[Time of Arrival] <= TT2.[Time of Arrival] AND
TT1.[Time of Departure] >= TT2.[Time of Arrival]) OR
(TT2.[Time of Arrival] <= TT1.[Time of Arrival] AND
TT2.[Time of Departure] >= TT1.[Time of Arrival]))

go
CREATE VIEW QueryV4 AS
SELECT TT.Movie, C.Name
FROM Characters C, TimeTable TT, Planets P
WHERE ((C.Race = 'Human' and P.Type = 'Desert') OR
(C.Race = 'Droid' and P.Type = 'Swamp')) AND
C.Name = TT.CharacterName AND P.Name = TT.PlanetName
ORDER BY TT.Movie, C.Name

go
CREATE VIEW QueryV5 AS
Select C.Name, P.Name, sum(TT.[Time of Departure]-TT.[Time of Arrival]+1) AS TotalTime
FROM Characters C, TimeTable TT, Planets P
WHERE TT.CharacterName = C.Name AND
TT.PlanetName = P.Name AND P.Affiliation = 'Neutral'
GROUP BY C.Name, P.Name

/* end script */